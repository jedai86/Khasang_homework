package lesson2;

import java.util.Scanner;

/**
 * Created by Jedai86 on 10.10.2016.
 */
public class Exercise2 {
    public static final int NUMBER = 10;

    public static void main(String[] args) {
        int[] nums = new int[NUMBER];
        System.out.printf("Enter %d numbers: \n", NUMBER);
        initializeArray(nums);
        sortArray(nums);
        printArray(nums);
    }

    static void printArray(int[] nums) {
        System.out.println("Array: ");
        for (int num : nums) {
            System.out.println(num);
        }
    }

    static void printErrMessage() {
        System.out.println("Not valid number, enter another: ");
    }

    static void initializeArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean notExit = true;
            do {
                Scanner scan = new Scanner(System.in);
                if (scan.hasNextInt()) {
                    nums[i] = scan.nextInt();
                    notExit = false;
                } else {
                    printErrMessage();
                }
            } while (notExit);
        }
    }

    static void sortArray(int[] nums) {
        for (int i = nums.length - 1; i > 1; i--) {
            for (int j = 0; j < i ; j++) {
                if (nums[j] < nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }

        }
    }
}
