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
    } else if (num < acc[1]) {
        acc[1] = num
    } else if (num > acc[3]) {
        acc[2] = acc[3]
        acc[3] = num
    } else if (num > acc[2]) {
        acc[2] = num
    }
    acc
}.let { it[1] to it[2] }