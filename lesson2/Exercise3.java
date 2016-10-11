package lesson2;

import java.util.Scanner;

/**
 * Created by Jedai86 on 11.10.2016.
 */
public class Exercise3 {
    public static void main(String[] args) {
        System.out.print("Enter k: \n> ");
        int k = getNumberFromUser();
        System.out.print("Enter t: \n> ");
        int t = getNumberFromUser();
        System.out.print("Enter n: \n> ");
        int n = getNumberFromUser();
        int[] array1 = new int[n];
        int[] array2 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = k*(i-t);
            array2[i] = k + t - i;
        }
        printArray(array1);
        printArray(array2);
    }

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

    static void printArray(int[] array) {
        System.out.print("[");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }

}
