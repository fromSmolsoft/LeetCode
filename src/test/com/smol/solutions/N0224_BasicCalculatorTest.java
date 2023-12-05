package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class N0224_BasicCalculatorTest {

    private N0224_BasicCalculator obj;

    @BeforeEach
    void setUp() {
        obj = new N0224_BasicCalculator();
    }

    /**
     * <pre>
     * Example 1:
     * Input: s = "1 + 1"
     * Output: 2
     *
     * Example 2:
     * Input: s = " 2-1 + 2 "
     * Output: 3
     *
     * Example 3:
     * Input: s = "(1+(4+5+2)-3)+(6+8)"
     * Output: 23
     *
     * Constraints:
     *     1 <= s.length <= 3 * 105
     *     s consists of digits, '+', '-', '(', ')', and ' '.
     *     s represents a valid expression.
     *     '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
     *     '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
     *     There will be no two consecutive operators in the input.
     *     Every number and running calculation will fit in a signed 32-bit integer.
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(value = {
            " 2,    '1 + 1'",
            " 3,    ' 2-1 + 2 '",
            "23,    '(1+(4+5+2)-3)+(6+8)'"
    })
    void calculate(int expected, String s) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = obj.getClass().getMethods();
        for (Method m : methods) {
            if (m.getName().contains("calculate")) {
                Assertions.assertEquals(expected,
                        (int) m.invoke(obj, s),
                        "\nmethod: " + m.getName() +
                        "\n\"" + s + "\"");
            }
        }
    }
}