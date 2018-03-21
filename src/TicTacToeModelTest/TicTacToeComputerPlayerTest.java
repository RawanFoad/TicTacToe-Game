package TicTacToeModelTest;

import static org.junit.Assert.*;

import org.junit.Test;

import TicTacToeModel.TicTacToeBoard;
import TicTacToeModel.TicTacToeComputerPlayer;

public class TicTacToeComputerPlayerTest {

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
