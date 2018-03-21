package TicTacToeDisplay;

import java.util.Scanner;

public class TicTacToeDisplayMessages {

	public String readInput() {
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}

	public void displayMessage(String message) {
		System.out.println(message);
	}

	public void displayWhoseTurn(String name, String symbol) {
		displayMessage(name + TicTacToeConstants.MESSAGE_TURN_OF_PLAYER
				+ symbol);
	}

	public void displayComputerPlayerPosition(int[] currentPosition) {
		displayMessage((currentPosition[0] + 1)
				+ TicTacToeConstants.COMMA_SEPARATOR + (currentPosition[1] + 1));
	}

	public void displayGame(String[][] board) {
		displayMessage(TicTacToeConstants.MESSAGE_START_GAME);

		TicTacToeDisplayBoard ticTacToeDisplayBoard = new TicTacToeDisplayBoard();
		ticTacToeDisplayBoard.displayBoard(board);
	}

	public void displayWinner(String name) {
		displayMessage(name + TicTacToeConstants.GAME_STATUS_WINNER);
	}

	public void invalidBoardSize(String reason) {
		displayMessage(reason + TicTacToeConstants.NEW_LINE
				+ TicTacToeConstants.ENTER_SIZE_OF_BOARD);
	}

	public void invalidUserPlayerSymbol(String reason) {
		displayMessage(reason + TicTacToeConstants.NEW_LINE
				+ TicTacToeConstants.ENTER_SYMBOL_OF_USER_PLAYER);
	}

	public void invalidComputerPlayerSymbol(String reason) {
		displayMessage(reason + TicTacToeConstants.NEW_LINE
				+ TicTacToeConstants.ENTER_SYMBOL_OF_COMPUTER_PLAYER);
	}

	public void invalidUserNextMove(String reason) {
		displayMessage(reason + TicTacToeConstants.NEW_LINE
				+ TicTacToeConstants.ENTER_POSITION_OF_PLAYER);
	}

}
