package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

class N0057_InsertIntervalTest {


    private N0057_InsertInterval obj;

    @BeforeEach
    void setUp() {
        obj = new N0057_InsertInterval();
    }

    /**
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
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "[[1,5],[6,9]];             [[1,3],[6,9]];                      [2,5]",
            "[[1,2],[3,10],[12,16]];    [[1,2],[3,5],[6,7],[8,10],[12,16]]; [4,8]",
            "[[1,6]];                   [[1,2],[3,4],[5,6]];                [2,5]",
            "[[1,4]];                   [[2,3]];                            [1,4]",
            "[[1,5]];                   [[2,3]];                            [1,5]"
    })
    void insert(String sExpected, String sIntervals, String sNewInterval) throws InvocationTargetException, IllegalAccessException {
        int[][] expected = TUtils.stringToMatrix(sExpected, "],\\[", ",", "[", "\\]");
        int[][] intervals = TUtils.stringToMatrix(sIntervals, "],\\[", ",", "[", "\\]");
        sNewInterval = TUtils.removeSubStrings(sNewInterval, "[", "\\]");
        int[] newInterval = TUtils.StringToIntArray(sNewInterval, ",");

        int[][] actual;
        Method[] methods = N0057_InsertInterval.class.getMethods();
        for (Method m : methods) {
            if (m.getName().contains("insert")) {
                actual = (int[][]) m.invoke(obj, intervals, newInterval);
                Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(actual), "\nintervals:" + Arrays.deepToString(intervals) + " newInt " + Arrays.toString(newInterval));
            }
        }

    }
}