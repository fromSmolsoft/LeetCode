package com.smol.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N273_IntegerToEnglishWordsTest {


    @BeforeEach
    void setUp() {

    }

    @ParameterizedTest
    @CsvSource(value = {
            "0, Zero",
            "13, Thirteen",
            "21, Twenty One",
            "34, Thirty Four",
            "67, Sixty Seven",
            "123, One Hundred Twenty Three",
            "1230, One Thousand Two Hundred Thirty",
            "12345, Twelve Thousand Three Hundred Forty Five",
            "20000, Twenty Thousand",
            "230000, Two Hundred Thirty Thousand",
            "234000, Two Hundred Thirty Four Thousand",
            "1234567, One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
            "2147483647, Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven",
    })
    void numberToWords(int input, String expected) {
        N273_IntegerToEnglishWords obj    = new N273_IntegerToEnglishWords();
        String                     actual = obj.numberToWords(input);
        assertEquals(expected, actual);
    }
}