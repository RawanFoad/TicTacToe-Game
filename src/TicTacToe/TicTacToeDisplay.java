package TicTacToe;

import java.util.Scanner;

public class TicTacToeDisplay {

	public String readInput() {
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}

	public void displayMessage(String message) {
		System.out.println(message);
	}

	public void displayInvalidMessage(String message) {
		System.out.println(message);
	}

	public void displayWhoseTurn(TicTacToePlayer currentPlayer) {
		displayMessage(currentPlayer.getName()
				+ TicTacToeConstants.TURN_OF_PLAYER + currentPlayer.getSymbol());
	}

	public void displayComputerPlayerPosition(int[] currentPosition) {
		displayMessage((currentPosition[0] + 1)
				+ TicTacToeConstants.COMMA_SEPARATOR + (currentPosition[1] + 1));
	}

	public void displayGame(String[][] board) {
		displayMessage(TicTacToeConstants.START_GAME);
		displayBoard(board);
	}

	public void displayWinner(TicTacToePlayer currentPlayer) {
		displayMessage(currentPlayer.getName()
				+ TicTacToeConstants.WINNER_PLAYER);
	}

	public void displayBoard(String[][] board) {
		System.out.println("");

		for (int i = 0; i < board.length; i++) {
			System.out.print("\t\t " + (i + 1));
		}
		System.out.println("\n");

		for (int i = 0; i < board.length; i++) {
			System.out.print("\t" + (i + 1));
			for (int j = 0; j < board.length; j++) {
				System.out.print("\t" + board[i][j] + "\t|");
			}
			System.out.println("");
			System.out
					.println("\t\t----------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("");
		}

		System.out.println("");
	}

	public void invalidBoardSize(String reason) {
		displayInvalidMessage(TicTacToeConstants.INVALID_INPUT + reason);
		displayInvalidMessage(TicTacToeConstants.ENTER_BOARD_SIZE);
	}

	public void invalidUserPlayerSymbol(String reason) {
		displayInvalidMessage(TicTacToeConstants.INVALID_INPUT + reason);
		displayInvalidMessage(TicTacToeConstants.ENTER_USER_PLAYER_SYMBOL);
	}

	public void invalidComputerPlayerSymbol(String reason) {
		displayInvalidMessage(TicTacToeConstants.INVALID_INPUT + reason);
		displayInvalidMessage(TicTacToeConstants.ENTER_COMPUTER_PLAYER_SYMBOL);
	}

	public void invalidUserNextMove(String reason) {
		displayInvalidMessage(TicTacToeConstants.INVALID_INPUT + reason);
		displayInvalidMessage(TicTacToeConstants.ENTER_PLAYER_POSITION);
	}

}
