package dev.artisrabocanvi.easy

/**
 * Finds the second minimum and second maximum values in the given list of integers.
 *
 * This function takes a list of integers as input and returns a pair containing the
 * second minimum and second maximum values in the list. The function uses the
 * kotlin.collections.fold function to iterate through the list and update
 * the current minimum, second minimum, maximum, and second maximum values.
 *
 * @param numbers the list of integers to find the second minimum and second maximum values for
 * @return a pair containing the second minimum and second maximum values in the list
 */
fun secondMinAndMax(numbers: List<Int>): Pair<Int, Int> = numbers.fold(
    mutableListOf(
        Integer.MAX_VALUE,
        Integer.MAX_VALUE,
        Integer.MIN_VALUE,
        Integer.MIN_VALUE
    )
) { acc, num ->
    if (num < acc[0]) {
        acc[1] = acc[0]
        acc[0] = num
    } else if (num < acc[1] && num > acc[0]) {
        acc[1] = num
    } else if (num > acc[3]) {
        acc[2] = acc[3]
        acc[3] = num
    } else if (num > acc[2] && num < acc[3]) {
        acc[2] = num
    }
    acc
}.let { it[1] to it[2] }

/**
 * Finds all pairs of numbers in the given list that add up to the target value.
 *
 * This function takes a list of integers and a target integer value as input, and returns
 * a list of pairs of integers from the input list that sum up to the target value.
 *
 * The function uses a single pass through the input list to find the pairs. It keeps track
 * of the numbers it has already seen in a set. For each number in the list, it checks if
 * the difference between the target value and the current number is in the set. If it is,
 * it adds a pair with the current number and the difference to the result list, and removes
 * the difference from the set. If the difference is not in the set, it adds the current
 * number to the set.
 *
 * @param numbers the list of integers to search
 * @param target the target integer value that the pairs should sum up to
 * @return a list of pairs of integers from the input list that sum up to the target value
 */
fun getPairs(numbers: List<Int>, target: Int): List<Pair<Int, Int>> {
    // Placeholder for numbers we have iterated over:
    val visitedNumbers = mutableSetOf<Int>()
    // Placeholder for the result list:
    val results = mutableListOf<Pair<Int, Int>>()

    // Iterating through the list of numbers, and storing the numbers that don't have a 'counterpart' in the set.
    for (num in numbers) {
        val difference = target - num
        if (difference in visitedNumbers) {
            results.add(num to difference)
            visitedNumbers.remove(difference)
        } else {
            visitedNumbers.add(num)
        }
    }
    return results
}