package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0169_MajorityElementTest {

    final N0169_MajorityElement obj   = new N0169_MajorityElement();

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            /*exp nums*/
            "3; 3,2,3",
            "2; 2,2,1,1,1,2,2",
    })
    void majorityElement(int exp, String sNums) {

        int [] nums = TUtils.StringToIntArray(sNums, ",");
        int actual = obj.majorityElement(nums);
        Assertions.assertEquals(exp, actual);

    }
}