package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0121_BestTimeToBuySellStockTest {

    TestUtils                    utils = new TestUtils();
    N0121_BestTimeToBuySellStock obj   = new N0121_BestTimeToBuySellStock();

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "5; 7,1,5,3,6,4",
            "0; 7,6,4,3,1",
            "98; 7,1,5,1,6,4,99",
            "0; 1",
            "1; 9,2,1,1,2"

    })
    void maxProfit(int exp, String inp) {
        int[] prices = utils.StringToIntArray(inp, ",");
        int   actual;

        actual = obj.maxProfit02(prices);
        Assertions.assertEquals(exp, actual);

        actual = obj.maxProfit(prices);
        Assertions.assertEquals(exp, actual);
    }
}