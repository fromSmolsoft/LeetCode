package com.smol.solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N0345_ReverseVowelsOfStringTest {


    @DisplayName("Reverse Vowels of a String")
    @ParameterizedTest
    @CsvSource(value = {
            "hello, holle",
            "leetcode, leotcede",
            "Martin, Mirtan",
            "RoboChukapabra, RabaChakupobro",
            "updownupdown, opduwnopduwn"
    })
    void reverseVowels(String s, String expected) {
        N0345_ReverseVowelsOfString obj = new N0345_ReverseVowelsOfString();
        assertEquals(expected, obj.reverseVowels(s));
        assertEquals(expected, obj.reverseVowels01(s));

    }
}