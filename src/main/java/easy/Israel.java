package easy;

import java.util.*;

public class Israel {

    /**
     * Finds the second minimum and second maximum values in the given list of integers.
     * <p>
     * This method takes a list of integers as input and returns a list containing the
     * second minimum and second maximum values in the list.
     * </p>
     * @param numbers the list of integers to find the second minimum and second maximum values for
     * @return a list of integers containing the second minimum and second maximum values in the list
     */
    public static List<Integer> secondMinAndMax(List<Integer> numbers) {
        // Defining the values of the current first and second min and max:
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : numbers) {
           if (num < firstMin) {
               // We have new min
               secondMin = firstMin;
               firstMin = num;
           } else if (num < secondMin && num > firstMin) {
               secondMin = num;
           } else if (num > firstMax) {
               // We have new max
               secondMax = firstMax;
               firstMax = num;
           } else if (num > secondMax && num < firstMax) {
               secondMax = num;
           }
        }
        return List.of(secondMin, secondMax);
    }

    /**
     * Finds all pairs of numbers in the given list that add up to the target value.
     * <p>
     * This function takes a list of integers and a target integer value as input, and returns
     * a list of pairs of integers from the input list that sum up to the target value.
     * </p>
     * <p>
     * The function uses a single pass through the input list to find the pairs. It keeps track
     * of the numbers it has already seen in a set. For each number in the list, it checks if
     * the difference between the target value and the current number is in the set. If it is,
     * it adds a pair with the current number and the difference to the result list, and removes
     * the difference from the set. If the difference is not in the set, it adds the current
     * number to the set.
     * </p>
     * @param numbers a collection of integers to search
     * @param target the target integer value that the pairs should sum up to
     * @return a list of lists of integers from the input list that sum up to the target value
     */
    public static List<List<Integer>> getPairs(Collection<Integer> numbers, int target) {
        // Placeholder for numbers we have iterated over:
        Set<Integer> visitedNumbers = new HashSet<>();
        // Placeholder for the result list:
        List<List<Integer>> results = new ArrayList<>();

        // Iterating through the list of numbers, and storing the numbers that don't have a 'counterpart' in the set.
        for (int num : numbers) {
            var difference = target - num;
            if (visitedNumbers.contains(difference)) {
                results.add(List.of(num, difference));
                visitedNumbers.remove(difference); // Eliminating unnecessary items from the set.
            } else {
                visitedNumbers.add(num);
            }
        }
        return results;
    }
}
