package bookmanager;


class Book {
    private int id;
    private String title;
    private String author;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return id + ". " + author + " - " + title + ".";
    }
}
