import java.util.Scanner;

public class TicTacToeDisplay {

	public void displayMessage(String message) {
		System.out.println(message);
	}

	public void displayInvalidMessage(String message) {
		System.out.println(message);
	}

	public void displayWhoseTurn(TicTacToePlayer currentPlayer) {
		displayMessage(currentPlayer.getName()
				+ TicTacToeConstants.TURN_OF_PLAYER + currentPlayer.getSymbol());
	}

	public String readInput() {
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}

}
