package TicTacToeModelTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import TicTacToeRulesTest.TicTacToeRulesTest;
import TicTacToeValidatorTest.TicTacToeValidatorTest;

@RunWith(Suite.class)
@SuiteClasses({ TicTacToeBoardTest.class, TicTacToeComputerPlayerTest.class,
		TicTacToeGameTest.class, TicTacToePlayerTest.class,
		TicTacToeRulesTest.class, TicTacToeValidatorTest.class })
public class AllTests {

}
