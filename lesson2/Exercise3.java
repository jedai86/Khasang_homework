package lesson2;

/**
 * Created by Jedai86 on 11.10.2016.
 */
public class Exercise3 {
    public static void main(String[] args) {
        System.out.print("Enter k: \n> ");
        int k = Shared.getNumberFromUser();
        System.out.print("Enter t: \n> ");
        int t = Shared.getNumberFromUser();
        System.out.print("Enter n: \n> ");
        int n = Shared.getNumberFromUser();
        int[] array1 = new int[n];
        int[] array2 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = k*(i-t);
            array2[i] = k + t - i;
        }
        printArray(array1);
        printArray(array2);
    }

    static void printArray(int[] array) {
        System.out.print("[");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }

}
