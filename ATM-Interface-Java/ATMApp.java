import java.util.*;

class Account {
    private String userId;
    private String pin;
    private double balance;
    private List<String> transactionHistory;

    public Account(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean authenticate(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrew: ₹" + amount);
            return true;
        }
        return false;
    }

    public boolean transfer(Account receiver, double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            receiver.balance += amount;
            transactionHistory.add("Transferred: ₹" + amount + " to " + receiver.userId);
            return true;
        }
        return false;
    }

    public void printTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String txn : transactionHistory) {
                System.out.println(txn);
            }
        }
    }
}

public class ATMApp {
    private static Map<String, Account> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Add default accounts
        accounts.put("user1", new Account("user1", "1234"));
        accounts.put("user2", new Account("user2", "5678"));

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        if (accounts.containsKey(userId)) {
            Account acc = accounts.get(userId);

            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();

            if (acc.authenticate(pin)) {
                System.out.println("Login Successful!");
                showMenu(acc);
            } else {
                System.out.println("Incorrect PIN.");
            }
        } else {
            System.out.println("User not found.");
        }
    }

    public static void showMenu(Account acc) {
        while (true) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: ₹" + acc.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    acc.deposit(scanner.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    if (!acc.withdraw(scanner.nextDouble())) {
                        System.out.println("Insufficient Balance!");
                    }
                    break;
                case 4:
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter receiver User ID: ");
                    String receiverId = scanner.nextLine();
                    if (accounts.containsKey(receiverId)) {
                        System.out.print("Enter amount to transfer: ");
                        double amount = scanner.nextDouble();
                        if (!acc.transfer(accounts.get(receiverId), amount)) {
                            System.out.println("Transfer failed. Check balance.");
                        }
                    } else {
                        System.out.println("Receiver not found.");
                    }
                    break;
                case 5:
                    acc.printTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
