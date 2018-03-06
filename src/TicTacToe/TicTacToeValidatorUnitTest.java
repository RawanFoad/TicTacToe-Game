package TicTacToe;

import static org.junit.Assert.*;

import org.junit.Test;

public class TicTacToeValidatorUnitTest {

	TicTacToeValidator ticTacToeValidator = new TicTacToeValidator();

	@Test
	public void testIsValidPosition() {
		int[] position = { 1, 4 };
		String[][] board = { { "X", "", "O", "X", "", "O" },
				{ "", "", "O", "", "", "O" }, { "", "X", "", "", "X", "" },
				{ "X", "", "O", "X", "", "O" }, { "", "", "O", "", "", "O" },
				{ "", "X", "", "", "X", "" } };
		boolean check = ticTacToeValidator.isValidPosition(6, board, position);
		assertEquals(check, true);

		board = new String[][] { { "X", "", "O", "X", "", "O" },
				{ "", "", "O", "", "X", "O" }, { "", "X", "", "", "X", "" },
				{ "X", "", "O", "X", "", "O" }, { "", "", "O", "", "", "O" },
				{ "", "X", "", "", "X", "" } };
		check = ticTacToeValidator.isValidPosition(6, board, position);
		assertEquals(check, false);

		check = ticTacToeValidator.isValidPosition(3, board, position);
		assertEquals(check, false);

		board = new String[][] { { "X", "", "O" }, { "", "", "O" },
				{ "", "X", "" } };
		check = ticTacToeValidator.isValidPosition(3, board, position);
		assertEquals(check, false);
	}

	@Test
	public void testIsWithinBoardSize() {
		int[] position = { 1, 1 };
		boolean isWithinBoardSize = ticTacToeValidator.isWithinBoardSize(
				position, 3);
		assertEquals(isWithinBoardSize, true);

		position = new int[] { 3, 12 };
		isWithinBoardSize = ticTacToeValidator.isWithinBoardSize(position, 3);
		assertEquals(isWithinBoardSize, false);
	}

}
