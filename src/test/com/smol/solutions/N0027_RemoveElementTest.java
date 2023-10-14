package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static java.util.Arrays.sort;

class N0027_RemoveElementTest {

    TestUtils           utils = new TestUtils();
    N0027_RemoveElement obj   = new N0027_RemoveElement();

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {

            /*exp;  expNums;        nums;               val*/
            "2;     2,2,,;          3,2,2,3;            3",
            "5;     0,1,4,0,3,,,;   0,1,2,2,3,0,4,2;    2",
            "0;     ,;              1;                  1",
            "0;     ;                ;                  0",
            "0;     ;               3,3;                3",
            "1;     2;              2;                  3",
            "1;     5;              4,5;                4"
    })
    void removeElement(int exp, String seNums, String sNums, int val) {

        int[] nums    = utils.StringToIntArray(sNums, ",");
        int[] expNums = utils.StringToIntArray(seNums, ",");

        int actual = obj.removeElement(nums, val);

        System.out.println("exp " + Arrays.toString(expNums));
        System.out.println("act " + Arrays.toString(nums));
        System.out.println("exp " + exp);
        System.out.println("act " + actual);


        Assertions.assertEquals(exp, actual, "length");
        sort(nums, 0, actual);
        sort(expNums, 0, exp);
        for (int i = 0; i < actual; i++) {
            Assertions.assertEquals(expNums[i], nums[i], "nums[" + i + "]");
        }
    }
}