package seabattle;

import java.util.Scanner;

class Player {
    private String name;

    void setName() {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Введите ваше имя: %n> ");
        this.name = scan.nextLine();
    }

    String getName() {
        return name;
    }

    int getShoot() {
        Scanner scan = new Scanner(System.in);
        int shoot;
        System.out.printf("%s, введите координату выстрела: %n> ", name);
        while (true) {
            if (scan.hasNextInt()) {
                shoot = scan.nextInt();
                break;
            } else {
                scan.nextLine();
                System.out.printf("Не правильная координата, введите другую: %n> ");
            }
        }
        System.out.printf("%s, ваш выстрел: %d%n", name, shoot);
        return shoot;
    }
}