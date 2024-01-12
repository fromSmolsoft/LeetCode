package com.smol.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * <h1>26. Remove Duplicates from Sorted Array</h1>
 * Easy
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 * <p>
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 * <p>
 * - Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * <h2>Custom Judge:</h2>
 * <pre>
 * The judge will test your solution with the following code:
 * {@code
 *      int[] nums = [...]; // Input array
 *      int[] expectedNums = [...]; // The expected answer with correct length
 *
 *      int k = removeDuplicates(nums); // Calls your implementation
 *
 *      assert k == expectedNums.length;
 *      for (int i = 0; i < k; i++) {
 *          assert nums[i] == expectedNums[i];
 *      }
 * }
 * If all assertions pass, then your solution will be accepted.
 *
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Example 2:
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Constraints:
 * {@code
 *     1 <= nums.length <= 3 * 104
 *     -100 <= nums[i] <= 100
 *     nums is sorted in non-decreasing order.
 * }
 * </pre>
 */
public class N0026_RemoveDuplicatesFromSortedArray {
    
    
    /**
     * <h1>Two pointers - sorted array</h1><pre>
     * left pointer to overwrite values with originals
     * right pointer to iterate all values and find those not yet seen
     *
     * Runtime 1ms, Beats 96.68%of users with Java
     * Memory 44.03MB, Beats 22.47%of users with Java
     * </pre>
     */
    public int removeDuplicates(int[] nums) {
        int left = 1;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[right - 1]) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
    
    
    /**
     * <h1>Two pointers - non-sorted array</h1>
     * <pre>
     * left pointer to overwrite values with originals
     * right pointer to iterate all values and find those not yet seen
     *
     * rest of the input array is overwritten by empty values
     *
     * Runtime 2ms, Beats 15.86%of users with Java
     * Memory 43.74MB, Beats 63.32%of users with Java
     * </pre>
     */
    public int removeDuplicates01(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int l = nums.length;
        int left = 0;
        for (int right = 0; right < l; right++) {
            int num = nums[right];
            if (!seen.contains(num)) {
                seen.add(num);
                nums[left++] = num;
            }
        }
        return left;
    }
}
