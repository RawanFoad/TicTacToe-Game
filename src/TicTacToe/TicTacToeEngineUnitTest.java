package TicTacToe;

import static org.junit.Assert.*;

import org.junit.Test;

import TicTacToe.TicTacToeBoard;
import TicTacToe.TicTacToeComputerPlayer;
import TicTacToe.TicTacToeEngine;
import TicTacToe.TicTacToeGame;
import TicTacToe.TicTacToeUserPlayer;

public class TicTacToeEngineUnitTest {

	TicTacToeEngine ticTacToeEngine = new TicTacToeEngine();

	@Test
	public void testPrepareGame() {// must enter 3, then x or X, then o or O
		TicTacToeGame ticTacToeGame = ticTacToeEngine.prepareGame();
		assertArrayEquals(ticTacToeGame.getCurrentBoard().getBoard(),
				getTicTacToeGame().getCurrentBoard().getBoard());
		assertEquals(ticTacToeGame.getCurrentBoard().getSize(),
				getTicTacToeGame().getCurrentBoard().getSize());
		assertEquals(ticTacToeGame.getCurrentComputerPlayer().getSymbol(),
				getTicTacToeGame().getCurrentComputerPlayer().getSymbol());
		assertEquals(ticTacToeGame.getCurrentUserPlayer().getSymbol(),
				getTicTacToeGame().getCurrentUserPlayer().getSymbol());
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
