public class TicTacToeUserPlayer extends TicTacToePlayer {

	TicTacToeDisplay ticTacToeDisplay;

	public TicTacToeUserPlayer() {
		ticTacToeDisplay = new TicTacToeDisplay();
	}

	@Override
	public int[] nextMove(TicTacToeBoard currentBoard) {
		int size = currentBoard.getSize();
		String[][] board = currentBoard.getBoard();

		int[] inputPosition = getPosition(size, board);

		return inputPosition;
	}

	private int[] getPosition(int size, String[][] board) {
		int[] inputPosition = new int[2];

		String input = ticTacToeDisplay.readInput();
		input = input.replaceAll("\\s", "");

		String[] inputSplitted = input
				.split(TicTacToeConstants.COMMA_SEPARATOR);
		if (inputSplitted.length == 2) {
			try {
				inputPosition[0] = Integer.parseInt(inputSplitted[0]) - 1;
				inputPosition[1] = Integer.parseInt(inputSplitted[1]) - 1;

				if (!isValidPosition(inputPosition, size)
						|| !board[inputPosition[0]][inputPosition[1]].isEmpty()) {
					invalidNextMoveOfUser();
					inputPosition = getPosition(size, board);
				}
			} catch (NumberFormatException numberFormatException) {
				invalidNextMoveOfUser();
				inputPosition = getPosition(size, board);
			}
		} else {
			invalidNextMoveOfUser();
			inputPosition = getPosition(size, board);
		}
		return inputPosition;
	}

	private void invalidNextMoveOfUser() {
		ticTacToeDisplay
				.displayInvalidMessage(TicTacToeConstants.INVALID_PLAYER_POSITION);
	}

}
