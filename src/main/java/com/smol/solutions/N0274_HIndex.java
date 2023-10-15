package com.smol.solutions;

import java.util.Arrays;

/**
 * <h1>274. H-Index</h1>
 * Medium
 * <p>
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 *
 *
 * <pre>
 * Example 1:
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 *
 * Example 2:
 * Input: citations = [1,3,1]
 * Output: 1
 *
 * Constraints:
 *     n == citations.length
 *     1 <= n <= 5000
 *     0 <= citations[i] <= 1000
 * </pre>
 */
public class N0274_HIndex {


    /**
     * <h1>Count sort</h1>
     * <pre>
     * - count elements higher than length of the input array altogether
     * - count rest separately
     * - iterate counts from highest index to lowest `i>=0; i--` and sum each count until index equals sum of counts.
     * - return index as result
     *
     * Runtime 0ms, Beats 100.00%
     * Memory 40.04MB Beats 85.73%
     * </pre>
     */
    public int hIndex(int[] citations) {
        int   l      = citations.length;
        int[] counts = new int[l + 1];

        for (int c : citations) {
            if (c > l) counts[l]++; // count elements >  arr length altogether
            else counts[c]++;       // count elements < arr length separately
        }

        int count = 0;
        for (int i = l; i >= 0; i--) {
            count += counts[i];
            if (count >= i) return i;
        }
        return 0;
    }


    /**
     * <h1>Brute force- sort first </h1>
     * <pre>
     * Slow
     * Runtime 3ms,     Beats 18.37%
     * Memory 40.39MB,  Beats 49.75%
     * </pre>
     */
    public int hIndex01(int[] citations) {
        if (citations.length == 1) return citations[0] == 0 ? 0 : 1;

        int h = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] <= (citations.length) - i && citations[i] > h) h = citations[i];
            else if (citations.length - i < citations[i] && citations.length - i > h) h = citations.length - i;
        }
        return h;
    }


}
