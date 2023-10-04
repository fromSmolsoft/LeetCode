package com.smol.solutions;

/**
 * <h1>28. Find the Index of the First Occurrence in a String</h1>
 * Easy <p>
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <pre>
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 *
 * Example 2:
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 * Constraints:
 *     1 <= haystack.length, needle.length <= 104
 *     haystack and needle consist of only lowercase English characters.
 * </pre>
 */
public class N0028_FindIndexOfFirstOccurrenceInString {

    /**
     * <h1>Three pointers</h1>
     * <pre>
     * - `i` pointer iterates "haystack"
     * - `j` pointer iterates "needle"
     * - `start` pointer saves first char of "needle" in "haystack" found
     *
     * Logic:
     * Loop through "haystack" chars
     * - if "haystack" char equals needle char
     *      -  if `j` is 0, `start` pointer saves `i`
     *      -  if `j` reaches full length of "needle", return `i` subtracted by length of "needle"
     *
     * - else if char of "needle" and "haystack" don't match
     *      - move `i` to `start` pointer
     *      - reset `j` (the "needle") pointer to its first char (0)
     *
     * retun -1 in case loop finishes without complete match
     *
     * Runtime 0ms, Beats 100.00% of users with Java
     * Memory 40.14MB, Beats 86.28% of users with Java
     * </pre>
     */
    public int strStr(String haystack, String needle) {

        char[] hay   = haystack.toCharArray();
        int    l1    = hay.length;
        char[] n     = needle.toCharArray();
        int    l2    = n.length - 1;
        int    j     = 0;
        int    start = 0;

        for (int i = 0; i < l1; i++) {
            if (hay[i] == n[j]) {
                if (j == 0) start = i;
                if (j++ == l2) return i - l2;
            } else if (j > 0) {
                i = start;
                j = 0;
            }
        }
        return -1;
    }

}
