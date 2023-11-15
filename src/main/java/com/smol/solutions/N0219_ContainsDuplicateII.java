package com.smol.solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <h1>219. Contains Duplicate II</h1>
 * <p>
 * Easy
 * <p>
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 *
 * <pre>
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 *
 * Example 3:
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 *
 * Constraints:
 *     1 <= nums.length <= 105
 *     -109 <= nums[i] <= 109
 *     0 <= k <= 105
 * </pre>
 */
public class N0219_ContainsDuplicateII {

    /**
     * <H2>By HashMap</H2>
     * Iterates over array. Saves unique values + their index. For duplicities checks if following is true `abs(i - j) <= k` returns true, where j is saved index, i is current index, k is given param.
     *
     * <pre>
     * Runtime 17ms Beats 75.31% of users with Java
     * Memory 57.07MB Beats 17.42% of users with Java
     * </pre>
     */
    public boolean containsNearbyDuplicateHP(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(i - map.get(nums[i])) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    /**
     * <h2> Sliding window + set</h2>
     * It iterates over the array using a sliding window. The front of the window is at i, the rear of the window is k steps back. The elements within that window are maintained using a Set. While adding new element to the set, if add() returns false, it means the element already exists in the set. At that point, we return true. If the control reaches out of for loop, it means that inner return true never executed, meaning no such duplicate element was found.
     *
     * <pre>
     * Runtime 15ms Beats 90.31% of users with Java
     * Memory 56.85MB Beats 30.40% of users with Java
     * </pre>
     * @author desc. san89kalp @ <a href="https://leetcode.com/problems/contains-duplicate-ii/solutions/61372/simple-java-solution/comments/62664">...</a>
     * @author logic southpenguin @ <a href="https://leetcode.com/problems/contains-duplicate-ii/solutions/61372/simple-java-solution/?envType=study-plan-v2&envId=top-interview-150">...</a>
     */
    public boolean containsNearbyDuplicateSW(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }

}
