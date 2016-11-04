package seabattle;

class Field {
    private final int size;
    private final Figure[][] field;
    private int shipsAliveCount;
    private Ship[] ships;
    private boolean debugMode;

    Field(final int size, final Ship[] ships, final boolean debugMode) {
        this.size = size;
        this.field = new Figure[size][size];
        this.ships = ships;
        this.shipsAliveCount = ships.length;
        this.debugMode = debugMode;
        this.initialize();
    }

    void doShoot(final int shootX, final int shootY) {
        switch (field[shootX][shootY]) {
            case EMPTY:
                System.out.println("Промах! ");
                field[shootX][shootY] = Figure.MISSED;
                break;
            case MISSED:
            case DAMAGED:
                System.out.println("Уже стреляли!");
                break;
            case SHIP:
                field[shootX][shootY] = Figure.DAMAGED;
                int i = findShipIndex(shootX, shootY);
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

    boolean setShip(final int shipIndex) {
        if (isValidCell(shipIndex)) {
            for (int i = 0; i < ships[shipIndex].getSize(); i++) {
                if (ships[shipIndex].isDirectionX()) {
                    field[ships[shipIndex].getPositionX() + i][ships[shipIndex].getPositionY()] = Figure.SHIP;
                } else {
                    field[ships[shipIndex].getPositionX()][ships[shipIndex].getPositionY() + i] = Figure.SHIP;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    void showField() {
        printLines();
        if (debugMode) {
            showFieldWithShips();
        } else {
            showFieldSecure();
        }
        System.out.println();
        System.out.print("  ");
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

    private void showFieldSecure() {
        for (int j = 0; j < size; j++) {
            System.out.print(j + " ");
            for (int i = 0; i < size; i++) {
                if (field[i][j] == Figure.SHIP) {
                    System.out.print(Figure.EMPTY + "  ");
                } else {
                    System.out.print(field[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }

    private void showFieldWithShips() {
        for (int j = 0; j < size; j++) {
            System.out.print(j + " ");
            for (int i = 0; i < size; i++) {
                System.out.print(field[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private void printLines() {
        for (int i = 0; i < (size + size / 2); i++) {
            System.out.print("==");
        }
        System.out.println();
    }

    private boolean isValidCell(final int shipIndex) {
        if (ships[shipIndex].isDirectionX()) {
            for (int i = 0; i < ships[shipIndex].getSize(); i++) {
                if (field[ships[shipIndex].getPositionX() + i][ships[shipIndex].getPositionY()] != Figure.EMPTY)
                    return false;
            }
        } else {
            for (int i = 0; i < ships[shipIndex].getSize(); i++) {
                if (field[ships[shipIndex].getPositionX()][ships[shipIndex].getPositionY() + i] != Figure.EMPTY)
                    return false;
            }
        }
        return true;
    }

    private int findShipIndex(final int coordinateX, final int coordinateY) {
        for (int i = 0; i < ships.length; i++) {
            if ((coordinateX >= ships[i].getPositionX()
                    && coordinateX < (ships[i].getPositionX() + ships[i].getSize())
                    && coordinateY == ships[i].getPositionY())
                    || (coordinateY >= ships[i].getPositionY()
                    && coordinateY < (ships[i].getPositionY() + ships[i].getSize())
                    && coordinateX == ships[i].getPositionX())) {
                return i;
            }
        }
        return -1;
    }

    private void initialize() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = Figure.EMPTY;
            }
        }
    }
}