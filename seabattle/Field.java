package seabattle;

class Field {
    private final int size;
    private final Figure[] field;
    private int shipsAliveCount;
    private Ship[] ships;

    Field(final int size, final Ship[] ships) {
        this.size = size;
        this.field = new Figure[size];
        this.ships = ships;
        this.shipsAliveCount = ships.length;
        this.initialize();
    }

    void doShoot(final int shoot) throws ArrayIndexOutOfBoundsException {
        switch (field[shoot]) {
            case EMPTY:
                System.out.println("Промах! ");
                field[shoot] = Figure.MISSED;
                break;
            case MISSED:
            case DAMAGED:
                System.out.println("Уже стреляли!");
                break;
            case SHIP:
                field[shoot] = Figure.DAMAGED;
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

    boolean continueGame() {
        return shipsAliveCount > 0;
    }

    boolean setShip(final Ship ship) {
        if (isValidCell(ship.getPosition(), ship.getSize())) {
            for (int i = 0; i < ship.getSize(); i++) {
                field[ship.getPosition() + i] = Figure.SHIP;
            }
        } else {
            return false;
        }
        return true;
    }

    void showField() {
        printLines();
        for (int i = 0; i < size; i++) {
            if (field[i] == Figure.SHIP) {
                System.out.print(Figure.EMPTY + "  ");
            } else {
                System.out.print(field[i] + "  ");
            }
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            if (i < 10) {
                System.out.print(i + "  ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        printLines();
    }

    private void printLines() {
        for (int i = 0; i < (size + size / 2); i++) {
            System.out.print("==");
        }
        System.out.println();
    }

    private boolean isValidCell(final int position, final int size) {
        if (position >= this.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (field[position + i] != Figure.EMPTY) return false;
        }
        return true;
    }

    private int findShipIndex(final int coordinate) {
        for (int i = 0; i < ships.length; i++) {
            if (coordinate >= ships[i].getPosition() && coordinate < (ships[i].getPosition() + ships[i].getSize())) {
                return i;
            }
        }
        return -1;
    }

    private void initialize() {
        for (int i = 0; i < size; i++) {
            field[i] = Figure.EMPTY;
        }
    }
}