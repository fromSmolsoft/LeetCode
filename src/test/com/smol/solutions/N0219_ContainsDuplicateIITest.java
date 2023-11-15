package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0219_ContainsDuplicateIITest {

    private static N0219_ContainsDuplicateII obj = new N0219_ContainsDuplicateII();

    /**
     * <pre>
     * Example 1:
     * Input: nums = [1,2,3,1], k = 3
     * Output: true
     *
     * Example 2:
     * Input: nums = [1,0,1,1], k = 1
     * Output: true
     *
     * Example 3:
     * Input: nums = [1,2,3,1,2,3], k = 2
     * Output: false
     *
     * Constraints:
     *     1 <= nums.length <= 105
     *     -109 <= nums[i] <= 109
     *     0 <= k <= 105
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "true; 3; 1,2,3,1 ",
            "true; 1; 1,0,1,1 ",
            "false; 2; 1,2,3,1,2,3"
    })
    void containsNearbyDuplicate(boolean exp, int k, String sNums) {

        int[] nums = TestUtils.StringToIntArray(sNums, ",");
        boolean act;


        act = obj.containsNearbyDuplicateHP(nums, k);
        Assertions.assertEquals(exp, act);

        act = obj.containsNearbyDuplicateSW(nums, k);
        Assertions.assertEquals(exp, act);
    }
}