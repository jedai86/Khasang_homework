package bookmanager;


enum MenuItem {
    FIRST(1), SECOND(2), THIRD(3), LAST(4);

    private int num;

    MenuItem(int num) {
        this.num = num;
    }

    int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}
