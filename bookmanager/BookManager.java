package bookmanager;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jedai86 on 20.11.2016.
 */
class BookManager {
    private ArrayList<Book> books;
    private Menu menu;
    private int count;

    BookManager() {
        books = new ArrayList<>();
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
                    Book book = new Book(count, title, author);
                    addBook(book);
                    break;
                case SECOND:
                    printAllBooks();
                    break;
                case THIRD:
                    if (count == 0) {
                        System.out.println("Книг нет");
                        break;
                    } else {
                        int id = getNumberId();
                        deleteBook(id);
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

    private void addBook(Book book) {
        books.add(book);
    }

    private void deleteBook(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
            }
        }
    }

    private void printAllBooks() {
        System.out.println("-----------------");
        if (books.size() != 0) {
            for (Book book : books) {
                System.out.println(book);
            }
        } else {
            System.out.println("Книг нет!");
        }
        System.out.println("-----------------");
    }
}
