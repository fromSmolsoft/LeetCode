package com.smol.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N0001_two_sumTest {

    @ParameterizedTest
    @CsvSource(value = {
            "2;7;11;15, 9, 0;1",
            "3;2;4, 6, 1;2",
            "3;3, 6, 0;1"
    })
    void test(String inputArray, int targetInt, String expectedArray) {

        String[] inputs          = inputArray.split(";");
        int[]    nums            = Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();
        String[] expected        = expectedArray.split(";");
        int[]    expectedNumbers = Arrays.stream(expected).mapToInt(Integer::parseInt).toArray();

        assertEquals(Arrays.toString(expectedNumbers), Arrays.toString(new N0001_two_sum().twoSum(nums, targetInt)));
    }

}