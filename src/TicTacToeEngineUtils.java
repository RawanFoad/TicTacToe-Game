import java.util.Random;

public class TicTacToeEngineUtils {

	protected TicTacToeDisplay ticTacToeDisplay;

	public TicTacToeEngineUtils() {
		ticTacToeDisplay = new TicTacToeDisplay();
	}

	protected TicTacToeBoard prepareBoard() {
		TicTacToeBoard gameBoard = new TicTacToeBoard();
		try {
			String input = ticTacToeDisplay.readInput();

			int sizeInput = Integer.parseInt(input);
			if (sizeInput >= 3 && sizeInput <= 10) {
				gameBoard.setSize(sizeInput);
				gameBoard.setEmptyBoard();
			} else {
				invalidBoardSize();
				gameBoard = prepareBoard();
			}
		} catch (NumberFormatException numberFormatException) {
			invalidBoardSize();
			gameBoard = prepareBoard();
		}
		return gameBoard;
	}

	private void invalidBoardSize() {
		ticTacToeDisplay
				.displayInvalidMessage(TicTacToeConstants.INVALID_BOARD_SIZE);
	}

	protected TicTacToeBoard prepareBoard(TicTacToeBoard currentBoard,
			int[] position, String playerSymbol) {
		String[][] board = currentBoard.getBoard();
		board[position[0]][position[1]] = playerSymbol;
		currentBoard.setBoard(board);
		return currentBoard;
	}

	protected TicTacToeUserPlayer prepareUserPlayer(
			String excludedComputerPlayerSybmol) {
		TicTacToeUserPlayer ticTacToeUserPlayer = new TicTacToeUserPlayer();
		String input = ticTacToeDisplay.readInput();

		if (input.length() == 1
				&& !input.equalsIgnoreCase(excludedComputerPlayerSybmol)) {
			ticTacToeUserPlayer.setSybmol(input);
			ticTacToeUserPlayer.setName(TicTacToeConstants.USER_PLAYER_NAME);
			ticTacToeUserPlayer.setComputer(false);
		} else {
			invalidUserPlayerSymbol();
			ticTacToeUserPlayer = prepareUserPlayer(excludedComputerPlayerSybmol);
		}
		return ticTacToeUserPlayer;
	}

	private void invalidUserPlayerSymbol() {
		ticTacToeDisplay
				.displayInvalidMessage(TicTacToeConstants.INVALID_USER_PLAYER_SYMBOL);
	}

	protected TicTacToeComputerPlayer prepareComputerPlayer(
			String excludedUserPlayerSybmol) {
		TicTacToeComputerPlayer ticTacToeComputerPlayer = new TicTacToeComputerPlayer();
		String input = ticTacToeDisplay.readInput();

		if (input.length() == 1
				&& !input.equalsIgnoreCase(excludedUserPlayerSybmol)) {
			ticTacToeComputerPlayer.setSybmol(input);
			ticTacToeComputerPlayer
					.setName(TicTacToeConstants.COMPUTER_PLAYER_NAME);
			ticTacToeComputerPlayer.setComputer(true);
		} else {
			invalidComputerPlayerSymbol();
			ticTacToeComputerPlayer = prepareComputerPlayer(excludedUserPlayerSybmol);
		}
		return ticTacToeComputerPlayer;
	}

	private void invalidComputerPlayerSymbol() {
		ticTacToeDisplay
				.displayInvalidMessage(TicTacToeConstants.INVALID_COMPUTER_PLAYER_SYMBOL);
	}

	protected TicTacToePlayer prepareCurrentPlayer(
			TicTacToeUserPlayer ticTacToeUserPlayer,
			TicTacToeComputerPlayer ticTacToeComputerPlayer) {
		Random random = new Random();
		TicTacToePlayer randomPlayer;
		if (random.nextBoolean()) {
			randomPlayer = ticTacToeUserPlayer;
		} else {
			randomPlayer = ticTacToeComputerPlayer;
		}
		return randomPlayer;
	}

	protected int[] getPosition(TicTacToeGame ticTacToeGame) {
		int[] currentPosition;
		TicTacToeBoard board = ticTacToeGame.getCurrentBoard();
		if (ticTacToeGame.getCurrentPlayer() instanceof TicTacToeComputerPlayer) {
			currentPosition = ticTacToeGame.getCurrentComputerPlayer()
					.nextMove(board);
			int row = currentPosition[0] + 1;
			int column = currentPosition[1] + 1;
			ticTacToeDisplay.displayMessage(row
					+ TicTacToeConstants.COMMA_SEPARATOR + column);
		} else {
			ticTacToeDisplay
					.displayMessage(TicTacToeConstants.ENTER_PLAYER_POSITION);
			currentPosition = ticTacToeGame.getCurrentUserPlayer().nextMove(
					board);
		}
		return currentPosition;
	}

	protected TicTacToePlayer prepareCurrentPlayer(TicTacToeGame ticTacToeGame) {
		TicTacToePlayer currentPlayer;
		if (ticTacToeGame.getCurrentPlayer() instanceof TicTacToeComputerPlayer) {
			currentPlayer = ticTacToeGame.getCurrentUserPlayer();
		} else {
			currentPlayer = ticTacToeGame.getCurrentComputerPlayer();
		}
		return currentPlayer;
	}

	protected void displayWinner(TicTacToePlayer currentPlayer) {
		ticTacToeDisplay.displayMessage(currentPlayer.getName()
				+ TicTacToeConstants.WINNER_PLAYER);
	}

	protected void displayBoard(String[][] board) {
		System.out.println("");

		for (int i = 0; i < board.length; i++) {
			System.out.print("\t\t " + (i + 1));
		}
		System.out.println("\n");

		for (int i = 0; i < board.length; i++) {
			System.out.print("\t" + (i + 1));
			for (int j = 0; j < board.length; j++) {
				System.out.print("\t" + board[i][j] + "\t|");
			}
			System.out.println("");
			System.out
					.println("\t\t----------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("");
		}

		System.out.println("");
	}

}
