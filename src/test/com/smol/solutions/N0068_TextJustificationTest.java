package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

class N0068_TextJustificationTest {

    private TUtils utils   = new TUtils();
    private N0068_TextJustification obj     = new N0068_TextJustification();
    private Method[]                methods = obj.getClass().getDeclaredMethods();

    private static String generateMessage(int maxWidth, String[] words, List<String> exp, List<String> act) {
        StringBuilder messagePrint = new StringBuilder();

        char   q = '"';
        String d = ", ";

        messagePrint.append("\nwidth : ").append(maxWidth);

        messagePrint.append("\nwords : ");
        for (String w : words) messagePrint.append(q).append(w).append(q).append(d);

        messagePrint.append("\nexpect: ");
        for (String w : exp) messagePrint.append(q).append(w).append(q).append(d);

        messagePrint.append("\nactual: ");
        for (String w : act) messagePrint.append(q).append(w).append(q).append(d);

        messagePrint.append("\n");
        return messagePrint.toString();
    }

    /**
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
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {

            /*1*/ "'This    is    an', 'example  of text', 'justification.  '; 16; This,is,an,example,of,text,justification.; ",
            /*2*/ "'What   must   be','acknowledgment  ','shall be        '; 16; What,must,be,acknowledgment,shall,be",
            /*3*/ "'Science  is  what we','understand      well','enough to explain to','a  computer.  Art is','everything  else  we','do                  '; 20; " +
                  "Science,is,what,we,understand,well,enough,to,explain,to,a,computer.,Art,is,everything,else,we,do,  "

    })
    void fullJustify(String sExp, int maxWidth, String sWords) throws InvocationTargetException, IllegalAccessException {
        String[]     words = utils.StringToStringArray(sWords, ",");
        List<String> exp   = utils.StringToStringList(sExp, ",", 1);
        List<String> act;


        for (Method m : methods) {

            String methodName = m.getName();
            if (methodName.startsWith("fullJustify")) {
                act = (List<String>) m.invoke(obj, words, maxWidth);
                Assertions.assertIterableEquals(exp, act, "\ntested method: " +methodName +  generateMessage(maxWidth, words, exp, act));
            }

        }


//        act = obj.fullJustify02(words, maxWidth);
//        Assertions.assertIterableEquals(exp, act, "02\n" + generateMessage(maxWidth, words, exp, act));
    }
}