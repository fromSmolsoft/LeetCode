package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0290_WordPatternTest {

    private final N0290_WordPattern obj = new N0290_WordPattern();

    /**
     * <pre>
     * Example 1:
     * Input: pattern = "abba", s = "dog cat cat dog"
     * Output: true
     *
     * Example 2:
     * Input: pattern = "abba", s = "dog cat cat fish"
     * Output: false
     *
     * Example 3:
     * Input: pattern = "aaaa", s = "dog cat cat dog"
     * Output: false
     *
     * Constraints:
     *     1 <= pattern.length <= 300
     *     pattern contains only lower-case English letters.
     *     1 <= s.length <= 3000
     *     s contains only lowercase English letters and spaces ' '.
     *     s does not contain any leading or trailing spaces.
     *     All the words in s are separated by a single space.
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(value = {
            "true, abba, dog cat cat dog",
            "false, abba, dog cat cat fish",
            "false, aaaa, dog cat cat dog",
            "true,  zaaz, dog cat cat dog",
            "false, abba,  dog dog dog dog"
    })
    void wordPattern(boolean exp, String pattern, String s) {
        String message = "\n" +
                         "pattern - string" +
                         "\n" + pattern + " - " + s +
                         "\n";
        boolean act;

        act = obj.wordPattern(pattern, s);
        Assertions.assertEquals(exp, act, "" + message);

        act = obj.wordPatternHM(pattern, s);
        Assertions.assertEquals(exp, act, "HashMap" + message);

    }
}