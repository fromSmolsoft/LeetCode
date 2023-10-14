package com.smol.solutions;

/**
 * <h1>55. Jump Game</h1>
 * <pre>
 * Medium
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 * Constraints:
 *     1 <= nums.length <= 104
 *     0 <= nums[i] <= 105
 * </pre>
 */
public class N0055_JumpGame {


    /**
     * <pre>
     * Runtime 2ms,     Beats 80.43%
     * Memory 44.27MB,  Beats 50.66%
     * </pre>
     * */
    public boolean canJump(int[] nums) {
        int reach = 0; // Furthest possible to combination of jumps with the longest reach

        for (int i = 0, l = nums.length; i <= reach; i++) {
            reach = Math.max(reach, i + nums[i]); // Check if when jumping from current position further spot can be reached
            if (reach >= l - 1) return true;   // (over)reached the last index
        }

        return false;
    }

    /**
     * <pre>
     * Runtime2 ms,     Beats 80.43%
     * Memory 44.2 MB,  Beats 61.5%
     * </pre>
     */
    public boolean canJump01(int[] nums) {
        int reach = 0;  // Furthest possible to combination of jumps with the longest reach
        for (int i = 0; i < nums.length; ++i) {
            if (i > reach) return false;            // Cannot be reached by combo of jumps
            reach = Math.max(reach, i + nums[i]);   // Check if when jumping from current position further spot can be reached
        }
        return true; // last index was reached
    }
}
