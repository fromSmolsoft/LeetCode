package com.smol.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>228. Summary Ranges</h1>
 * Easy
 * <p>
 * You are given a sorted unique integer array nums.
 * <p>
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * <p>
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 * <p>
 * Each range [a,b] in the list should be output as:
 * <p>
 * "a->b" if a != b     <p>
 * "a" if a == b        <p>
 *
 * <pre>
 * Example 1:
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 * Example 2:
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 * Constraints:
 *     0 <= nums.length <= 20
 *     -231 <= nums[i] <= 231 - 1
 *     All the values of nums are unique.
 *     nums is sorted in ascending order.
 * </pre>
 */
public class N0228_SummaryRanges {

    /**
     * <pre>
     * Runtime 5 ms     Beats 86.45% of users with Java
     * Memory 41.30 MB  Beats 9.17% of users with Java
     * </pre>
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int start = 0;

        for (int i = 0; i < nums.length; i++) {

            // if previous != current -> incrementation interrupted between  start and i+1
            if (i == nums.length - 1 || nums[i] + 1 != nums[i + 1]) {

                // print this if interval is single number
                if (start == i) {res.add(String.valueOf(nums[start]));}

                // print this if interval is range between two numbers
                else res.add(nums[start] + "->" + nums[i]);

                // set new start
                if (start != nums.length - 1) start = i + 1;
            }
        }
        return res;
    }
}
