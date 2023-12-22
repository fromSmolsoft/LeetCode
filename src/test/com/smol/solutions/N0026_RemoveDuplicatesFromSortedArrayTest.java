package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

class N0026_RemoveDuplicatesFromSortedArrayTest {

  private final N0026_RemoveDuplicatesFromSortedArray obj     = new N0026_RemoveDuplicatesFromSortedArray();
  private final Method[]                              methods = N0026_RemoveDuplicatesFromSortedArray.class.getDeclaredMethods();

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            /*exp1;     exp2;               input; */
            "2;         1,2,;               1,1,2;",
            "5;         0,1,2,3,4,,,,,;     0,0,1,1,1,2,2,3,3,4;"
    })
    void removeDuplicates(int exp1, String exp2, String input) throws InvocationTargetException, IllegalAccessException {
        int[] nums         = TUtils.StringToIntArray(input, ",");
        int[] expectedNums = TUtils.StringToIntArray(exp2, ",");
        int[] numsTemp     = Arrays.copyOf(nums, nums.length);

        for (Method m : methods) {
            iterateArray(m, exp1, nums, expectedNums);
            nums = Arrays.copyOf(numsTemp, numsTemp.length);
        }
    }

    private void iterateArray(Method m, int exp1, int[] nums, int[] expectedNums) throws InvocationTargetException, IllegalAccessException {
        int actual = (int) m.invoke(obj, (Object) nums);
        Assertions.assertEquals(exp1, actual);
        for (int i = 0; i < exp1; i++) {
            Assertions.assertEquals(expectedNums[i], nums[i], m.getName());
        }
    }
}