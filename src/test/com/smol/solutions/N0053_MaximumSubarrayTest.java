package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0053_MaximumSubarrayTest {
    
    private final N0053_MaximumSubarray obj = new N0053_MaximumSubarray();
    
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "6; -2,1,-3,4,-1,2,1,-5,4",
            "1; 1",
            "23; 5,4,-1,7,8"
    })
    void maxSubArray(int exp, String numbers) {
        int[] nums = TUtils.StringToIntArray(numbers, ",");
        int actual = obj.maxSubArray(nums);
        Assertions.assertEquals(exp, actual);
    }
}