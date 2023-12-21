package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0135_CandyTest {

    private N0135_Candy obj   = new N0135_Candy();
    private TUtils utils = new TUtils();

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            " 5; 1,0,2",
            " 4; 1,2,2",
            " 8; 1,0,2,0,0,0",
            "10; 1,0,2,0,0,0,9",
            "12; 0,1,0,2,0,0,0,9,0",
            "13; 1,2,87,87,87,2,1",
            "15; 1,2,3,4,5"

    })
    void candy(int exp, String sRatings) {
        int[] ratings = utils.StringToIntArray(sRatings, ",");
        int   act;
        act = obj.candy(ratings);
        Assertions.assertEquals(exp, act);

        act = obj.candy2Ways(ratings);
        Assertions.assertEquals(exp, act);

    }
}