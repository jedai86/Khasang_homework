package lesson2;

import java.util.Scanner;

/**
 * Created by Jedai86 on 12.10.2016.
 */
public class Shared {
    static int getNumberFromUser() {
        int num;
        do {
            Scanner scan = new Scanner(System.in);
            if (scan.hasNextInt()) {
                num = scan.nextInt();
                break;
            } else {
                System.out.println("You entered invalid number, try once more");
                System.out.print("> ");
            }
        } while (true);
        return num;
    }

    static void guessWord(char[] word) {
        char[] emptyWordArray = new char[word.length];
        for (int i = 0; i < emptyWordArray.length; i++) {
            emptyWordArray[i] = '_';
        }
        System.out.printf("Your word consists of %d letters: \n", word.length);
        printCharArray(emptyWordArray);
        System.out.println("Enter the letter, or 0 to exit");
        char letter;
        int guessedLetters = 0;
        int counter = 0;
        while (true) {
            boolean guess = false;
            Scanner scan = new Scanner(System.in);
            System.out.printf("> ");
            try {
                letter = scan.nextLine().charAt(0);
                counter++;
            } catch (Exception e) {
                letter = '\r';
            }
            if (letter == '0') {
                break;
            }
            for (int i = 0; i < word.length; i++) {
                if (word[i] == letter && emptyWordArray[i] != word[i]) {
                    emptyWordArray[i] = word[i];
                    guess = true;
                    guessedLetters++;
                }
            }
            if (guess) {
                System.out.println("You guess the letter");
            } else {
                System.out.println("You missed, try once more");
            }
            printCharArray(emptyWordArray);
            if (guessedLetters == word.length) {
                System.out.printf("Congratulations! You guess the word with %d attempts!\n", counter);
                break;
            }
        }
    }

    static void printCharArray(char[] array) {
        for (char c : array) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
