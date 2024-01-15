import java.util.Scanner;
import java.util.Random;

public class NumberGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
        int maxAttempts = 7;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game");
        System.out.println("Guess the number between " + minRange + " and " + maxRange);

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guessedNumber = sc.nextInt();
            attempts++;

            if (guessedNumber == targetNumber) {
                System.out.println(" You guessed the correct number.");
                break;
            } else if (guessedNumber < targetNumber) {
                System.out.println("Too low. Try again");
            } else {
                System.out.println("Too high. Try again");
            }
        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry! You've run out of attempts. The correct number was: " + targetNumber);
            System.out.println( "Your Score = "+ attempts+" i.e. Failed");
        }
    }
}

