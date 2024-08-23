package easy;

import java.util.*;

public class Israel {

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
