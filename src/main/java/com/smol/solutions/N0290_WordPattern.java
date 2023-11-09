package com.smol.solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <h1>290. Word Pattern</h1>
 * Easy
 * <p>
 * Given a pattern and a string s, find if s follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 *
 * <pre>
 * Example 1:
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 *
 * Example 2:
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 *
 * Example 3:
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 *
 * Constraints:
 *     1 <= pattern.length <= 300
 *     pattern contains only lower-case English letters.
 *     1 <= s.length <= 3000
 *     s contains only lowercase English letters and spaces ' '.
 *     s does not contain any leading or trailing spaces.
 *     All the words in s are separated by a single space.
 * </pre>
 */
public class N0290_WordPattern {

    public boolean wordPattern(String pattern, String s) {
        int[] chars = new int[26];
        Set<String> seen = new HashSet<>();
        String[] words = new String[26];
        int j = 0;

        for (int i = 0; i < pattern.length(); i++) {
            //prepare new word
            StringBuilder newWord = new StringBuilder();
            while (j < s.length() && s.charAt(j) != ' ') newWord.append(s.charAt(j++));


            if (chars[pattern.charAt(i) - 97] == 0 &&
                !seen.contains(newWord.toString())) {
                chars[pattern.charAt(i) - 97] = i + 1;
                words[pattern.charAt(i) - 97] = newWord.toString();
                seen.add(newWord.toString());

            }else if (chars[pattern.charAt(i) - 97] != 0){


            } else if (!newWord.toString().equals(words[pattern.charAt(i) - 97])) {
                return false;
            }


            while (j < s.length() && s.charAt(j) == ' ') j++;
        }

        return true;
    }

    public boolean wordPatternHM(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

}
