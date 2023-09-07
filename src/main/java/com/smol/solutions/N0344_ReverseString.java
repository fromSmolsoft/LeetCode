package com.smol.solutions;

/**
 * <h1>344. Reverse String</h1>
 * Easy
 * <p>
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * <p>
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * <p>
 * Example 2:
 * <p>
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */

public class N0344_ReverseString {

    /**
     * Runtime 1ms, Beats 52.83%of users with Java <p>
     * Memory  50.59MB, Beats 70.98%of users with Java <p>
     */
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (j > i) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
