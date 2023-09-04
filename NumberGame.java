import java.util.*;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //object creating
        Random random = new Random();
        int lowerLimit = 1;//defining the lowest value
        int upperLimit = 100;//defining the highest value
        int maxAttempts = 7;//defining no.of attempts
        int rounds = 0;
        int totalAttempts = 0;

        while (true) {
            rounds++;//incrementing the value
            System.out.println("\nRound " + rounds);

            int secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int attempts = playRound(secretNumber, maxAttempts);
            totalAttempts += attempts;

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        double averageAttempts = rounds > 0 ? (double) totalAttempts / rounds : 0;
        System.out.println("\nGame Over! You played " + rounds + " round(s) and your average score is " + String.format("%.2f", averageAttempts) + " attempts per round.");
    }

    public static int playRound(int secretNumber, int maxAttempts) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        System.out.println("I'm thinking of a number between 1 and 100. You have " + maxAttempts + " attempts.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > secretNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number " + secretNumber + " correctly in " + attempts + " attempts.");
                return attempts;
            }

            System.out.println("You have " + (maxAttempts - attempts) + " attempt(s) remaining.");
        }

        System.out.println("Out of attempts! The correct number was " + secretNumber + ".");
        return 0;
    }
}