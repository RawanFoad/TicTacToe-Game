# TicTacToe-Game

Description:
************
- Digital Tic-tac-toe game
- Inputs:	> Invalid inputs are expected to be handled appropriately.
			> Configurations are provided via console.
			> The game takes 3 configurable inputs:
				1) Size of the playground. Valid values are between 3 & 10.
				2) Play character 1: A single character for the human player (usually O & X)
				3) Play character 2: A single character for the computer (usually O & X)
- Input & output are on console.
- General Rules: https://en.wikipedia.org/wiki/Tic-tac-toe
- User play against the computer, Who is starting at random.
- Next position is provided in a format like 3,2.
- After each move:
	> new state of playfield is displayed
	> player can enter the next position of their character.

Technology:
***********
- Used Java programming language, JUnit4 jar, Eclipse SDK 3.7.0

Software design:
****************
-	class TicTacToe has main function
		> Singleton design pattern is used here to ensure that only one instance of game is created in JVM.
-	class TicTacToeController states the general steps of the process
		> for more readable code
-	abstract class TicTacToePlayer has common functions and attributes of players.
	classes TicTacToeComputerPlayer & TicTacToeUserPlayer extend abstract class TicTacToePlayer 
		> Factory design pattern is used to here to make code extendable without changing the code.
		> helps in having more than 1 player easily and in adding more congifurations for players if needed.

To run the code:
****************
1) Clone project make sure that Junit4 jar is added
2) Compile
3) Go to class TicTacToe.java & run