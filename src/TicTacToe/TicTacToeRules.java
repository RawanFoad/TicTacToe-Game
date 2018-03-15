package TicTacToe;

public class TicTacToeRules {
	private TicTacToeDisplay ticTacToeDisplay;

	public TicTacToeRules() {
		ticTacToeDisplay = new TicTacToeDisplay();
	}

	public boolean isEndGame(boolean isWinner, boolean isFull) {
		return isWinner || isFull;
	}

	public boolean isFull(String[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j].isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isWinner(String[][] board, int[] currentPosition,
			String symbol) {
		return isDiagonalWinner(board, currentPosition, symbol)
				|| isHorizontalWinner(board, currentPosition, symbol)
				|| isVerticalWinner(board, currentPosition, symbol);
	}

	private boolean isDiagonalWinner(String[][] board, int[] currentPosition,
			String symbol) {
		return isRightDiagonalWinner(board, currentPosition, symbol)
				|| isLeftDiagonalWinner(board, currentPosition, symbol);
	}

	private boolean isRightDiagonalWinner(String[][] board,
			int[] currentPosition, String symbol) {
		boolean isRightDiagonalWinner = false;
		if (currentPosition[0] == currentPosition[1]) {
			isRightDiagonalWinner = isRightDiagonalWinner(board, symbol,
					isRightDiagonalWinner);
		}
		if (isRightDiagonalWinner) {
			ticTacToeDisplay
					.displayMessage(TicTacToeConstants.IS_RIGHT_DIAGONAL_WINNER);
		}
		return isRightDiagonalWinner;
	}

	private boolean isRightDiagonalWinner(String[][] board, String symbol,
			boolean isRightDiagonalWinner) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][i].equalsIgnoreCase(symbol)) {
				isRightDiagonalWinner = true;
			} else {
				isRightDiagonalWinner = false;
				break;
			}
		}
		return isRightDiagonalWinner;
	}

	private boolean isLeftDiagonalWinner(String[][] board,
			int[] currentPosition, String symbol) {
		boolean isLeftDiagonalWinner = false;

		int length = board.length;
		for (int i = 0; i < length; i++) {
			if (board[i][length - i - 1].equalsIgnoreCase(symbol)) {
				isLeftDiagonalWinner = true;
			} else {
				isLeftDiagonalWinner = false;
				break;
			}
		}
		if (isLeftDiagonalWinner) {
			ticTacToeDisplay
					.displayMessage(TicTacToeConstants.IS_LEFT_DIAGONAL_WINNER);
		}
		return isLeftDiagonalWinner;
	}

	private boolean isHorizontalWinner(String[][] board, int[] currentPosition,
			String symbol) {
		boolean isHorizontalWinner = false;

		int row = currentPosition[0];

		for (int j = 0; j < board.length; j++) {
			if (board[row][j].equalsIgnoreCase(symbol)) {
				isHorizontalWinner = true;
			} else {
				isHorizontalWinner = false;
				break;
			}
		}
		if (isHorizontalWinner) {
			ticTacToeDisplay
					.displayMessage(TicTacToeConstants.IS_HORIZONTAL_WINNER);
		}
		return isHorizontalWinner;

	}

	private boolean isVerticalWinner(String[][] board, int[] currentPosition,
			String symbol) {
		boolean isVerticalWinner = false;

		int column = currentPosition[1];

		for (int i = 0; i < board.length; i++) {
			if (board[i][column].equalsIgnoreCase(symbol)) {
				isVerticalWinner = true;
			} else {
				isVerticalWinner = false;
				break;
			}
		}
		if (isVerticalWinner) {
			ticTacToeDisplay
					.displayMessage(TicTacToeConstants.IS_VERTICAL_WINNER);
		}
		return isVerticalWinner;

	}

}
