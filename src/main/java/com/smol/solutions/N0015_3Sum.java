package com.smol.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>15. 3Sum</h1>
 * Medium
 * <p>
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 * <pre>
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and
 * the order of the triplets does not matter.
 *
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation:
 * The only possible triplet does not sum up to 0.
 *
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation:
 * The only possible triplet sums up to 0.
 *
 * Constraints:
 *     3 <= nums.length <= 3000
 *     -105 <= nums[i] <= 105
 * </pre>
 */
public class N0015_3Sum {

    /**
     * Todo, too slow, too many nesting, meeds optimalization
     * <pre>
     * Runtime 38ms Beats 41.50% of users with Java
     * Memory 50.46MB Beats 71.52% of users with Java
     * </pre>
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;

        if (n < 3 || nums[0] > 0 || nums[n - 1] < 0) return result;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];
            int left   = i + 1;
            int right  = n - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;

                } else if (sum < target) {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;

                } else {
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) right--;

                }

            }

        }
        return result;
    }

}
