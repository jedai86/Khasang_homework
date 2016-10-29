package seabattle;

class Game {
    private final int GAME_SIZE = 15;
    private final int MAX_SHIP_SIZE = 3;
    private final String GAME_NAME = "Game SeaBattle!";
    private final int SHIPS_COUNT = 3;

    void playGame() {
        Field field = new Field(GAME_SIZE);
        Player player = new Player();
        Ship ship = new Ship(MAX_SHIP_SIZE);

        ship.generatePosition(GAME_SIZE);

        boolean shipSetted;  //TODO цикл переделать
        do {
           shipSetted = field.setShip(ship);
        } while (!shipSetted);

        System.out.println(GAME_NAME);
        player.setName();

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