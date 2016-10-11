package lesson2;

import java.util.Scanner;

/**
 * Created by Jedai86 on 09.10.2016.
 */
public class Exercise1 {
    public static void main(String[] args) {
        int a;
        int b;
        System.out.println("Enter first number: ");
        System.out.print("> ");
        a = getNumberFromUser();
        System.out.println("Enter second number: ");
        System.out.print("> ");
        b = getNumberFromUser();
        calculate(a, b);
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

    static void calculate(int a, int b) {
        boolean otherCase = true;
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            System.out.println("Multiple of numbers: " + (a*b));
            otherCase = false;
        }
        if (a > b) {
            System.out.println("Difference of numbers: " + (a - b));
            otherCase = false;
        }
        if (a < 0 && b < 0) {
            System.out.println("Sum of numbers: " + (a + b));
            otherCase = false;
        }
        if (otherCase) {
            System.out.println("a Mod b: " + (a % b));
        }
    }

}
