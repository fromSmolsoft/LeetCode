package com.smol.solutions;

import com.smol.solutions._13_RomanToInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _13_RomanToIntegerTest {
    private _13_RomanToInteger obj;

    @BeforeEach
    void setUp() {

        obj = new _13_RomanToInteger();
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