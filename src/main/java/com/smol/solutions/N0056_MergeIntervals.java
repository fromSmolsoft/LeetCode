package com.smol.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>56. Merge Intervals</h1>
 * Medium
 * <p>
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * <pre>
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 *
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * Constraints:
 *     1 <= intervals.length <= 104
 *     intervals[i].length == 2
 *     0 <= starti <= endi <= 104
 * </pre>
 */
public class N0056_MergeIntervals {

    /**
     * <pre>
     * Runtime 10 ms Beats 30.85% of users with Java
     * Memory 45.92 MB Beats 16.89% of users with Java
     * </pre>
     */
    public int[][] merge(int[][] ints) {

        if (ints.length <= 1) return ints;

        //none sorted input has to be sorted by first indices of each "sub-array"
        Arrays.sort(ints, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int start = ints[0][0];
        int end = ints[0][ints[0].length - 1];

        for (int i = 1; i < ints.length; i++) {

            // if right interval is the last of all intervals
            if (i == ints.length - 1) {

                // if last interval doesn't intercept with start-end interval
                if (end < ints[i][0]) {
                    // save both start-end and last interval separately
                    res.add(new int[]{start, end});
                    res.add(new int[]{ints[i][0], ints[i][ints[i].length - 1]});

                } else {
                    // end updated to the highest possible value
                    end = Math.max(end, ints[i][ints[i].length - 1]);

                    // save interval start-end
                    res.add(new int[]{start, end});
                }

            } else
                // when intervals don't intercept:
                // if end < right start
                if (end < ints[i][0]) {
                    // save new interval
                    res.add(new int[]{start, end});
                    // update start & end
                    start = ints[i][0];
                    end = ints[i][ints[i].length - 1];

                } else
                    //when intervals intercept:
                    // if end >= first of right interval->
                    //      if end is smaller than last of right interval->
                    //          end = last of right interval
                    if (end >= ints[i][0]) end = Math.max(end, ints[i][ints[i].length - 1]);
        }
        return res.toArray(new int[0][]);
    }

    /**
     * Concise but slower
     * @author isalonisharma @ <a href="https://leetcode.com/problems/merge-intervals/?envType=study-plan-v2&envId=top-interview-150">lnk</a>
     */
    public int[][] merge01(int[][] intervals) {
        List<int[]> answer = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] i : intervals) {
            if (i[0] <= end) {
                end = Math.max(end, i[1]);
            } else {
                answer.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        answer.add(new int[]{start, end});
        return answer.toArray(new int[0][]);
    }
}