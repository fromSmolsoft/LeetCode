package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0125_ValidPalindromeTest {

    private static N0125_ValidPalindrome obj = new N0125_ValidPalindrome();

    /**
     * <pre>
     * Example 1:
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     *
     * Example 2:
     * Input: s = "race a car"
     * Output: false
     * Explanation: "raceacar" is not a palindrome.
     *
     * Example 3:
     * Input: s = " "
     * Output: true
     * Explanation: s is an empty string "" after removing non-alphanumeric characters.
     * Since an empty string reads the same forward and backward, it is a palindrome.
     *
     * Constraints:
     *     1 <= s.length <= 2 * 105
     *     s consists only of printable ASCII characters.
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(value = {
            "true, 'A man, a plan, a canal: Panama'",
            "false,race a car",
            "true, ' '",
            "true, Jelenovi pivo nelej"
    })
    void isPalindrome(boolean exp, String input) {
        boolean act = obj.isPalindrome(input);
        Assertions.assertEquals(exp, act);
    }
}