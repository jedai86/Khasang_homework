package lesson2;

/**
 * Created by Jedai86 on 09.10.2016.
 */
public class TestIfElse {
    public static void main(String[] args) {
        testIf(10, 20);
        testSwitch(5);
        testWhile(5);
        testDoWhile(66);
        testFor(6);
    }

    static void testFor(int i) {
        for (int j = 0; j < i; j++) {
            System.out.println(i*j);
        }
    }

    static void testDoWhile(int i) {
        do {
            System.out.println(i);
            i++;
        } while (i < 10);
    }

    static void testWhile(int i) {
        while (i < 100) {
            System.out.println(i);
            i++;
        }
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
