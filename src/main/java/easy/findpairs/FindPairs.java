package easy.findpairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
Find all pairs in an unsorted integer array which sum is equal to a given number.
Example: Array: [1, 3, 19, 5, 46, 4, 2, 7]; number to find: 6. Output: [1, 5], [2, 4]
 */
public class FindPairs {

    public static void main(String[] args) {
        int[] nums = {1, 42, 7,  5, 2, 3, 6, 4, 7, 52};
        int target = 6;
        findPairs(nums, target);
        findPairsHash(nums, target);
    }

    /* The first solution uses two nested for loops to sum pairs of numbers
    a useful trick is to trim the array list to avoid checking for numbers larger than the target.
    */
    public static List<List<Integer>> findPairs(int[] nums_, int target_){
        List<List<Integer>> resultingPairs = new ArrayList<>();
        // We create a shorter, sorted array
        List<Integer> sortedNums = Arrays.stream(nums_)
                .sorted()
                .boxed()
                .filter(x -> x <= target_)
                .toList();
        for (int i = 0, n = sortedNums.size(); i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (sortedNums.get(i) + sortedNums.get(j) == target_) {
                    resultingPairs.add(List.of(sortedNums.get(i), sortedNums.get(j)));
                }
            }
        }
        System.out.println(resultingPairs);
        return resultingPairs;
    }

    /* Second solution using a hash set to store the target - nums[i] value
    and check if the current number is in the set. No nested for loops required.
     */
    public static List<List<Integer>> findPairsHash(int[] nums_, int target_) {
        HashSet<Integer> numberSet = new HashSet<>();
        List<List<Integer>> resultingPairs = new ArrayList<>();
        for (int i = 0; i < nums_.length; i++) {
            int temp = target_ - nums_[i];
            if (numberSet.contains(nums_[i])) {
                // The List.of() is extremely useful here to create a list of two elements
                resultingPairs.add(List.of(temp, nums_[i]));
            }
            numberSet.add(temp);
        }
        System.out.println(resultingPairs);
        return resultingPairs;
    }

}
