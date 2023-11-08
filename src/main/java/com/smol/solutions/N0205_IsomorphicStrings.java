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
     * <h2>ASCII indexing </h2>
     */
    public boolean isIsomorphic(String s, String t) {
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


}
