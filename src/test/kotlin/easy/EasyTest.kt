package easy

import dev.artisrabocanvi.easy.getPairs
import dev.artisrabocanvi.easy.isAcronym
import dev.artisrabocanvi.easy.secondMinAndMax
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.equals.shouldBeEqual
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class EasyTest {

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetPairs {
        @ParameterizedTest(name = "List: {0} - Target: {1} - Expected pairs: {2}")
        @MethodSource("dataProvider")
        fun `returns the correct number of pairs`(list: List<Int>, target: Int, expectedPairs: Int) {
            val actualPairs = getPairs(list, target)
            actualPairs.size shouldBeEqual expectedPairs
        }

        @ParameterizedTest(name = "List: {0} - Target: {1}")
        @MethodSource("dataProvider")
        fun `returns the correct pairs of numbers`(list: List<Int>, target: Int) {
            val actual = getPairs(list, target)

            actual.forEach { pair ->
                val sumOfPair = pair.first + pair.second
                sumOfPair shouldBeEqual target
            }
        }

        // Test data provider
        private fun dataProvider() = listOf(
            Arguments.of(listOf(34, 19, 1, 71, 3, 2, 5, 4, 9, 20), 6, 2),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 10, 4),
            Arguments.of(listOf(12, 10, 24, 36, 14, 16, 4), 28, 2)
        )
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class SecondMinAndMax {

        @ParameterizedTest(name = "List: {0} - Expected pair: {1}")
        @MethodSource("dataProvider")
        fun `returns the correct pair containing the second min and second max numbers`(list: List<Int>, expectedPair: Pair<Int, Int>) {
            val actualPair = secondMinAndMax(list)
            actualPair shouldBeEqual expectedPair
        }

        // Test data provider
        private fun dataProvider() = listOf(
            Arguments.of(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 1 to 9),
            Arguments.of(listOf(0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5), 1 to 4),
            Arguments.of(listOf(0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5), 1 to 4),
            Arguments.of(listOf(-9999, 0, 9999, 9999999), 0 to 9999),
            Arguments.of(listOf(-2, -1, 0, 1, 2), -1 to 1)
        )
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class IsAcronym {

        @ParameterizedTest
        @MethodSource("dataProviderAcronyms")
        fun `identifies correct acronyms`(possibleAcronym: String, meaning: String) {
            val actualResult = isAcronym(possibleAcronym, meaning)
            actualResult.shouldBeTrue()
        }

        @ParameterizedTest
        @MethodSource("dataProviderNonAcronyms")
        fun `identifies wrong acronyms`(possibleAcronym: String, meaning: String) {
            val actualResult = isAcronym(possibleAcronym, meaning)
            actualResult.shouldBeFalse()
        }


        // Test data provider
        private fun dataProviderAcronyms() = listOf(
            Arguments.of("ASAP", "As soon as possible"),
            Arguments.of("asap", "As soon as possible"),
            Arguments.of("ASAP", "As Soon As Possible"),
            Arguments.of("ASAP", "AS SOON AS POSSIBLE"),
            Arguments.of("BRB", "Be right back"),
            Arguments.of("YOLO", "You Only Live Once"),
            Arguments.of("FYI", "For your information"),
            Arguments.of("DIY", "Do it yourself"),
            Arguments.of("EOD", "End of day")
        )

        // Test data provider
        private fun dataProviderNonAcronyms() = listOf(
            Arguments.of("ASAP", "Possible As Soon As"),
            Arguments.of("BRB", "I'll be right back"),
            Arguments.of("YOLO", "You Only Live Twice"),
            Arguments.of("FYI", "For your minded information"),
            Arguments.of("DIY", "Do not do it yourself"),
            Arguments.of("EOD", "End of month")
        )
    }
}