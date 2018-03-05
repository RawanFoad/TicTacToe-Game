public class TicTacToeGame {

	private TicTacToeBoard currentBoard;
	private TicTacToeUserPlayer currentUserPlayer;
	private TicTacToeComputerPlayer currentComputerPlayer;
	private int[] currentPosition = new int[2];
	private TicTacToePlayer currentPlayer;

	public TicTacToeBoard getCurrentBoard() {
		return currentBoard;
	}

	public void setCurrentBoard(TicTacToeBoard currentBoard) {
		this.currentBoard = currentBoard;
	}

	public TicTacToeUserPlayer getCurrentUserPlayer() {
		return currentUserPlayer;
	}

	public void setCurrentUserPlayer(TicTacToeUserPlayer currentUserPlayer) {
		this.currentUserPlayer = currentUserPlayer;
	}

	public TicTacToeComputerPlayer getCurrentComputerPlayer() {
		return currentComputerPlayer;
	}

	public void setCurrentComputerPlayer(
			TicTacToeComputerPlayer currentComputerPlayer) {
		this.currentComputerPlayer = currentComputerPlayer;
	}

	public int[] getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int[] currentPosition) {
		this.currentPosition = currentPosition;
	}

	public TicTacToePlayer getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(TicTacToePlayer currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

}
