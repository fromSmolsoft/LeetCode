package com.smol.solutions;

/**
 * <h1>58. Length of Last Word</h1>
 * Easy <p>
 * Given a string `s` consisting of words and spaces, return the length of the **last** word in the string. <p>
 * <p>
 * A word is a maximal substring consisting of non-space characters only. <p>
 * (A substring is a contiguous non-empty sequence of characters within a string.)
 *
 * <pre>
 * Example 1:
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 *
 * Example 2:
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 *
 * Example 3:
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 *
 * Constraints:
 *     1 <= s.length <= 104
 *     s consists of only English letters and spaces ' '.
 *     There will be at least one word in s.
 * </pre>
 */
public class N0058_LengthOfLastWord {

    /**
     * <h1>No libraries - divided loop</h1>
     * <pre>
     * Runtime 0ms, Beats 100.00%
     * Memory 40.31MB, Beats 89.35%
     * </pre>
     */
    public int lengthOfLastWord(String s) {
        int    i;
        char[] chars = s.toCharArray();
        for (i = chars.length - 1; i >= 0; i--)
            if (chars[i] != ' ') break; //trims white spaces manually as oppose to trim()

        int count = 0;
        for (; i >= 0; i--) {       //continues from when white spaces ends until  white spaces appears again = last word
            if (chars[i] != ' ') count++;
            else break;
        }
        return count;
    }

}
