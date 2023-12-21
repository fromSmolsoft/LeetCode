package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

class N0228_SummaryRangesTest {

    private N0228_SummaryRanges obj;

    @BeforeEach
    void setUp() {
        obj = new N0228_SummaryRanges();
    }

    /**
     * <pre>
     *  Example 1:
     *  Input: nums = [0,1,2,4,5,7]
     *  Output: ["0->2","4->5","7"]
     *  Explanation: The ranges are:
     *  [0,2] --> "0->2"
     *  [4,5] --> "4->5"
     *  [7,7] --> "7"
     *
     *  Example 2:
     *  Input: nums = [0,2,3,4,6,8,9]
     *  Output: ["0","2->4","6","8->9"]
     *  Explanation: The ranges are:
     *  [0,0] --> "0"
     *  [2,4] --> "2->4"
     *  [6,6] --> "6"
     *  [8,9] --> "8->9"
     *
     *  Constraints:
     *      0 <= nums.length <= 20
     *      -231 <= nums[i] <= 231 - 1
     *      All the values of nums are unique.
     *      nums is sorted in ascending order.
     *  </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "0->2,4->5,7; 0,1,2,4,5,7",
            "0,2->4,6,8->9; 0,2,3,4,6,8,9"
    })
    void summaryRanges(String sExp, String sInp) {
        List<String> expected = TUtils.StringToStringList(sExp, ",");
        int[] input = TUtils.StringToIntArray(sInp, ",");
        List<String> actual = obj.summaryRanges(input);

        Assertions.assertIterableEquals(expected, actual,
                "\ninp: " + Arrays.toString(input) +
                "\nexp: " + expected +
                "\nact: " + actual +
                "\n"
        );

    }
}