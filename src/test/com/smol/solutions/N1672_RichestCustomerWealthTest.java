package com.smol.solutions;


import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N1672_RichestCustomerWealthTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1;2;3, 3;2;1, 6",
    })
    void maximumWealth(String input1, String input2, int expected) {
        N1672_RichestCustomerWealth obj   = new N1672_RichestCustomerWealth();
        TUtils utils = new TUtils();
        //todo make it work with j>2 in array [i][j]
        int[]                       nums1 = utils.StringToIntArray(input1, ";");
        int[]                       nums2 = utils.StringToIntArray(input2, ";");
        int[][]                     nums  = new int[][]{nums1, nums2};
        assertEquals(obj.maximumWealth(nums), expected);
    }
}