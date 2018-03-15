package TicTacToe;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TicTacToeEngineUtilsUnitTest {

	TicTacToeEngineUtils ticTacToeEngineUtils = new TicTacToeEngineUtils();

	@Test
	public void testPrepareBoard() {// must enter 3
		String[][] board = getTicTacToeBoard().getBoard();
		TicTacToeDisplay ticTacToeDisplay = new TicTacToeDisplay();
		ticTacToeDisplay.displayMessage(TicTacToeConstants.ENTER_SIZE_OF_BOARD);
		String[][] board2 = ticTacToeEngineUtils.prepareBoard().getBoard();
		assertArrayEquals(board, board2);
	}

	@Test
	public void testPosition() {// must enter 2,2
		TicTacToeGame game = getTicTacToeGame();
		ticTacToeEngineUtils.preparePosition(game);
		int[] position = { 1, 1 };
		assertArrayEquals(game.getCurrentPosition(), position);
	}

	@Test
	public void testSymbol() {
		String text = ticTacToeEngineUtils
				.getSymbol(getTicTacToeComputerPlayer());
		assertEquals(text, "O");

		text = ticTacToeEngineUtils.getSymbol(getTicTacToeUserPlayer());
		assertEquals(text, "X");
	}

	@Test
	public void testPositionUpdateBoard() {
		TicTacToeGame game = getUpdatedTicTacToeGame();
		ticTacToeEngineUtils.prepareBoard(game);
		String[][] board = new String[][] { { "X", "", "O" }, { "", "X", "O" },
				{ "", "X", "" } };
		assertArrayEquals(game.getCurrentBoard().getBoard(), board);
	}

	@Test
	public void testPrepareUserPlayer() {// must enter x or X
		TicTacToeDisplay ticTacToeDisplay = new TicTacToeDisplay();
		ticTacToeDisplay
				.displayMessage(TicTacToeConstants.ENTER_SYMBOL_OF_USER_PLAYER);
		TicTacToeUserPlayer userPlayer = ticTacToeEngineUtils
				.prepareUserPlayer(getTicTacToeComputerPlayer().getSymbol());
		assertEquals(userPlayer.getSymbol(), "X");
	}

	@Test
	public void testPrepareComputerPlayer() {// must enter o or O
		TicTacToeDisplay ticTacToeDisplay = new TicTacToeDisplay();
		ticTacToeDisplay
				.displayMessage(TicTacToeConstants.ENTER_SYMBOL_OF_COMPUTER_PLAYER);
		TicTacToeComputerPlayer computerPlayer = ticTacToeEngineUtils
				.prepareComputerPlayer(getTicTacToeUserPlayer().getSymbol());
		assertEquals(computerPlayer.getSymbol(), "O");
	}

	@Test
	public void testPrepareCurrentPlayer() {
		TicTacToeGame game = getTicTacToeGame();
		ticTacToeEngineUtils.prepareCurrentPlayer(game);
		assertTrue(game.getCurrentPlayer() instanceof TicTacToeComputerPlayer);

		game = getTicTacToeGame();
		ticTacToeEngineUtils.prepareCurrentPlayer(game);
		assertTrue(game.getCurrentPlayer() instanceof TicTacToeUserPlayer
				|| game.getCurrentPlayer() instanceof TicTacToeComputerPlayer);
	}

	private TicTacToeGame getTicTacToeGame() {
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		int[] position = { 1, 1 };
		ticTacToeGame.setCurrentPosition(position);
		ticTacToeGame.setCurrentBoard(getTicTacToeBoard());
		ticTacToeGame.setCurrentUserPlayer(getTicTacToeUserPlayer());
		ticTacToeGame.setCurrentComputerPlayer(getTicTacToeComputerPlayer());
		ticTacToeGame.setCurrentPlayer(getTicTacToeUserPlayer());
		return ticTacToeGame;
	}

	private TicTacToeBoard getTicTacToeBoard() {
		TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
		ticTacToeBoard.setSize(3);
		ticTacToeBoard.setEmptyBoard();
		return ticTacToeBoard;
	}

	private TicTacToeGame getUpdatedTicTacToeGame() {
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		ticTacToeGame.setCurrentComputerPlayer(getTicTacToeGame()
				.getCurrentComputerPlayer());
		ticTacToeGame.setCurrentPlayer(getTicTacToeGame().getCurrentPlayer());
		ticTacToeGame.setCurrentPosition(getTicTacToeGame()
				.getCurrentPosition());
		ticTacToeGame.setCurrentUserPlayer(getTicTacToeGame()
				.getCurrentUserPlayer());

		ticTacToeGame.setCurrentBoard(getUpdatedTicTacToeBoard());
		return ticTacToeGame;
	}

	private TicTacToeBoard getUpdatedTicTacToeBoard() {
		TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
		ticTacToeBoard.setSize(3);
		String[][] board = new String[][] { { "X", "", "O" }, { "", "", "O" },
				{ "", "X", "" } };
		ticTacToeBoard.setBoard(board);
		return ticTacToeBoard;
	}

	private TicTacToeComputerPlayer getTicTacToeComputerPlayer() {
		TicTacToeComputerPlayer ticTacToeComputerPlayer = new TicTacToeComputerPlayer();
		ticTacToeComputerPlayer.setSymbol("O");
		ticTacToeComputerPlayer.setName("Computer");
		ticTacToeComputerPlayer.setComputer(true);
		return ticTacToeComputerPlayer;
	}

	private TicTacToeUserPlayer getTicTacToeUserPlayer() {
		TicTacToeUserPlayer ticTacToeUserPlayer = new TicTacToeUserPlayer();
		ticTacToeUserPlayer.setSymbol("X");
		ticTacToeUserPlayer.setName("User");
		ticTacToeUserPlayer.setComputer(false);
		return ticTacToeUserPlayer;
	}

}
