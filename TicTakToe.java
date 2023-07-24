import java.util.Scanner;

public class TicTacToe {
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY_CELL = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        currentPlayer = PLAYER_X;
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE || board[row][col] != EMPTY_CELL) {
            return false;
        }

        board[row][col] = currentPlayer;
        return true;
    }

    public boolean isGameOver() {
        return checkRows() || checkColumns() || checkDiagonals() || isBoardFull();
    }

    private boolean checkRows() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0] != EMPTY_CELL && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[0][i] != EMPTY_CELL && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        return (board[0][0] != EMPTY_CELL && board[0][0] == board[1][1] && board[0][0] == board[2][2]) ||
               (board[0][2] != EMPTY_CELL && board[0][2] == board[1][1] && board[0][2] == board[2][0]);
    }

    private boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe!");

        while (!game.isGameOver()) {
            game.printBoard();

            System.out.println("Player " + game.currentPlayer + ", it's your turn.");
            int row, col;
            do {
                System.out.print("Enter the row (0-2): ");
                row = scanner.nextInt();
                System.out.print("Enter the column (0-2): ");
                col = scanner.nextInt();
            } while (!game.makeMove(row, col));

            game.switchPlayer();
        }

        game.printBoard();
        char winner = game.currentPlayer == PLAYER_X ? PLAYER_O : PLAYER_X;
        System.out.println("Game Over! Player " + winner + " wins!");
        scanner.close();
    }
}