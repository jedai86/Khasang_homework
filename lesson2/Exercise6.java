package lesson2;

import java.io.Console;
import java.util.Scanner;

/**
 * Created by Jedai86 on 13.10.2016.
 */
public class Exercise6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\"Guess the word game\" for 2 players");
        System.out.printf("Enter the name of the first player:\n> ");
        String player1 = scan.nextLine();
        System.out.printf("Enter the name of the second player:\n> ");
        String player2 = scan.nextLine();
        while (true) {
            System.out.println("Type 's' to start or 'q' to exit");
            String s = scan.nextLine();
            if (s.toLowerCase().equals("q")) {
                break;
            }
            System.out.println("Begin the game for the first player");
            playGame(player1);
            System.out.println("Begin the game for the second player");
            playGame(player2);
        }
    }

    static void playGame(String playerName) {
        Console cons = System.console();
        Scanner scan = new Scanner(System.in);
        char[] wordToGuess;
        System.out.printf("%s, please, enter your word:\n> ", playerName);
        try {
            if (cons != null) {  //Secure method, it doesn't display characters in console input. Doesn't work in IDE, only in real console!
                wordToGuess = cons.readPassword("Word (not displayed for secure): ");
                Shared.guessWord(wordToGuess);
            } else {
                String word = scan.nextLine();
                wordToGuess = word.toLowerCase().toCharArray();
                Shared.guessWord(wordToGuess);
            }
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }
}
