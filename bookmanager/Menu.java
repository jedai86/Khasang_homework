package bookmanager;


import java.util.Scanner;

class Menu {

    Menu() {
    }

    void printMenu() {
        System.out.printf("--Менеджер книг--%n" +
                "%d. Добавить книгу%n" +
                "%d. Показать все книги%n" +
                "%d. Удалить книгу%n" +
                "%d. Выход%n-----------------%n", MenuItem.FIRST.getNum(), MenuItem.SECOND.getNum(), MenuItem.THIRD.getNum(), MenuItem.LAST.getNum());
    }

    MenuItem getMenuItemFromUser() {
        System.out.printf("Введите номер пункта меню%n>");
        Scanner scan = new Scanner(System.in);
        int num;
        while (true) {
            if (scan.hasNextInt()) {
                num = scan.nextInt();
                if (num >= MenuItem.FIRST.getNum() && num <= MenuItem.LAST.getNum()) {
                    switch (num) {
                        case 1:
                            return MenuItem.FIRST;
                        case 2:
                            return MenuItem.SECOND;
                        case 3:
                            return MenuItem.THIRD;
                        case 4:
                            return MenuItem.LAST;
                    }
                } else {
                    scan.nextLine();
                    System.out.printf("Неправильный пункт меню! Введите еще раз%n>");
                }
            } else {
                scan.nextLine();
                System.out.printf("Неправильный пункт меню! Введите еще раз%n>");
            }
        }
    }
}