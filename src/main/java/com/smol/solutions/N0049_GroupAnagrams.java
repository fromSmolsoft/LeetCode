package com.smol.solutions;

import java.util.*;

/**
 * <h1>49. Group Anagrams</h1>
 * Medium
 * <p>
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * <pre>
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * Constraints:
 *     1 <= strs.length <= 104
 *     0 <= strs[i].length <= 100
 *     strs[i] consists of lowercase English letters.
 * </pre>
 */
public class N0049_GroupAnagrams {

    /**
     * <h2>Sort each string alphanumerically to compare</h2>
     * Memory efficient but slow
     * <pre>
     * Runtime 378ms Beats 5.01% of users with Java
     * Memory 46.03MB Beats 98.79% of users with Java
     * </pre>
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        // short quit for single word input
        if (strs.length == 1) {
            result.add(Arrays.asList(strs));
            return result;
        }
        // short quit for empty input
        else if (strs.length == 0) {
            return result;
        }

        String[] sorted = new String[strs.length]; //array instead of String uses less memory for some reason
        List<String> seen = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {

            // sort string a-z 0-9
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            sorted[i] = String.valueOf(chars);

            // find index where first anagram was saved
            if (seen.contains(sorted[i])) {
                int index = seen.indexOf(sorted[i]);

                // add new anagram into the list
                result.get(index).add(strs[i]);
            } else {

                // mark down first time seen anagram
                seen.add(sorted[i]);

                // save uniques into the main list of lists
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                result.add(newList);
            }
        }
        return result;
    }

    /**
     * <h2>Frequency counter with HashMap </h2>
     * @author davidluoyes @  <a href="https://leetcode.com/problems/group-anagrams/solutions/19176/share-my-short-java-solution/comments/241458">...</a>
     */
    public List<List<String>> groupAnagramsHS01(String[] strs) {
        if (strs == null || strs.length == 0) return Collections.emptyList();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] frequencyArr = new int[128];
            for (int i = 0; i < s.length(); i++) {
                frequencyArr[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(frequencyArr);
            List<String> tempList = map.getOrDefault(key, new LinkedList<String>());
            tempList.add(s);
            map.put(key, tempList);
        }
        return new LinkedList<>(map.values());
    }

    /**
     * Improved version of groupAnagramsHS01 method
     * @author davidluoyes and legendaryengineer <a href="https://leetcode.com/problems/group-anagrams/solutions/19176/share-my-short-java-solution/comments/241458">...</a>
     */
    public List<List<String>> groupAnagramsHS02(String[] strs) {
        if (strs == null || strs.length == 0) return Collections.emptyList();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            //char type 0~127 is enough for constraint 0 <= strs[i].length <= 100
            //char array to String is really fast, thanks @legendaryengineer
            //You should use other data type when length of string is longer.
            //E.g. Use byte (-128 to 127), short (-32,768 to 32,767),
            //int. -2,147,483,648 to 2,147,483,647
            char[] frequencyArr = new char[26];
            for (int i = 0; i < s.length(); i++) {
                frequencyArr[s.charAt(i) - 'a']++;
            }
            //6 ms use char(0~127) array and new String(frequencyArr) method.
            //17ms when use byte (-128 to 127) array and Arrays.toString(frequencyArr) method
            //29ms when use int(-2,147,483,648 to 2,147,483,647) and Arrays.toString(frequencyArr) method
            String key = new String(frequencyArr);
            List<String> tempList = map.getOrDefault(key, new LinkedList<String>());
            tempList.add(s);
            map.put(key, tempList);
        }
        return new LinkedList<>(map.values());
    }
}
