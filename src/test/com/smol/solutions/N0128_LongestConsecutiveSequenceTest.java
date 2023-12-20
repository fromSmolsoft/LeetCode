package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0128_LongestConsecutiveSequenceTest {

    N0128_LongestConsecutiveSequence obj = new N0128_LongestConsecutiveSequence();

    /**
     * <pre>
     * Example 1:
     * Input: nums = [100,4,200,1,3,2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     *
     * Example 2:
     * Input: nums = [0,3,7,2,5,8,4,6,0,1]
     * Output: 9
     *
     * Constraints:
     *     0 <= nums.length <= 105
     *     -109 <= nums[i] <= 109
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "4; 5,6,7,1,3,2,10,11,12,13",
            "9; 0,3,7,2,5,8,4,6,0,1",
            "4; 100,4,200,1,3,2",
            "1;1",
            "0;",
            "3; 1,2,0,1"
    })
    void longestConsecutive(int exp, String sNums) {
        int[] nums = TUtils.StringToIntArray(sNums, ",");
        int act;


        act = obj.longestConsecutive(nums);
        Assertions.assertEquals(exp, act);

        act = obj.longestConsecutiveHS(nums);
        Assertions.assertEquals(exp, act);
    }
}