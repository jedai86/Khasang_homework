package lesson2;

/**
 * Created by Jedai86 on 10.10.2016.
 */
public class Exercise2 {
    public static final int NUMBER_COUNT = 10;
    public static int[] numbers = new int[NUMBER_COUNT];

    public static void main(String[] args) {

        System.out.printf("Enter %d numbers: %n", NUMBER_COUNT);
        initializeArray();
        sortArray();
        printArray();
    }

    static void printArray() {
        System.out.println("Array: ");
        for (int num : numbers) {
            System.out.println(num);
        }
    }

    static void initializeArray() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Shared.getNumberFromUser();
        }
    }

    static void sortArray() {
        for (int i = numbers.length - 1; i > 1; i--) {
            for (int j = 0; j < i ; j++) {
                if (numbers[j] < numbers[j+1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = tmp;
                }
            }

        }
    }
}
