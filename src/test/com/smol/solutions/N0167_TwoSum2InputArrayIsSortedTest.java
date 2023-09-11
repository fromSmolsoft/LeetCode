package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0167_TwoSum2InputArrayIsSortedTest {
    TestUtils utils = new TestUtils();

    @ParameterizedTest
    @CsvSource(value = {
            " 9,  2|7|11|15, 1|2",
            " 6,  2|3|4,     1|3",
            "-1, -1|0,      1|2"
    })
    void twoSum(int target, String numbers, String expected) {
        N0167_TwoSum2InputArrayIsSorted obj = new N0167_TwoSum2InputArrayIsSorted();

        int[] inputs        = utils.convertStringToIntArray(numbers, "\\|");
        int[] expectedArray = utils.convertStringToIntArray(expected, "\\|");
        int[] actual        = obj.twoSum(inputs, target);

        Assertions.assertArrayEquals(expectedArray, actual);

    }
}