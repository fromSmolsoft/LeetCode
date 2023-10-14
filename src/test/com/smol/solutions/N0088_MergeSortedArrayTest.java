package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class N0088_MergeSortedArrayTest {

    private final TestUtils utils = new TestUtils();

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            /*
            exp;            num1;           m;  num2;   n;    */
            "1,2;           2,0;            1;  1;      1",
            "1,2,2,3,5,6;   1,2,3,0,0,0;    3;  2,5,6;  3",
            "1;             1;              1;  '';     0",
            "1;             0;              0;  1;      1",

    })
    void merge(String exp, String numbers1, int m, String numbers2, int n) {
        //transform String params into arrays;
        int[] expected = utils.StringToIntArray(exp, ",");
        int[] nums1    = utils.StringToIntArray(numbers1, ",");
        int[] nums2    = utils.StringToIntArray(numbers2, ",");
        int[] actual   = Arrays.copyOf(nums1, m + n);

        N0088_MergeSortedArray obj = new N0088_MergeSortedArray();
        obj.merge(actual, m, nums2, n);

        System.out.println("n1  " + Arrays.toString(nums1));
        System.out.println("n2  " + Arrays.toString(nums2));
        System.out.println("exp " + Arrays.toString(expected));
        System.out.println("act " + Arrays.toString(actual));


        Assertions.assertArrayEquals(expected, actual);


    }
}