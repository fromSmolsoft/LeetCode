package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class N0015_3SumTest {
    
    private final N0015_3Sum obj = new N0015_3Sum();
    
    /**
     * <pre>
     * Example 1:
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Explanation:
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
     * The distinct triplets are [-1,0,1] and [-1,-1,2].
     * Notice that the order of the output and
     * the order of the triplets does not matter.
     *
     * Example 2:
     * Input: nums = [0,1,1]
     * Output: []
     * Explanation:
     * The only possible triplet does not sum up to 0.
     *
     * Example 3:
     * Input: nums = [0,0,0]
     * Output: [[0,0,0]]
     * Explanation:
     * The only possible triplet sums up to 0.
     *
     * Constraints:
     *     3 <= nums.length <= 3000
     *     -105 <= nums[i] <= 105
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            ";",
            "-1,-1,2],[-1,0,1; -1,0,1,2,-1,-4",
            " ;                 0,1,1",
            "0,0,0;             0,0,0",
            "-2,0,2],[-2,1,1;  -2,0,1,1,2",
            "-5,1,4],[-3,-1,4],[-3,0,3],[-2,-1,3],[-2,1,1],[-1,0,1],[0,0,0; -2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0"
    })
    public void threeSum(String sExp, String sInput) {
        List<String> listExp = TUtils.StringToStringList(sExp, "\\],\\[");
        List<List<Integer>> exp = new ArrayList<>();
        for (String s : listExp) exp.add(TUtils.StringToIntList(s, ","));
        
        int[] input = TUtils.StringToIntArray(sInput, ",");
        
        List<List<Integer>> act = obj.threeSum(input);
        
        String message =
                "method :" +
                "\ninput:" + Arrays.toString(input) +
                "\nexp:  " + exp +
                "\nact:  " + act +
                "\n";
        
        Assertions.assertEquals(exp, act, message);
    }
    
}