package com.smol.solutions;

import java.util.Arrays;

/**
 * <h1>14. Longest Common Prefix</h1>
 * Easy <p>
 * Write a function to find the longest common prefix string amongst an array of strings. <p>
 * If there is no common prefix, return an empty string "". <p>
 * <p>
 * Example 1: <p>
 * Input: strs = ["flower","flow","flight"] <p>
 * Output: "fl" <p>
 * <p>
 * Example 2: <p>
 * Input: strs = ["dog","racecar","car"] <p>
 * Output: "" <p>
 * Explanation: There is no common prefix among the input strings. <p>
 * <p>
 * Constraints: <p>
 * 1 <= strs.length <= 200 <p>
 * 0 <= strs[i].length <= 200 <p>
 * strs[i] consists of only lowercase English letters. <p>
 */

public class N0014_LongestCommonPrefix {
    /**
     * Runtime 1ms, Beats 82.85%of users with Java <p>
     * Memory 40.80MB, Beats 32.55%of users with Java <p>
     */
    public String longestCommonPrefix(String[] strs) {
        int prefixLength = getPrefixLenght(strs);
        return strs[0].substring(0, prefixLength);
    }

    /** Helper. Calculates leght of common characters */
    private int getPrefixLenght(String[] strs) {
        String first        = strs[0];
        int    prefixLength = first.length();
        for (int j = 1; j < strs.length; j++) {
            int strLength = strs[j].length();
            prefixLength = Math.min(prefixLength, strLength);
            for (int i = 0; i < prefixLength; i++) {
                if (first.charAt(i) != strs[j].charAt(i)) {
                    prefixLength = i;
                    break;
                }
            }
        }
        return prefixLength;
    }


    /**
     * Alphabetically sorting array, then comparing first and last string in array, because they have the biggest differences.  It will reduces number of iterations.
     */
    public String longestCommonPrefix01(String[] strs) {
        Arrays.sort(strs);
        String s1  = strs[0];
        String s2  = strs[strs.length - 1];
        int    idx = 0;
        while (idx < s1.length() && idx < s2.length()) {
            if (s1.charAt(idx) == s2.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }

}
