package com.smol.solutions;

/**
 * <h1>122. Best Time to Buy and Sell Stock II</h1>
 * Medium   <p>
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.  <p>
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.    <p>
 * Find and return the maximum profit you can achieve.
 *
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
public class N0122_BestTimeToBuyAndSellStockII {

    /**
     * Logic: <p>
     * sum of all differences between all low and high where low comes before high
     *
     * <pre>
     * Runtime 1ms,     Beats 85.06%of users with Java
     * Memory 44.69MB,  Beats 19.50%of users with Java
     * </pre>
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }


    public int maxProfit02(int[] prices) {
        // It is impossible to sell stock on first day, set -infinity as initial value for cur_hold
        int hold = -Integer.MAX_VALUE, notHold = 0;
        for (int stockPrice : prices) {
            int prevHold = hold, prevNotHold = notHold;
            // either keep hold, or buy in stock today at stock price
            hold = Math.max(prevHold, prevNotHold - stockPrice);
            // either keep not-hold, or sell out stock today at stock price
            notHold = Math.max(prevNotHold, prevHold + stockPrice);
        }
        // maximum profit must be in not-hold state
        return notHold;
    }


    public int maxProfit03(int[] prices) {
        int[] res = trade(prices.length - 1, prices);
        return res[1];
    }

    public int[] trade(int day, int[] prices) {

        if (day == 0) {
            // first element: buy on day_#0
            // second element: do nothing on day_#0
            int[] res = {-prices[0], 0};
            return res;
        }

        int[] prev     = trade(day - 1, prices);
        int   prevHold = prev[0], prevNotHold = prev[1];

        int hold    = Math.max(prevHold, prevNotHold - prices[day]);
        int notHold = Math.max(prevNotHold, prevHold + prices[day]);

        int[] res = {hold, notHold};
        return res;
    }
}
