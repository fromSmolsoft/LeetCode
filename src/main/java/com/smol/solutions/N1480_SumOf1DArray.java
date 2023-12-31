package com.smol.solutions;

public class N1480_SumOf1DArray {
    /**
     * 1480. Running Sum of 1d Array
     * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
     * Return the running sum of nums. <p>
     * Example 1:<p>
     * Input: nums = [1,2,3,4]
     * Output: [1,3,6,10]
     * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4]. <p>
     * Example 2:<p>
     * Input: nums = [1,1,1,1,1]
     * Output: [1,2,3,4,5]
     * Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1]. <p>
     * Example 3:<p>
     * Input: nums = [3,1,2,10,1]
     * Output: [3,4,6,16,17] <p>
     * Constraints:<p>
     * 1 <= nums.length <= 1000
     * -10^6 <= nums[i] <= 10^6
     */
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
