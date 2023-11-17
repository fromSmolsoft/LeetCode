package com.smol.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>54. Spiral Matrix</h1>
 * Medium
 * <p>
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <pre>
 * Example 1:
 *    +-----+-----+-----+
 *    |     |     |     |
 *    |  1**** 2 *** 3  |
 *    |     |     |  *  |
 *    +-----+-----+--*--+
 *    |     |     |  *  |
 *    |  4 *** 5  |  6  |
 *    |  *  |     |  *  |
 *    +--*--+-----+--*--+
 *    |  *  |     |  *  |
 *    |  7 *** 8 *** 9  |
 *    |     |     |     |
 *    +-----+-----+-----+
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * Constraints:
 *     m == matrix.length
 *     n == matrix[i].length
 *     1 <= m, n <= 10
 *     -100 <= matrix[i][j] <= 100
 * </pre>
 */
public class N0054_SpiralMatrix {

    /**
     * <pre>
     * Runtime Beats 100.00% of users with Java
     * Memory 40.70MB Beats 38.53% of users with Java
     * </pre>
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        if (matrix.length == 0) return spiral;

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {

            // move right
            for (int i = left; i <= right; i++) {
                spiral.add(matrix[top][i]);
            }
            top++;

            // move down
            for (int i = top; i <= bottom; i++) {
                spiral.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                // move left
                for (int i = right; i >= left; i--) {
                    spiral.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                // move up
                for (int i = bottom; i >= top; i--) {
                    spiral.add(matrix[i][left]);
                }
                left++;
            }

        }
        return spiral;
    }

}
