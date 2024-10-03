import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private String password;
    private double balance;

    // Constructor to initialize a bank account with account holder's name and password
    public BankAccount(String accountHolderName, String password) {
        this.accountNumber = generateAccountNumber();
        this.accountHolderName = accountHolderName;
        this.password = password;
        this.balance = 0;
    }

    // Generate a random account number
    private String generateAccountNumber() {
        Random random = new Random();
        int number = 100000 + random.nextInt(900000); // Generate a random 6-digit number
        return String.valueOf(number);
    }

    // Getters for account information
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Verify if the entered password matches the account password
    public boolean verifyPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    // Deposit a specified amount into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw a specified amount from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    // Save the account details to a file
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(accountNumber + ".txt"))) {
            writer.write("Account Number: " + accountNumber + "\n");
            writer.write("Account Holder Name: " + accountHolderName + "\n");
            writer.write("Password: " + password + "\n");
            writer.write("Balance: $" + balance + "\n");
            System.out.println("Account details saved to file: " + accountNumber + ".txt");
        } catch (IOException e) {
            System.out.println("An error occurred while saving account details.");
            e.printStackTrace();
        }
    }
}
