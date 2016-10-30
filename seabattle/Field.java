package seabattle;

class Field {
    private final int SIZE;
    private final char[] field;
    private final char EMPTY_CELL = '.';
    private final char SHIP_CELL = 'X';
    private final char SHIP_DAMAGED = '#';
    private final char SHOOTED_CELL = '*';
    private Ship[] ships;
    private int shipsAliveCount;

    Field(final int size, final Ship[] ships) {
        this.SIZE = size;
        this.field = new char[size];
        this.ships = ships;
        this.initialize();
        this.shipsAliveCount = ships.length;
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
                int i = findShipIndex(shoot);
                ships[i].damageShip();
                if (ships[i].isKilled()) {
                    System.out.print("Этот корбаль убит! ");
                    shipsAliveCount--;
                    System.out.printf("Вам осталось %d кораблей%n", shipsAliveCount);
                } else {
                    System.out.println("Этот корабль ранен!");
                }
                break;
        }
    }

    int findShipIndex(int coordinate) {
        for (int i = 0; i < ships.length; i++) {
            if (coordinate >= ships[i].getPosition() && coordinate < (ships[i].getPosition() + ships[i].getSize())) {
                return i;
            }
        }
        return -1;
    }

    boolean continueGame() {
        return shipsAliveCount > 0;
    }

    boolean isValidCell(final int position, final int size) {
        if (position >= SIZE) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (field[position + i] != EMPTY_CELL) return false;
        }
        return true;
    }

    boolean setShip(Ship ship) {
        if (isValidCell(ship.getPosition(), ship.getSize())) {
            for (int i = 0; i < ship.getSize(); i++) {
                field[ship.getPosition() + i] = SHIP_CELL;
            }
        } else {
            return false;
        }
        return true;
    }

    void showField() {
        printLines();
        for (int i = 0; i < SIZE; i++) {
            //       if (field[i] == SHIP_CELL) {
            //           System.out.print(EMPTY_CELL + "  ");
            //       } else {
            System.out.print(field[i] + "  ");
            //       }
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
        for (int i = 0; i < (SIZE + SIZE / 2); i++) {
            System.out.print("==");
        }
        System.out.println();
    }
}