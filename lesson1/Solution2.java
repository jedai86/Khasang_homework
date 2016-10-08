package lesson1;

/**
 * Created by Jedai86 on 08.10.2016.
 */
public class Solution2 {
    public static void main(String[] args) {
        calculateProgression(0, 5);
    }

    static void calculateProgression(int a, int q) {
        System.out.println(a);
        if (a > 100) {
            return;
        }
        int b = a + q;
        calculateProgression(b, q);
    }
}
