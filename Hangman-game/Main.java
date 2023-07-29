
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"apple", "banana", "orange", "pineapple","papaya","Chikoo", "pear","guava"};
        String word = words[(int) (Math.random() * words.length)];
        char[] guessedLetters = new char[word.length()];
        int attemptsLeft = 6;

        // Initialize guessedLetters with underscores
        for (int i = 0; i < word.length(); i++) {
            guessedLetters[i] = '_';
        }

        System.out.println("Welcome to Hangman!");
        while (attemptsLeft > 0) {
            System.out.print("Word: ");
            for (char letter : guessedLetters) {
                System.out.print(letter + " ");
            }

            System.out.println("\nAttempts left: " + attemptsLeft);
            System.out.print("Guess a letter: ");
            char guess = scanner.next().charAt(0);

            boolean isCorrectGuess = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    guessedLetters[i] = guess;
                    isCorrectGuess = true;
                }
            }

            if (!isCorrectGuess) {
                attemptsLeft--;
                System.out.println("Incorrect guess!");
            }

            if (word.equals(new String(guessedLetters))) {
                System.out.println("Congratulations! You guessed the word: " + word);
                break;
            }
        }

        if (attemptsLeft == 0) {
            System.out.println("Sorry, you ran out of attempts. The word was: " + word);
        }

        scanner.close();
    }
}
