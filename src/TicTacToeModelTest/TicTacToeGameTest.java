package TicTacToeModelTest;

import static org.junit.Assert.*;

import org.junit.Test;

import TicTacToeModel.TicTacToeBoard;
import TicTacToeModel.TicTacToeComputerPlayer;
import TicTacToeModel.TicTacToeGame;
import TicTacToeModel.TicTacToePlayer;
import TicTacToeModel.TicTacToeUserPlayer;

public class TicTacToeGameTest {

	TicTacToeGame ticTacToeGame = new TicTacToeGame();

	@Test
	public void testCurrentBoard() {
		TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
		String[][] board = { { "X", "", "O" }, { "", "", "O" }, { "", "X", "" } };
		ticTacToeBoard.setBoard(board);
		ticTacToeBoard.setSize(3);
		ticTacToeGame.setCurrentBoard(ticTacToeBoard);
		TicTacToeBoard ticTacToeBoard2 = ticTacToeGame.getCurrentBoard();
		assertSame(ticTacToeBoard, ticTacToeBoard2);
	}

	@Test
	public void testCurrentUserPlayer() {
		ticTacToeGame.setCurrentUserPlayer(getTicTacToeUserPlayer());
		TicTacToeUserPlayer ticTacToeUserPlayer = ticTacToeGame
				.getCurrentUserPlayer();
		assertSame(getTicTacToeUserPlayer().getName(),
				ticTacToeUserPlayer.getName());
		assertSame(getTicTacToeUserPlayer().getSymbol(),
				ticTacToeUserPlayer.getSymbol());
	}

	@Test
	public void testCurrentComputerPlayer() {
		ticTacToeGame.setCurrentComputerPlayer(getTicTacToeComputerPlayer());
		TicTacToeComputerPlayer computerPlayer = ticTacToeGame
				.getCurrentComputerPlayer();
		assertSame(computerPlayer.getName(), getTicTacToeComputerPlayer()
				.getName());
		assertSame(computerPlayer.getSymbol(), getTicTacToeComputerPlayer()
				.getSymbol());
	}

	@Test
	public void testCurrentPlayer() {
		ticTacToeGame.setCurrentPlayer(getTicTacToeUserPlayer());
		TicTacToePlayer ticTacToePlayer = ticTacToeGame.getCurrentPlayer();
		assertSame(getTicTacToeUserPlayer().getName(),
				ticTacToePlayer.getName());
		assertSame(getTicTacToeUserPlayer().getSymbol(),
				ticTacToePlayer.getSymbol());

		ticTacToeGame.setCurrentPlayer(getTicTacToeComputerPlayer());
		ticTacToePlayer = ticTacToeGame.getCurrentPlayer();
		assertSame(getTicTacToeComputerPlayer().getName(),
				ticTacToePlayer.getName());
		assertSame(getTicTacToeComputerPlayer().getSymbol(),
				ticTacToePlayer.getSymbol());

		int[] position = { 1, 1 };
		ticTacToeGame.setCurrentPosition(position);
		int[] position2 = ticTacToeGame.getCurrentPosition();
		assertArrayEquals(position, position2);
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
