package bookmanager;


enum MenuItem {
    FIRST(1, "Добавить книгу"), SECOND(2, "Показать все книги"), THIRD(3, "Удалить книгу"), LAST(4, "Выход");

    private int num;
    private String menuString;

    MenuItem(int num, String menuString) {
        this.num = num;
        this.menuString = menuString;
    }

    int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return String.valueOf(num) + ". " + menuString;
    }
}
