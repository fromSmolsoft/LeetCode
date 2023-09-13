package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Method;
import java.util.Arrays;

class N0001_two_sumTest {

    @ParameterizedTest
    @CsvSource(value = {
            "2;7;11;15, 9, 0;1",
            "3;2;4, 6, 1;2",
            "3;3, 6, 0;1"
    })
    void test(String inputArray, int targetInt, String expectedArray) throws Exception {

        String[] inputs          = inputArray.split(";");
        int[]    nums            = Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();
        String[] expected        = expectedArray.split(";");
        int[]    expectedNumbers = Arrays.stream(expected).mapToInt(Integer::parseInt).toArray();

//        assertEquals(Arrays.toString(expectedNumbers), Arrays.toString(new N0001_two_sum().twoSum(nums, targetInt)));

        N0001_two_sum obj = new N0001_two_sum();

        //testing all the alternative methods by using Java Reflections
        Method[] methods = N0001_two_sum.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("twoSum")) {
                System.out.printf("method: " + method.getName());
                int[] actuals = (int[]) method.invoke(obj, nums, targetInt);
                System.out.printf("->expected: %s, actual: %s\n",Arrays.toString(expectedNumbers), Arrays.toString(actuals));
                Assertions.assertArrayEquals(expectedNumbers, actuals);
            }
        }
    }
}