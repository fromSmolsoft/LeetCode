package com.smol.solutions;

/**
 * <h1>48. Rotate Image</h1>
 * Medium
 * <p>
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * <pre>
 * Example 1:
 * ┌───┬───┬───┐     ┌───┬───┬───┐
 * │ 1 │ 2 │ 3 │     │ 7 │ 4 │ 1 │
 * ├───┼───┼───┤ ──► ├───┼───┼───┤
 * │ 4 │ 5 │ 6 │     │ 8 │ 5 │ 2 │
 * ├───┼───┼───┤ ──► ├───┼───┼───┤
 * │ 7 │ 8 │ 9 │     │ 9 │ 6 │ 3 │
 * └───┴───┴───┘     └───┴───┴───┘
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 * Example 2:
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * Constraints:
 *     n == matrix.length == matrix[i].length
 *     1 <= n <= 20
 *     -1000 <= matrix[i][j] <= 1000
 * </pre>
 */
public class N0048_RotateImage {

    /**
     * <h2>Rows reverse & transposing</h2>
     * 1. revers order of (horizontal) rows <p>
     * 2. transpose diagonally where the diagonal goes from top-left to bottom-right <p>
     * <pre>
     *      +--+--+--+--+           ---+--+--+--+
     *      |  |  |  |  | <-,       |`.|  |  |  |
     *      +--+--+--+--+    \      +--\--+--+--+
     *      |  |  |  |  | <-  |     |  |`.|  |  |
     *      +--+--+--+--+   | |     +--+--\--+--+
     *      |  |  |  |  | <-  /     |  |  |`.|  |
     *      +--+--+--+--+    /      +--+--+--\--+
     *      |  |  |  |  | <-`       |  |  |  |`.|
     *      +--+--+--+--+           +--+--+--+--'
     * </pre>
     * <pre>
     * Runtime 0 ms     Beats 100.00% of users with Java
     * Memory 41.55 MB  Beats 12.91% of users with Java
     * </pre>
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //reversion of horizontal lines order
        int k = 0;
        int l = n - 1;
        while (k < l) {
            int[] temp = matrix[k];
            matrix[k] = matrix[l];
            matrix[l] = temp;
            k++;
            l--;
        }

        //transposing of matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * <H2>4-way swap</H2>
     * <pre>
     *                                     _,_
     *                                 ,'       `.
     *         i=0                    -    j=0    ▼
     *    +--+--+--+--+--+           +--+--+--+--+--+
     *    |**|**|**|**|**|          ►|**|  |  |  |**| -,
     *    +--+--+--+--+--+       ,'  +--+--+--+--+--+   ',
     *    |**|  |  |  |**|      /    |  |  |  |  |  |     \
     *    +--+--+--+--+--+     /     +--+--+--+--+--+      ,
     *    |**|  |  |  |**|     |     |  |  |  |  |  |      |
     *    +--+--+--+--+--+     |     +--+--+--+--+--+      `
     *    |**|  |  |  |**|      \    |  |  |  |  |  |     /
     *    +--+--+--+--+--+       `.  +--+--+--+--+--+   .`
     *    |**|**|**|**|**|         ' |**|  |  |  |**| ◄`
     *    +--+--+--+--+--+           +--+--+--+--+--+
     *                                ▲            ,
     *                                 `.         /
     *                                   '.____.`
     *         j=1               j=2             j=3
     *   +--+--+--+--+--+ +--+--+--+--+--+ +--+--+--+--+--+
     *   |  |**|  |  |  | |  |  |**|  |  | |  |  |  |**|  |
     *   +--+--+--+--+--+ +--+--+--+--+--+ +--+--+--+--+--+
     *   |**|  |  |  |  | |  |  |  |  |  | |**|  |  |  |  |
     *   +--+--+--+--+--+ +--+--+--+--+--+ +--+--+--+--+--+
     *   |  |  |  |  |  | |**|  |  |  |**| |  |  |  |  |  |
     *   +--+--+--+--+--+ +--+--+--+--+--+ +--+--+--+--+--+
     *   |  |  |  |  |**| |  |  |  |  |  | |  |  |  |  |**|
     *   +--+--+--+--+--+ +--+--+--+--+--+ +--+--+--+--+--+
     *   |  |**|  |  |  | |  |  |**|  |  | |  |**|  |  |  |
     *   +--+--+--+--+--+ +--+--+--+--+--+ +--+--+--+--+--+
     *  Next inner "level"
     *         i=1               j=0             j=1
     *   +--+--+--+--+--+ +--+--+--+--+--+ +--+--+--+--+--+
     *   |  |  |  |  |  | |  |  |  |  |  | |  |  |  |  |  |
     *   +--+--+--+--+--+ +--+--+--+--+--+ +--+--+--+--+--+
     *   |  |**|**|**|  | |  |**|  |**|  | |  |  |**|  |  |
     *   +--+--+--+--+--+ +--+--+--+--+--+ +--+--+--+--+--+
     *   |  |**|  |**|  | |  |  |  |  |  | |  |**|  |**|  |
     *   +--+--+--+--+--+ +--+--+--+--+--+ +--+--+--+--+--+
     *   |  |**|**|**|  | |  |**|  |**|  | |  |  |**|  |  |
     *   +--+--+--+--+--+ +--+--+--+--+--+ +--+--+--+--+--+
     *   |  |  |  |  |  | |  |  |  |  |  | |  |  |  |  |  |
     *   +--+--+--+--+--+ +--+--+--+--+--+ +--+--+--+--+--+
     *
     * </pre>
     */
    public void rotate4W(int[][] M) {
        int n = M.length, depth = n / 2;
        for (int i = 0; i < depth; i++) {
            int len = n - 2 * i - 1, opp = n - 1 - i;
            for (int j = 0; j < len; j++) {
                int temp = M[i][i + j];
                M[i][i + j] = M[opp - j][i];
                M[opp - j][i] = M[opp][opp - j];
                M[opp][opp - j] = M[i + j][opp];
                M[i + j][opp] = temp;
            }
        }
    }
}
