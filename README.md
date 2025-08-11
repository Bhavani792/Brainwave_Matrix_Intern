# **ATM Interface – Java Project**

## **Project Description**
This is a Java-based ATM interface that simulates basic banking operations in a console environment. The program is menu-driven and allows a user to authenticate using a User ID and PIN, then perform banking transactions such as balance inquiry, deposit, withdrawal, and transaction history review.

## **Objectives**
- Simulate real-world ATM functionality.  
- Demonstrate use of Java classes, objects, and methods.  
- Provide a secure, menu-driven interface using Java console.  
- Practice clean coding practices and modular programming.

## **Key Features**
- **User Authentication**: Validates user ID and PIN.  
- **Check Balance**: Displays current balance.  
- **Deposit**: Adds funds to the account.  
- **Withdraw**: Deducts amount if sufficient balance is available.  
- **Transaction History**: Displays a history of all transactions.  
- **Logout**: Securely exits the system.

## **Technologies Used**
- **Language**: Java (JDK 8 or above)  
- **Tools**: Any Java-supported IDE (e.g., IntelliJ IDEA, Eclipse, VS Code)  
- **Concepts**: OOP (Classes, Objects, Encapsulation), Conditional Statements, Loops, Scanner for input, ArrayList for transaction history.

## **Project Structure**

- ATM-Interface-Java/
- │
- ├── ATMApp.java       # Main Java file containing all logic
- └── README.md         # Project documentation

## **How to Run**
- Open terminal and navigate to the project directory:
  - 1. **bash**
    - cd ATM-Interface-Java

- Compile the Java file
  - 2. **bash**
    - javac ATMApp.java

- Run the program
  - 3. **bash**
    - java ATMApp

## **Sample Flow**
- Welcome to the ATM Interface
- Enter User ID: user1
- Enter PIN: ****

1. View Balance
2. Deposit Amount
3. Withdraw Amount
4. View Transaction History
5. Logout

- Enter your choice: 2
- Enter deposit amount: 5000
- Deposit successful.

## **Sample Credentials**

  User ID	    PIN
- user1	      1234
- user2  	    5678
- These users are hardcoded in the program for demonstration.

## **Future Enhancements**
- Support for multiple user accounts
- PIN reset or change functionality
- Integration with file or database storage
- Graphical User Interface using JavaFX or Swing

## **Disclaimer**
- This is a sample project created for educational and internship evaluation purposes. It does not perform any real-world banking functions.
