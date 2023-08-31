package solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _3_LongestSubstringWithoutRepeatingCharactersTest {
    //todo test

    _3_LongestSubstringWithoutRepeatingCharacters substringWithoutRepeatingCharacters;

    @BeforeEach
    void setUp() {
        substringWithoutRepeatingCharacters = new _3_LongestSubstringWithoutRepeatingCharacters();
    }

    /** Example 1: Input: s = "abcabcbb", Output: 3, Explanation: The answer is "abc", with the length of 3. */
    @Test
    void test1() {
        String s      = "abcabcbb";
        int    length = substringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
        assertEquals(3, length);
    }

    /** Example 2: Input: s = "bbbbb", Output: 1, Explanation: The answer is "b", with the length of 1. */
    @Test
    void test2() {
        String s      = "bbbbb";
        int    length = substringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
        assertEquals(1, length);

    }

    /** Example 3:, Input: s = "pwwkew", Output: 3, Explanation: The answer is "wke", with the length of 3. Notice that the answer must be a substring, "pwke" is a subsequence and not a substring. */
    @Test
    void test3() {
        String s      = "pwwkew";
        int    length = substringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
        assertEquals(3, length);

    }    @Test
    void test4() {
        String s      = "abcabcbblkajdlajsdaldjaldjlagruqbbc";
        int    length = substringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
        assertEquals(9, length);

    }
    @Test
    void test5() {
        String s      = "abcabcdefg";
        int    length = substringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
        assertEquals(7, length);

    }
}