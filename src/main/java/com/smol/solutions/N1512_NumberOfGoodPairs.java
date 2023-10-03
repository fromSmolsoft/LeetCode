package com.smol.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>1512. Number of Good Pairs</h1>
 */
public class N1512_NumberOfGoodPairs {

    /**
     * <pre>
     * Logic:
     * - find all duplicates
     * - calculate pairs from num of duplicates
     * -
     * example 1,1,1,1  ->  pairs= 4-1 + 3-1 + 2-1
     *
     *
     * Runtime 1ms,     Beats 86.48%of users with Java
     * Memory 39.96MB,  Beats 34.90%of users with Java
     * </pre>
     */
    public int numIdenticalPairs(int[] nums) {
        int                   pairs = 0;
        Map<Integer, Integer> seen  = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (seen.containsKey(nums[i])) {
                seen.put(nums[i], 1 + seen.get(nums[i]));
            } else seen.put(nums[i], 1);
        }

        for (Integer n : seen.values()) {
            if (n > 1) {
                while (n > 1) pairs += (--n);
            }
        }
        return pairs;
    }

    /**
     * First we can count the frequency of each number using array. If a number appears n times, then n * (n – 1) / 2 pairs can be made with this number.
     * @author hardik_ahir <a href="https://leetcode.com/problems/number-of-good-pairs/solutions/733540/java-100-faster-100-space-easy-solution/?envType=daily-question&envId=2023-10-03">leetcode.com/hardik_ahir</a>
     */
    public int numIdenticalPairs01(int[] nums) {

        int   ans   = 0;
        int[] count = new int[101];

        for (int n : nums)
            count[n]++;

        for (int n : count)
            ans += (n * (n - 1)) / 2;

        return ans;
    }

}
