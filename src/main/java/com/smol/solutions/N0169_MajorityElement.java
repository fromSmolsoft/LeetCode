package com.smol.solutions;

/**
 * <h1>169. Majority Element</h1>
 * Easy
 * <p>
 * Given an array nums of size n, return the majority element.
 * <p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * <pre>
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 * Constraints:
 *     n == nums.length
 *     1 <= n <= 5 * 104
 *     -109 <= nums[i] <= 109
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 * </pre>
 */
public class N0169_MajorityElement {
    /**
     * <h1>Boyer–Moore majority vote algorithm</h1><pre>
     * Runtime 1ms,     Beats 99.89%of users with Java
     * Memory 48.55MB,  Beats 33.45%of users with Java
     * </pre>
     */
    public int majorityElement(int[] nums) {
        int candidate = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) sum++;
            else if (sum == 0) {
                candidate = nums[i];
                sum++;
            } else sum--;
        }
        return candidate;
    }

}
