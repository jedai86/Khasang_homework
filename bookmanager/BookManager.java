package bookmanager;

import java.util.Scanner;

/**
 * Created by Jedai86 on 20.11.2016.
 */
class BookManager {
    private Book book;
    private Books books;
    private Menu menu;
    private int count;

    BookManager() {
        books = new Books();
        menu = new Menu();
    }

    void start() {
        do {
            menu.printMenu();
            switch (menu.getMenuItemFromUser()) {
                case FIRST:
                    System.out.println("Введите автора книги: ");
                    String author = getString();
                    System.out.println("Введите нзвание книги: ");
                    String title = getString();
                    count++;
                    book = new Book(count,title, author);
                    books.addBook(book);
                    break;
                case SECOND:
                    books.printAllBooks();
                    break;
                case THIRD:
                    System.out.println("Введите ID книги для удаления");
                    int id = getNumberId();
                    books.deleteBook(id);
                    break;
                case LAST:
                    return;
            }
        } while (true);
    }

    String getString() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    int getNumberId() {
        Scanner scan = new Scanner(System.in);
        int num;
        while (true) {
            if (scan.hasNextInt()) {
                num = scan.nextInt();
                if (num > 0 && num <= count) {
                    return num;
                } else {
                    scan.nextLine();
                    System.out.printf("Неправильный ID! Введите еще раз%n>");
                }
            } else {
                scan.nextLine();
                System.out.printf("Неправильный ID! Введите еще раз%n>");
            }
        }
    }
}
