package lesson2;

import java.util.Scanner;

/**
 * Created by Jedai86 on 12.10.2016.
 */
public class Shared {
    static int getNumberFromUser() {
        int num;
        do {
            Scanner scan = new Scanner(System.in);
            if (scan.hasNextInt()) {
                num = scan.nextInt();
                break;
            } else {
                System.out.println("You entered invalid number, try once more");
                System.out.print("> ");
            }
        } while (true);
        return num;
    }
}
