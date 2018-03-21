package TicTacToeDisplay;

public class TicTacToeConstants {

	public static final int MAXIMUM_BOARD_SIZE = 10;
	public static final int MINIMUM_BOARD_SIZE = 3;

	private static final String COLON = " : ";
	private static final String ENTER = "Please enter ";
	private static final String INVALID = "Invalid Input, ";
	
	public static final String COMMA_SEPARATOR = ",";
	public static final String NAME_OF_COMPUTER_PLAYER = "Computer";
	public static final String NAME_OF_USER_PLAYER = "You";
	public static final String EMPTY = "";
	public static final String ENTER_POSITION_OF_PLAYER = ENTER + "Position consists of row,column values, empty and within Board's Size" + COLON;
	public static final String ENTER_SIZE_OF_BOARD = ENTER + "Board's Size number between " + MINIMUM_BOARD_SIZE + " & " + MAXIMUM_BOARD_SIZE + COLON;
	public static final String ENTER_SYMBOL_OF_COMPUTER_PLAYER = ENTER + "Single character for " + NAME_OF_COMPUTER_PLAYER + COLON;
	public static final String ENTER_SYMBOL_OF_USER_PLAYER = ENTER + "Single character for " + NAME_OF_USER_PLAYER + COLON;
	public static final String GAME_STATUS_DRAW = "No body lose =D !";
	public static final String GAME_STATUS_WINNER = " Won ! WohoOoo =D !";
	public static final String INVALID_SIZE_NOT_IN_RANGE = INVALID + "Size is not between 3 and 10";
	public static final String INVALID_SIZE_NOT_NUMBER = INVALID + "Size is not a number";
	public static final String INVALID_SYMBOL_TAKEN = INVALID + "Symbol is taken by the other player";
	public static final String INVALID_SYMBOL_NOT_ONE_CHAR = INVALID + "Symbol is not a single char";
	public static final String INVALID_POSITION_NOT_NUMBER = INVALID + "row or column are not numbers";
	public static final String INVALID_POSITION_WRONG_FORMAT = INVALID + "Position is wrong format, should be row,column";
	public static final String INVALID_POSITION_TAKEN = INVALID + "Cell is taken";
	public static final String INVALID_POSITION_NOT_IN_RANGE = INVALID + "row or column is not in board size";
	public static final String IS_HORIZONTAL_WINNER = "Winner did it Horizontally";
	public static final String IS_LEFT_DIAGONAL_WINNER = "Winner did it Diagonally to the left";
	public static final String IS_RIGHT_DIAGONAL_WINNER = "Winner did it Diagonally to the right";
	public static final String IS_VERTICAL_WINNER = "Winner did it Vertically";
	public static final String MESSAGE_START_GAME = "Let The Game Begin =D !";
	public static final String MESSAGE_TURN_OF_PLAYER = " will play with symbol ";
	public static final String NEW_LINE = "\n";
	public static final String MESSAGE_WELCOME = "Let's TicTacToe =D !" + NEW_LINE;

}
