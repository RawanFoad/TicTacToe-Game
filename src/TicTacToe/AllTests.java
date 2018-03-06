package TicTacToe;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TicTacToeBoardUnitTest.class,
		TicTacToeComputerPlayerUnitTest.class, TicTacToeEngineUnitTest.class,
		TicTacToeEngineUtilsUnitTest.class, TicTacToeGameUnitTest.class,
		TicTacToePlayerUnitTest.class, TicTacToeRulesUnitTest.class,
		TicTacToeUserPlayerUnitTest.class, TicTacToeValidatorUnitTest.class })
public class AllTests {
	// size=3
	// symbol user = x
	// symbol computer = o
	// position=2,2
}
