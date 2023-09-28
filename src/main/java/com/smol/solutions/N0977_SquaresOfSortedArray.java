package com.smol.solutions;

import java.util.Arrays;

/**
 * <h1>977. Squares of a Sorted Array</h1>
 * Easy <p>
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * <pre>
 *
 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 *
 * Example 2:
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 * Constraints:
 *     1 <= nums.length <= 104
 *     -104 <= nums[i] <= 104
 *     nums is sorted in non-decreasing order.
 *
 * </pre>
 * Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */
public class N0977_SquaresOfSortedArray {


    /**
     * <h1>Two pointers solution</h1> <pre>
     * Pointer staring positions:
     * - left  - first element
     * - right - last element
     * - index - last element
     *
     * Logic:
     * - while left <= right
     * - compare their absolute values
     * - add bigger value as squared value to index
     * - if left value was bigger increment left pointer position
     *   and vice versa for right pointer
     * -
     * </pre>
     */
    public int[] sortedSquares(int[] nums) {
        int   left   = 0;
        int   right  = nums.length - 1;
        int   i      = right;
        int[] result = new int[nums.length];

        while (left <= right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) result[i] = nums[right] * nums[right--];
            else result[i] = nums[left] * nums[left++];
            i--;
        }
        return result;
    }

    /**
     * <h1>Brute force </h1>
     * O(n logn)
     * <pre>
     * Slow but Simple solution
     * 1. square values
     * 2. sorts array
     * Runtime 7ms, Beats 41.38%of users with Java
     * Memory 44.98MB, Beats 39.43%of users with Java
     * </pre>
     */
    public int[] sortedSquares01(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);
        return result;
    }
}
