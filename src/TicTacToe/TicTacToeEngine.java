package TicTacToe;

public class TicTacToeEngine extends TicTacToeEngineUtils {

	public TicTacToeGame prepareGame() {
		ticTacToeDisplay.displayMessage(TicTacToeConstants.WELCOME_MESSAGE);

		ticTacToeDisplay.displayMessage(TicTacToeConstants.ENTER_BOARD_SIZE);
		TicTacToeBoard gameBoard = prepareBoard();
		ticTacToeGame.setCurrentBoard(gameBoard);

		ticTacToeDisplay
				.displayMessage(TicTacToeConstants.ENTER_USER_PLAYER_SYMBOL);
		TicTacToeUserPlayer gameUserPlayer = prepareUserPlayer(getSymbol(ticTacToeGame
				.getCurrentComputerPlayer()));
		ticTacToeGame.setCurrentUserPlayer(gameUserPlayer);

		ticTacToeDisplay
				.displayMessage(TicTacToeConstants.ENTER_COMPUTER_PLAYER_SYMBOL);
		TicTacToeComputerPlayer gameComputerPlayer = prepareComputerPlayer(getSymbol(ticTacToeGame
				.getCurrentUserPlayer()));
		ticTacToeGame.setCurrentComputerPlayer(gameComputerPlayer);

		TicTacToePlayer ticTacToeCurrentPlayer = prepareCurrentPlayer(ticTacToeGame);
		ticTacToeGame.setCurrentPlayer(ticTacToeCurrentPlayer);

		ticTacToeDisplay
				.displayGame(ticTacToeGame.getCurrentBoard().getBoard());

		return ticTacToeGame;
	}

	public TicTacToeGame startOrContinueGame(TicTacToeGame ticTacToeGame) {
		ticTacToeDisplay.displayWhoseTurn(ticTacToeGame.getCurrentPlayer());

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
			ticTacToeDisplay.displayWinner(ticTacToeGame.getCurrentPlayer());
		} else {
			if (isFull) {
				ticTacToeDisplay.displayMessage(TicTacToeConstants.DRAW_GAME);
			}
		}
	}

}
