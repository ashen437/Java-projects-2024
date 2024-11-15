import java.util.Scanner;

public class TipCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String repeat;

        do {
            double billAmount = 0;      
            double tipPercentage = 0;   

            
            while (true) {
                System.out.print("Enter the bill amount: ");
                if (scanner.hasNextDouble()) {            
                    billAmount = scanner.nextDouble();    
                    if (billAmount > 0) break;            
                    else System.out.println("Please enter a positive bill amount.");
                } else {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    scanner.next(); // Discard invalid input
                }
            }

            
            while (true) {
                System.out.print("Enter the tip percentage: ");
                if (scanner.hasNextDouble()) {             
                    tipPercentage = scanner.nextDouble();  
                    if (tipPercentage >= 0) break;         
                    else System.out.println("Please enter a non-negative tip percentage.");
                } else {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    scanner.next(); 
                }
            }

            
            double tipAmount = (billAmount * tipPercentage) / 100; 
            double totalAmount = billAmount + tipAmount;           

            // Display results
            System.out.printf("Tip: %.2f%n", tipAmount);
            System.out.printf("Total: %.2f%n", totalAmount);

            
            while (true) {
                System.out.print("Would you like to calculate again? (y/n): ");
                repeat = scanner.next().toLowerCase(); 
                if (repeat.equals("y") || repeat.equals("n")) break; 
                else System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");
            }

        } while (repeat.equals("y")); 

        System.out.println("Thank you for using the Tip Calculator!");
        scanner.close();
    }
}
