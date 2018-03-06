package TicTacToe;

import static org.junit.Assert.*;

import org.junit.Test;

import TicTacToe.TicTacToeRules;

public class TicTacToeRulesUnitTest {

	TicTacToeRules ticTacToeRules = new TicTacToeRules();

	@Test
	public void testIsFull() {
		// empty
		String[][] board = new String[][] { { "", "", "" }, { "", "", "" },
				{ "", "", "" } };
		boolean check = ticTacToeRules.isFull(board);
		assertEquals(check, false);
		// not full
		board = new String[][] { { "X", "", "O" }, { "", "", "O" },
				{ "", "X", "" } };
		check = ticTacToeRules.isFull(board);
		assertEquals(check, false);
		// full
		board = new String[][] { { "O", "X", "X" }, { "X", "X", "O" },
				{ "O", "O", "X" } };
		check = ticTacToeRules.isFull(board);
		assertEquals(check, true);
	}

	@Test
	public void testIsWinner() {
		int[] position = { 1, 1 };
		// empty
		String[][] board = new String[][] { { "", "", "" }, { "", "", "" },
				{ "", "", "" } };
		boolean check = ticTacToeRules.isWinner(board, position, "X");
		assertEquals(check, false);
		// not full
		board = new String[][] { { "X", "", "O" }, { "", "", "O" },
				{ "", "X", "" } };
		check = ticTacToeRules.isWinner(board, position, "X");
		assertEquals(check, false);
		// full
		board = new String[][] { { "O", "X", "X" }, { "X", "X", "O" },
				{ "O", "O", "X" } };
		check = ticTacToeRules.isWinner(board, position, "X");
		assertEquals(check, false);
		// horizontal
		board = new String[][] { { "", "", "" }, { "X", "X", "X" },
				{ "", "O", "O" } };
		check = ticTacToeRules.isWinner(board, position, "X");
		assertEquals(check, true);
		// vertical
		board = new String[][] { { "O", "X", "" }, { "", "X", "O" },
				{ "O", "X", "" } };
		check = ticTacToeRules.isWinner(board, position, "X");
		assertEquals(check, true);
		// left diagonal
		board = new String[][] { { "O", "O", "X" }, { "", "X", "O" },
				{ "X", "", "X" } };
		check = ticTacToeRules.isWinner(board, position, "X");
		assertEquals(check, true);
		// right diagonal
		board = new String[][] { { "X", "O", "O" }, { "O", "X", "" },
				{ "", "", "X" } };
		check = ticTacToeRules.isWinner(board, position, "X");
		assertEquals(check, true);
	}

}
