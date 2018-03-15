package TicTacToe;

public class TicTacToeEngine extends TicTacToeEngineUtils {

	public TicTacToeGame prepareGame() {
		ticTacToeDisplay.displayMessage(TicTacToeConstants.MESSAGE_WELCOME);

		ticTacToeDisplay.displayMessage(TicTacToeConstants.ENTER_SIZE_OF_BOARD);
		TicTacToeBoard gameBoard = prepareBoard();
		ticTacToeGame.setCurrentBoard(gameBoard);

		ticTacToeDisplay
				.displayMessage(TicTacToeConstants.ENTER_SYMBOL_OF_USER_PLAYER);
		String symbol = getSymbol(ticTacToeGame.getCurrentComputerPlayer());
		TicTacToeUserPlayer gameUserPlayer = prepareUserPlayer(symbol);
		ticTacToeGame.setCurrentUserPlayer(gameUserPlayer);

		ticTacToeDisplay
				.displayMessage(TicTacToeConstants.ENTER_SYMBOL_OF_COMPUTER_PLAYER);
		symbol = getSymbol(ticTacToeGame.getCurrentUserPlayer());
		TicTacToeComputerPlayer gameComputerPlayer = prepareComputerPlayer(symbol);
		ticTacToeGame.setCurrentComputerPlayer(gameComputerPlayer);

		prepareCurrentPlayer(ticTacToeGame);

		ticTacToeDisplay
				.displayGame(ticTacToeGame.getCurrentBoard().getBoard());

		return ticTacToeGame;
	}

	public TicTacToeGame startOrContinueGame(TicTacToeGame ticTacToeGame) {
		String symbol = ticTacToeGame.getCurrentPlayer().getSymbol();
		String name = ticTacToeGame.getCurrentPlayer().getName();
		ticTacToeDisplay.displayWhoseTurn(name, symbol);

		preparePosition(ticTacToeGame);
		prepareBoard(ticTacToeGame);

		String[][] board = ticTacToeGame.getCurrentBoard().getBoard();
		ticTacToeDisplay.displayBoard(board);

		int[] currentPosition = ticTacToeGame.getCurrentPosition();
		boolean isWinner = ticTacToeRules.isWinner(board, currentPosition,
				symbol);
		boolean isFull = ticTacToeRules.isFull(board);
		if (!ticTacToeRules.isEndGame(isWinner, isFull)) {
			prepareCurrentPlayer(ticTacToeGame);
			ticTacToeGame = startOrContinueGame(ticTacToeGame);
		}
		checkWinner(isWinner, isFull);

		return ticTacToeGame;
	}

	private void checkWinner(boolean isWinner, boolean isFull) {
		if (isWinner) {
			String name = ticTacToeGame.getCurrentPlayer().getName();
			ticTacToeDisplay.displayWinner(name);
		} else {
			if (isFull) {
				ticTacToeDisplay
						.displayMessage(TicTacToeConstants.GAME_STATUS_DRAW);
			}
		}
	}

}
