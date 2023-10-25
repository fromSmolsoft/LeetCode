package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0151_ReverseWordsInStringTest {


    N0151_ReverseWordsInString obj = new N0151_ReverseWordsInString();

    /**
     * <pre>
     *  Example 1:
     *  Input: s = "the sky is blue"
     *  Output: "blue is sky the"
     *
     *  Example 2:
     *  Input: s = "  hello world  "
     *  Output: "world hello"
     *  Explanation: Your reversed string should not contain leading or trailing spaces.
     *
     *  Example 3:
     *  Input: s = "a good   example"
     *  Output: "example good a"
     *  Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
     *
     *  Constraints:
     *      1 <= s.length <= 104
     *      s contains English letters (upper-case and lower-case), digits, and spaces ' '.
     *      There is at least one word in s.
     */
    @ParameterizedTest
    @CsvSource(value = {
            "'blue is sky the', 'the sky is blue'",
            "'world hello',     '  hello world  '",
            "'example good a',  'a good   example'"
    })
    void reverseWords(String exp, String s) {
        String act;
        act = obj.reverseWordsNoSplit(s);
        Assertions.assertEquals(exp, act, " No `split()` & `trim()`");

        act = obj.reverseWordsLib(s);
        Assertions.assertEquals(exp, act, "Java Util libs");

        act = obj.reverseWordsNoLibs(s);
        Assertions.assertEquals(exp, act, "No libs");
    }
}