package seabattle;

import java.util.Random;

class Ship {
    private int positionX;
    private int positionY;
    private final int size;
    private int health;
    private boolean directionX;

    Ship(final int size) {
        this.size = size;
        this.health = size;
    }

    int getPositionX() {
        return positionX;
    }

    int getPositionY() {
        return positionY;
    }

    int getSize() {
        return size;
    }

    boolean isDirectionX() {
        return directionX;
    }

    boolean isKilled() {
        return health == 0;
    }

    void generatePosition(final int gameSize) {
        Random rand = new Random();
        generateDirection();
        if (directionX) {
            positionX = rand.nextInt(gameSize - size + 1);
            positionY = rand.nextInt(gameSize);
        } else {
            positionY = rand.nextInt(gameSize - size + 1);
            positionX = rand.nextInt(gameSize);
        }
    }

    void damageShip() {
        health--;
    }

    private void generateDirection() {
        Random rand = new Random();
        directionX = rand.nextBoolean();
    }
}