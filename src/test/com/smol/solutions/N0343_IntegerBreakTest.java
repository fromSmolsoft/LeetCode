package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0343_IntegerBreakTest {

    final N0343_IntegerBreak obj = new N0343_IntegerBreak();

    @ParameterizedTest
    @CsvSource(value = {
            /*exp       input*/
            "1,         2",
            "2,         3",
            "6,         5",
            "9,         6",
            "36,        10",
            "1549681956,58"
    })
    void integerBreak(int exp, int n) {
        int actual = obj.integerBreak(n);
        Assertions.assertEquals(exp, actual, "n=" + n);
    }
}