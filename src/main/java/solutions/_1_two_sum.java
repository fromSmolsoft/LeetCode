package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order. <p>
 * Example 1:<p>
 * Input: nums = [2,7,11,15], target = 9 <p>
 * Output: [0,1] <p>
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]. <p>
 * Example 2: <p>
 * Input: nums = [3,2,4], target = 6 <p>
 * Output: [1,2] <p>
 * Example 3: <p>
 * Input: nums = [3,3], target = 6 <p>
 * Output: [0,1] <p>
 * Constraints: <p>
 * 2 <= nums.length <= 104 <p>
 * -109 <= nums[i] <= 109 <p>
 * -109 <= target <= 109 <p>
 * Only one valid answer exists. <p>
 */
public class _1_two_sum {

    /** Efficient 0(n) solution */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapNums = new HashMap<>();
        int numbLength = nums.length;

        for (int i = 0; i < numbLength; i++) {
            int complement = target - nums[i];
            if (mapNums.containsKey(complement)) {
                return new int[]{mapNums.get(complement), i};
            } else {
                mapNums.put(nums[i], i);
            }
        }
        return new int[]{};
    }


    /** Brute force O(n^2) solution */
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{j, i};
                }
            }
        }
        return null;
    }
}
