package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class N0073_SetMatrixZeroesTest {

    private N0073_SetMatrixZeroes obj;

    @BeforeEach
    void setUp() {
        obj = new N0073_SetMatrixZeroes();
    }

    /**
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
     * Constraints:
     *     m == matrix.length
     *     n == matrix[0].length
     *     1 <= m, n <= 200
     *     -231 <= matrix[i][j] <= 231 - 1
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "[[1,0,1],[0,0,0],[1,0,1]];         [[1,1,1],[1,0,1],[1,1,1]]",
            "[[0,0,0,0],[0,4,5,0],[0,3,1,0]];   [[0,1,2,0],[3,4,5,2],[1,3,1,5]]",
            "[[0,0,0,0],[0,0,0,4],[0,0,0,0],[0,0,0,3],[0,0,0,0]]; [[0,0,0,5],[4,3,1,4],[0,1,1,4],[1,2,1,3],[0,0,1,1]]"
    })
    void setZeroes(String sExpected, String sMatrix) {
        int[][] expected = stringToMatrix(sExpected);
        int[][] matrix = stringToMatrix(sMatrix);
        int[][] actual;

        actual = TUtils.copy2DArray(matrix);
        obj.setZeroesArr(actual);
        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(actual), "\nArray \nmatrix\n" + Arrays.deepToString(matrix) + "\n");

        actual = TUtils.copy2DArray(matrix);
        obj.setZeroes(actual);
        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(actual), "\nArray \nmatrix\n" + Arrays.deepToString(matrix) + "\n");


    }


    private int[][] stringToMatrix(String stringMatrix) {
        String[] temp = TUtils.StringToStringArray(stringMatrix, "],\\[");
        int[][] matrix = new int[temp.length][];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = TUtils.removeSubStrings(temp[i], "[", "\\]");
            int[] subArray = TUtils.StringToIntArray(temp[i], ",");
            matrix[i] = subArray;
        }

        return matrix;
    }


}