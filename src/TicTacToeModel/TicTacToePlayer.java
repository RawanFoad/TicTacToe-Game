package TicTacToeModel;

import TicTacToeValidator.TicTacToeValidator;

public abstract class TicTacToePlayer {

	private String sybmol;
	private String name;
	private boolean isComputer;

	protected TicTacToeValidator ticTacToeValidator = new TicTacToeValidator();

	protected abstract int[] nextMove(TicTacToeBoard board);

	public String getSymbol() {
		return sybmol;
	}

	public void setSymbol(String sybmol) {
		this.sybmol = sybmol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isComputer() {
		return isComputer;
	}

	public void setComputer(boolean isComputer) {
		this.isComputer = isComputer;
	}

}
