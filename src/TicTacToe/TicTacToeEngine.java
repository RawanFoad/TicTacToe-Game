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

		TicTacToePlayer ticTacToeCurrentPlayer = prepareCurrentPlayer(ticTacToeGame);
		ticTacToeGame.setCurrentPlayer(ticTacToeCurrentPlayer);

		ticTacToeDisplay
				.displayGame(ticTacToeGame.getCurrentBoard().getBoard());

		return ticTacToeGame;
	}

	public TicTacToeGame startOrContinueGame(TicTacToeGame ticTacToeGame) {
		String name = ticTacToeGame.getCurrentPlayer().getName();
		String symbol = ticTacToeGame.getCurrentPlayer().getSymbol();
		ticTacToeDisplay.displayWhoseTurn(name, symbol);

		int[] currentPosition = getPosition(ticTacToeGame);
		ticTacToeGame.setCurrentPosition(currentPosition);

		TicTacToeBoard gameBoard = prepareBoard(ticTacToeGame);
		ticTacToeGame.setCurrentBoard(gameBoard);

		ticTacToeDisplay.displayBoard(ticTacToeGame.getCurrentBoard()
				.getBoard());

		ticTacToeGame = continueOrEndGame(ticTacToeGame);

		return ticTacToeGame;
	}

	private TicTacToeGame continueOrEndGame(TicTacToeGame ticTacToeGame) {
		String[][] board = ticTacToeGame.getCurrentBoard().getBoard();
		int[] gamePosition = ticTacToeGame.getCurrentPosition();
		String gameSymbol = ticTacToeGame.getCurrentPlayer().getSymbol();

		boolean isWinner = ticTacToeRules.isWinner(board, gamePosition,
				gameSymbol);
		boolean isFull = ticTacToeRules.isFull(board);
		boolean isEndGame = isWinner || isFull;

		if (!isEndGame) {
			TicTacToePlayer ticTacToeCurrentPlayer = prepareCurrentPlayer(ticTacToeGame);
			ticTacToeGame.setCurrentPlayer(ticTacToeCurrentPlayer);

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
