package GuessTheNumber;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
   public GuessTheNumber() {
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Random random = new Random();
      System.out.println("Welcome To Houdini's Magic Number Guessing Game");
      System.out.println("I have a Number between 1 and 100. Can you guess the number within 7 lucky guesses?");
      System.out.println("Well, if you do it, you are a pretty awesome guesser!");
      System.out.println("Let's start!");

      String playAgain;
      do {
         int numberToGuess = random.nextInt(100) + 1;
         int numberOfTries = 1;
         int userGuess = 0;
         boolean validInput = false;

         while(numberOfTries < 8 && userGuess != numberToGuess) {
            do {
               System.out.print("Enter Your Guess Number: ");

               try {
                  userGuess = scanner.nextInt();
                  if (userGuess >= 1 && userGuess <= 100) {
                     validInput = true;
                  } else {
                     validInput = false;
                     System.out.println("Invalid Input! Please enter a number between 1 and 100.");
                  }
               } catch (InputMismatchException var9) {
                  System.out.println("Invalid Input! Please enter a valid number between 1 and 100.");
                  scanner.next();
                  validInput = false;
               }
            } while(!validInput);

            ++numberOfTries;
            if (userGuess < numberToGuess) {
               System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
               System.out.println("Too high! Try again.");
            } else {
               System.out.println("Congratulations little Houdini! You've guessed the number in " + numberOfTries + " tries.");
            }

            if (numberOfTries == 8 && userGuess != numberToGuess) {
               System.out.println("Sorry! You've reached the maximum number of guesses.");
               System.out.println("The correct number was " + numberToGuess);
            }
         }

         do {
            System.out.print("Do you want to play again? (Y/N): ");
            playAgain = scanner.next().trim().toUpperCase();
            if (!playAgain.equals("Y") && !playAgain.equals("N")) {
               System.out.println("Invalid choice! Please enter Y or N.");
            }
         } while(!playAgain.equals("Y") && !playAgain.equals("N"));
      } while(playAgain.equals("Y"));

      System.out.println("Thanks for playing!");
      scanner.close();
   }
}
