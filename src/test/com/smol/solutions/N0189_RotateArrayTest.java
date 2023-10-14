package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

class N0189_RotateArrayTest {

    TestUtils         utils   = new TestUtils();
    N0189_RotateArray obj     = new N0189_RotateArray();
    Method[]          methods = N0189_RotateArray.class.getDeclaredMethods();

    /**
     * <pre>
     * Example 1:
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]
     *
     * Example 2:
     * Input: nums = [-1,-100,3,99], k = 2
     * Output: [3,99,-1,-100]
     * Explanation:
     * rotate 1 steps to the right: [99,-1,-100,3]
     * rotate 2 steps to the right: [3,99,-1,-100]
     * </pre>
     */
    @DisplayName("Rotate Array ")
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            " partial ; 5,6,7,1,2,3,4; 3; 1,2,3,4,5,6,7",
            " partial ; 3,99,-1,-100;  2; -1,-100,3,99",
            " no rot. ; 1,2,3,4,5,6,7; 0; 1,2,3,4,5,6,7",
            " full rot.;1,2,3,4,5,6,7; 7; 1,2,3,4,5,6,7",
    })
    void rotate(String desc, String sExp, int k, String sNums) throws InvocationTargetException, IllegalAccessException {

        int[] exp      = utils.StringToIntArray(sExp, ",");
        int[] nums     = utils.StringToIntArray(sNums, ",");
        int[] numsOrig = Arrays.copyOf(nums, nums.length);

        String message = String.format(
                "\nk:   %s" +
                "\ninp: %s" +
                "\nexp: %s "
                , k, Arrays.toString(nums), Arrays.toString(exp));

        for (Method m : methods) {
            if (m.getName().startsWith("rotate")) {
                nums = Arrays.copyOf(numsOrig, numsOrig.length);
                m.invoke(obj, nums, k);
                Assertions.assertArrayEquals(exp, nums, "method" + m + message + "\nout: " + Arrays.toString(nums));
            }
        }


    }
}