package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class N0289_GameofLifeTest {

    private N0289_GameofLife obj;

    @BeforeEach
    void setUp() {
        obj = new N0289_GameofLife();
    }

    /**
     * <pre>
     * Example 1:
     *       +---+---+---+    +---+---+---+
     *       | 0 | 1 | 0 |    | 0 | 0 | 0 |
     *       +---+---+---+    +---+---+---+
     *       | 0 | 0 | 1 |    | 1 | 0 | 1 |
     *       +---+---+---+ => +---+---+---+
     *       | 1 | 1 | 1 |    | 0 | 1 | 1 |
     *       +---+---+---+    +---+---+---+
     *       | 0 | 0 | 0 |    | 0 | 1 | 0 |
     *       +---+---+---+    +---+---+---+
     * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
     * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
     *
     * Example 2:
     * Input: board = [[1,1],[1,0]]
     * Output: [[1,1],[1,1]]
     *
     * Constraints:
     *     m == board.length
     *     n == board[i].length
     *     1 <= m, n <= 25
     *     board[i][j] is 0 or 1.
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]; [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]",
            "[[1,1],[1,1]]; [[1,1],[1,0]]"
    })
    void gameOfLife(String sExpected, String sInput) {

        int[][] expected = TestUtils.stringToMatrix(sExpected, "],\\[", ",", "[", "\\]");
        int[][] input = TestUtils.stringToMatrix(sInput, "],\\[", ",", "[", "\\]");
        int[][] actual;

        actual = TestUtils.copy2DArray(input);
        obj.gameOfLifeBF(actual);

        List<int[][]> list;
        list = new ArrayList<>();
        list.add(input);
        list.add(expected);
        list.add(actual);

        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(actual),
                "\n" + TestUtils.printMatricesHorisont(list) + "\n" +
                "\n\nInput    :" + Arrays.deepToString(input));


        actual = TestUtils.copy2DArray(input);
        obj.gameOfLife(actual);

        list = new ArrayList<>();
        list.add(input);
        list.add(expected);
        list.add(actual);

        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(actual),
                "\n" + TestUtils.printMatricesHorisont(list) + "\n" +
                "\n\nInput    :" + Arrays.deepToString(input));

    }


    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "1; 0; 0; [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]",
            "3; 1; 0; [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]",
            "3; 3; 1; [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]",
            "3; 1; 0; [[0,2,0],[0,0,1],[1,1,1],[0,0,0]]",
    })
    public void getLives(int exp, int i, int j,String sBoard) {
        int[][] board = TestUtils.stringToMatrix(sBoard, "],\\[", ",", "[", "\\]");
        int m = board.length;
        int n = board[0].length;
        int act;

        act = obj.getLives(board, i, j, n, m);
        Assertions.assertEquals(exp,act);
    }
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "1; 0; 0; [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]",
            "3; 1; 0; [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]",
            "3; 3; 1; [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]",
    })
    public void getLivesBF(int exp, int i, int j,String sBoard) {
        int[][] board = TestUtils.stringToMatrix(sBoard, "],\\[", ",", "[", "\\]");
        int m = board.length;
        int n = board[0].length;
        int act;

        act = obj.getLivesBF(board, i, j, n, m);
        Assertions.assertEquals(exp,act);
    }
}