package com.smol.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _3_LongestSubstringWithoutRepeatingCharactersTest {

    _3_LongestSubstringWithoutRepeatingCharacters obj;

    @BeforeEach
    void setUp() {
        obj = new _3_LongestSubstringWithoutRepeatingCharacters();
    }

    /**
     * Example 1: Input: s = "abcabcbb", Output: 3, Explanation: The answer is "abc", with the length of 3. <p>
     * Example 2: Input: s = "bbbbb", Output: 1, Explanation: The answer is "b", with the length of 1. <p>
     * Example 3:, Input: s = "pwwkew", Output: 3, Explanation: The answer is "wke", with the length of 3. Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
    @ParameterizedTest
    @CsvSource(value = {
            "abcabcbb, 3",
            "bbbbb, 1",
            "pwwkew, 3",
            "abcabcbblkajdlajsdaldjaldjlagruqbbc, 9",
            "abcabcdefg, 7"
    })
    void lengOFLongestSubstringTest(String s, int length) {
        assertEquals(length, obj.lengthOfLongestSubstring(s));
    }
}