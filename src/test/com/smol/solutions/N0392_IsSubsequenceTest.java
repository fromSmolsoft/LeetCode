package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0392_IsSubsequenceTest {

    final N0392_IsSubsequence obj = new N0392_IsSubsequence();

    /**
     * <pre>
     * Example 1:
     * Input: s = "abc", t = "ahbgdc"
     * Output: true
     *
     * Example 2:
     * Input: s = "axc", t = "ahbgdc"
     * Output: false
     *
     * Constraints:
     *     0 <= s.length <= 100
     *     0 <= t.length <= 104
     *     s and t consist only of lowercase English letters.
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(value = {
            "true, abc, ahbgdc",
            "false, axc, ahbgdc",
            "true, '', ahbgdc",
            "false, abc, ''",

            //There won't be null as input
            // "true, , ahbgdc",
            // "false, '', ",
            // "true, , ",


    })
    void isSubsequence(boolean exp, String sub, String text) {
        boolean act = obj.isSubsequence(sub, text);
        Assertions.assertEquals(exp, act);
    }
}