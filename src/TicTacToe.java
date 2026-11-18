import java.util.Scanner;

public class TicTacToe {
  private static String playerMark = "X";
  private static int moveCounter = 0;
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
    Scanner in = new Scanner(System.in);
    clearBoard();
    boolean done = false;
    do {// while players want to keep playing
      System.out.println(playerMark + "'s turn.");
      System.out.println("Here is the board:");
      display();
      System.out.println("Please enter the row and column for your " + playerMark + ".");
      int row = SafeInput.getRangedInt(in, "row: ", 1, 3) - 1;
      int col = SafeInput.getRangedInt(in, "column: ", 1, 3) - 1;
      if (isValidMove(row, col)) {
        board[row][col] = playerMark;
        moveCounter += 1;
        if (moveCounter >= 5) {// if a win is possible
          if (isWin(playerMark)) {// if it is a win
            System.out.println("Player " + playerMark + " wins!");
            if (SafeInput.getYNConfirm(in, "Play again?")) {
              done = false;
              display();
              reset();
            } else {
              done = true;
            }
          } else if (isTie()) {// if it is a tie
            if (SafeInput.getYNConfirm(in, "Play again?")) {
              done = false;
              display();
              reset();
            } else {
              done = true;
            }
          } else {// if it is not a win or a tie
            invertBoard();
          }
        } else {// if win is not possible
          invertBoard();
        }
      } else {
        // not a valid move
        System.out.println("Please input a valid move. there was already a piece at that location.");

      }

    } while (!done);
  }

  private static void clearBoard() {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        board[i][j] = " ";
      }
    }
  }

  private static void invertBoard() {
//    for (int i = 0; i < rows; i++) {
//      for (int j = 0; j < cols; j++) {
//        if (!board[i][j].equals(" ")) {
//          if (board[i][j].equals("X")) {
//            board[i][j] = "O";
//          } else if (board[i][j].equals("O")) {
//            board[i][j] = "X";
//          }
//        }
//      }
//    }
    if (playerMark.equals("X")) {
      playerMark = "O";
    } else {
      playerMark = "X";
    }
  }

  private static void display() {
    System.out.println("  | 1 | 2 | 3 |");
    for (int i = 0; i < rows; i++) {
      System.out.printf("%d | %-1s | %-1s | %-1s |\n", i + 1, board[i][0], board[i][1], board[i][2]);
    }
  }

  private static boolean isValidMove(int row, int col) {
    if (board[row][col].equals(" ")) {
      return true;
    } else {
      return false;
    }
  }

  private static boolean isWin(String player) {
    if (isColWin(player) || isRowWin(player) || isDiagonalWin(player)) {
      return true;
    } else {
      return false;
    }
  }

  private static boolean isRowWin(String player) {
    for (int i = 0; i < rows; i++) {
      if (board[i][0].equals(player)
          && board[i][1].equals(player)
          && board[i][2].equals(player)) {
        return true;
      }
    }

    return false;
  }

  private static boolean isColWin(String player) {
    for (int i = 0; i < cols; i++) {
      if (board[0][i].equals(player)
          && board[1][i].equals(player)
          && board[2][i].equals(player)) {
        return true;
      }
    }

    return false;
  }

  private static boolean isDiagonalWin(String player) {
    if (board[0][0].equals(player)
        && board[1][1].equals(player)
        && board[2][2].equals(player)) {
      return true;
    }
    if (board[2][0].equals(player)
        && board[1][1].equals(player)
        && board[0][2].equals(player)) {
      return true;
    }
    return false;
  }

  private static boolean isTie() {
    if (moveCounter >= 9) {
      return true;
    } else {
      return false;
    }
  }

  private static void reset() {
    moveCounter = 0;
    clearBoard();
    playerMark = "X";
  }
}
