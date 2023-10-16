package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class N0134_GasStationTest {


    TestUtils        utils = new TestUtils();
    N0134_GasStation obj   = new N0134_GasStation();


    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            /*exp   gas         cost*/
            " 3;    1,2,3,4,5;  3,4,5,1,2",
            "-1;    2,3,4;      3,4,3",
            " 4;    0,0,0,0,5;  1,1,1,1,1",
            " 4;    5,1,2,3,4;  4,4,1,5,1",
            " 2;    6,1,4,3,5;  3,8,2,4,2",
            " 0;    3,1,1;      1,2,2"
    })
    void canCompleteCircuit(int exp, String sGas, String sCost) {

        int[] gas  = utils.StringToIntArray(sGas, ",");
        int[] cost = utils.StringToIntArray(sCost, ",");
        int   act  = obj.canCompleteCircuit(gas, cost);

        String message =
                "\ngas :" + Arrays.toString(gas) +
                "\ncost:" + Arrays.toString(cost);
        Assertions.assertEquals(exp, act, message);
    }
}