package TicTacToe;

import TicTacToeController.TicTacToeController;

public class TicTacToe {

	private static TicTacToeController ticTacToeControllerInstance = null;

	public static void main(String[] args) {
		if (ticTacToeControllerInstance == null) {
			ticTacToeControllerInstance = new TicTacToeController();
		}
	}

}
