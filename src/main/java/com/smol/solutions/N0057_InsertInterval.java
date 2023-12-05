package com.smol.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>57. Insert Interval</h1>
 * Medium
 * <p>
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * <p>
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * <p>
 * Return intervals after the insertion.
 *
 * <pre>
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 * Constraints:
 *     0 <= intervals.length <= 104
 *     intervals[i].length == 2
 *     0 <= starti <= endi <= 105
 *     intervals is sorted by starti in ascending order.
 *     newInterval.length == 2
 *     0 <= start <= end <= 105
 * </pre>
 */
public class N0057_InsertInterval {

    /**
     * <pre>
     * Runtime 1 ms     Beats 99.32% of users with Java
     * Memory 44.60 MB  Beats 6.14% of users with Java
     * </pre>
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0, n = intervals.length;

        // add all intervals ending before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) res.add(intervals[i++]);

        // merge intervals that intersect with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // add all intervals starting after newInterval ends
        while (i < n) res.add(intervals[i++]);

        return res.toArray(new int[0][]);
    }
}
