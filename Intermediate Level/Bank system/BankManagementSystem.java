import java.util.ArrayList;
import java.util.Scanner;

// Main class for the Bank Management System
public class BankManagementSystem {
    // List to store all bank accounts
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    // Scanner object to read input from the console
    static Scanner scanner = new Scanner(System.in);

    // Main method (entry point of the program)
    public static void main(String[] args) {
        while (true) {
            try {
                // Displaying menu options
                System.out.println("********************************************");
                System.out.println("*                 Menu Option              *");
                System.out.println("********************************************");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Check Balance");
                System.out.println("0. Exit");
                System.out.println("********************************************");
                System.out.print("Enter your choice: ");

                // Reading user choice
                int choice = scanner.nextInt();

                // Handling user choice
                switch (choice) {
                    case 1 -> createAccount();
                    case 2 -> depositMoney();
                    case 3 -> withdrawMoney();
                    case 4 -> checkBalance();
                    case 0 -> {
                        System.out.println("Exiting... Thank you!");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                // Handling exceptions
                System.out.println("An error occurred: " + e.getMessage());
                scanner.next(); // Consume the invalid input
            }
        }
    }

    // Method to create a new bank account
    private static void createAccount() {
        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.next();
        System.out.print("Enter password for the account: ");
        String password = scanner.next();

        BankAccount account = new BankAccount(accountHolderName, password);
        accounts.add(account);
        account.saveToFile();
        System.out.println("Account created successfully with account number: " + account.getAccountNumber());
    }

    // Method to deposit money into an account
    private static void depositMoney() {
        BankAccount account = authenticateAccount();
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
            account.saveToFile();
        }
    }

    // Method to withdraw money from an account
    private static void withdrawMoney() {
        BankAccount account = authenticateAccount();
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
            account.saveToFile();
        }
    }

    // Method to check the balance of an account
    private static void checkBalance() {
        BankAccount account = authenticateAccount();
        if (account != null) {
            System.out.println("Account Balance: $" + account.getBalance());
        }
    }

    // Method to authenticate an account using account number and password
    private static BankAccount authenticateAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        BankAccount account = findAccount(accountNumber);

        if (account != null) {
            System.out.print("Enter password: ");
            String password = scanner.next();
            if (account.verifyPassword(password)) {
                return account;
            } else {
                System.out.println("Wrong password. Please try again.");
            }
        } else {
            System.out.println("Account not found.");
        }
        return null;
    }

    // Method to find an account by account number
    private static BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
