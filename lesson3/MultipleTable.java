package lesson3;

/**
 * Created by Jedai86 on 20.10.2016.
 */
public class MultipleTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            String p = " ";
            for (int j = 2; j < 6; j++) {
                if (i == 10) {
                    p = "";
                }
                System.out.printf("%d x %s%d = %d\t\t", j, p, i, i * j);
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 1; i <= 10; i++) {
            String p = " ";
            for (int j = 6; j < 10; j++) {
                if (i == 10) {
                    p = "";
                }
                System.out.printf("%d x %s%d = %d\t\t", j, p, i, i * j);
            }
            System.out.println();
        }
    }
}
