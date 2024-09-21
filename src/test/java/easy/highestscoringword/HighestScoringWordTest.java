package easy.highestscoringword;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class HighestScoringWordTest {

    // Parameterized test using MethodSource to provide test data
    @ParameterizedTest
    @MethodSource("dataProvider")
    void returnsTheCorrectWordBasedOnTheScore(String sentence, String expectedWord) {

        String actualWord = HighestScoringWord.highestScoringWord(sentence);

        // Assert that the result matches the expected word
        assertThat(actualWord).isEqualTo(expectedWord);
    }

    // Method to provide test data for the parameterized test
    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("Life is not a problem to be solved", "problem"),
                Arguments.of("You did it", "You"),
                Arguments.of("Java sucks", "sucks"),
                Arguments.of("I do not know what to do", "know"),
                Arguments.of("I like it as it is", "like"),
                Arguments.of("What time are we climbing up the volcano", "volcano"),
                Arguments.of("I wish I knew you as I thought I did", "thought"),
                Arguments.of("aabb bbcc ccbb bbaa", "bbcc"),
                Arguments.of("c ab", "c")
        );
    }
}
