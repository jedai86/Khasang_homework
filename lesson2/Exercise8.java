package lesson2;

import java.util.Scanner;

/**
 * Created by Jedai86 on 16.10.2016.
 */
public class Exercise8 {
    private static final char EMPTY_CHAR = '_';
    private static final int ROW_SIZE = 3;
    private static final char[] field = new char[ROW_SIZE * ROW_SIZE];
    private static final char player1Char = 'X';
    private static final char player2Char = 'O';

    public static void main(String[] args) {
        for (int i = 0; i < field.length; i++) {
            field[i] = EMPTY_CHAR;
        }
    }
//TODO
    static void showField() {
        for (int i = 0; i < field.length; i++) {
            System.out.print(field[i] + " ");
            if ((i + 1) % ROW_SIZE == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
