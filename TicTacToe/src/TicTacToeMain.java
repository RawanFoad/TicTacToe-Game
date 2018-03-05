public class TicTacToeMain {

	private static TicTacToeController ticTacToeControllerInstance = null;

	public static void main(String[] args) {
		if (ticTacToeControllerInstance == null) {
			ticTacToeControllerInstance = new TicTacToeController();
		}
	}

}
