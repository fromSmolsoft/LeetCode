package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

class N0452_MinimumNumberOfArrowsToBurstBalloonsTest {

    private N0452_MinimumNumberOfArrowsToBurstBalloons obj;


    @BeforeEach
    void setUp() {
        obj = new N0452_MinimumNumberOfArrowsToBurstBalloons();
    }

    /**
     * <pre>
     * Example 1:
     * Input: points = [[10,16],[2,8],[1,6],[7,12]]
     * Output: 2
     * Explanation: The balloons can be burst by 2 arrows:
     * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
     * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
     *
     * Example 2:
     * Input: points = [[1,2],[3,4],[5,6],[7,8]]
     * Output: 4
     * Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
     *
     * Example 3:
     * Input: points = [[1,2],[2,3],[3,4],[4,5]]
     * Output: 2
     * Explanation: The balloons can be burst by 2 arrows:
     * - Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
     * - Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
     *
     * Constraints:
     *     1 <= points.length <= 105
     *     points[i].length == 2
     *     -231 <= xstart < xend <= 231 - 1
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "2; [[10,16],[2,8],[1,6],[7,12]]",
            "4; [[1,2],[3,4],[5,6],[7,8]]",
            "2; [[1,2],[2,3],[3,4],[4,5]]",
            "1; [[1,2]]",
            "2; [[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]",
            "2; [[-2147483646,-2147483645],[2147483646,2147483647]]",
            "2; [[9,12],[1,10],[4,11],[8,12],[3,9],[6,9],[6,7]]"
    })
    void findMinArrowShots(int expected, String sInput) throws InvocationTargetException, IllegalAccessException {
        int[][] input = TUtils.stringToMatrix(sInput, "\\],\\[", ",", "\\[", "\\]");
        int actual;
        Method[] methods = N0452_MinimumNumberOfArrowsToBurstBalloons.class.getMethods();
        for (Method m : methods) {
            if (m.getName().contains("findMinArrowShots")) {
                int[][] temp = TUtils.copy2DArray(input); // cloning input, tested method can change input in come cases
                actual = (int) m.invoke(obj, (Object) temp);
                Assertions.assertEquals(expected, actual, "\nmethod: " + m.getName() + "\ninput    :" + Arrays.deepToString(input));
            }
        }
    }
}