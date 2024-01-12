package com.smol.solutions;

/**
 * <h1>392. Is Subsequence</h1>
 * Easy
 * <p>
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * <p>
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
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
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 */
public class N0392_IsSubsequence {

    /**
     * txt pointer iterates text
     * sub pointer iterates subsequence only if it finds match in text.
     * if any pointer exceeds length of their String, break the loop.
     * if sub pointer iterated full length of subsequence String, return true else false.
     *
     * <pre>
     * Runtime 1ms, Beats 91.28%
     * Memory 40.36MB, Beats 57.67%
     * </pre>
     */
    public boolean isSubsequence(String s, String t) {

        int m = t.length(), n = s.length();

        if (n > m) return false;
        else if (n == 0) return true;

        int sub = 0, txt = 0;

        while (txt < m) {
            if (t.charAt(txt) == s.charAt(sub)) {
                sub++;
                if (sub >= n) break;
            }
            txt++;
        }
        return sub == n;
    }

}
