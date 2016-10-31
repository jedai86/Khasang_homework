package seabattle;


enum Figure {
    EMPTY('.'), SHIP('X'), DAMAGED('#'), MISSED('*');

    private final char symbol;

    Figure(final char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
