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

    void deleteBook(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
            }
        }
    }

    void printAllBooks() {
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
