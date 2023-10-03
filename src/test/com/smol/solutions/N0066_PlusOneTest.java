package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class N0066_PlusOneTest {

    TestUtils     utils = new TestUtils();
    N0066_PlusOne obj   = new N0066_PlusOne();

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            /*expected  input*/
            "4,3,2,2;   4,3,2,1",
            "1,0;       9",
            "1,0,0,0;   9,9,9",
            "2,0,0;     1,9,9",
    })
    void plusOne(String exp, String inp) {
        int[] input    = utils.convertStringToIntArray(inp, ",");
        int[] expected = utils.convertStringToIntArray(exp, ",");
        int[] actual   = obj.plusOne(input);

        Assertions.assertArrayEquals(expected, actual, "act:" + Arrays.toString(actual));
    }
}