package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

class N0167_TwoSum2InputArrayIsSortedTest {
    TUtils utils = new TUtils();
    
    @ParameterizedTest
    @CsvSource(value = {
            " 9,  2|7|11|15, 1|2",
            " 6,  2|3|4,     1|3",
            "-1, -1|0,      1|2"
    })
    void twoSum(int target, String numbers, String expected) throws InvocationTargetException, IllegalAccessException {
        N0167_TwoSum2InputArrayIsSorted obj = new N0167_TwoSum2InputArrayIsSorted();
        
        int[] inputs = utils.StringToIntArray(numbers, "\\|");
        int[] expectedArray = utils.StringToIntArray(expected, "\\|");
        
        Method[] methods = N0167_TwoSum2InputArrayIsSorted.class.getDeclaredMethods();
        
        for (Method method : methods) {
            if (method.getName().startsWith("twoSum")) {
                int[] actuals = (int[]) method.invoke(obj, inputs, target);
                String message = "\nmethod: " + method.getName() +
                                 "\nexp: %s \nact: %s \n".formatted(Arrays.toString(expectedArray), Arrays.toString(actuals));
                Assertions.assertArrayEquals(expectedArray, actuals, message);
            }
        }
    }
}