package lesson2;

/**
 * Created by Jedai86 on 09.10.2016.
 */
public class TestIfElse {
    public static void main(String[] args) {
        testIf(10, 20);
        testSwitch(5);
    }

    static void testSwitch(int grade) {
        switch (grade) {
            case 5:
                System.out.println("Best!");
                break;
            case 4:
                System.out.println("Good");
                break;
            case 3:
                System.out.println("Normal");
                break;
            case 2:
            case 1:
                System.out.println("Bad!");
                break;
            default:
                System.out.println("Not valid");
        }
    }

    static void testIf(int a, int b) {
        if (a > b) {
            System.out.println("a > b");
        } else {
            System.out.println("a <= b");
        }
    }
}
