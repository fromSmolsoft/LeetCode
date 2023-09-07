package com.smol.solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N541_ReverseStringIITest {

    @DisplayName("Reverse String II")
    @ParameterizedTest
    @CsvSource(value = {
            "2, abcd, bacd",
            "2, abcdefg, bacdfeg",
            "2, abcdefghkij, bacdfeghikj",
            "2, abcdefgabcdefgabcdefg, bacdfegacbdegfabdcefg",
            "3, abcdefg, cbadefg",
            "3, abcdefgabcdefgabcdefg, cbadefbagcdeagfbcdgfe",

    })
    void reverseStr(int k, String s, String expected) {
        N541_ReverseStringII obj = new N541_ReverseStringII();
        System.out.println("input   : " + s);
        assertEquals(expected, obj.reverseStr(s, k));
    }
}