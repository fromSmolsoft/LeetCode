package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0042_TrappingRainWaterTest {

    TestUtils               utils = new TestUtils();
    N0042_TrappingRainWater obj   = new N0042_TrappingRainWater();


    /**
     * <pre>     *
     * Example 1:
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
     *
     * Example 2:
     * Input: height = [4,2,0,3,2,5]
     * Output: 9
     *
     * Constraints:
     *     n == height.length
     *     1 <= n <= 2 * 104
     *     0 <= height[i] <= 105
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "6; 0,1,0,2,1,0,1,3,2,1,2,1",
            "9; 4,2,0,3,2,5",
            "6; 3,2,1,3,2,1,3,2,1",
            "4; 3,2,1,2,3",
            "10; 10,0,10",
            "10; 10,0,10,0",
            "0; 0",
            "0; 10,0,0",
            "0; 0,0,10",
            "0; 0,10,0",

    })
    void trap(int exp, String sH) {
        int[] heights = utils.StringToIntArray(sH, ",");
        int   act;

        act = obj.trap2P(heights);
        Assertions.assertEquals(exp, act, "2P ");

        act = obj.trapSt(heights);
        Assertions.assertEquals(exp, act, "Stack ");

    }
}