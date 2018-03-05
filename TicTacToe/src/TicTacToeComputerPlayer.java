import java.util.Random;

public class TicTacToeComputerPlayer extends TicTacToePlayer {

	@Override
	public int[] nextMove(TicTacToeBoard currentBoard) {
		int size = currentBoard.getSize();
		String[][] board = currentBoard.getBoard();

		int[] inputPosition = getPosition(size, board);

		return inputPosition;
	}

	private int[] getPosition(int size, String[][] board) {
		int[] inputPosition = new int[2];

		Random random = new Random();
		inputPosition[0] = random.nextInt(size);
		inputPosition[1] = random.nextInt(size);

		if (!isValidPosition(inputPosition, size)
				|| !board[inputPosition[0]][inputPosition[1]].isEmpty()) {
			inputPosition = getPosition(size, board);
		}

		return inputPosition;
	}

}
