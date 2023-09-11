package com.smol.solutions;

/**
 * <h1>2810. Faulty Keyboard</h1>
 * Easy<p>
 * Your laptop keyboard is faulty, and whenever you type a character 'i' on it, it reverses the string that you have written. Typing other characters works as expected. <p>
 * You are given a 0-indexed string s, and you type each character of s using your faulty keyboard. <p>
 * Return the final string that will be present on your laptop screen. <p>
 * <p>
 * Example 1: <p>
 * Input: s = "string"<p>
 * Output: "rtsng"<p>
 * Explanation:<p>
 * After typing first character, the text on the screen is "s".<p>
 * After the second character, the text is "st".<p>
 * After the third character, the text is "str".<p>
 * Since the fourth character is an 'i', the text gets reversed and becomes "rts".<p>
 * After the fifth character, the text is "rtsn".<p>
 * After the sixth character, the text is "rtsng".<p>
 * Therefore, we return "rtsng".<p>
 * <p>
 * Example 2: <p>
 * Input: s = "poiinter" <p>
 * Output: "ponter" <p> *
 * Explanation: <p>
 * After the first character, the text on the screen is "p".<p>
 * After the second character, the text is "po".<p>
 * Since the third character you type is an 'i', the text gets reversed and becomes "op".<p>
 * Since the fourth character you type is an 'i', the text gets reversed and becomes "po".<p>
 * After the fifth character, the text is "pon".<p>
 * After the sixth character, the text is "pont".<p>
 * After the seventh character, the text is "ponte".<p>
 * After the eighth character, the text is "ponter".<p>
 * Therefore, we return "ponter".<p>
 * <p>
 * Constraints:  <p>
 * 1 <= s.length <= 100 <p>
 * s consists of lowercase English letters. <p>
 * s[0] != 'i' <p>
 */
public class N2810_FaultyKeyboard {

    /**
     * Runtime 3ms, Beats 97.58%of users with Java<p>
     * Memory 43.68MB, Beats 77.01%of users with Java<p>
     */
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        int           l  = s.length();
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if (c != 'i') sb.append(c);
            else sb.reverse();
        }
        return sb.toString();
    }

}
