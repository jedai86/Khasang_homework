package lesson2;

/**
 * Created by Jedai86 on 09.10.2016.
 */
public class Exercise1 {
    public static void main(String[] args) {
        int a;
        int b;
        System.out.println("Enter first number: ");
        System.out.print("> ");
        a = Shared.getNumberFromUser();
        System.out.println("Enter second number: ");
        System.out.print("> ");
        b = Shared.getNumberFromUser();
        calculate(a, b);
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
