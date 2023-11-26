package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0242_ValidAnagramTest {

    private N0242_ValidAnagram obj = new N0242_ValidAnagram();

    /**
     * <pre>
     *  Example 1:
     *  Input: s = "anagram", t = "nagaram"
     *  Output: true
     *
     *  Example 2:
     *  Input: s = "rat", t = "car"
     *  Output: false
     *
     *  Constraints:
     *      1 <= s.length, t.length <= 5 * 104
     *      s and t consist of lowercase English letters.
     *  </pre>
     */
    @ParameterizedTest
    @CsvSource(value = {
            "true, anagram, nagaram",
            "false, rat, car",
            "false, anagra, nagaram",
            "false, anagram, nagara",

    })
    void isAnagram(boolean exp, String s, String t) {
        boolean act;

        act = obj.isAnagram(s, t);
        Assertions.assertEquals(exp, act);

        act = obj.isAnagramUniCode(s, t);
        Assertions.assertEquals(exp, act);

        act = obj.isAnagramSort(s, t);
        Assertions.assertEquals(exp, act);
    }
}