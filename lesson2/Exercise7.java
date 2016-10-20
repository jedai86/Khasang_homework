package lesson2;

import java.util.Scanner;

/**
 * Created by Jedai86 on 14.10.2016.
 */
public class Exercise7 {
    private static final char EMPTY_CHAR = '_';
    private static final int ROW_SIZE = 3;
    private static char[] field = new char[ROW_SIZE * ROW_SIZE];

    public static void main(String[] args) {

        for (int i = 0; i < field.length; i++) {
            field[i] = EMPTY_CHAR;
        }
        int count = field.length;
        System.out.println("Put your char into an array");

        while (count > 0) {
            Scanner scan = new Scanner(System.in);
            boolean isValid = false;
            showField();
            System.out.printf("Enter number of element to put your char (from 1 to %d) or 0 to exit:%n> ", field.length);
            int elementNumber = Shared.getNumberFromUser();

            if (elementNumber <= field.length && elementNumber > 0) {
                if (field[elementNumber - 1] == '_') {
                    isValid = true;
                } else {
                    System.out.println("Element is not empty!");
                }
            } else if (elementNumber == 0) {
                break;
            } else {
                System.out.println("Invalid number of element, try another");
            }

            if (isValid) {
                System.out.printf("Enter char:%n> ");
                char c = scan.nextLine().charAt(0);
                field[elementNumber - 1] = c;
                count--;
            }
        }
    }

    static void showField() {
        for (int i = 0; i < field.length; i++) {
            System.out.print(field[i] + " ");
            if ((i + 1) % ROW_SIZE == 0) {
                System.out.println();
            }
        }
    }
}
