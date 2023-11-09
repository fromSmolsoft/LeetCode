package com.smol.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>205. Isomorphic Strings</h1>
 * Easy
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 * <pre>
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 *
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 *
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 *
 * Constraints:
 *     1 <= s.length <= 5 * 104
 *     t.length == s.length
 *     s and t consist of any valid ascii character.
 * </pre>
 */
public class N0205_IsomorphicStrings {

    /**
     * <H2>HashMap, simple</H2>
     * simplest solution. <p>
     * Time O(n)
     * </p>
     * <pre>
     * Runtime 10ms Beats 65.36% with Java
     * Memory 41.46MB Beats 43.33% with Java
     * </pre>
     */
    public boolean isIsomorphicHM(String s, String t) {
        Map<Character, Character> matches = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char tT = t.charAt(i);
            char sS = s.charAt(i);

            if (matches.containsKey(tT)) {
                if (matches.get(tT) != sS) return false;
            } else if (matches.containsValue(sS)) return false;
            else matches.put(tT, sS);
        }
        return true;
    }

    /**
     * <h2>ASCII "map" into two arrays </h2>
     */
    public boolean isIsomorphicM(String s, String t) {
        int[] map1 = new int[200]; //200 ascii chars, index = char, val = position in string
        int[] map2 = new int[200];

        for (int i = 0; i < s.length(); i++) {
            //compares last known positions of chars in each string
            // if positions don't match, String is not isomorphic (one char would be mapped to multiple chars)
            if (map1[s.charAt(i)] != map2[t.charAt(i)]) return false;
            //saving last chars positions
            map1[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    /**
     * <h2>Single array ASCII position</h2>
     * The main idea is to store the last seen positions of current (i-th) characters in both strings.
     * If previously stored positions are different then we know that the fact they're occurring in the current i-th position simultaneously is a mistake.
     * We could use a map for storing but as we deal with chars which are basically ints and can be used as indices we can do the whole thing with an array.
     * <p>
     * @author shpolsky @  <a href="https://leetcode.com/problems/isomorphic-strings/solutions/57810/short-java-solution-without-maps/?envType=study-plan-v2&envId=top-interview-150">...</a>
     */
    public boolean isIsomorphicA(String s1, String s2) {
        int[] map = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (map[s1.charAt(i)] != map[s2.charAt(i) + 256]) return false;
            map[s1.charAt(i)] = map[s2.charAt(i) + 256] = i + 1;
        }
        return true;
    }


}
