package TicTacToeController;

import TicTacToeEngine.TicTacToeEngine;
import TicTacToeModel.TicTacToeGame;

public class TicTacToeController {

	public TicTacToeController() {
		TicTacToeEngine ticTacToeEngine = new TicTacToeEngine();

		TicTacToeGame ticTacToeGame = ticTacToeEngine.prepareGame();
		ticTacToeEngine.startOrContinueGame(ticTacToeGame);
	}

}
