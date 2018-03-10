package TicTacToe;

public class TicTacToeValidator {

	public boolean isValidPosition(int size, String[][] board,
			int[] inputPosition) {
		return isWithinBoardSize(inputPosition, size)
				&& isEmptyCell(board, inputPosition);
	}

	public boolean isWithinBoardSize(int[] inputPosition, int size) {
		return inputPosition[0] >= 0 && inputPosition[0] < size
				&& inputPosition[1] >= 0 && inputPosition[1] < size;
	}

	private boolean isEmptyCell(String[][] board, int[] inputPosition) {
		return board[inputPosition[0]][inputPosition[1]].isEmpty();
	}

}
