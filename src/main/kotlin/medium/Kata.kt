package dev.artisrabocanvi.medium

/**
 * Generates the Josephus permutation of the given collection.
 *
 * The Josephus permutation is a sequence of elements from a collection where elements
 * are removed from the front of the collection in a circular fashion, with a given step
 * size. This function implements this algorithm and returns the resulting permutation.
 *
 * @param <E> the type of elements in the input collection
 * @param collectionDeque the input collection to generate the Josephus permutation from
 * @param steps the number of steps to take before removing an element from the collection
 * @return a new list containing the Josephus permutation of the input collection
 */
fun <E> josephusPermutation(collectionDeque: ArrayDeque<E>, steps: Int): List<E> {
    val resultCollection = mutableListOf<E>()
    while (collectionDeque.isNotEmpty()) {
        repeat(steps - 1) {
            collectionDeque.addLast(collectionDeque.removeFirst())
        }
        resultCollection.add(collectionDeque.removeFirst())
    }
    return resultCollection
}