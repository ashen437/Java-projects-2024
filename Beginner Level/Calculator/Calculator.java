import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    static Scanner scanner;
    static int firstnum;
    static int secondnum;

    public Calculator() {
    }

    public static void main(String[] args) {
        System.out.println("Simple Calculator");
        System.out.println("******************");
        chooseTask();
    }

    public static void chooseTask() {
        while(true) {
            try {
                System.out.println("Select the operation to perform");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Get Remainder");
                System.out.println("6. Floor Division");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                if (choice == 0) {
                    System.out.println("Exiting the Calculator...");
                    return;
                }

                System.out.print("Enter your first number: ");
                firstnum = scanner.nextInt();
                System.out.print("Enter your second number: ");
                secondnum = scanner.nextInt();
                int answer6;
                switch (choice) {
                    case 1:
                        int answer1 = firstnum + secondnum;
                        System.out.println(firstnum + " + " + secondnum + " = " + answer1);
                        break;
                    case 2:
                        int answer2 = firstnum - secondnum;
                        System.out.println(firstnum + " - " + secondnum + " = " + answer2);
                        break;
                    case 3:
                        int answer3 = firstnum * secondnum;
                        System.out.println(firstnum + " * " + secondnum + " = " + answer3);
                        break;
                    case 4:
                        if (secondnum != 0) {
                            answer6 = firstnum / secondnum;
                            System.out.println(firstnum + " / " + secondnum + " = " + answer6);
                        } else {
                            System.out.println("Error: Division by zero is not allowed.");
                        }
                        break;
                    case 5:
                        if (secondnum != 0) {
                            answer6 = firstnum % secondnum;
                            System.out.println(firstnum + " % " + secondnum + " = " + answer6);
                        } else {
                            System.out.println("Error: Division by zero is not allowed.");
                        }
                        break;
                    case 6:
                        if (secondnum != 0) {
                            answer6 = firstnum / secondnum;
                            System.out.println(firstnum + " // " + secondnum + " = " + answer6);
                        } else {
                            System.out.println("Error: Division by zero is not allowed.");
                        }
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (InputMismatchException var5) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        }
    }

    static {
        scanner = new Scanner(System.in);
    }
}
