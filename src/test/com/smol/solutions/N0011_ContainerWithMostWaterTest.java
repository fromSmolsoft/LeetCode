package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N0011_ContainerWithMostWaterTest {
    
    private final N0011_ContainerWithMostWater obj = new N0011_ContainerWithMostWater();
    
    /**
     * <pre>
     * Example 1:
     *  {@code
     *      8│    ┌┐             ┌┐
     *      7│    │┼─────────────┼┼─┬┐
     *      6│    ││~┌┐~~~~~~~~~~││~││
     *      5│    ││~││~~~~┌┐~~~~││~││
     *      4│    ││~││~~~~││~┌┐~││~││
     *      3│    ││~││~~~~││~││~││~││
     *      2│    ││~││~┌┐~││~││~││~││
     *      1│ ┌┐ ││~││~││~││~││~││~││
     *      0└─┴┴─┴┴─┴┴─┴┴─┴┴─┴┴─┴┴─┴┴─
     *          0  1  2  3  4  5  6  8
     * }
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
     *
     * Example 2:
     * Input: height = [1,1]
     * Output: 1
     *
     * Constraints:
     *     n == height.length
     *     2 <= n <= 105
     *     0 <= height[i] <= 104
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "49; 1,8,6,2,5,4,8,3,7",
            " 1; 1,1",
            " 5; 1,5,7,1",
            " 5; 1,10,0,2,1,1",
            " 0; 0,5,0"
    })
    void maxArea(int exp, String sHeights) {
        int[] heights = TUtils.StringToIntArray(sHeights, ",");
        int act;
        
        act = obj.maxAreaBF(heights);
        assertEquals(exp, act, "BF");
        
        act = obj.maxArea(heights);
        assertEquals(exp, act);
    }
}