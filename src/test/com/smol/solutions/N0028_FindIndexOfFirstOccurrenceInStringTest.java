package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0028_FindIndexOfFirstOccurrenceInStringTest {

    N0028_FindIndexOfFirstOccurrenceInString obj = new N0028_FindIndexOfFirstOccurrenceInString();


    @ParameterizedTest
    @CsvSource(value = {
            "-1, leetcode,      leeto",
            " 0, sadbutsad,     sad",
            " 1, mississippi,   issi",
            " 1, abcd,          bc",
            " 2, abcd,          cd",
            " 2, end,           d",
            " 4, mississippi,   issip",
            " 9, mississippi,   pi"
    })
    void strStr(int exp, String haystack, String needle) {
        int actual = obj.strStr(haystack, needle);
        Assertions.assertEquals(exp, actual);
    }
}