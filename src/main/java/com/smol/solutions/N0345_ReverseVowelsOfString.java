package com.smol.solutions;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <h1>345. Reverse Vowels of a String</h1>
 * Easy <p>
 * Given a string s, reverse only all the vowels in the string and return it.
 * <p>
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "hello"
 * Output: "holle"
 * <p>
 * Example 2:
 * <p>
 * Input: s = "leetcode"
 * Output: "leotcede"
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 3 * 105
 * s consist of printable ASCII characters.
 */
public class N0345_ReverseVowelsOfString {


    /**
     * Runtime  4ms, Beats 64.50%of users with Java <p>
     * Memory 43.49MB, Beats 95.90%of users with Java  <p>
     */
    public String reverseVowels(String s) {

        char[]         charArray = s.toCharArray();
        Set<Character> vowels    = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        int i = 0;
        int j = charArray.length - 1;
        while (i < j) {
            // checking for vowels
            if (!vowels.contains(charArray[i])) i++; // skip non-vowels
            if (!vowels.contains(charArray[j])) j--; // skip non-vowels
            if (vowels.contains(charArray[i]) && vowels.contains(charArray[j])) {
                // vowel swapping
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
                i++;
                j--;
            }
        }
        return new String(charArray);
    }

    /**
     * Runtime 6ms, Beats 41.26%of users with Java <p>
     * Memory 43.71MB, Beats 73.24%of users with Java <p>
     */
    public String reverseVowels01(String s) {

        char[] charArray = s.toCharArray();
        Set<Character> vowels = Stream.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
                .collect(Collectors.toSet()); // Stream is slower then `add(...)` individually but readable

        int i = 0;
        int j = charArray.length - 1;
        while (i < j) {
            // checking for vowels
            if (!vowels.contains(charArray[i])) i++; // skip non-vowels
            if (!vowels.contains(charArray[j])) j--; // skip non-vowels
            if (vowels.contains(charArray[i]) && vowels.contains(charArray[j])) {
                // vowel swapping
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
                i++;
                j--;
            }
        }
        return new String(charArray);
    }

}
