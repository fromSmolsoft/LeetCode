package com.smol.solutions;

/**
 * <h1>917. Reverse Only Letters</h1>
 * Easy<p>
 * Given a string s, reverse the string according to the following rules: <p>
 * All the characters that are not English letters remain in the same position. <p>
 * All the English letters (lowercase or uppercase) should be reversed. <p>
 * Return s after reversing it. <p>
 * <p>
 * Example 1: <p>
 * Input: s = "ab-cd" <p>
 * Output: "dc-ba" <p>
 * <p>
 * Example 2: <p>
 * Input: s = "a-bC-dEf-ghIj" <p>
 * Output: "j-Ih-gfE-dCba" <p>
 * <p>
 * Example 3: <p>
 * Input: s = "Test1ng-Leet=code-Q!" <p>
 * Output: "Qedo1ct-eeLg=ntse-T!" <p>
 * <p>
 * Constraints: <p>
 * 1 <= s.length <= 100 <p>
 * s consists of characters with ASCII values in the range [33, 122]. <p>
 * s does not contain '\"' or '\\'. <p>
 */

public class N0917_ReverseOnlyLetters {

    /**
     * Runtime 0ms, Beats 100.00%of users with Java <p>
     * Memory 40.58MB, Beats 61.62%of users with Java <p>
     */
    public String reverseOnlyLetters(String s) {
        char[] charArray = s.toCharArray();
        int    i         = 0;
        int    j         = charArray.length - 1;

        while (i < j) {
            if (Character.isLetter(charArray[i]) && Character.isLetter(charArray[j])) {
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
                i++;
                j--;
            } else {
                if (!Character.isLetter(charArray[i])) i++;
                if (!Character.isLetter(charArray[j])) j--;
            }
        }
        return new String(charArray);
    }
}
