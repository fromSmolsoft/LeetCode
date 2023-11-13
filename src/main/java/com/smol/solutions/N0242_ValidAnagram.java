package com.smol.solutions;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <h1>242. Valid Anagram</h1>
 * Easy <p>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise. <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <pre>
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Constraints:
 *     1 <= s.length, t.length <= 5 * 104
 *     s and t consist of lowercase English letters.
 * </pre>
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
public class N0242_ValidAnagram {

    /**
     * <h2> Count ascii chars and compare </h2>
     *
     * <pre>
     * Runtime 4ms, Beats 74.53%of users with Java
     * Memory 41.73MB, Beats 88.87%of users with Java
     * </pre>
     */
    public boolean isAnagram(String s, String t) {

        // diff length of strings means == no anagram
        if (s.length() != t.length()) return false;

        int[] letters = new int[26];

        // count chars in 1st string
        for (int i = 0; i < s.length(); i++) letters[s.charAt(i) - 97] += 1;

        // compare chars in 2nd string with counted chars
        for (int j = 0; j < t.length(); j++) {
            if (letters[t.charAt(j) - 97] > 0) letters[t.charAt(j) - 97] -= 1;
            else return false;
        }
        return true;
    }

    /**
     * <h2>Followup for unicode chars</h2>
     * @author TMS @ <a href="https://leetcode.com/problems/valid-anagram/solutions/66484/accepted-java-o-n-solution-in-5-lines/comments/68623">...</a>
     */
    public boolean isAnagramUniCode(String s, String t) {

        if (s.length() != t.length()) return false;
        var map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
            map.merge(t.charAt(i), -1, Integer::sum);
        }
        return map.values().stream().noneMatch(v -> v != 0);
    }

    /**
     * <h2>Sorting</h2>
     * sort(s.begin(), s.end()); sorts the characters in string s in ascending order. This rearranges the characters in s so that they are in alphabetical order.
     * <p>
     * sort(t.begin(), t.end()); sorts the characters in string t in ascending order. Similarly, this rearranges the characters in t to be in alphabetical order.
     * <p>
     * return s == t; compares the sorted strings s and t using the equality operator (==). If the sorted strings are equal, it means that the original strings s and t have the same characters in the same order, indicating that they are anagrams. In this case, the function returns true. Otherwise, if the sorted strings are not equal, the function returns false, indicating that the strings are not anagrams.
     */
    public boolean isAnagramSort(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }
}
