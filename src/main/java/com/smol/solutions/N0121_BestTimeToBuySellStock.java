package com.smol.solutions;

/**
 * <h1>121. Best Time to Buy and Sell Stock</h1>
 * Easy
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * <pre>
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 * Constraints:
 *     1 <= prices.length <= 105
 *     0 <= prices[i] <= 104
 * </pre>
 */
public class N0121_BestTimeToBuySellStock {


    /**
     * Optimized solution
     * <pre>
     * Logic
     * for each iteration:
     * 1. compare prices[i] with best buying price so far
     * 2. save lowest of the two new best buying price
     * 3. compare possible profit with max profit achieved so far
     * 4. save highest of the two as new max profit
     *
     * Runtime 1ms,     Beats 99.95%of users with Java
     * Memory 60.75MB,  Beats 70.88%of users with Java
     * </pre>
     */
    public int maxProfit(int[] prices) {
        int bestBuy   = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            bestBuy = Math.min(bestBuy, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - bestBuy);
        }
        return maxProfit;
    }

    /**
     * Readable solution
     * <pre>
     * Runtime 2ms,     Beats 75.57%of users with Java
     * Memory 61.12MB,  Beats 29.06%of users with Java
     * </pre>
     */
    public int maxProfit02(int[] prices) {
        int bestBuy   = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < bestBuy) bestBuy = prices[i];
            int profit = prices[i] - bestBuy;
            if (maxProfit < profit) maxProfit = profit;
        }
        return maxProfit;
    }


}
