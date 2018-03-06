package TicTacToe;

import static org.junit.Assert.*;

import org.junit.Test;

import TicTacToe.TicTacToeBoard;
import TicTacToe.TicTacToeConstants;
import TicTacToe.TicTacToeDisplay;
import TicTacToe.TicTacToeUserPlayer;

public class TicTacToeUserPlayerUnitTest {

	TicTacToeUserPlayer ticTacToeUserPlayer = new TicTacToeUserPlayer();

	@Test
	public void testNextMove() {// must enter 2,2
		TicTacToeDisplay ticTacToeDisplay = new TicTacToeDisplay();
		ticTacToeDisplay
				.displayMessage(TicTacToeConstants.ENTER_PLAYER_POSITION);
		int[] position = ticTacToeUserPlayer.nextMove(getTicTacToeBoard());
		int[] position2 = { 1, 1 };
		assertArrayEquals(position, position2);
	}

	private TicTacToeBoard getTicTacToeBoard() {
		TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
		ticTacToeBoard.setSize(3);
		String[][] board = { { "X", "", "O" }, { "", "", "O" }, { "", "X", "" } };
		ticTacToeBoard.setBoard(board);
		return ticTacToeBoard;
	}

}
