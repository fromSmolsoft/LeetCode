package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0977_SquaresOfSortedArrayTest {


    final N0977_SquaresOfSortedArray obj   = new N0977_SquaresOfSortedArray();

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "0,1,9,16,100;  -4,-1,0,3,10",
            "4,9,9,49,121; -7,-3,2,3,11"
    })
    void sortedSquares(String exp, String nums) {
        int[] expected = TUtils.StringToIntArray(exp, ",");
        int[] numbers  = TUtils.StringToIntArray(nums, ",");
        int[] actual;


        actual = obj.sortedSquares(numbers);
        Assertions.assertArrayEquals(expected, actual);

        actual = obj.sortedSquares01(numbers);
        Assertions.assertArrayEquals(expected, actual);
    }
}