public abstract class TicTacToePlayer {
	private String sybmol;
	private String name;
	private boolean isComputer;

	protected abstract int[] nextMove(TicTacToeBoard board);

	protected boolean isValidPosition(int[] inputPosition, int size) {
		return inputPosition[0] >= 0 && inputPosition[0] < size
				&& inputPosition[1] >= 0 && inputPosition[1] < size;
	}

	public String getSymbol() {
		return sybmol;
	}

	public void setSybmol(String sybmol) {
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
