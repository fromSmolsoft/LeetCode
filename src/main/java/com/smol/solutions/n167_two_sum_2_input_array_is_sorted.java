package com.smol.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>167. Two Sum II - Input Array Is Sorted</h1>
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.
 * <p>
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * <p>
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * <p>
 * Your solution must use only constant extra space.
 * <p>
 * Example 1:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * <p>
 * Example 2:
 * <p>
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 * <p>
 * Example 3:
 * <p>
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 * <p>
 * Constraints:
 * <p>
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 */
public class n167_two_sum_2_input_array_is_sorted {

    /** faster, simple */
    public int[] twoSum(int[] numbers, int target) {
        int l   = 0;
        int r   = numbers.length - 1;
        int sum = numbers[l] + numbers[r];

        while (sum != target) {
            if (sum < target) l++;
            else r--;
            sum = numbers[l] + numbers[r];
        }
        return new int[]{l + 1, r + 1};
    }

    /** faster, simple */
    public int[] twoSum03(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (numbers[l] + numbers[r] != target) {
            if (numbers[l] + numbers[r] < target) l++;
            else r--;
        }
        return new int[]{l + 1, r + 1};
    }

    /** fast */
    public int[] twoSum02(int[] numbers, int target) {
        int   l      = 0;
        int   r      = numbers.length - 1;
        int[] result = new int[2];

        while (l < r) {
            int sum = numbers[l] + numbers[r];

            if (sum == target) {
                result[0] = l + 1;
                result[1] = r + 1;
                return result;
            } else if (sum > target) {
                r--;
            } else l++;
        }
        return result;
    }

    /** slow, complicated */
    public int[] twoSum01(int[] numbers, int target) {
        Map<Integer, Integer> numsMap    = new HashMap<>();
        int                   numbLength = numbers.length;

        for (int i = 1; i < numbLength; i++) {
            int complement = target - numbers[i];
            if (numsMap.containsKey(complement)) {
                return new int[]{numsMap.get(complement) + 1, i + 1};
            } else {
                numsMap.put(numbers[i], i);
            }
        }
        return new int[]{};
    }
}
