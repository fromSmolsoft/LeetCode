package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

class N0054_SpiralMatrixTest {

    private N0054_SpiralMatrix obj = new N0054_SpiralMatrix();

    /**
     * <pre>
     * Example 1:
     *    +-----+-----+-----+
     *    |     |     |     |
     *    |  1**** 2 *** 3  |
     *    |     |     |  *  |
     *    +-----+-----+--*--+
     *    |     |     |  *  |
     *    |  4 *** 5  |  6  |
     *    |  *  |     |  *  |
     *    +--*--+-----+--*--+
     *    |  *  |     |  *  |
     *    |  7 *** 8 *** 9  |
     *    |     |     |     |
     *    +-----+-----+-----+
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [1,2,3,6,9,8,7,4,5]
     *
     * Example 2:
     * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * Constraints:
     *     m == matrix.length
     *     n == matrix[i].length
     *     1 <= m, n <= 10
     *     -100 <= matrix[i][j] <= 100
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "1,2,3,6,9,8,7,4,5;             [[1,2,3],[4,5,6],[7,8,9]]",
            "1,2,3,4,8,12,11,10,9,5,6,7;    [[1,2,3,4],[5,6,7,8],[9,10,11,12]]",
            "1,2,3,6,9,8,7,5,5;             [[1,2,3],[5,5,6],[7,8,9]]",
            "1,1,1,2,3,3,3,2,2;             [[1,1,1],[2,2,2],[3,3,3]]",
            "1,2,3;                         [[1],[2],[3]]",
            "1,1,1;                         [[1,1,1]]",
            "10;                            [[10]]"
    })
    void spiralOrder(String sExp, String sInput) {

        // prepare input data
        String[] tempInput = TestUtils.StringToStringArray(sInput, "],\\[");
        int[][] input = new int[tempInput.length][];
        for (int i = 0; i < tempInput.length; i++) {
            String s = tempInput[i];
            s = TestUtils.removeSubStrings(s, "\\[", "\\]");
            int[] tempNums = TestUtils.StringToIntArray(s, ",");
            input[i] = tempNums;
        }

        // prepare expected data
        List<Integer> exp = TestUtils.StringToIntList(sExp, ",");

        // get actual data
        List<Integer> act = obj.spiralOrder(input);

        // build message
        StringBuilder tempMessage = new StringBuilder(input.length * 2);
        for (int[] i : input) {
            tempMessage.append(Arrays.toString(i)).append("\n");
        }

        String message =
                "\ninp:" +
                "\n" + tempMessage +
                "\nexp:" + exp +
                "\nact:" + act +
                "\n";

        Assertions.assertIterableEquals(exp, act, message);
    }
}