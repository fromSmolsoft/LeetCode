package com.smol.solutions;

/**
 * <h1>151. Reverse Words in a String</h1>
 * Medium
 * <p>
 * Given an input string s, reverse the order of the words.
 * <p>
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * <p>
 * Return a string of the words in reverse order concatenated by a single space.
 * <p>
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 * <pre>
 * Example 1:
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 * Example 3:
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * Constraints:
 *     1 <= s.length <= 104
 *     s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 *     There is at least one word in s.
 *
 * Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 * </pre>
 */
public class N0151_ReverseWordsInString {

    /**
     * <h1>No `split()` & `trim()`</h1>
     * <pre>
     * Runtime 8ms,     Beats 60.11%
     * Memory 43.17MB,  Beats 62.95%
     * </pre>
     */
    public String reverseWordsNoSplit(String s) {
        StringBuilder temp     = new StringBuilder();
        StringBuilder reversed = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (ch == ' ') {
                if (!temp.isEmpty()) reversed.insert(0, temp + " ");
                temp = new StringBuilder();
            } else temp.append(ch);
        }
        if (!temp.isEmpty()) reversed.insert(0, temp + " ");
        return reversed.substring(0, reversed.length() - 1);
    }


    /**
     * <h1>By Java libraries</h1>
     * <pre>
     * Runtime 6ms Beats 83.49%
     * Memory 42.99MB Beats 65.63%
     * </pre>
     */
    public String reverseWordsLib(String s) {
        String[]      words    = s.trim().split(" ");//use "\s" for all whitespace variants (tab, space, etc...)
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 1; i--) {
            reversed.append(words[i]);
            if (!words[i].isEmpty()) reversed.append(" ");
        }
        return reversed.append(words[0]).toString();
    }

    /**
     * <h1>Two pointers, no `split()` & `trim()` & `StringBuilder` </h1>
     */

    public String reverseWordsNoLibs(String s) {
        if (s == null) return null;

        char[] a = s.toCharArray();
        int    n = a.length;

        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseEeachWord(a, n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }

    void reverseEeachWord(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++; // skip spaces
            while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
            reverse(a, i, j - 1);                      // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }

    // reverse a[] from a[i] to a[j]
    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }
}