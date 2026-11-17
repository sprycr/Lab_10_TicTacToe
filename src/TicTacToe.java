public class TicTacToe {
  private static final int rows = 3;
  private static final int cols = 3;
  private static String board[][] = new String[rows][cols];

  public static void main(String[] args) {
    // clearBoard{};
    // SafeInput.getRangedInt(prompt for row, 1, 3);
    // SafeInput.getRangedInt(prompt for column, 1, 3);
    // reindex values to array
    // verify if the move is isValidMove
    // record the move in the array
    // increment move counter
    // if moves>=5, check isWin
    // if there is a win, announce it and display the board state.
    // prompt to play again with SafeInput.getYNConfirm();
    // toggle player with invertBoard()
    //
  }

  private static void clearBoard() {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        board[i][j] = " ";
      }
    }
  }

  private static void invertBoard() {

  }

  private static void switchPlayer() {

  }

  private static void display() {

  }

  private static boolean isValidMove(int row, int col) {

  }

  private static boolean isWin(String player) {

  }

  private static boolean isColWin(String player) {

  }

  private static boolean isRowWin(String player) {

  }

  private static boolean isDiagonalWin(String player) {

  }

  private static boolean isTie() {

  }
}
