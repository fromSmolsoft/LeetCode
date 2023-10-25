package com.smol.solutions;

/**
 * <h1>135. Candy</h1>
 * Hard <p>
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings. <p>
 * You are giving candies to these children subjected to the following requirements: <p>
 * - Each child must have at least one candy.   <p>
 * - Children with a higher rating get more candies than their neighbors.   <p>
 * <p>
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 * <pre>
 * Example 1:
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 *
 * Example 2:
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 *
 * Constraints:
 *     n == ratings.length
 *     1 <= n <= 2 * 104
 *     0 <= ratings[i] <= 2 * 104
 * </pre>
 */
public class N0135_Candy {


    /**
     * <h1>Greedy, One pass</h1>
     * <pre>
     * Runtime 3ms, Beats 78.05%
     * Memory 43.68MB, Beats 55.99%
     * </pre>
     */
    public int candy(int[] ratings) {
        int n = ratings.length;

        int candySum = 1;
        int up       = 0, down = 0; //bonus candy for kids with neighbors with lower rating
        int peak     = 0;     //peak candy bonus / rating to lower bonus candy

        for (int i = 0; i < n - 1; i++) {
            int previous = ratings[i];
            int current  = ratings[i + 1];

            if (previous < current) {
                up++;
                down = 0;
                peak = up;
                candySum += up + 1;
            } else if (previous == current) {
                up = down = peak = 0;
                candySum++;
            } else {
                up = 0;
                down++;
                candySum += down + 1;
                if (peak >= down) candySum--;
            }
        }
        return candySum;
    }


    /**
     * <h1>Greedy, Two ways iterations</h1>
     * <pre>
     * Runtime 3ms, Beats 78.05%
     * Memory 43.06MB, Beats 99.17%
     * </pre>
     */
    public int candy2Ways(int[] ratings) {
        int   n       = ratings.length;
        int[] candies = new int[n];

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
        }

        for (int j = n - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1]) candies[j] = Math.max(candies[j], candies[j + 1] + 1);
        }

        int candySum = n;
        for (int candy : candies) candySum += candy;
        return candySum;
    }
}
