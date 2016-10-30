package lesson2;

/**
 * Created by Jedai86 on 12.10.2016.
 */
public class Exercise4 {
    public static void main(String[] args) {
        final int MIN_VALUE = 1;
        final int MAX_VALUE = 10;
        final int EXIT_VALUE = 0;
        final int TARGET_SUM = 21;
        System.out.printf("Enter numbers from %d to %d (enter %d to exit): %n> ", MIN_VALUE, MAX_VALUE, EXIT_VALUE);
        int sum = 0;
        while (true) {
            int n = Shared.getNumberFromUser();
            if ((n >= -MAX_VALUE) && (n <= MAX_VALUE)) {
                if (n == EXIT_VALUE) {
                    System.out.println("You don't reach target sum, try later");
                    return;
                } else {
                    sum += n;
                }
            } else {
                System.out.println("Invalid number, enter another");
            }
            if (sum == TARGET_SUM) {
                System.out.println("You reached target sum!");
                return;
            }
            System.out.print("> ");
        }
    }
}
