package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

class N0056_MergeIntervalsTest {

    private N0056_MergeIntervals obj;
    private Method[] methods;

    @BeforeEach
    void setUp() {
        obj = new N0056_MergeIntervals();
        methods = N0056_MergeIntervals.class.getMethods();
    }

    /**
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
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {

            "[[1,6],[8,10],[15,18]];    [[1,3],[2,6],[8,10],[15,18]]",
            "[[1,5]];                   [[1,4],[4,5]]",
            "[[0,4]];                   [[1,4],[0,4]]",
            "[[0,0],[1,4]];             [[1,4],[0,0]]",
            "[[1,4]];                   [[1,4],[2,3]]",
            "[[1,10]];                  [[1,10],[2,3],[4,5],[4,9]",
            "[[1,3]];                   [[1,3]]"
    })
    void merge(String sExpected, String sIntervals) throws InvocationTargetException, IllegalAccessException {
        int[][] expected = TUtils.stringToMatrix(sExpected, "],\\[", ",", "\\[", "\\]");
        int[][] intervals = TUtils.stringToMatrix(sIntervals, "],\\[", ",", "\\[", "\\]");
        int[][] actual;


        for (Method m : methods) {
            if (m.getName().contains("merge")) {
                actual = (int[][]) m.invoke(obj, (Object) TUtils.copy2DArray(intervals));
                Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(actual), m.getName() + "\n" + "\nInput    :" + Arrays.deepToString(intervals));
            }
        }
    }
}