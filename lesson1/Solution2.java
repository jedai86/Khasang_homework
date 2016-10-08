package lesson1;

/**
 * Created by Jedai86 on 08.10.2016.
 */
public class Solution2 {
    public static void main(String[] args) {
        calculateProgression(0, 5);
    }

    static int calculateProgression(int a, int q) {
        System.out.println(a);
        int result;
        if (a >= 100) {
            return a;
        }
        result = calculateProgression(a + q, q);
        return result;
        //gdfgdfg
    }
}
