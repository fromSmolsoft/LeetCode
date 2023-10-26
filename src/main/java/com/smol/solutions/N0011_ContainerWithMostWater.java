package com.smol.solutions;

/**
 * <h1>11. Container With Most Water</h1>
 * Medium
 * <p>
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 *
 * <pre>
 * Example 1:
 *  {@code
 *    height
 *      8│    ┌┐             ┌┐
 *      7│    │┼─────────────┼┼─┬┐ water level
 *      6│    ││~┌┐~~~~~~~~~~││~││
 *      5│    ││~││~~~~┌┐~~~~││~││
 *      4│    ││~││~~~~││~┌┐~││~││
 *      3│    ││~││~~~~││~││~││~││
 *      2│    ││~││~┌┐~││~││~││~││
 *      1│ ┌┐ ││~││~││~││~││~││~││
 *       └─┴┴─┴┴─┴┴─┴┴─┴┴─┴┴─┴┴─┴┴─
 *       0  1  2  3  4  5  6  8  9  length (index)
 * }
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 *
 * Constraints:
 *     n == height.length
 *     2 <= n <= 105
 *     0 <= height[i] <= 104
 * </pre>
 */
public class N0011_ContainerWithMostWater {
    /**
     * <h1>Two pointers</h1>
     * Finds maxArea between two pointers: `left` and `right` by moving pointer with lower value closer to the other pointer.
     * <pre>
     * Area:
     * {@code
     *    height at index
     *      8│    ┌┐             ┌┐
     *      7│    │┼─────────────┼┼─┬┐ water level
     *      6│    ││~┌┐~~~~~~~~~~││~││
     *      5│    ││~││~~~~┌┐~~~~││~││
     *      4│    ││~││~~~~││~┌┐~││~││
     *      3│    ││~││~~~~││~││~││~││
     *      2│    ││~││~┌┐~││~││~││~││
     *      1│ ┌┐ ││~││~││~││~││~││~││
     *       └─┴┴─┴┴─┴┴─┴┴─┴┴─┴┴─┴┴─┴┴─
     *       0  1  2  3  4  5  6  8  9  length (index)
     *             ▲                 ▲
     *             └─ left           └─ right
     *
     *   if height[left] < height[right] move left closer to right and vice versa.
     *   if both heights equals move both pointer closer to each other.
     *   save new area if it is bigger than previous max area.
     *
     * }</pre>
     * <pre>
     *  Runtime 4ms, Beats 85.41%
     *  Memory 55.17MB, Beats 89.02%
     *  </pre>
     * @param height array of heights
     * @return max area
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left    = 0;  // start index of area
        int right   = height.length - 1;   // end index of area

        while (left < right) {
            int w  = right - left;
            int lH = height[left];
            int rH = height[right];
            int h  = Math.min(lH, rH);

            maxArea = Math.max(maxArea, h * w);

            if (lH < rH) left++;
            else if (lH > rH) right--;
            else {
                left++;
                right--;
            }

        }
        return maxArea;
    }

    /**
     * <h1>Brute force</h1>
     * Slow but simple to understand.
     * Iterates and compare every element against all elements on the right.
     * Saves max area if it's bigger than previous maxArea.
     */
    public int maxAreaBF(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int iH = height[i];
            for (int j = i + 1; j < height.length; j++) {
                int minH = Math.min(iH, height[j]);
                maxArea = Math.max(minH * (j - i), maxArea);
            }
        }
        return maxArea;
    }
}
