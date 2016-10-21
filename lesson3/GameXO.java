package lesson3;

/**
 * Created by Jedai86 on 20.10.2016.
 */
public class GameXO {

    private static final char EMPTY_CHAR = '_';
    private static final int SIZE = 3;
    private static final char[][] field = new char[SIZE][SIZE];
    private static final char player1Char = 'X';
    private static final char player2Char = 'O';

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = EMPTY_CHAR;
            }
        }
        boolean firstPlayerMove = true;
        while (hasEmpty()) {
            showField();
            if (firstPlayerMove) {
                makeMove(player1Char);
                firstPlayerMove = false;
            } else {
                makeMove(player2Char);
                firstPlayerMove = true;
            }
            if (gameState() != 0) {
                switch (gameState()) {
                    case 1:
                        System.out.println("Player 1 win!");
                        break;
                    case 2:
                        System.out.println("Player 2 win!");
                        break;
                    case 3:
                        System.out.println("Nobody win");
                        break;
                }
                break;
            }
        }
    }

    static int gameState() {
        for (int i = 0; i < SIZE; i++) {
            int countPlayer1 = 0;
            int countPlayer2 = 0;
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == player1Char) countPlayer1++;
                if (field[i][j] == player2Char) countPlayer2++;
            }
            if (countPlayer1 == SIZE) return 1;
            if (countPlayer2 == SIZE) return 2;
        }
        return 0;
    }

    static void makeMove(char playerChar) {
        while (hasEmpty()) {
            int i = randCoordinate();
            int j = randCoordinate();
            if (field[i][j] == EMPTY_CHAR) {
                field[i][j] = playerChar;
                return;
            }
        }
    }

    static int randCoordinate() {
        return (int) (SIZE*Math.random());
    }

    static boolean hasEmpty() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == EMPTY_CHAR) {
                    return true;
                }
            }
        }
        return false;
    }

    static void showField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
