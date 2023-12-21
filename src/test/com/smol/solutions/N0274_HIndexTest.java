package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0274_HIndexTest {
    TUtils utils = new TUtils();
    N0274_HIndex obj   = new N0274_HIndex();

    /**
     * <pre>
     * Example 1:
     * Input: citations = [3,0,6,1,5]
     * Output: 3
     * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
     * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
     *
     * Example 2:
     * Input: citations = [1,3,1]
     * Output: 1
     *
     * Constraints:
     *     n == citations.length
     *     1 <= n <= 5000
     *     0 <= citations[i] <= 1000
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "3; 3,0,6,1,5",
            "1; 1,3,1",
            "4; 4,4,4,4,4,4,5",
            "1; 100",
            "0; 0",
            "2; 11,15"
    })
    void hIndex(int exp, String sInp) {
        int[] input = utils.StringToIntArray(sInp, ",");
        int   act;
        act = obj.hIndex(input);
        Assertions.assertEquals(exp, act,"00");

        act = obj.hIndex01(input);
        Assertions.assertEquals(exp, act,"01");
    }
}