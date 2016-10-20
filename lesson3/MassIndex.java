package lesson3;

import java.util.Scanner;

/**
 * Created by Jedai86 on 20.10.2016.
 */
public class MassIndex {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите рост в см: ");
        double height = (scan.nextDouble()) / 100.0;
        System.out.println("Введите вес в кг: ");
        double weight = scan.nextDouble();
        double massIndex = massIndex(height, weight);
        System.out.printf("Идекс массы тела равен: %.2f%n", massIndex);
        diagnoz(massIndex);
    }

    private static double massIndex(double height, double weight) {
        return weight / (height * height);
    }

    private static void diagnoz(double massIndex) {
        System.out.print("Ваш диагноз: ");
        if (massIndex <= 16.0) {
            System.out.println("Выраженный дефицит массы тела");
        } else if (massIndex > 16.0 && massIndex < 18.5) {
            System.out.println("Недостаточная (дефицит) масса тела");
        } else if (massIndex >= 18.5 && massIndex < 25) {
            System.out.println("Норма");
        } else if (massIndex >= 25 && massIndex < 30) {
            System.out.println("Избыточная масса тела (предожирение)");
        } else if (massIndex >= 30 && massIndex < 35) {
            System.out.println("Ожирение первой степени");
        } else if (massIndex >= 35 && massIndex < 40) {
            System.out.println("Ожирение второй степени");
        } else if (massIndex >= 40) {
            System.out.println("Ожирение третьей степени (морбидное)");
        }
    }
}
