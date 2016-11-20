package bookmanager;

import java.util.ArrayList;

class Books {
    private ArrayList<Book> books;

    Books() {
        books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
    }

    void deleteBook(Book book) {
        books.remove(book);
    }

    void printAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
