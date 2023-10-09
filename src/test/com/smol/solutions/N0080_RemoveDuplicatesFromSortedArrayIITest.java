package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class N0080_RemoveDuplicatesFromSortedArrayIITest {


    TestUtils                               utils = new TestUtils();
    N0080_RemoveDuplicatesFromSortedArrayII obj   = new N0080_RemoveDuplicatesFromSortedArrayII();

    /**
     * <pre>
     * Example 1:
     * Input: nums = [1,1,1,2,2,3]
     * Output: 5, nums = [1,1,2,2,3,_]
     * Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     *
     * Example 2:
     * Input: nums = [0,0,1,1,1,1,2,3,3]
     * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
     * Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     *
     * Constraints:
     *     1 <= nums.length <= 3 * 104
     *     -104 <= nums[i] <= 104
     *     nums is sorted in non-decreasing order.
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "5; 1,1,2,2,3;      1,1,1,2,2,3; ",
            "7; 0,0,1,1,2,3,3;  0,0,1,1,1,1,2,3,3",
            "1; 1;              1",
            "4; 1,2,3,4;        1,2,3,4",
            "5; 1,2,2,3,4;      1,2,2,2,2,2,3,4"

    })
    void removeDuplicates(int expK, String sExpOutput, String sInput) {

        int[] expOut  = utils.StringToIntArray(sExpOutput, ",");
        int[] nums    = utils.StringToIntArray(sInput, ",");
        int[] numsOrg = Arrays.copyOf(nums, nums.length);

       //method 1
        int   actual  = obj.removeDuplicates(nums);

        Assertions.assertEquals(expK, actual, "number of elements");

        for (int i = 0; i < expOut.length; i++) {
            Assertions.assertEquals(expOut[i], nums[i], "\nexp" + Arrays.toString(expOut) +
                                                        "\nact" + Arrays.toString(nums) +
                                                        "\nmismatch at index " + i);
        }

        //method 2
        nums = Arrays.copyOf(numsOrg, numsOrg.length);
        actual = obj.removeDuplicates02(nums);

        Assertions.assertEquals(expK, actual, "number of elements");

        for (int i = 0; i < expOut.length; i++) {
            Assertions.assertEquals(expOut[i], nums[i], "\nexp" + Arrays.toString(expOut) +
                                                        "\nact" + Arrays.toString(nums) +
                                                        "\nmismatch at index " + i);
        }


    }
}