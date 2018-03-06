package TicTacToe;

import static org.junit.Assert.*;

import org.junit.Test;

import TicTacToe.TicTacToeBoard;

public class TicTacToeBoardUnitTest {

	TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();

	@Test
	public void testSize() {
		ticTacToeBoard.setSize(3);
		int size = ticTacToeBoard.getSize();
		assertEquals(size, 3);
	}

	@Test
	public void testBoard() {
		String[][] board = new String[][] { { "X", "", "O" }, { "", "", "O" },
				{ "", "X", "" } };
		ticTacToeBoard.setBoard(board);
		String[][] board2 = ticTacToeBoard.getBoard();
		assertArrayEquals(board, board2);

		ticTacToeBoard.setSize(3);
		ticTacToeBoard.setEmptyBoard();
		board = new String[][] { { "", "", "" }, { "", "", "" }, { "", "", "" } };
		board2 = ticTacToeBoard.getBoard();
		assertArrayEquals(board, board2);
	}
}
