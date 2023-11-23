package com.smol.solutions;

/**
 * <h1>73. Set Matrix Zeroes</h1>
 * Medium
 * <p>
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * <p>
 * You must do it in place.
 *
 * <pre>
 * Example 1:
 *     +---+---+---+      +---+---+---+
 *     | 1 | 1 | 1 |      | 1 |[0]| 1 |
 *     +---+---+---+      +---+---+---+
 *     | 1 |>0<| 1 |      |[0]| 0 |[0]|
 *     +---+---+---+      +---+---+---+
 *     | 1 | 1 | 1 |      | 1 |[0]| 1 |
 *     +---+---+---+      +---+---+---+
 *
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 *
 * Example 2:
 *     +---+---+---+---+  +---+---+---+---+
 *     |>0<| 1 | 2 |>0<|  | 0 |[0]|[0]| 0 |
 *     +---+---+---+---+  +---+---+---+---+
 *     | 3 | 4 | 5 | 2 |  |[0]| 4 | 5 |[0]|
 *     +---+---+---+---+  +---+---+---+---+
 *     | 1 | 3 | 1 | 5 |  |[0]| 3 | 1 |[0]|
 *     +---+---+---+---+  +---+---+---+---+
 *
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * Constraints:
 *     m == matrix.length
 *     n == matrix[0].length
 *     1 <= m, n <= 200
 *     -231 <= matrix[i][j] <= 231 - 1
 * </pre>
 * Follow up:
 * - A straightforward solution using O(mn) space is probably a bad idea. <p>
 * - A simple improvement uses O(m + n) space, but still not the best solution. <p>
 * - Could you devise a constant space solution? <p>
 */
public class N0073_SetMatrixZeroes {


    /**
     * <h2>Seen rows and columns</h2>
     * Uses array to save rows and columns with "0". It saves both to same array to optimize performance<p>
     * Then zeroes saved rows and columns <p>
     *
     * <pre>
     * Runtime 1ms Beats 90.22% of users with Java
     * Memory 44.78MB Beats 23.87% of users with Java
     * </pre>
     */
    public void setZeroesArr(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] seen = new int[matrix.length + n];

        for (int i = 0; i < matrix.length; i++) {
            if (seen[i] != 0) continue;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    seen[i] = i + 1;
                    seen[j + m] = j + 1;
                }
            }
        }

        for (int i = 0; i < seen.length - n; i++) {
            if (seen[i] != 0) matrix[i] = new int[n];
        }
        for (int j = seen.length - n; j < seen.length; j++) {
            if (seen[j] != 0) {
                for (int i = 0; i < matrix.length; i++) matrix[i][j - m] = 0;
            }
        }
    }

    /**
     * <h2>0th row and column marks zeroing </h2>
     * <h3>Looking for zeros:</h3>
     * if there is "0" in 0th row -> mark it down and go to next phase (break) <p>
     * if there is "0" in 0th column -> mark it down and go to next phase <p>
     * If there is "0" anywhere else: <p>
     * - change value to zero in same column in 0th row  <p>
     * - change value to zero in same row in 0th column  <p>
     * <p>
     * <h3>Zeroing</h3>
     * if there is "0" in 0th row -> all elements in row = "0" <p>
     * if there is "0" in 0th column -> all elements in column = "0" <p>
     * if 0th row was zero at beginning -> zero 0th row fully
     * if 0th column was zero at beginning -> zero 0th column fully
     *
     * <pre>
     * Runtime 1ms Beats 90.22% of users with Java
     * Memory 44.84MB Beats 15.19% of users with Java
     * </pre>
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean isRow0 = false, isCol0 = false;

        //check 0th row & 0th column
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isCol0 = true;
                break;
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                isRow0 = true;
                break;
            }
        }

        //check rest of the array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //zero inner matrix
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        //zero 0th row and column
        if (isRow0) matrix[0] = new int[n];

        if (isCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }

}
