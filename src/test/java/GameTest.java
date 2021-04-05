import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private final Game game = new Game();

    public static Stream<Arguments> allP1WinCases() {
        return Stream.of(
                Arguments.arguments("rock", "scissors"),
                Arguments.arguments("paper", "rock"),
                Arguments.arguments("scissors", "paper")
        );
    }

    public static Stream<Arguments> allP1LoseCases() {
        return Stream.of(
                Arguments.arguments("rock", "paper"),
                Arguments.arguments("paper", "scissors"),
                Arguments.arguments("scissors", "rock")
        );
    }

    public static Stream<Arguments> allDrawCases() {
        return Stream.of(
                Arguments.arguments("rock", "rock"),
                Arguments.arguments("paper", "paper"),
                Arguments.arguments("scissors", "scissors")
        );
    }

    public static Stream<Arguments> allValidInputCases() {
        return Stream.of(
                Arguments.arguments("rock"),
                Arguments.arguments("paper"),
                Arguments.arguments("scissors")
        );
    }

    public static Stream<Arguments> allInvalidInputCases() {
        return Stream.of(
                Arguments.arguments("stone"),
                Arguments.arguments("pepper"),
                Arguments.arguments("sisters")
        );
    }

    @ParameterizedTest
    @MethodSource("allP1WinCases")
    public void allP1WinCasesTest(String p1, String p2) {
        game.setP1Move(p1);
        game.setP2Move(p2);

        assertEquals("Player 1 win!", game.result());
    }

    @ParameterizedTest
    @MethodSource("allP1LoseCases")
    public void allP1LoseCasesTest(String p1, String p2) {
        game.setP1Move(p1);
        game.setP2Move(p2);

        assertEquals("Player 2 win!", game.result());
    }

    @ParameterizedTest
    @MethodSource("allDrawCases")
    public void allDrawCasesTest(String p1, String p2) {
        game.setP1Move(p1);
        game.setP2Move(p2);

        assertEquals("Draw!", game.result());
    }

    @ParameterizedTest
    @MethodSource("allValidInputCases")
    public void allP1ValidInputCasesTest(String p1) {
        assertDoesNotThrow(() -> game.setP1Move(p1));
    }

    @ParameterizedTest
    @MethodSource("allValidInputCases")
    public void allP2ValidInputCasesTest(String p2) {
        assertDoesNotThrow(() -> game.setP2Move(p2));
    }

    @ParameterizedTest
    @MethodSource("allInvalidInputCases")
    public void allP1InvalidInputCasesTest(String p1) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> game.setP1Move(p1));
        assertEquals("Bad Choice!", exception.getMessage());
    }

    @ParameterizedTest
    @MethodSource("allInvalidInputCases")
    public void allP2InvalidInputCasesTest(String p2) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> game.setP2Move(p2));
        assertEquals("Bad Choice!", exception.getMessage());
    }
}