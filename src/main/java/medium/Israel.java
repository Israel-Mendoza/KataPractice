package medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Israel {

    /**
     * Generates the Josephus permutation of the given collection.
     * <p>
     * The Josephus permutation is a sequence of elements from a collection where elements
     * are removed from the front of the collection in a circular fashion, with a given step
     * size. This function implements this algorithm and returns the resulting permutation.
     * </p>
     *
     * @param <E>   the type of elements in the input collection
     * @param items the input collection to generate the Josephus permutation from
     * @param steps the number of steps to take before removing an element from the collection
     * @return a new list containing the Josephus permutation of the input collection
     */
    public static <E> List<E> josephusPermutation(Deque<E> items, int steps) {
        if (items == null) {
            throw new IllegalArgumentException("ArrayDeque must not be null");
        }

        List<E> resultList = new ArrayList<>(items.size());

        while (!items.isEmpty()) {
            for (int i = 0; i < steps - 1; i++) {
                items.addLast(items.removeFirst());
            }
            resultList.add(items.removeFirst());
        }
        return resultList;
    }
}
