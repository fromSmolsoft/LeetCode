package com.smol.solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N0344_ReverseStringTest {


    /**
     * Example 1:
     * <p>
     * Input: s = ["h","e","l","l","o"]
     * Output: ["o","l","l","e","h"]
     * <p>
     * Example 2:
     * <p>
     * Input: s = ["H","a","n","n","a","h"]
     * Output: ["h","a","n","n","a","H"]
     */
    @DisplayName("Reverse String")
    @ParameterizedTest
    @CsvSource(value = {
            "hello, olleh",
            "hannah, hannah",
            "Martin, nitraM",
            "jelenovipivonelej, jelenovipivonelej",
    })
    void reverseStringTest(String input, String expected) {
        char[]              s   = input.toCharArray();
        N0344_ReverseString obj = new N0344_ReverseString();
        obj.reverseString(s);
        assertEquals(expected, new String(s));
    }

}