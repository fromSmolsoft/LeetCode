package com.smol.solutions;

/**
 * <h1>189. Rotate Array</h1>
 * Medium
 * <p>
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * <pre>
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 * Constraints:
 *     1 <= nums.length <= 105
 *     -231 <= nums[i] <= 231 - 1
 *     0 <= k <= 105
 *
 * Follow up:
 *
 *     Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 *     Could you do it in-place with O(1) extra space?
 *
 * </pre>
 */
public class N0189_RotateArray {


    /**
     * <h1> Divide and reverse </h1>
     * O(n) time cost, O(1) space cost
     * <pre>
     * Visualization
     * nums = "----->-->"; k =3
     * result = "-->----->";
     *
     * reverse "----->-->" we can get "<--<-----"
     * reverse "<--" we can get "--><-----"
     * reverse "<-----" we can get "-->----->"
     *
     * Runtime 0ms,     Beats 100.00%of users with Java
     * Memory 55.47MB,  Beats 68.92%of users with Java
     * </pre>
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }

    private void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     *  Time complexity O(n), extra space cost O(1)
     * @author liji94188 @ <a href="https://leetcode.com/problems/rotate-array/solutions/54289/my-three-way-to-solve-this-problem-the-first-way-is-interesting-java/comments/55990">...</a>
     */
    public void rotate01(int[] nums, int k) {
        k %= nums.length;
        if (k <= 0) return;
        int index = k, loopHead = 0, curr = nums[0];
        //1. index is the index of the element we will update in each iteration.
        //2. loopHead is head of a loop (if exist) for index since each time we
        // move index k steps further.
        //3. curr is the value got from previous iteration nums[preIndex] and
        //for updating nums[index]
        for (int count = 0; count < nums.length; count++) {
            if (index == loopHead) { //loop detected
                nums[index] = curr; //set the value of loopHead.
                loopHead++; //move 1 step further to jump out of loop
                curr = nums[++index]; //This is the head of new loop
                index = (index + k) % nums.length;
            } else { //each time go k steps further
                int tmp = nums[index];
                nums[index] = curr;
                curr = tmp;
                index = (index + k) % nums.length;
            }
        }
    }


    /**
     *  O(n) time cost, O(1) space cost
     * @author zwangbo @ <a href="https://leetcode.com/problems/rotate-array/solutions/54289/my-three-way-to-solve-this-problem-the-first-way-is-interesting-java/?envType=study-plan-v2&envId=top-interview-150">...</a>
     */
    public void rotate02(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        //step each time to move
        int step = k % nums.length;
        //find GCD between nums length and step
        int gcd = findGcd(nums.length, step);
        int position, count;

        //gcd path to finish movie
        for (int i = 0; i < gcd; i++) {
            //beginning position of each path
            position = i;
            //count is the number we need swap each path
            count = nums.length / gcd - 1;
            for (int j = 0; j < count; j++) {
                position = (position + step) % nums.length;
                //swap index value in index i and position
                nums[i] ^= nums[position];
                nums[position] ^= nums[i];
                nums[i] ^= nums[position];
            }
        }
    }

    public int findGcd(int a, int b) {
        return (a == 0 || b == 0) ? a + b : findGcd(b, a % b);
    }

    /**<h1> Normal way</h1>
     * O(n) time cost, O(k % nums.length) space cos
     * @author zwangbo @ <a href="https://leetcode.com/problems/rotate-array/solutions/54289/my-three-way-to-solve-this-problem-the-first-way-is-interesting-java/?envType=study-plan-v2&envId=top-interview-150">...</a>
     */
    public void rotate03(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        //step each time to move
        int   step = k % nums.length;
        int[] tmp  = new int[step];
        for (int i = 0; i < step; i++) {
            tmp[i] = nums[nums.length - step + i];
        }
        for (int i = nums.length - step - 1; i >= 0; i--) {
            nums[i + step] = nums[i];
        }
        for (int i = 0; i < step; i++) {
            nums[i] = tmp[i];
        }

    }

}
