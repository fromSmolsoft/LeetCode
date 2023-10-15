package com.smol.solutions;

/**
 * <h1>238. Product of Array Except Self</h1>
 * Medium
 * <p>
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * <pre>
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 * Constraints:
 *     2 <= nums.length <= 105
 *     -30 <= nums[i] <= 30
 *     The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * </pre>
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
public class N0238_ProductOfArrayExceptSelf {


    /**
     * <pre>
     * Runtime 1ms,     Beats 100.00%
     * Memory 51.74MB,  Beats 75.48%
     * </pre>
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = left;
            left = left * nums[i];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];
        }

        return result;
    }

}
