package com.smol.solutions;

/**
 * <h1>1420. Build Array Where You Can Find The Maximum Exactly K Comparisons</h1>
 * Hard
 * <p>
 * You are given three integers n, m and k. Consider the following algorithm to find the maximum element of an array of positive integers:
 * <pre>
 *  {@code
 *      maximum_value = -1
 *      maximum_index = -1
 *      search_cost = 0
 *      n = arr.length
 *
 *      for (i=0; i < n; i++) {
 *          if (maximum_value < arr[i]) {
 *              maximum_value = arr[i]
 *              maximum_index = i
 *              search_cost = search_cost + 1
 *          }
 *      }
 *      return maximum_index
 *   }
 * </pre>
 * <pre>
 * You should build the array arr which has the following properties:
 *  - arr has exactly n integers.
 *  - 1 <= arr[i] <= m where (0 <= i < n).
 *  - After applying the mentioned algorithm to arr, the value search_cost is equal to k.
 * </pre>
 * Return the number of ways to build the array arr under the mentioned conditions. As the answer may grow large, the answer must be computed modulo 109 + 7.
 * <pre>
 *
 * Example 1:
 * Input: n = 2, m = 3, k = 1
 * Output: 6
 * Explanation: The possible arrays are [1, 1], [2, 1], [2, 2], [3, 1], [3, 2] [3, 3]
 *
 * Example 2:
 * Input: n = 5, m = 2, k = 3
 * Output: 0
 * Explanation: There are no possible arrays that satisify the mentioned conditions.
 *
 * Example 3:
 * Input: n = 9, m = 1, k = 1
 * Output: 1
 * Explanation: The only possible array is [1, 1, 1, 1, 1, 1, 1, 1, 1]
 *
 * Constraints:
 *     1 <= n <= 50
 *     1 <= m <= 100
 *     0 <= k <= n
 * </pre>
 */
public class N1420_ArrayMaximumExactlyKComparisons {

    /**
     * The problem can be tackled with dynamic programming, where we try to build the solution incrementally. We can break down the problem into sub-problems where we consider smaller arrays and try to determine the number of valid arrays we can form given a certain cost and maximum value.
     * <pre>
     * We use the following states:
     * - i: the length of the array.
     * - maxNum: the maximum number in the array.
     * - cost: the cost of the array.
     * </pre>
     * We define dp[i][maxNum][cost] as the number of arrays of length i with a maximum value of maxNum and a cost of cost. To compute this, we consider two cases:
     * <p>
     * - The last number added to the array isn't a new maximum. In this case, it can be any number from 1 to maxNum, and the cost remains unchanged.
     * <p>
     * - The last number added is a new maximum. Here, the previous maximum could be any number from 1 to maxNum - 1, and the cost decreases by 1 since we've added a new maximum.
     * <p>
     * <p>
     * <p>
     * However, summing over possible maximums for each state would be inefficient. To accelerate this, we introduce a prefix sum array that keeps track of the sum of valid arrays for a given cost up to the current maximum.
     * <p>
     * <p>
     * <p>
     * Complexity   <p>
     * - Time complexity: O(n×m×k)O(n \times m \times k)O(n×m×k) <p>
     * The main loop iterates n times. For each iteration, we consider m possible maximum values and k possible costs, making the time complexity cubic.
     * <p>
     * - Space complexity: O(m×k)O(m \times k)O(m×k) <p>
     * We use two 2D arrays, dp and prefix, each of size m×km \times km×k, and two other arrays, prevDp and prevPrefix, for storing the previous state. Hence, the space complexity is quadratic.
     * @author vanAmsen  @ <a href="https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/solutions/4139874/90-27-dynamic-programming-optimized/?envType=daily-question&envId=2023-10-07">leetcode.com/...</a>
     */
    public int numOfArrays(int n, int m, int k) {
        final int mod = 1000000007;

        int[][] dp         = new int[m + 1][k + 1];
        int[][] prefix     = new int[m + 1][k + 1];
        int[][] prevDp     = new int[m + 1][k + 1];
        int[][] prevPrefix = new int[m + 1][k + 1];

        for (int j = 1; j <= m; j++) {
            prevDp[j][1] = 1;
            prevPrefix[j][1] = j;
        }

        for (int i = 2; i <= n; i++) {
            for (int maxNum = 1; maxNum <= m; maxNum++) {
                for (int cost = 1; cost <= k; cost++) {
                    dp[maxNum][cost] = (int) (((long) maxNum * prevDp[maxNum][cost]) % mod);

                    if (maxNum > 1 && cost > 1) {
                        dp[maxNum][cost] = (dp[maxNum][cost] + prevPrefix[maxNum - 1][cost - 1]) % mod;
                    }

                    prefix[maxNum][cost] = (prefix[maxNum - 1][cost] + dp[maxNum][cost]) % mod;
                }
            }

            for (int j = 1; j <= m; j++) {
                System.arraycopy(dp[j], 0, prevDp[j], 0, k + 1);
                System.arraycopy(prefix[j], 0, prevPrefix[j], 0, k + 1);
            }
        }

        return prefix[m][k];
    }

}
