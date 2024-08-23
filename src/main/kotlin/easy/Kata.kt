package dev.artisrabocanvi.easy

fun secondMinAndMax(number: List<Int>): Pair<Int, Int> = number.fold(
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