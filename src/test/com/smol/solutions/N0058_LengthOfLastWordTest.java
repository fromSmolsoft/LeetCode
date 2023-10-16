package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0058_LengthOfLastWordTest {

    N0058_LengthOfLastWord obj = new N0058_LengthOfLastWord();

    /**
     * <pre>
     * Example 1:
     * Input: s = "Hello World"
     * Output: 5
     * Explanation: The last word is "World" with length 5.
     *
     * Example 2:
     * Input: s = "   fly me   to   the moon  "
     * Output: 4
     * Explanation: The last word is "moon" with length 4.
     *
     * Example 3:
     * Input: s = "luffy is still joyboy"
     * Output: 6
     * Explanation: The last word is "joyboy" with length 6.
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(value = {

            "5, 'Hello World'",
            "5, 'Hello World '",
            "5, 'Hello World  '",
            "1, 'Hello World  !'",
            "4, '   fly me   to   the moon  '",
            "6, 'luffy is still joyboy'",
            "1, a",
            "1, 'n '"

    })
    void lengthOfLastWord(int exp, String s) {
        int act = obj.lengthOfLastWord(s);
        Assertions.assertEquals(exp, act, "\"" + s + "\"");
    }
}