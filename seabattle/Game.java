package seabattle;

class Game {
    private final String GAME_NAME = "Game SeaBattle!";
    private final int gameSize;
    private final int maxShipSize;
    private final int shipsCount;
    private Ship[] ships;

    Game(int gameSize, int maxShipSize, int shipsCount) {
        this.gameSize = gameSize;
        this.maxShipSize = maxShipSize;
        this.shipsCount = shipsCount;
    }

    void playGame() {
        Player player = new Player();

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

        Field field = new Field(gameSize, ships);

        for (int i = 0; i < shipsCount; i++) {
            boolean shipSetted;
            do {
                ships[i].generatePosition(gameSize);
                shipSetted = field.setShip(ships[i]);
            } while (!shipSetted);
        }

        System.out.println(GAME_NAME);
        player.setName();
        System.out.printf("Вам нужно потопить %d кораблей%n", shipsCount);

        do {
            field.showField();
            int shoot = player.getShoot();
            try {
                field.doShoot(shoot);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Не правильная координата!");
            }
        } while (field.continueGame());

        field.showField();
        System.out.printf("%s, вы потопили все корабли!", player.getName());
    }
}