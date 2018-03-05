public class TicTacToeBoard {

	private int size;
	private String[][] board;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String[][] getBoard() {
		return board;
	}

	public void setBoard(String[][] board) {
		this.board = board;
	}

	public void setEmptyBoard() {
		board = new String[getSize()][getSize()];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = TicTacToeConstants.EMPTY;
			}
		}
		setBoard(board);
	}

}
