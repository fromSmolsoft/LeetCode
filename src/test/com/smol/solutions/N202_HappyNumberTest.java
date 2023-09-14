package com.smol.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N202_HappyNumberTest {

    @ParameterizedTest
    @CsvSource(value = {
            "19, true",
            "2, false",
            "20000000, false",
            "99, false"
    })
    void isHappy(int n, boolean expected) {
        assertEquals(expected, new N202_HappyNumber().isHappy(n));
        assertEquals(expected, new N202_HappyNumber().isHappy01(n));
    }
}