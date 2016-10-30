package seabattle;

import java.util.Random;

class Ship {
    private int position;
    private final int size;
    private int health;

    Ship(final int size) {
        this.size = size;
        this.health = size;
    }

    int getPosition() {
        return position;
    }

    void generatePosition(final int gameSize) {
        Random rand = new Random();
        position = rand.nextInt(gameSize-size+1);
    }

    int getSize() {
        return size;
    }

    void damageShip() {
        health--;
    }

    boolean isKilled() {
        return health == 0;
    }
}