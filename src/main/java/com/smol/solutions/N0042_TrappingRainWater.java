package com.smol.solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>42. Trapping Rain Water</h1>
 * Hard
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * <pre>
 * Example 1:
 * {@code
 * 3|
 * 2|               ██
 * 1|       ██░░░░░░████░░██
 * 0|   ██░░████░░████████████
 * -+---+-+-+-+-+-+-+-+-+-+-+--
 *      0 1 2 3 4 5 6 7 8 9 10
 * }
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Example 2:
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 * Constraints:
 *     n == height.length
 *     1 <= n <= 2 * 104
 *     0 <= height[i] <= 105
 *
 * </pre>
 */
public class N0042_TrappingRainWater {


    /**
     * <h1>Stack, RT: O(n), AS: O(1)</h1>
     * slow but memory efficient
     * <pre>
     * Runtime 3ms, Beats 16.03%
     * Memory  43.42MB, Beats 98.77%
     * </pre>
     */
    public int trapSt(int[] height) {
        // if (height==null) return 0;  //unnecessary in this case bc n == height.length, 1 <= n <= 2 * 104
        int i     = 0;
        int water = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        while (i < height.length) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) stack.push(i++);
            else {
                int pre = stack.pop();
                if (!stack.isEmpty()) {
                    //get smaller height of the two sides
                    int minHeight = Math.min(height[stack.peek()], height[i]);
                    //calculate water filled area
                    water += (minHeight - height[pre]) * (i - stack.peek() - 1);
                }
            }
        }
        return water;
    }


    /**
     * <h1>Two pointers, Basic Java</h1>
     * Faster but memory inefficient
     * <pre>
     * Runtime 1ms, Beats 75.91%
     * Memory 44.53MB, Beats 24.41%
     * </pre>
     */
    public int trap2P(int[] height) {

        int water = 0;
        int lPeak = 0;
        int rPeak = 0;
        int l     = 0;
        int r     = height.length - 1;

        while (l <= r) {
            lPeak = Math.max(lPeak, height[l]);
            rPeak = Math.max(rPeak, height[r]);
            if (lPeak < rPeak) {
                water += (lPeak - height[l]);
                l++;
            } else {
                water += (rPeak - height[r]);
                r--;
            }
        }
        return water;
    }
}
