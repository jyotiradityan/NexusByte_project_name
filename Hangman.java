import java.util.Scanner;
import java.util.Random;

public class HangmanGame {
    private static final String[] words = {"apple", "banana", "orange", "grape", "pear"};
    private static final int MAX_TRIES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String wordToGuess = words[random.nextInt(words.length)];
        char[] guessedLetters = new char[wordToGuess.length()];
        int tries = 0;

        // Initialize the guessedLetters array with underscores
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }

        while (true) {
            if (tries == MAX_TRIES) {
                System.out.println("You've reached the maximum number of tries. Game over!");
                break;
            }

            // Display the current state of the word with underscores for unguessed letters
            System.out.println("Current word: " + String.valueOf(guessedLetters));

            // Ask the player to guess a letter
            System.out.print("Guess a letter: ");
            char guess = scanner.next().charAt(0);

            // Check if the guessed letter is in the word
            boolean correctGuess = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedLetters[i] = guess;
                    correctGuess = true;
                }
            }

            if (correctGuess) {
                System.out.println("Correct guess!");
            } else {
                System.out.println("Incorrect guess. You have " + (MAX_TRIES - tries - 1) + " tries left.");
                tries++;
            }

            // Check if the word has been guessed completely
            if (String.valueOf(guessedLetters).equals(wordToGuess)) {
                System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
                break;
            }
        }

        scanner.close();
    }
}