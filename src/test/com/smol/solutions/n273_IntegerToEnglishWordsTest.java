package com.smol.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class n273_IntegerToEnglishWordsTest {


    @BeforeEach
    void setUp() {

    }

    @ParameterizedTest
    @CsvSource(value = {
            "123, One Hundred Twenty Three",
            "12345, Twelve Thousand Three Hundred Forty Five",
            "1234567, One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
            "1230, One Thousand Two Hundred Thirty"
    })
    void numberToWords(int input, String expected) {
        n273_IntegerToEnglishWords obj    = new n273_IntegerToEnglishWords();
        String                     actual = obj.numberToWords(input);
        assertEquals(expected, actual);
    }
}