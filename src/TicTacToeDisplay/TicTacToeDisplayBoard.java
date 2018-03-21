package TicTacToeDisplay;


public class TicTacToeDisplayBoard {

	public void displayBoard(String[][] board) {
		TicTacToeDisplayMessages ticTacToeDisplayMessages = new TicTacToeDisplayMessages();

		ticTacToeDisplayMessages.displayMessage(TicTacToeConstants.EMPTY);
		for (int i = 0; i < board.length; i++) {
			System.out.print("\t\t " + (i + 1));
		}

		ticTacToeDisplayMessages.displayMessage(TicTacToeConstants.NEW_LINE);
		for (int i = 0; i < board.length; i++) {
			System.out.print("\t" + (i + 1));
			for (int j = 0; j < board.length; j++) {
				System.out.print("\t" + board[i][j] + "\t|");
			}

			ticTacToeDisplayMessages.displayMessage(TicTacToeConstants.EMPTY);
			System.out.print("\t\t---------");
			for (int j = 1; j < board.length; j++) {
				System.out.print("----------------");
			}
			ticTacToeDisplayMessages.displayMessage(TicTacToeConstants.EMPTY);

		}

		ticTacToeDisplayMessages.displayMessage(TicTacToeConstants.EMPTY);

	}

}
