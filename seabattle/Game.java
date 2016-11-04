package seabattle;

class Game {
    private final String GAME_NAME = "Game SeaBattle!";
    private final int gameSize;
    private final int maxShipSize;
    private final int shipsCount;
    private Player player;
    private Ship[] ships;
    private Field field;
    private boolean debugMode;

    Game(final int gameSize, final int maxShipSize, final int shipsCount, final boolean debugMode) {
        this.gameSize = gameSize;
        this.maxShipSize = maxShipSize;
        this.shipsCount = shipsCount;
        this.debugMode = debugMode;
    }

    void playGame() {
        initializeGame();
        System.out.println(GAME_NAME);
        if (debugMode) {
            printShipsInfo();
        } else {
            player.setName();
        }
        System.out.printf("Вам нужно потопить %d кораблей%n", shipsCount);

        int shootCount = 0;
        do {
            field.showField();
            int shootX = player.getShoot("X", gameSize);
            int shootY = player.getShoot("Y", gameSize);
            field.doShoot(shootX, shootY);
            shootCount++;
        } while (field.continueGame());

        field.showField();
        System.out.printf("%s, вы потопили все корабли за %d выстрелов!%n", player.getName(), shootCount);
    }

    private void initializeGame() {
        player = new Player();
        initializeShips();
        initializeField();
    }

    private void initializeShips() {
        ships = new Ship[shipsCount];
        int shipSize = 1;
        for (int i = 0; i < shipsCount; i++) {
            ships[i] = new Ship(shipSize);
            if (shipSize < maxShipSize) {
                shipSize++;
            } else {
                shipSize = 1;
            }
        }
    }

    private void initializeField() {
        field = new Field(gameSize, ships, debugMode);
        for (int i = 0; i < shipsCount; i++) {
            boolean shipSetted;
            do {
                ships[i].generatePosition(gameSize);
                shipSetted = field.setShip(i);
            } while (!shipSetted);
        }
    }

    private void printShipsInfo() {
        for (int i = 0; i < shipsCount; i++) {
            System.out.printf("Ship# %d: posXY: %d, %d; size: %d; dirХ: %s.%n",
                    i, ships[i].getPositionX(), ships[i].getPositionY(), ships[i].getSize(), ships[i].isDirectionX());
        }
    }
}