package com.smol.solutions;

/**
 * <h1>88. Merge Sorted Array</h1>
 * Easy
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively. <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order. <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n. <p>
 * <p>
 * Example 1:  <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 <p>
 * Output: [1,2,2,3,5,6] <p>
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6]. <p>
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1. <p>
 * <p>
 * Example 2: <p>
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0 <p>
 * Output: [1] <p>
 * Explanation: The arrays we are merging are [1] and []. <p>
 * The result of the merge is [1]. <p>
 * <p>
 * Example 3: <p>
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1 <p>
 * Output: [1] <p>
 * Explanation: The arrays we are merging are [] and [1]. <p>
 * The result of the merge is [1]. <p>
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1. <p>
 * <p>
 * Constraints: <p>
 * nums1.length == m + n <p>
 * nums2.length == n <p>
 * 0 <= m, n <= 200 <p>
 * 1 <= m + n <= 200 <p>
 * -109 <= nums1[i], nums2[j] <= 109 <p>
 * <p>
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time? <p>
 */
public class N0088_MergeSortedArray {

    /**
     * <h1>Three pointers decrementing </h1><pre>
     * - iterate arrays backwards (from end to start  6,5,4...0)
     * - uses 3 pointers:
     *      - i - index to place bigger value in nums1[]
     *      - m - index value in nums1[] to be compared
     *      - n - index value in nums2[] to be compared
     *
     * - Single while loop:
     *      - iterates until index n >= 0
     *      - compares values nums[m] vs nums[n]
     *      - inserts bigger value in nums[i]
     *      - decrements either m or n depending which value was bigger
     *      - decrements i
     *
     * Runtime 0ms, Beats 100.00%of users with Java
     * Memory 41.40MB, Beats 38.73%of users with Java
     * </pre>
     * @param nums1 main array. It's being modified without losing reference in memory
     * @param nums2 secondary array
     * @param m     nubmer of values in nums1. It doesn't equal array length.
     * @param n     number of values in nums2
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int i = m + n - 1;
        m--;
        n--;

        while (n >= 0) {
            if (m >= 0 && nums1[m] > nums2[n]) nums1[i--] = nums1[m--];
            else nums1[i--] = nums2[n--];
        }
    }
}
