package lesson3;

/**
 * Created by Jedai86 on 20.10.2016.
 */
public class GameXO {

    private final char EMPTY_CHAR = '_';
    private final int SIZE = 3;
    private final char[][] field = new char[SIZE][SIZE];
    private final char player1Char = 'X';
    private final char player2Char = 'O';
    private int emptyCharsCount = SIZE*SIZE;

    public static void main(String[] args) {
        GameXO game = new GameXO();
        game.showField();
        game.mainLoop();
    }

    public GameXO() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = EMPTY_CHAR;
            }
        }
    }

    void mainLoop() {

        boolean firstPlayerMove = true;
        boolean moveSuccessful;

        while (true) {
            if (firstPlayerMove) {
                moveSuccessful = makeMove(player1Char);
                if (!moveSuccessful) {
                    System.out.println("Ничья!");
                    return;
                }
                firstPlayerMove = false;
            } else {
                moveSuccessful = makeMove(player2Char);
                if (!moveSuccessful) {
                    System.out.println("Ничья!");
                    return;
                }
                firstPlayerMove = true;
            }
            showField();
            int state = gameState();
            if (state == 1) {
                System.out.println("Выиграл игрок 1!");
                return;
            } else if (state == 2) {
                System.out.println("Выиграл игрок 2!");
                return;
            }
        }
    }

    int gameState() {

        int countPlayer1;
        int countPlayer2;

        for (int i = 0; i < SIZE; i++) {
            countPlayer1 = 0;
            countPlayer2 = 0;
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == player1Char) {
                    countPlayer1++;
                } else if (field[i][j] == player2Char) {
                    countPlayer2++;
                }
            }
            if (countPlayer1 == SIZE) {
                return 1;
            } else if (countPlayer2 == SIZE) {
                return 2;
            }
        }

        for (int j = 0; j < SIZE; j++) {
            countPlayer1 = 0;
            countPlayer2 = 0;
            for (int i = 0; i < SIZE; i++) {
                if (field[i][j] == player1Char) {
                    countPlayer1++;
                } else if (field[i][j] == player2Char) {
                    countPlayer2++;
                }
            }
            if (countPlayer1 == SIZE) {
                return 1;
            } else if (countPlayer2 == SIZE) {
                return 2;
            }
        }

        countPlayer1 = 0;
        countPlayer2 = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == j) {
                    if (field[i][j] == player1Char) {
                        countPlayer1++;
                    } else if (field[i][j] == player2Char) {
                        countPlayer2++;
                    }
                }
            }
        }
        if (countPlayer1 == SIZE) {
            return 1;
        } else if (countPlayer2 == SIZE) {
            return 2;
        }

        countPlayer1 = 0;
        countPlayer2 = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (j == (SIZE - i - 1)) {
                    if (field[i][j] == player1Char) {
                        countPlayer1++;
                    } else if (field[i][j] == player2Char) {
                        countPlayer2++;
                    }
                }
            }
        }
        if (countPlayer1 == SIZE) {
            return 1;
        } else if (countPlayer2 == SIZE) {
            return 2;
        }

        return 0;
    }

    boolean makeMove(char playerChar) {
        while (emptyCharsCount > 0) {
            int i = randCoordinate();
            int j = randCoordinate();
            if (field[i][j] == EMPTY_CHAR) {
                field[i][j] = playerChar;
                emptyCharsCount--;
                return true;
            }
        }
        return false;
    }

    int randCoordinate() {
        return (int) (SIZE * Math.random());
    }
/*
    boolean hasEmpty() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == EMPTY_CHAR) {
                    return true;
                }
            }
        }
        return false;
    }
*/
    void showField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}