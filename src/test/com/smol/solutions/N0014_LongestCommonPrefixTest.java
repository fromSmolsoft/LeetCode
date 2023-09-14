package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0014_LongestCommonPrefixTest {


    @ParameterizedTest
    @CsvSource(value = {
            "fl, flower;flow;flight",
            " , dog;racecar;car",
            "ma, martin;matew;magpie",

    })
    void longestCommonPrefixTest(String expected, String strs) {
        expected = expected == null ? "" : expected; //if string is null make it into empty string
        String[] strings = strs.split(";"); //split string
        Assertions.assertEquals(expected, new N0014_LongestCommonPrefix().longestCommonPrefix(strings));
    }
}