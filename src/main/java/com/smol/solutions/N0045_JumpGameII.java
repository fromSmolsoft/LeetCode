package com.smol.solutions;

/**
 * <h1>45. Jump Game II</h1>
 * Medium <p>
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * <p>
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 * <pre>
 *     0 <= j <= nums[i] and
 *     i + j < n
 * </pre>
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 *
 * <pre>
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 * Constraints:
 *     1 <= nums.length <= 104
 *     0 <= nums[i] <= 1000
 *     It's guaranteed that you can reach nums[n - 1].
 * </pre>
 */
public class N0045_JumpGameII {

    /**
     * <h1>Furthest jump in a temp range</h1>
     * Greedy algorithm
     * <h3>Logic:</h3>
     * 1. find new furthest possible jump within range of previous furthest possible jump - (if) <p>
     * 2. update range end with it's furthest possible "jump landing" spot - (if) <p>
     * 3. repeat all until all array is checked - (loop)    <p>
     *
     * <pre>
     * Runtime 1ms,    Beats 99.12%
     * Memory 44.24MB, Beats 77.35%
     * </pre>>
     */
    public int jump(int[] nums) {

        int rangeEnd = 0; //range end of last furthest jump
        int furthest = 0; //furthest reachable spot from all spots up to the rangeEnd
        int jumps    = 0; // min number of jumps

        for (int i = 0, l = nums.length - 1; i < l; i++) {
            furthest = Math.max(furthest, nums[i] + i); //find new furthest jump
            if (i == rangeEnd) {     // at the end of the rangeEnd
                rangeEnd = furthest; // update rangeEnd with the furthest jump
                jumps++;              // jump
            }
        }
        return jumps;
    }

}
