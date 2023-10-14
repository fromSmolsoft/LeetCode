package com.smol.solutions;

import java.util.*;

/**
 * <h1>229. Majority Element II</h1>
 * <p>
 * Medium <p>
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * <pre>
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: [3]
 *
 * Example 2:
 * Input: nums = [1]
 * Output: [1]
 *
 * Example 3:
 * Input: nums = [1,2]
 * Output: [1,2]
 *
 * Constraints:
 *     1 <= nums.length <= 5 * 104
 *     -109 <= nums[i] <= 109
 * </pre>
 */
public class N0229_MajorityElement_II {

/**<h1>Boyer–Moore majority vote algorithm</h1><pre>
 * Runtime 2ms, Beats 98.52%of users with Java
 * Memory 47.31MB, Beats 5.65%of users with Java
 * </pre>*/
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        int candidate1 = 0, candidate2 = 0, sum1 = 0, sum2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1) sum1++;
            else if (nums[i] == candidate2) sum2++;
            else if (sum1 == 0) {
                candidate1 = nums[i];
                sum1++;
            } else if (sum2 == 0) {
                candidate2 = nums[i];
                sum2++;
            } else {
                sum1--;
                sum2--;
            }
        }

        sum1 = sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1) sum1++;
            else if (nums[i] == candidate2) sum2++;
        }
        List<Integer> result = new ArrayList<>();
        if (sum1 > nums.length / 3) result.add(candidate1);
        if (sum2 > nums.length / 3) result.add(candidate2);

        return result;
    }

    /**
     * <h1>HashMap 2</h1><pre>
     * slow but should work work different n
     * Runtime 13ms,    Beats 21.73%of users with Java
     * Memory 46.65MB,  Beats 47.18%of users with Java</pre>
     */
    public List<Integer> majorityElement02(int[] nums) {
        int           n      = nums.length;
        List<Integer> result = new ArrayList<>();
        if (n == 0) return result;

        int                   i    = 0;
        int                   k    = n / 3;
        Map<Integer, Integer> seen = new HashMap<>();

        while (i < n) {
            int number = nums[i++];
            if (result.contains(number))
                continue; // pass other operations if already identified as multiplicity
            if (k == 0) {    // if k == 0 -> all unique numbers apply, pass other operations
                result.add(number);
                continue;
            }
            if (seen.containsKey(number)) { // if seen > 1
                if (seen.get(number) >= k) result.add(number); //if seen > k times, add to list
                else seen.merge(number, 1, Integer::sum);   //if seen <= k times

            } else seen.put(number, 1);  //if seem for the 1st time
        }
        return result;
    }


    /**
     * <h1>HashMap solution<</h1> <pre>
     * slow but should work work different n
     * Runtime 12ms, Beats 33.23%of users with Java
     * Memory 46.56MB, Beats 55.69%of users with Java
     * </pre>
     */
    public List<Integer> majorityElement01(int[] nums) {
        int           l      = nums.length;
        int           k      = l / 3;
        List<Integer> result = new ArrayList<>();

        if (k == 0) {
            Set<Integer> seen = new HashSet<>();
            for (int i = 0; i < l; i++) {
                if (!seen.contains(nums[i])) {
                    seen.add(nums[i]);
                    result.add(nums[i]);
                }
            }
            return result;
        }

        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < l; i++) {
            if (seen.containsKey(nums[i])) {
                int temp = seen.get(nums[i]) + 1;
                if (temp > k + 1) continue;
                if (temp == k + 1) result.add(nums[i]);
                seen.put(nums[i], temp);
            } else seen.put(nums[i], 1);
        }
        return result;
    }

}
