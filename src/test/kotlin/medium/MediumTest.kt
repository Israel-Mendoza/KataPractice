package medium

import dev.artisrabocanvi.medium.josephusPermutation
import io.kotest.matchers.equals.shouldBeEqual
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class MediumTest {

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class JosephusPermutationTest {

        @ParameterizedTest
        @MethodSource("dataProvider")
        fun <E> `returns a list which size is equal to the passed ArrayDeque`(
            arrayDeque: ArrayDeque<E>,
            steps: Int,
            expected: List<E>,
        ) {
            val originalArrayDequeSize = arrayDeque.size
            val actualResultSize = josephusPermutation(arrayDeque, steps).size

            actualResultSize shouldBeEqual originalArrayDequeSize
        }

        @ParameterizedTest
        @MethodSource("dataProvider")
        fun <E> `returns the correct list`(arrayDeque: ArrayDeque<E>, steps: Int, expected: List<E>) {
            val actualResult = josephusPermutation(arrayDeque, steps)

            actualResult shouldBeEqual expected
        }


        private fun dataProvider() = listOf(
            Arguments.of(ArrayDeque(listOf(1, 2, 3, 4, 5, 6, 7)), 1, listOf(1, 2, 3, 4, 5, 6, 7)),
            Arguments.of(ArrayDeque(listOf(1, 2, 3, 4, 5, 6, 7)), 2, listOf(2, 4, 6, 1, 5, 3, 7)),
            Arguments.of(ArrayDeque(listOf(1, 2, 3, 4, 5, 6, 7)), 3, listOf(3, 6, 2, 7, 5, 1, 4)),
            Arguments.of(ArrayDeque(listOf(1, 2, 3, 4, 5, 6, 7)), 4, listOf(4, 1, 6, 5, 7, 3, 2)),
            Arguments.of(ArrayDeque(listOf(1, 2, 3, 4, 5, 6, 7)), 5, listOf(5, 3, 2, 4, 7, 1, 6)),
            Arguments.of(ArrayDeque(listOf(1, 2, 3, 4, 5, 6, 7)), 6, listOf(6, 5, 7, 2, 1, 4, 3)),
            Arguments.of(ArrayDeque(listOf(1, 2, 3, 4, 5, 6, 7)), 7, listOf(7, 1, 3, 6, 2, 4, 5)),
            Arguments.of(ArrayDeque(listOf(1, 2, 3, 4, 5, 6, 7)), 8, listOf(1, 3, 6, 5, 2, 7, 4)),
            Arguments.of(ArrayDeque(listOf(1, 2, 3, 4, 5, 6, 7)), 9, listOf(2, 5, 3, 4, 1, 6, 7)),
            Arguments.of(ArrayDeque(listOf(1.5, 2.4, 3.3, 4.2, 5.1)), 3, listOf(3.3, 1.5, 5.1, 2.4, 4.2)),
            Arguments.of(ArrayDeque(listOf(1.1, 3.3, 5.5, 7.7, 9.9)), 4, listOf(7.7, 5.5, 9.9, 3.3, 1.1)),
            Arguments.of(
                ArrayDeque(listOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i')),
                2,
                listOf('b', 'd', 'f', 'h', 'a', 'e', 'i', 'g', 'c')
            ),
            Arguments.of(
                ArrayDeque(listOf("alpha", "bravo", "charlie", "delta", "echo", "frank", "george", "hotel")),
                3,
                listOf("charlie", "frank", "alpha", "echo", "bravo", "hotel", "delta", "george")
            ),
            Arguments.of(
                ArrayDeque(listOf(true, true, true, true, false, false, false, false)),
                5,
                listOf(false, true, false, false, true, true, false, true)
            ),
        )
    }
}