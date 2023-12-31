package com.smol.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N0013_RomanToIntegerTest {
    private N0013_RomanToInteger obj;

    @BeforeEach
    void setUp() {

        obj = new N0013_RomanToInteger();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "III, 3",
            "IV, 4",
            "LVIII, 58",
            "MCMXCIV, 1994",
            "CDXLIV, 444",
            "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMCMXCIX, 99999",
    })
    void intToRoman(String roman, int expected) {
        assertEquals(expected, obj.romanToInt(roman));
    }
}