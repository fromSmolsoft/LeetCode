package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

class N0150_EvaluateReversePolishNotationTest {

    private N0150_EvaluateReversePolishNotation obj;

    @BeforeEach
    void setUp() {
        obj = new N0150_EvaluateReversePolishNotation();
    }

    /**
     * <pre>
     * Example 1:
     * Input: tokens = ["2","1","+","3","*"]
     * Output: 9
     * Explanation: ((2 + 1) * 3) = 9
     *
     * Example 2:
     * Input: tokens = ["4","13","5","/","+"]
     * Output: 6
     * Explanation: (4 + (13 / 5)) = 6
     *
     * Example 3:
     * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
     * Output: 22
     * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
     * = ((10 * (6 / (12 * -11))) + 17) + 5
     * = ((10 * (6 / -132)) + 17) + 5
     * = ((10 * 0) + 17) + 5
     * = (0 + 17) + 5
     * = 17 + 5
     * = 22
     *
     * Constraints:
     *     1 <= tokens.length <= 104
     *     tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "9;     2,1,+,3,*",
            "6;     4,13,5,/,+",
            "22;    10,6,9,3,+,-11,*,/,*,17,+,5,+",
            "0;     10,5,-,-5,+"
    })
    void evalRPN(int expected, String sTokens) throws InvocationTargetException, IllegalAccessException {
        String[] tokens = TestUtils.StringToStringArray(sTokens, ",");

        Method[] methods = obj.getClass().getMethods();
        for (Method m : methods) {
            if (m.getName().contains("evalRPN")) {
                int actual = (int) m.invoke(obj, (Object) tokens);
                Assertions.assertEquals(expected, actual, "\nmethod:" + m.getName() + "\ntokens:" + Arrays.toString(tokens));
            }
        }

    }
}