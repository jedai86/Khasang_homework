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
        while (true) {
            menu.printMenu();
            switch (menu.getMenuItemFromUser()) {
                case FIRST:
                    System.out.println("Введите автора книги: ");
                    String author = getString();
                    System.out.println("Введите нзвание книги: ");
                    String title = getString();
                    count++;
                    book = new Book(count, title, author);
                    books.addBook(book);
                    break;
                case SECOND:
                    books.printAllBooks();
                    break;
                case THIRD:
                    if (books.getCount() == 0) {
                        System.out.println("Книг нет");
                        break;
                    } else {
                        int id = getNumberId();
                        books.deleteBook(id);
                        break;
                    }
                case LAST:
                    return;
            }
        }
    }

    private String getString() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    private int getNumberId() {
        int id;
        System.out.println("Введите ID книги для удаления");
        while (true) {
            id = menu.getNumberFromUser();
            if (id > 0 && id <= count) {
                return id;
            } else {
                System.out.printf("Неправильный ID! Введите еще раз%n>");
            }
        }
    }
}
