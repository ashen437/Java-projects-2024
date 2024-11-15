import java.util.Scanner;

public class TipCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String repeat;

        do {
            double billAmount = 0;      // To store the bill amount
            int tipPercentage = 0;      // To store the tip percentage as an integer

            // Step 1: Input validation for bill amount
            while (true) {
                System.out.print("Enter the bill amount: ");
                if (scanner.hasNextDouble()) {            // Check if input is a valid number
                    billAmount = scanner.nextDouble();    // Store the bill amount
                    if (billAmount > 0) break;            // Exit loop if input is positive
                    else System.out.println("Please enter a positive bill amount.");
                } else {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    scanner.next(); // Discard invalid input
                }
            }

            // Step 2: Input validation for tip percentage (integer only)
            while (true) {
                System.out.print("Enter the tip percentage (whole number only): ");
                if (scanner.hasNextInt()) {                 // Check if input is a valid integer
                    tipPercentage = scanner.nextInt();      // Store the tip percentage
                    break;                                  // Exit loop if input is an integer
                } else {
                    System.out.println("Invalid input. Please enter a whole number (integer) for the tip percentage.");
                    scanner.next(); // Discard invalid input
                }
            }

            // Step 3: Calculate tip and total amounts
            double tipAmount = (billAmount * tipPercentage) / 100; // Tip calculation
            double totalAmount = billAmount + tipAmount;           // Total amount calculation

            // Display results
            System.out.printf("Tip: %.2f%n", tipAmount);
            System.out.printf("Total: %.2f%n", totalAmount);

            // Step 4: Ask the user if they want to repeat the process
            while (true) {
                System.out.print("Would you like to calculate again? (y/n): ");
                repeat = scanner.next().toLowerCase(); // Convert input to lowercase
                if (repeat.equals("y") || repeat.equals("n")) break; // Accept only 'y' or 'n'
                else System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");
            }

        } while (repeat.equals("y")); // Repeat process if user entered 'y'

        System.out.println("Thank you for using the Tip Calculator!");
        scanner.close();
    }
}
