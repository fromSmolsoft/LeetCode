package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0006_ZigzagConversionTest {

    private N0006_ZigzagConversion obj = new N0006_ZigzagConversion();

    /**
     * <pre>
     * Example 1:
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     *
     * Example 2:
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     *
     * Example 3:
     * Input: s = "A", numRows = 1
     * Output: "A"
     *
     * Constraints:
     *     1 <= s.length <= 1000
     *     s consists of English letters (lower-case and upper-case), ',' and '.'.
     *     1 <= numRows <= 1000
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(value = {
            "PAHNAPLSIIGYIR,    PAYPALISHIRING, 3",
            "PINALSIGYAHRPI,    PAYPALISHIRING, 4",
            "A,                 A,              1",
            "AB,                AB,             1"
    })
    void convert(String exp, String s, int row) {
        String act;

        act = obj.convert(s, row);
        Assertions.assertEquals(exp, act, "O(n)");

        act = obj.convertBF(s, row);
        Assertions.assertEquals(exp, act,"Brute Force");

        act = obj.convertSA(s, row);
        Assertions.assertEquals(exp, act,"StringBuilder array");
    }
}