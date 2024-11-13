import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scannerobj = new Scanner(System.in);
        boolean repeat = true;

        while (repeat) {
            int mathMarks = 0, scienceMarks = 0, englishMarks = 0;
            
            // Input validation loop for Math marks
            while (true) {
                try {
                    System.out.print("Enter marks for Math : ");
                    mathMarks = scannerobj.nextInt();
                    if (mathMarks < 0 || mathMarks > 100) {
                        System.out.println("Invalid input. Marks must be between 0 and 100.");
                    } else {
                        break; // exit loop if input is valid
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a numeric value for Math marks.");
                    scannerobj.nextLine(); // clear invalid input from scanner buffer
                }
            }

            // Input validation loop for Science marks
            while (true) {
                try {
                    System.out.print("Enter marks for Science : ");
                    scienceMarks = scannerobj.nextInt();
                    if (scienceMarks < 0 || scienceMarks > 100) {
                        System.out.println("Invalid input. Marks must be between 0 and 100.");
                    } else {
                        break; // exit loop if input is valid
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a numeric value for Science marks.");
                    scannerobj.nextLine(); // clear invalid input from scanner buffer
                }
            }

            // Input validation loop for English marks
            while (true) {
                try {
                    System.out.print("Enter marks for English : ");
                    englishMarks = scannerobj.nextInt();
                    if (englishMarks < 0 || englishMarks > 100) {
                        System.out.println("Invalid input. Marks must be between 0 and 100.");
                    } else {
                        break; // exit loop if input is valid
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a numeric value for English marks.");
                    scannerobj.nextLine(); // clear invalid input from scanner buffer
                }
            }

            // Calculate the average
            double average = (mathMarks + scienceMarks + englishMarks) / 3.0;

            // Determine grade based on average
            String grade;
            if (average >= 90) {
                grade = "A+";
            } else if (average >= 80) {
                grade = "A";
            } else if (average >= 70) {
                grade = "B+";
            } else if (average >= 60) {
                grade = "B";
            } else if (average >= 50) {
                grade = "C";
            } else if (average >= 35) {
                grade = "S";
            } else {
                grade = "F";
            }

            System.out.printf("Average: %.2f, Grade: %s%n", average, grade);

            // Asking if the user wants to try again
            System.out.print("Do you want to try again? (Enter Y for yes or N for no): ");
            String response = scannerobj.next().toUpperCase();

            // Validate response for repeat
            repeat = response.equals("Y");
            
            while (!response.equals("Y") && !response.equals("N")) {
                System.out.println("Invalid input. Please enter 'Y' for yes or 'N' for no.");
                // Asking if the user wants to try again
                System.out.print("Do you want to try again? (Enter Y for yes or N for no): ");
                response = scannerobj.next().toUpperCase();
                repeat = response.equals("Y");
            }
        }

        scannerobj.close();  // Close scanner once, after loop ends
        System.out.println("Thank you for using Grade Calculator. Good Luck..!");
    }
}
