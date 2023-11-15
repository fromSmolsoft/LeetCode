package com.smol.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <h1>128. Longest Consecutive Sequence</h1>
 * Medium
 * <p>
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 *
 * <pre>
 * Example 1: *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Example 2: *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 * Constraints:
 *     0 <= nums.length <= 105
 *     -109 <= nums[i] <= 109
 * </pre>
 */
public class N0128_LongestConsecutiveSequence {

    /**
     * <h2>Sort and count</h2>
     * O(n log(n) + n) <p>
     * <pre>
     * Runtime 15ms Beats 95.06% of users with Java
     * Memory 57.01MB Beats 55.92% of users with Java
     * </pre>
     */
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        int max = 1, tempMax = 1;
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) tempMax++;
            else if (nums[i - 1] != nums[i]) {
                max = Math.max(max, tempMax);
                tempMax = 1;
            }
        }

        max = Math.max(max, tempMax);
        return max;
    }

    /**
     * <h2>No sort, Set, O(n)</h2>
     * @author jeantimex @ <a href="https://leetcode.com/problems/longest-consecutive-sequence/solutions/3171254/solution/?envType=study-plan-v2&envId=top-interview-150">...</a>
     */
    public int longestConsecutiveHS(int[] nums) {
        int max = 0;

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int count = 1;

            // look left
            int num = nums[i];
            while (set.contains(--num)) {
                count++;
                set.remove(num);
            }

            // look right
            num = nums[i];
            while (set.contains(++num)) {
                count++;
                set.remove(num);
            }

            max = Math.max(max, count);
        }

        return max;
    }

}
