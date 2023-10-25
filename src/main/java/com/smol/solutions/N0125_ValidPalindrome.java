package com.smol.solutions;

/**
 * <h1>125. Valid Palindrome</h1>
 * Easy  <p>
 * <p>
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
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
public class N0125_ValidPalindrome {


    /**
     * <h1> Two pointers + character numeric values </h1>
     * Converts string to lowercase.
     * Uses chars numeric value to find if they are not numbers or lower case letters
     * <pre>
     * 'a' = 97
     * 'z' = 122
     * '0' = 48
     * '9' = 57
     * </pre>
     * Skips other characters  <p>
     *
     * <h2>Time and memory</h2>
     * <pre>
     * Runtime 2ms, Beats 99.33%
     * Memory 43.60MB, Beats 44.23%
     * </pre>
     */
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int    start = 0;
        int    end   = chars.length - 1;

        while (start <= end) {
            char leftChar  = chars[start];
            char rightChar = chars[end];

            if ((leftChar < 97 || leftChar > 122) &&
                (leftChar < 48 || leftChar > 57)
            ) {
                start++;
                continue;
            }

            if ((rightChar < 97 || rightChar > 122) &&
                (rightChar < 48 || rightChar > 57)
            ) {
                end--;
                continue;
            }

            if (leftChar == rightChar) {
                start++;
                end--;
            } else return false;
        }
        return true;
    }

    /**
     * <h1>Short,regex replace</h1>
     */
    public boolean isPalindromeSB(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev    = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }

}
