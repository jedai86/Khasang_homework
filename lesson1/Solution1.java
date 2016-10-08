package lesson1;

/**
 * Created by Jadai86 on 08.10.2016.
 */
public class Solution1 {
    public static void main(String[] args) {
        testStackOverflow();
        testStackOverflow(100);
        testStackOverflow(100.52);
    }

    static void testStackOverflow() {
        System.out.println("Metod 1");
    }

    static void testStackOverflow(int a) {
        System.out.println("Metod 1 " + a);
        testStackOverflow(a + 1);
    }

    static void testStackOverflow(double a) {
        System.out.println("Metod 1 " + a);
    }
}
