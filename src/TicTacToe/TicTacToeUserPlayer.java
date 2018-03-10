package TicTacToe;

public class TicTacToeUserPlayer extends TicTacToePlayer {

	private TicTacToeDisplay ticTacToeDisplay;

	public TicTacToeUserPlayer() {
		ticTacToeDisplay = new TicTacToeDisplay();
		setName(TicTacToeConstants.NAME_OF_USER_PLAYER);
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
			inputPosition = getInputPosition(size, board, inputPosition,
					inputSplitted);
		} else {
			ticTacToeDisplay
					.invalidUserNextMove(TicTacToeConstants.INVALID_POSITION_WRONG_FORMAT);
			inputPosition = getPosition(size, board);
		}
		return inputPosition;
	}

	private int[] getInputPosition(int size, String[][] board,
			int[] inputPosition, String[] inputSplitted) {
		try {
			inputPosition[0] = Integer.parseInt(inputSplitted[0]) - 1;
			inputPosition[1] = Integer.parseInt(inputSplitted[1]) - 1;

			if (!ticTacToeValidator.isValidPosition(size, board, inputPosition)) {
				ticTacToeDisplay.invalidUserNextMove(invalidNextMove(
						inputPosition, size));
				inputPosition = getPosition(size, board);
			}
		} catch (NumberFormatException numberFormatException) {
			ticTacToeDisplay
					.invalidUserNextMove(TicTacToeConstants.INVALID_POSITION_NOT_NUMBER);
			inputPosition = getPosition(size, board);
		}
		return inputPosition;
	}

	private String invalidNextMove(int[] inputPosition, int size) {
		boolean isWithinBoardSize = ticTacToeValidator.isWithinBoardSize(
				inputPosition, size);
		return isWithinBoardSize ? TicTacToeConstants.INVALID_POSITION_TAKEN
				: TicTacToeConstants.INVALID_POSITION_NOT_IN_RANGE;
	}
}
