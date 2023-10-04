package com.smol.solutions;

/**
 * <h1>53. Maximum Subarray</h1>
 * Medium   <p>
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * <pre>
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 *
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 *
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 *
 * Constraints:
 *     1 <= nums.length <= 105
 *     -104 <= nums[i] <= 104
 * </pre>
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class N0053_MaximumSubarray {

    /**
     * <h1>Kadane's Algorithm</h1>
     * <pre>
     * - iterate array, each time:
     *      - element is added to the sum
     *      - if sum is bigger then max, the new max = sum
     *      - if sum < 0 make sum = 0
     *
     * Runtime 1ms, Beats 100.00% of users with Java
     * Memory 59.70MB, Beats 36.64% of users with Java
     * </pre>
     * @param nums integer array
     * @return max - biggest of all sub-sums achieved during itteration
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            sum += num;
            if (sum > max) max = sum;
            if (sum < 0) sum = 0;
        }
        return max;
    }
}
