package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0122_BestTimeToBuyAndSellStockIITest {
    
    private final N0122_BestTimeToBuyAndSellStockII obj = new N0122_BestTimeToBuyAndSellStockII();
    
    /**
     * <pre>
     * Example 1:
     * Input: prices = [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     * Total profit is 4 + 3 = 7.
     *
     * Example 2:
     * Input: prices = [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     * Total profit is 4.
     *
     * Example 3:
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
     *
     * Constraints:
     *     1 <= prices.length <= 3 * 104
     *     0 <= prices[i] <= 104
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "7; 7,1,5,3,6,4",
            "4; 1,2,3,4,5",
            "0; 7,6,4,3,1"
    })
    void maxProfit(int exp, String sInp) {
        int[] prices = TUtils.StringToIntArray(sInp, ",");
        int actual;
        
        actual = obj.maxProfit(prices);
        Assertions.assertEquals(exp, actual, "00");
        
        actual = obj.maxProfit02(prices);
        Assertions.assertEquals(exp, actual, "02");
        
        actual = obj.maxProfit03(prices);
        Assertions.assertEquals(exp, actual, "03");
    }
}