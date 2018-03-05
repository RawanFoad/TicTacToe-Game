public class TicTacToeController {

	TicTacToeEngine ticTacToeEngine;

	public TicTacToeController() {
		ticTacToeEngine = new TicTacToeEngine();

		TicTacToeGame ticTacToeGame = ticTacToeEngine.prepareGame();
		ticTacToeEngine.startGame(ticTacToeGame);
	}

}
