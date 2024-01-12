package com.smol.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N0003_LongestSubstringWithoutRepeatingCharactersTest {
    
    
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
    void lenghtOFLongestSubstringTest(String s, int length) throws InvocationTargetException, IllegalAccessException {
        N0003_LongestSubstringWithoutRepeatingCharacters obj = new N0003_LongestSubstringWithoutRepeatingCharacters();
        Method[] methods = N0003_LongestSubstringWithoutRepeatingCharacters.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().startsWith("lengthOfLongestSubstring")) {
                int actual = (int) method.invoke(obj, s);
                String message = "method: " + method.getName() + "->expected: %d, actual: %d\n".formatted(length, actual);
                assertEquals(length, actual, message);
            }
        }
    }
}