package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class N0238_ProductOfArrayExceptSelfTest {


    TUtils utils = new TUtils();
    N0238_ProductOfArrayExceptSelf obj   = new N0238_ProductOfArrayExceptSelf();


    /**
     * <pre>
     * Example 1:
     * Input: nums = [1,2,3,4]
     * Output: [24,12,8,6]
     *
     * Example 2:
     * Input: nums = [-1,1,0,-3,3]
     * Output: [0,0,9,0,0]
     *
     * Constraints:
     *     2 <= nums.length <= 105
     *     -30 <= nums[i] <= 30
     *     The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {

            "24,12,8,6; 1,2,3,4",
            "0,0,9,0,0;-1,1,0,-3,3",
            "1,1,1,1,1;   -1,-1,-1,-1,-1",
            "-1,-1,-1,-1;   -1,-1,-1,-1"

    })
    void productExceptSelf(String sExp, String sInp) {
        int[]  exp = utils.StringToIntArray(sExp, ",");
        int[]  inp = utils.StringToIntArray(sInp, ",");
        int[]  act;
        String message;

        act = obj.productExceptSelf(inp);
        message = "\nexp " + Arrays.toString(exp)
                  + "\nact " + Arrays.toString(act)
                  + "\n";
        Assertions.assertArrayEquals(exp, act, message);

        act = obj.productExceptSelfBF(inp);
        message = "\nexp " + Arrays.toString(exp)
                  + "\nact " + Arrays.toString(act)
                  + "\n";
        Assertions.assertArrayEquals(exp, act, message);

        act = obj.productExceptSelfBF(inp);
        message = "\nexp " + Arrays.toString(exp)
                  + "\nact " + Arrays.toString(act)
                  + "\n";
        Assertions.assertArrayEquals(exp, act, message);

    }
}