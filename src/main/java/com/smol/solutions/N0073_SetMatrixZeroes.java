package com.smol.solutions;

import java.util.HashSet;
import java.util.Set;

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
     * <h1>Seen rows and columns</h1>
     * Uses Set to save non-duplicated rows and columns  <p>
     * Then zeroes saved rows and columns <p>
     * <pre>
     * Runtime 2 ms Beats 23.16% of users with Java
     * Memory 44.83 MB Beats 15.19% of users with Java
     * </pre>
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> iSeen = new HashSet<>();
        Set<Integer> jSeen = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            if (iSeen.contains(i)) continue;
            for (int j = 0; j < matrix[i].length; j++) {
//                if (jSeen.contains(j)) continue;
                if (matrix[i][j] == 0) {
                    iSeen.add(i);
                    jSeen.add(j);
                }
            }
        }

        for (int i : iSeen) matrix[i] = new int[matrix[i].length];
        for (int j : jSeen) {
            for (int i = 0; i < matrix.length; i++) matrix[i][j] = 0;
        }

    }

}
