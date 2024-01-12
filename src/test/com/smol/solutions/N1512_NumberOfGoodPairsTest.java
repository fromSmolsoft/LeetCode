package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N1512_NumberOfGoodPairsTest {

    private final N1512_NumberOfGoodPairs obj   = new N1512_NumberOfGoodPairs();

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {

            /*exp   input*/
            "4;     1,2,3,1,1,3",
            "6;     1,1,1,1",
            "0;     1,2,3"
    })
    void numIdenticalPairs(int exp, String inp) {
        int[] input  = TUtils.StringToIntArray(inp, ",");

        int   actual = obj.numIdenticalPairs(input);
        Assertions.assertEquals(exp, actual);

        int actual2 = obj.numIdenticalPairs01(input);
        Assertions.assertEquals(exp, actual2);

    }
}