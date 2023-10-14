package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0045_JumpGameIITest {

    TestUtils        utils = new TestUtils();
    N0045_JumpGameII obj   = new N0045_JumpGameII();

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "2;  2,3,1,1,4",
            "2;  2,3,0,1,4",
            "2;  2,1,6,1,4",
            "2;  3,2,2,0,4",
            "2;  2,3,1,8,4",
            "0; 0",
            "2; 3,0,8,2,0,0,1",
            "2; 7,0,9,6,9,6,1,7,9,0,1,2,9,0,3",
    })
    void jump(int exp, String sIpn) {
        int[] nums = utils.StringToIntArray(sIpn, ",");
        int   act  = obj.jump(nums);
        Assertions.assertEquals(exp, act);

    }
}