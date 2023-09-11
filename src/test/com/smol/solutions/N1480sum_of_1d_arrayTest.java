package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N1480sum_of_1d_arrayTest {

    TestUtils utils = new TestUtils();

    @ParameterizedTest
    @CsvSource(value = {
            "1;2;3;4,    1;3;6;10",
            "1;1;1;1;1,  1;2;3;4;5",
            "3;1;2;10;1, 3;4;6;16;17"
    })
    void runningSumTest(String nums, String expected) {
        int[]                numsArray     = utils.convertStringToIntArray(nums, ";");
        int[]                expectedArray = utils.convertStringToIntArray(expected, ";");
        N1480sum_of_1d_array obj           = new N1480sum_of_1d_array();
        int[]                actualArray   = obj.runningSum(numsArray);


        Assertions.assertArrayEquals(expectedArray, actualArray);
    }
}