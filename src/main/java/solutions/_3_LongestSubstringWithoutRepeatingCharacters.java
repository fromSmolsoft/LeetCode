package solutions;

import java.util.HashSet;

/**
 * <h1>3. Longest Substring Without Repeating Characters</h1>
 * Medium
 * 36.7K
 * 1.7K
 * Companies
 * <p>
 * Given a string s, find the length of the longest
 * substring
 * without repeating characters.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        //fixme
        char               current;
        int                max      = 0;
        HashSet<Character> set      = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            if (set.add(current)) {
            } else {
                if (set.size() > max) {
                    max = set.size();
                }
                set.clear();
                set.add(current);
            }
        }
        return max;
    }

}
