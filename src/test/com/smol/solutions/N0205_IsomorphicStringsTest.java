package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0205_IsomorphicStringsTest {

    private N0205_IsomorphicStrings obj = new N0205_IsomorphicStrings();

    /**
     * <pre>
     *   Example 1:
     *   Input: s = "egg", t = "add"
     *   Output: true
     *
     *   Example 2:
     *   Input: s = "foo", t = "bar"
     *   Output: false
     *
     *   Example 3:
     *   Input: s = "paper", t = "title"
     *   Output: true
     *
     *   Constraints:
     *       1 <= s.length <= 5 * 104
     *       t.length == s.length
     *       s and t consist of any valid ascii character.
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(value = {
            " true, egg, add ",
            "false, foo, bar",
            "true, paper, title",
            "false, bbbaaaba, aaabbbba",
            "false, badc, baba"

    })
    void isIsomorphic(boolean exp, String s, String t) {
        boolean act;
        act = obj.isIsomorphicHM(s, t);
        Assertions.assertEquals(exp, act, "\ns= " + s +
                                          "\nt= " + t +
                                          "\n");
       act = obj.isIsomorphic(s, t);
        Assertions.assertEquals(exp, act, "\ns= " + s +
                                          "\nt= " + t +
                                          "\n");
    }
}