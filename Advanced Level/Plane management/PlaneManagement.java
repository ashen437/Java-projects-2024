import java.util.InputMismatchException;
import java.util.Scanner;

public class PlaneManagement {

    static int[] seat_name_A = new int[14];
    static int[] seat_name_B = new int[12];
    static int[] seat_name_C = new int[12];
    static int[] seat_name_D = new int[14];
    static Ticket[] array_tickets = new Ticket[52];
    static int ticketCount = 0;
    static Scanner print_scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome to the Plane Management application");
        System.out.println();
        initializeSeats();
        displayMenu();
    }

    /* method I used to fill array with zeros before code start, so when seating plan run we have zero values in seats, that didn't sold
    during session */
    static void initializeSeats() {
        for (int i = 0; i < seat_name_A.length; i++) {
            seat_name_A[i] = 0;
        }
        for (int i = 0; i < seat_name_B.length; i++) {
            seat_name_B[i] = 0;
        }
        for (int i = 0; i < seat_name_C.length; i++) {
            seat_name_C[i] = 0;
        }
        for (int i = 0; i < seat_name_D.length; i++) {
            seat_name_D[i] = 0;
        }
    }

    //method that display the menu options
    static void displayMenu() {
        
        while (true) {
            try{
            System.out.println("********************************************\n");
            System.out.println("*                 Menu Option                *");
            System.out.println("\n********************************************");
            System.out.println("1. Buy a seat");
            System.out.println("2. Cancel a seat");
            System.out.println("3. Find first available seat");
            System.out.println("4. Show seating plan");
            System.out.println("5. Print tickets information and total sales");
            System.out.println("6. Search ticket");
            System.out.println("0. Exit");
            System.out.println("********************************************");
            System.out.print("Enter your choice: ");
        
    
            

                int option = print_scanner.nextInt();

                switch (option) {
                    case 0:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    case 1:
                        buy_Seat();
                        break;
                    case 2:
                        cancel_Seat();
                        break;
                    case 3:
                        find_First_Available();
                        break;
                    case 4:
                        show_Seating_Plan();
                        break;
                    case 5:
                        print_tickets_info();
                        break;
                    case 6:
                        searchTicket();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again with valid number.");
                    }
                }    
                catch (InputMismatchException e) {
                System.out.println("Invalid input type. Please try again with valid data type.");
                System.out.println();
                print_scanner.next(); // Clear the invalid input from the scanner
                
                }
            }

        }
        
    

    //method that run buy seats in menu option
    static void buy_Seat() {
        while (true) {
            try {
                System.out.println("--------------------------------");
                System.out.println("            Buy Seat");
                System.out.println("--------------------------------");
                System.out.print("Enter row letter (A-D): ");
                char row = Character.toUpperCase(print_scanner.next().charAt(0));
                System.out.print("Enter seat number: ");
                int seatNumber = print_scanner.nextInt();

                int[] seats = getSeatsArray(row);

                if (isValidSeat(row, seatNumber)) {
                    if (seats[seatNumber - 1] == 0) {
                        System.out.print("Enter first name: ");
                        String name = print_scanner.next();

                        System.out.print("Enter surname: ");
                        String surname = print_scanner.next();

                        System.out.print("Enter email: ");
                        String email = print_scanner.next();

                        Person person = new Person(name, surname, email);
                        Ticket ticket = new Ticket( row, seatNumber, calculatePrice(row,seatNumber), person);
                        array_tickets[ticketCount++] = ticket;
                        Ticket save_ticket = new Ticket( row, seatNumber, calculatePrice(row,seatNumber), person);
                        save_ticket.save();

                        seats[seatNumber - 1] = 1; // Mark seat as sold for that row and seat number
                        System.out.println("Seat successfully sold!");
                        break;
                    } else {
                        System.out.println("Seat already sold.\nPlease enter 1 to choose another seat \nenter 0 to back to menu options.");
                        System.out.print("Enter your choice: ");
                        int input_ = print_scanner.nextInt();
                        
                        if(input_==0){
                            break;
                        }else{
                            System.out.println();
                        }


                    }
                } else {
                    System.out.println();
                }
            } 
            catch (InputMismatchException e) {
                System.out.println("Invalid row or seat number. Please try again.");
                print_scanner.next(); // Clear the invalid input from the scanner
            }

        }
    }

    //method that run cancel seat in menu option
    static void cancel_Seat() {
        
            try {
                System.out.println("--------------------------------");
                System.out.println("          Cancel Seat");
                System.out.println("--------------------------------");
                System.out.print("Enter row letter (A-D): ");
                char row = Character.toUpperCase(print_scanner.next().charAt(0));
                System.out.print("Enter seat number: ");
                int seatNumber = print_scanner.nextInt();

                int[] seats = getSeatsArray(row);

                if (isValidSeat(row, seatNumber)) {
                    if (seats[seatNumber - 1] == 1) {
                        seats[seatNumber - 1] = 0; // Mark seat as available again
                        
                        System.out.println("Seat successfully cancelled and made available again!");
                        
                    } else {
                        System.out.println("Seat is already available.");
                    }
                } 
                
                else {
                    System.out.println("Invalid row or seat number. Please try again.");
                }
            
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid row or seat number. Please try again.");
                print_scanner.next(); // Clear the invalid input from the scanner
            }
        
    }

    //method that run first available seat in menu option
    static void find_First_Available() {
        System.out.println("--------------------------------");
        System.out.println("     Find First Available");
        System.out.println("--------------------------------");
        for (char i = 'A'; i< 'E'; i ++) {
            int[] seats_ = firstavailabseats(i);
            int j = 0;
            while (j<seats_.length) {
                if (seats_[j] == 0) {
                   System.out.println("Found a seat in row " + i + " seat number is " + Integer.valueOf(j + 1));
                   
                   break; 
                }
                j++;
            }
            
        }
        
    }

    //method that run seating palan in menu option
    static void show_Seating_Plan() {

        System.out.println("--------------------------------");
        System.out.println("       Show seating plan");
        System.out.println("--------------------------------");
        System.out.println();

        System.out.print("Row A: ");
        printSeatRow(seat_name_A);
        System.out.print("Row B: ");
        printSeatRow(seat_name_B);
        System.out.print("Row C: ");
        printSeatRow(seat_name_C);
        System.out.print("Row D: ");
        printSeatRow(seat_name_D);
    }


    //method that print seat row in showing seating plan
    static void printSeatRow(int[] seats) {

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                System.out.print("O "); // Available seat
            } else {
                System.out.print("X "); // Sold seat
            }
        }
        System.out.println(); // Move to the next row
    }

    //method that check seat number valid or not according to their row
    static boolean isValidSeat(char row, int seatNumber) {
        switch (row) {
            case 'A':
                if (seatNumber >= 1 && seatNumber <= 14) {
                    return true;
                }else{
                    System.out.println("Invalid seat number. Please try again.");
                    return false;
                }
                
            case 'B':
                if (seatNumber >= 1 && seatNumber <= 12) {
                    return true;
                }else{
                    System.out.println("Invalid seat number. Please try again.");
                    return false;
                }

            case 'C':
                if (seatNumber >= 1 && seatNumber <= 12) {
                    return true;
                }else{
                    System.out.println("Invalid seat number. Please try again.");
                    return false;
                }
                
            case 'D':
                if (seatNumber >= 1 && seatNumber <= 12) {
                    return true;
                }else{
                    System.out.println("Invalid seat number. Please try again.");
                    return false;
                }
            
            default:
                System.out.println("Invalid row number. Please try again.");
                return false;
        }
    }

    //method that choose right array according to seat row letter
    static int[] getSeatsArray(char row) {
        switch (row) {
            case 'A':
                return seat_name_A;
            case 'B':
                return seat_name_B;
            case 'C':
                return seat_name_C;
            default :
                return seat_name_D;    
        }
    }
    

    //method that calculate prices according to seat number
    static double calculatePrice(char row,int seatNumber){
        switch (seatNumber) {
            case 1,2,3,4,5:
                return 200.00;
            case 6,7,8,9:
                return 150.00;
            default:
                return 180.00;
            }
    }
    
    //method that run print_ticket_info in menu option
    static void  print_tickets_info() {
        System.out.println("------------------------------------------------------");
        System.out.println("      Tickets information and total sales");
        System.out.println("------------------------------------------------------");
        
        double totalAmount = 0; // Initialize total amount
        
        // Iterate over each row
        for (char i = 'A'; i <= 'D'; i++) {
            int[] seats_ = firstavailabseats(i);
            
            // Iterate over each seat in the row
            for (int j = 0; j < seats_.length; j++) {
                if (seats_[j] == 1) { // Check if the seat is sold
                    for (Ticket ticket : array_tickets) {
                        // Check if the ticket matches the row and seat number
                        if (ticket != null && ticket.getRow() == i && ticket.getSeatNumber() == j + 1) {
                            // Print the information of the found ticket
                            System.out.println("Ticket Information:");
                            ticket.printTicketInfo();
                            totalAmount += ticket.getPrice(); // Add ticket price to total amount
                            System.out.println();
                        }
                    }
                }
            }
        }
        // Print total amount after printing all ticket information
        System.out.println("Total Amount Of Sales: £" + totalAmount);
    }
    

    //method that help for choosing right array for first available seat 
    static int[] firstavailabseats(char i) {
        switch (i) {
            case 'A':
                return seat_name_A;
            case 'B':
                return seat_name_B;
            case 'C':
                return seat_name_C;
            default :
                return seat_name_D;
    
        }
    } 

    //method that run search ticket in menu
    static void searchTicket() {
        
            try {
                System.out.println("--------------------------------");
                System.out.println("        Search Ticket");
                System.out.println("--------------------------------");
                System.out.print("Enter row letter (A-D): ");
                char row = Character.toUpperCase(print_scanner.next().charAt(0));
                System.out.print("Enter seat number: ");
                int seatNumber = print_scanner.nextInt();

                int[] seats = getSeatsArray(row);

                if (isValidSeat(row, seatNumber)) {
                    if (seats[seatNumber - 1] == 0) {

                        System.out.println("This seat is available.");
                        // Iterate through each ticket in the tickets ArrayList

                    }
                    else {
                        System.out.println("Seat already sold.Here required informations about that ticket's buyer.");
                        for (Ticket ticket : array_tickets) {
                            // Check if the ticket matches the provided row and seat number
                            if (ticket.getRow() == row && ticket.getSeatNumber() == seatNumber) {
                                // Print the information of the found ticket
                                System.out.println("Ticket Information:");
                                ticket.printTicketInfo();
                                break; // Exit the loop once the ticket is found
                        
                            }
                        }
                    }
                }
                else {
                    System.out.println("Invalid row or seat number. Please try again.");
                
                }

            }
            catch (InputMismatchException e) {
            System.out.println("Invalid row or seat number. Please try again.");
            
            }
            
        
    }
}
