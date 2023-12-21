package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0055_JumpGameTest {

    TUtils utils = new TUtils();
    N0055_JumpGame obj   = new N0055_JumpGame();

    /**
     * <pre>
     * Example 1:
     * Input: nums = [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     *
     * Example 2:
     * Input: nums = [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
     *
     * Constraints:
     *     1 <= nums.length <= 104
     *     0 <= nums[i] <= 105
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "true;  2,3,1,1,4",
            "true;  2,1,6,1,4",
            "true;  3,2,2,0,4",
            "true;  2,3,1,8,4",

            "false; 3,2,1,0,4",
            "true; 0",
            "true; 3,0,8,2,0,0,1"
    })
    void canJump(boolean exp, String sInp) {
        int[]   inputs  = utils.StringToIntArray(sInp, ",");
        boolean act;
        String  message;

        message = "M00";
        act = obj.canJump(inputs);
        Assertions.assertEquals(exp, act, message);

        message = "M01";
        act = obj.canJump01(inputs);
        Assertions.assertEquals(exp, act, message);
    }
}