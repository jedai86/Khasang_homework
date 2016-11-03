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

    int getShoot(final String coordinateName, final int gameSize) {
        Scanner scan = new Scanner(System.in);
        int shoot;
        System.out.printf("%s, введите координату выстрела по оси %s: %n> ", name, coordinateName);
        while (true) {
            if (scan.hasNextInt()) {
                shoot = scan.nextInt();
                if (shoot >= 0 && shoot < gameSize) {
                    break;
                } else {
                    scan.nextLine();
                    System.out.printf("Не правильная координата, введите другую: %n> ");
                }
            } else {
                scan.nextLine();
                System.out.printf("Не правильная координата, введите другую: %n> ");
            }
        }
        return shoot;
    }
}