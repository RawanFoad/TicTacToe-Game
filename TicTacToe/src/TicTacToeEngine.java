public class TicTacToeEngine extends TicTacToeEngineUtils {

	private TicTacToeGame ticTacToeGame;
	private TicTacToeRules ticTacToeRules;

	public TicTacToeEngine() {
		ticTacToeGame = new TicTacToeGame();
		ticTacToeRules = new TicTacToeRules();
	}

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

		TicTacToePlayer ticTacToeCurrentPlayer = prepareCurrentPlayer(
				ticTacToeGame.getCurrentUserPlayer(),
				ticTacToeGame.getCurrentComputerPlayer());
		ticTacToeGame.setCurrentPlayer(ticTacToeCurrentPlayer);

		displayNewGame();

		return ticTacToeGame;
	}

	private void displayNewGame() {
		ticTacToeDisplay.displayMessage(TicTacToeConstants.START_GAME);
		displayBoard(ticTacToeGame.getCurrentBoard().getBoard());
	}

	public void startGame(TicTacToeGame ticTacToeGame) {
		ticTacToeDisplay.displayWhoseTurn(ticTacToeGame.getCurrentPlayer());

		int[] currentPosition = getPosition(ticTacToeGame);
		ticTacToeGame.setCurrentPosition(currentPosition);

		TicTacToeBoard gameBoard = prepareBoard(
				ticTacToeGame.getCurrentBoard(),
				ticTacToeGame.getCurrentPosition(), ticTacToeGame
						.getCurrentPlayer().getSymbol());
		ticTacToeGame.setCurrentBoard(gameBoard);

		String[][] board = ticTacToeGame.getCurrentBoard().getBoard();
		displayBoard(board);

		int[] gamePosition = ticTacToeGame.getCurrentPosition();
		String gameSymbol = ticTacToeGame.getCurrentPlayer().getSymbol();

		checkWinner(ticTacToeGame, board, gamePosition, gameSymbol);

	}

	private void checkWinner(TicTacToeGame ticTacToeGame, String[][] board,
			int[] gamePosition, String gameSymbol) {
		if (ticTacToeRules.isWinner(board, gamePosition, gameSymbol)) {
			displayWinner(ticTacToeGame.getCurrentPlayer());
		} else {
			if (ticTacToeRules.isFull(board)) {
				ticTacToeDisplay.displayMessage(TicTacToeConstants.DRAW_GAME);
			} else {
				TicTacToePlayer ticTacToePlayer = prepareCurrentPlayer(ticTacToeGame);
				ticTacToeGame.setCurrentPlayer(ticTacToePlayer);

				startGame(ticTacToeGame);
			}
		}
	}

	private String getSymbol(TicTacToePlayer player) {
		return player != null ? player.getSymbol() : TicTacToeConstants.EMPTY;
	}

}
