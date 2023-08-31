package solutions;

import java.util.HashSet;
import java.util.Set;

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

    public int lengthOfLongestSubstring01(String s) {
        //fixme - it doesn't work in all cases
        char           current;
        int            max = 0;
        int            j   = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            if (set.add(current)) {
                // continue looping
            } else {
                int temp = set.size();
                if (temp > max) {
                    max = temp;
                }
                set.remove(s.charAt(j++));
                set.add(current);
            }
        }
        max = Math.max(max, set.size());
        return max;
    }

   /**
    * The idea is use a hash set to track the longest substring without repeating characters so far, use a fast pointer j to see if character j is in the hash set or not, if not, great, add it to the hash set, move j forward and update the max length, otherwise, delete from the head by using a slow pointer i until we can put character j to the hash set.*/
    public int lengthOfLongestSubstring(String s) {
        int            i   = 0;
        int            j   = 0;
        int            max = 0;
        Set<Character> set = new HashSet<>();
        //iterate the string
        while (j < s.length()) {
            // if character j is not in the hash set
            if (!set.contains(s.charAt(j))) {
                // add it to the hash set
                set.add(s.charAt(j++));
                // update the max length
                max = Math.max(max, set.size());
            } else {
                // delete character from the head
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

}
