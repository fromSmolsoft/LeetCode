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

    /**
     * <h2>Without Hashmap</h2>
     * ! Proof of concept, might require an optimization ! <p>
     * Doesn't use Java prebuilt HashMap <p>
     * Fast <p>
     * <pre>
     * Runtime 1ms      Beats 100% Java
     * Memory 40.58MB   Beats 24.66%  Java
     * </pre>
     */
    public boolean wordPattern(String pattern, String s) {
        // init
        int[] chars = new int[26];
        Set<String> seen = new HashSet<>();
        String[] words = new String[26];
        int j = 0;

        // pattern iteration
        for (int i = 0; i < pattern.length(); i++) {

            //if string is too short to reach end of the pattern (= not enough words)
            if (j >= s.length()) return false;

            // Prepare next word by sub-string iteration
            StringBuilder newWord = new StringBuilder();
            while (j < s.length() && s.charAt(j) != ' ') newWord.append(s.charAt(j++));
            String nWord = newWord.toString();

            int cIndex = pattern.charAt(i) - 97;

            // if char  &&  word were not seen
            if (chars[cIndex] == 0) {
                if (!seen.contains(nWord)) {
                    // Save char && word
                    chars[cIndex] = i + 1;
                    words[cIndex] = nWord;
                    seen.add(nWord);

                    // if char was not seen but word was seen
                } else return false;

                // if char was seen but word was not seen
            } else if (chars[cIndex] != 0 && !seen.contains(nWord)) return false;

                // if word doesn't equal
            else if (!nWord.equals(words[cIndex])) return false;

            // fill in the white spaces
            while (j < s.length() && s.charAt(j) == ' ') j++;
        }
        // if full string was processed == true / false
        return j == s.length();
    }

    public boolean wordPatternHM(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i = 0; i < words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

}
