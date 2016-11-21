package bookmanager;


import java.util.Scanner;

class Menu {
    private MenuItem[] menuItems;

    Menu() {
        menuItems = MenuItem.values();
    }

    void printMenu() {
        System.out.println("--Менеджер книг--");
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem);
        }
        System.out.println("-----------------");
    }

    MenuItem getMenuItemFromUser() {
        System.out.printf("Введите номер пункта меню%n>");
        while (true) {
            int num = getNumberFromUser();
            if (num >= MenuItem.FIRST.getNum() && num <= MenuItem.LAST.getNum()) {
                for (MenuItem menuItem : menuItems) {
                    if (num == menuItem.getNum()) {
                        return menuItem;
                    }
                }
            } else {
                System.out.printf("Неправильный пункт меню! Введите еще раз%n>");
            }
        }
    }

    int getNumberFromUser() {
        Scanner scan = new Scanner(System.in);
        int num;
        while (true) {
            if (scan.hasNextInt()) {
                num = scan.nextInt();
                return num;
            } else {
                scan.nextLine();
                System.out.printf("Неправильное значение! Введите еще раз%n>");
            }
        }
    }
}
