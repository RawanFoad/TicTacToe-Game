package TicTacToe;

import static org.junit.Assert.*;

import org.junit.Test;

import TicTacToe.TicTacToeBoard;
import TicTacToe.TicTacToeComputerPlayer;

public class TicTacToeComputerPlayerUnitTest {

	TicTacToeComputerPlayer ticTacToeComputerPlayer = new TicTacToeComputerPlayer();

	@Test
	public void testNextMove() {
		int[] position = ticTacToeComputerPlayer.nextMove(getTicTacToeBoard());
		assertEquals(position.length, 2);
	}

	private TicTacToeBoard getTicTacToeBoard() {
		TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
		ticTacToeBoard.setSize(3);
		String[][] board = { { "X", "", "O" }, { "", "", "O" }, { "", "X", "" } };
		ticTacToeBoard.setBoard(board);
		return ticTacToeBoard;
	}

}
