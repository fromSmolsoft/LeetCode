package com.smol.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>68. Text Justification</h1>
 * Hard <p>
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 * <p>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * <p>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * <p>
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 * <p>
 * Note:    <p>
 * - A word is defined as a character sequence consisting of non-space characters only.   <p>
 * - Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.   <p>
 * - The input array words contains at least one word.    <p>
 *
 * <pre>
 * Example 1:
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 * Example 2:
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation:
 * Note that the last line is "shall be    " instead of "shall     be",
 * because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified because it contains only one word.
 *
 * Example 3:
 * Input: words = ["Science","is","what","we","understand","well",
 *                  "enough","to","explain","to","a","computer.",
 *                  "Art","is","everything","else","we","do"],
 *       maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 * Constraints:
 *     1 <= words.length <= 300
 *     1 <= words[i].length <= 20
 *     words[i] consists of only English letters and symbols.
 *     1 <= maxWidth <= 100
 *     words[i].length <= maxWidth
 * </pre>
 */
public class N0068_TextJustification {

    public List<String> fullJustify02(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<String>();
        int          index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last  = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) break;
                //plus one for the space, if its a perfect fit it will fit
                count += 1 + words[last].length();
                last++;
            }
            StringBuilder builder = new StringBuilder();
            builder.append(words[index]);
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = index + 1; i < last; i++) {
                    builder.append(" ");
                    builder.append(words[i]);
                }
                for (int i = builder.length(); i < maxWidth; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (maxWidth - count) / diff;
                int r      = (maxWidth - count) % diff;
                for (int i = index + 1; i < last; i++) {
                    for (int k = spaces; k > 0; k--) {
                        builder.append(" ");
                    }
                    if (r > 0) {
                        builder.append(" ");
                        r--;
                    }
                    builder.append(" ");
                    builder.append(words[i]);
                }
            }
            lines.add(builder.toString());
            index = last;
        }
        return lines;
    }

    public List<String> fullJustify03(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int          i   = 0;
        while (i < words.length) {
            int width = 0, I = i;
            while (I < words.length && width + words[I].length() + (I - i) <= maxWidth)
                width += words[I++].length();
            int space = 1, extra = 0;
            if (I - i != 1 && I != words.length) {
                space = (maxWidth - width) / (I - i - 1);
                extra = (maxWidth - width) % (I - i - 1);
            }
            StringBuilder line = new StringBuilder(words[i++]);
            while (i < I) {
                for (int s = space; s > 0; s--) line.append(" ");
                if (extra-- > 0) line.append(" ");
                line.append(words[i++]);
            }
            for (int s = maxWidth - line.length(); s > 0; s--) line.append(" ");
            res.add(line.toString());
        }
        return res;
    }

}
