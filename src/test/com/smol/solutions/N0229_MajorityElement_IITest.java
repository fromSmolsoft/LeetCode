package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

class N0229_MajorityElement_IITest {

    TestUtils                utils   = new TestUtils();
    N0229_MajorityElement_II obj     = new N0229_MajorityElement_II();
    Method[]                 methods = N0229_MajorityElement_II.class.getDeclaredMethods();

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            /*exp   nums    */
            "2;     2,2",
            "3;     3,2,3",
            "1;     1",
            "1,2;   1,2",
            "2,4;   2,2,2,4,4,4",
            "7;     3,2,3,9,7,7,7,7,7,9",
            " ;     1,2,3,4,5,6,7,8,9,10",
            " ;      "
    })
    void majorityElement(String exp, String input) throws InvocationTargetException, IllegalAccessException {
        int[] nums = utils.StringToIntArray(input, ",");

        List<Integer> expected = utils.StringToIntList(exp, ",");
        List<Integer> actual;

        for (Method m : methods) {
            String name = m.getName();

            if (name.startsWith("majorityElement")) {
                actual = (List<Integer>) m.invoke(obj, nums);
                Assertions.assertIterableEquals(expected, actual, "\n" + name + "(...) ");
            }
        }

    }
}