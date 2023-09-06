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
public class N541_ReverseStringII {

    public String reverseStr01(String s, int k) {

        //todo
        // - [ ] for every 2k characters counting from the start of the string reverse the first k characters
        // - [ ] if there are fewer than k characters left, reverse all of them
        // - [ ] if there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original

        // k=2 ab cd ef ga bc  de fg ab cd ef g
        // k=2 ba cd fe ga cb  de gf ab dc ef g
        //     01 23 45 67 89  12 14 16 18 20 21

        //k=3 abc def gab cde fga bcd efg
        //k=3 cba def bag cde agf bcd gfe

        StringBuilder sb     = new StringBuilder();
        int           length = s.length();


//        int back = k -1;
//        for (int i = back; i < length; i++) {
//
//            for (int left = i; left >= i - back; left--) {
//                sb.append(s.charAt(left));
//                System.out.println("reversed: " + sb);
//            }
//            //fixme
//            sb.append(s, i+1, i= Math.min(i + (2 * k)-1,length));
//            System.out.println("added   : " + sb);
//    }


        return sb.toString();
    }

    /**
     * credits to: deepVashisth
     */
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        int    n   = str.length;
        for (int i = 0; i <= n - 1; i += 2 * k) {
            if (i + k - 1 <= n - 1) {
                reverseK(i, i + k - 1, str);
            } else {
                //for fewer than k characters left (edge case)
                reverseK(i, n - 1, str);
            }
        }
        String ans = new String(str);
        return ans;
    }

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
