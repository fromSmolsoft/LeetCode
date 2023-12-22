package com.smol.solutions;

/**
 * <h1>541. Reverse String II</h1>
 * Easy <p>
 * Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string. <p>
 * If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original. <p>
 * Example 1:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * <p>
 * Example 2:
 * Input: s = "abcd", k = 2
 * Output: "bacd"
 * <p>
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of only lowercase English letters.
 * 1 <= k <= 104
 */
public class N0541_ReverseStringII {

    /**
     * Runtime 1ms, Beats 87.01%of users with Java <p>
     * Memory  43.51MB, Beats 38.11%of users with Java <p>
     */
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int    length    = charArray.length;
        for (int i = 0; i <= length - 1; i += 2 * k) {
            reverseK(i, Math.min(i + k - 1, length - 1), charArray);
        }
        return new String(charArray);
    }


    /**
     * Runtime 1ms, Beats 87.01%of users with Java <p>
     * Memory 42.96MB.Beats 98.05%of users with Java <p>
     * original solution by deepVashisth <p>
     */
    public String reverseStr02(String s, int k) {
        char[] str = s.toCharArray();
        int    n   = str.length;
        for (int i = 0; i <= n - 1; i += 2 * k) {
            //for fewer than k characters left (edge case)
            reverseK(i, Math.min(i + k - 1, n - 1), str);
        }
        return new String(str);
    }

    /** Helper by by by deepVashisth */
    public void reverseK(int i, int j, char[] str) {
        while (i < j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }

}
