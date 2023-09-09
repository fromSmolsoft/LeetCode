package com.smol.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class n1342_NumberOfStepsToReduceNumberToZeroTest {

    @ParameterizedTest
    @CsvSource(value = {
            "14, 6",
            "8, 4",
            "123, 12"
    })
    void test(int num, int expected) {
        assertEquals(expected, new n1342_NumberOfStepsToReduceNumberToZero().numberOfSteps(num));
    }
}