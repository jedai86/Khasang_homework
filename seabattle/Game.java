package seabattle;

class Game {
    private final int GAME_SIZE = 15;
    private final int MAX_SHIP_SIZE = 3;
    private final String GAME_NAME = "Game SeaBattle!";
    private final int SHIPS_COUNT = 4;
    private Ship[] ships;

    void playGame() {
        Player player = new Player();

        ships = new Ship[SHIPS_COUNT];
        int shipSize = 1;
        for (int i = 0; i < SHIPS_COUNT; i++) {
            ships[i] = new Ship(shipSize);
            if (shipSize < MAX_SHIP_SIZE) {
                shipSize++;
            } else {
                shipSize = 1;
            }
        }

        Field field = new Field(GAME_SIZE, ships);

        for (int i = 0; i < SHIPS_COUNT; i++) {
            boolean shipSetted;
            do {
                ships[i].generatePosition(GAME_SIZE);
                shipSetted = field.setShip(ships[i]);
            } while (!shipSetted);
        }

        System.out.println(GAME_NAME);
        player.setName();
        System.out.printf("Вам нужно потопить %d кораблей%n", SHIPS_COUNT);

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