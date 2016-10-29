package seabattle;

class Field {
    private final int SIZE;
    private final char[] field;
    private final char EMPTY_CELL = '.';
    private final char SHIP_CELL = 'X';
    private final char SHIP_DAMAGED = '#';
    private final char SHOOTED_CELL = '*';
    private Ship ship;

    Field(final int size) {
        this.SIZE = size;
        this.field = new char[size];
        this.initialize();
    }

    void initialize() {
        for (int i = 0; i < SIZE; i++) {
            field[i] = EMPTY_CELL;
        }
    }

    void doShoot(final int shoot) throws ArrayIndexOutOfBoundsException {
        switch (field[shoot]) {
            case EMPTY_CELL:
                System.out.println("Промах! ");
                field[shoot] = SHOOTED_CELL;
                break;
            case SHOOTED_CELL:
            case SHIP_DAMAGED:
                System.out.println("Уже стреляли!");
                break;
            case SHIP_CELL:
                field[shoot] = SHIP_DAMAGED;
                ship.damageShip(1);
                if (isKilled()) {
                    System.out.println("Убит!");
                } else {
                    System.out.println("Ранен!");
                }
                break;
        }
    }

    boolean isKilled() {  //TODO переместить в класс Ship?
        return ship.getHealth() == 0;
    }

    boolean continueGame() {
        return !isKilled();
    }

    boolean isValidCell(final int position) {
        return (position < SIZE) && (field[position] == EMPTY_CELL);
    }

    boolean setShip(Ship ship) {
        this.ship = ship;
        for (int i = 0; i < ship.getSize(); i++) {
            if (isValidCell(ship.getPosition() + i)) {
                field[ship.getPosition() + i] = SHIP_CELL;
            } else {
                return false;
            }
        }
        return true;
    }

    void showField() {
        printLines();
        for (int i = 0; i < SIZE; i++) {
            if (field[i] == SHIP_CELL) {
                System.out.print(EMPTY_CELL + "  ");
            } else {
                System.out.print(field[i] + "  ");
            }
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            if (i < 10) {
                System.out.print(i + "  ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        printLines();
    }

    void printLines() {
        for (int i = 0; i < (SIZE+SIZE/2); i++) {
            System.out.print("==");
        }
        System.out.println();
    }
}