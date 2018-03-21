package TicTacToeEngine;

import java.util.Random;

import TicTacToeDisplay.TicTacToeConstants;
import TicTacToeDisplay.TicTacToeDisplayMessages;
import TicTacToeModel.TicTacToeBoard;
import TicTacToeModel.TicTacToeComputerPlayer;
import TicTacToeModel.TicTacToeGame;
import TicTacToeModel.TicTacToePlayer;
import TicTacToeModel.TicTacToeUserPlayer;
import TicTacToeRules.TicTacToeRules;

public class TicTacToeEngineUtils {

	protected TicTacToeGame ticTacToeGame;
	protected TicTacToeRules ticTacToeRules;
	protected TicTacToeDisplayMessages ticTacToeDisplay;

	public TicTacToeEngineUtils() {
		ticTacToeGame = new TicTacToeGame();
		ticTacToeRules = new TicTacToeRules();
		ticTacToeDisplay = new TicTacToeDisplayMessages();
	}

	protected TicTacToeBoard prepareBoard() {
		TicTacToeBoard gameBoard = new TicTacToeBoard();
		try {
			String input = ticTacToeDisplay.readInput();

			int sizeInput = Integer.parseInt(input);
			if (sizeInput >= TicTacToeConstants.MINIMUM_BOARD_SIZE
					&& sizeInput <= TicTacToeConstants.MAXIMUM_BOARD_SIZE) {
				gameBoard.setSize(sizeInput);
				gameBoard.setEmptyBoard();
			} else {
				ticTacToeDisplay
						.invalidBoardSize(TicTacToeConstants.INVALID_SIZE_NOT_IN_RANGE);
				gameBoard = prepareBoard();
			}
		} catch (NumberFormatException numberFormatException) {
			ticTacToeDisplay
					.invalidBoardSize(TicTacToeConstants.INVALID_SIZE_NOT_NUMBER);
			gameBoard = prepareBoard();
		}
		return gameBoard;
	}

	protected void prepareBoard(TicTacToeGame ticTacToeGame) {
		TicTacToeBoard currentBoard = ticTacToeGame.getCurrentBoard();
		int[] position = ticTacToeGame.getCurrentPosition();
		TicTacToePlayer currentPlayer = ticTacToeGame.getCurrentPlayer();
		String playerSymbol = currentPlayer != null ? currentPlayer.getSymbol()
				: TicTacToeConstants.EMPTY;

		String[][] board = currentBoard.getBoard();
		board[position[0]][position[1]] = playerSymbol;
		currentBoard.setBoard(board);
		ticTacToeGame.setCurrentBoard(currentBoard);
	}

	protected TicTacToeUserPlayer prepareUserPlayer(String excludedSybmol) {
		TicTacToeUserPlayer ticTacToeUserPlayer = new TicTacToeUserPlayer();
		String input = ticTacToeDisplay.readInput();

		boolean isOneChar = input.length() == 1;
		if (isOneChar && !input.equalsIgnoreCase(excludedSybmol)) {
			ticTacToeUserPlayer.setSymbol(input.toUpperCase());
			ticTacToeUserPlayer.setComputer(false);
		} else {
			ticTacToeDisplay.invalidUserPlayerSymbol(invalidSymbol(isOneChar));
			ticTacToeUserPlayer = prepareUserPlayer(excludedSybmol);
		}
		return ticTacToeUserPlayer;
	}

	protected TicTacToeComputerPlayer prepareComputerPlayer(
			String excludedSybmol) {
		TicTacToeComputerPlayer ticTacToeComputerPlayer = new TicTacToeComputerPlayer();
		String input = ticTacToeDisplay.readInput();

		boolean isOneChar = input.length() == 1;
		if (input.length() == 1 && !input.equalsIgnoreCase(excludedSybmol)) {
			ticTacToeComputerPlayer.setSymbol(input.toUpperCase());
			ticTacToeComputerPlayer.setComputer(true);
		} else {
			ticTacToeDisplay
					.invalidComputerPlayerSymbol(invalidSymbol(isOneChar));
			ticTacToeComputerPlayer = prepareComputerPlayer(excludedSybmol);
		}
		return ticTacToeComputerPlayer;
	}

	protected void prepareCurrentPlayer(TicTacToeGame ticTacToeGame) {
		TicTacToePlayer currentPlayer;

		if (ticTacToeGame.getCurrentPlayer() == null) {
			currentPlayer = getFirstPlayer(ticTacToeGame);
		} else {
			if (ticTacToeGame.getCurrentPlayer() instanceof TicTacToeComputerPlayer) {
				currentPlayer = ticTacToeGame.getCurrentUserPlayer();
			} else {
				currentPlayer = ticTacToeGame.getCurrentComputerPlayer();
			}
		}
		ticTacToeGame.setCurrentPlayer(currentPlayer);
	}

	protected void preparePosition(TicTacToeGame ticTacToeGame) {
		int[] currentPosition;
		TicTacToeBoard board = ticTacToeGame.getCurrentBoard();
		if (ticTacToeGame.getCurrentPlayer() instanceof TicTacToeComputerPlayer) {
			currentPosition = ticTacToeGame.getCurrentComputerPlayer()
					.nextMove(board);
			ticTacToeDisplay.displayComputerPlayerPosition(currentPosition);
		} else {
			ticTacToeDisplay
					.displayMessage(TicTacToeConstants.ENTER_POSITION_OF_PLAYER);
			currentPosition = ticTacToeGame.getCurrentUserPlayer().nextMove(
					board);
		}
		ticTacToeGame.setCurrentPosition(currentPosition);
	}

	protected String getSymbol(TicTacToePlayer player) {
		return player != null ? player.getSymbol() : TicTacToeConstants.EMPTY;
	}

	private String invalidSymbol(boolean isOneChar) {
		return isOneChar ? TicTacToeConstants.INVALID_SYMBOL_TAKEN
				: TicTacToeConstants.INVALID_SYMBOL_NOT_ONE_CHAR;
	}

	private TicTacToePlayer getFirstPlayer(TicTacToeGame ticTacToeGame) {
		TicTacToePlayer currentPlayer;
		Random random = new Random();
		if (random.nextBoolean()) {
			currentPlayer = ticTacToeGame.getCurrentUserPlayer();
		} else {
			currentPlayer = ticTacToeGame.getCurrentComputerPlayer();
		}
		return currentPlayer;
	}

}
