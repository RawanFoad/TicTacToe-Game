package TicTacToeModelTest;

import static org.junit.Assert.*;

import org.junit.Test;

import TicTacToeModel.TicTacToeComputerPlayer;
import TicTacToeModel.TicTacToePlayer;

public class TicTacToePlayerTest {

	@Test
	public void testSymbol() {
		TicTacToePlayer ticTacToePlayer = new TicTacToeComputerPlayer();

		ticTacToePlayer.setSymbol("O");
		String text = ticTacToePlayer.getSymbol();
		assertEquals(text, "O");
	}

	@Test
	public void testName() {
		TicTacToePlayer ticTacToePlayer = new TicTacToeComputerPlayer();

		ticTacToePlayer.setName("Computer");
		String text = ticTacToePlayer.getName();
		assertEquals(text, "Computer");
	}

	@Test
	public void testIsComputer() {
		TicTacToePlayer ticTacToePlayer = new TicTacToeComputerPlayer();

		ticTacToePlayer.setComputer(true);
		boolean check = ticTacToePlayer.isComputer();
		assertEquals(check, true);
	}

}
