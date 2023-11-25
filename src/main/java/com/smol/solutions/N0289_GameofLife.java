package com.smol.solutions;

/**
 * <h1>289. Game of Life</h1>
 * Medium
 * <p>
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p>
 * - Any live cell with fewer than two live neighbors dies as if caused by under-population. <p>
 * - Any live cell with two or three live neighbors lives on to the next generation. <p>
 * - Any live cell with more than three live neighbors dies, as if by over-population. <p>
 * - Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction. <p>
 * <p>
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
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
 *
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
 * Follow up:
 * Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells. <p>
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems? <p>
 */
public class N0289_GameofLife {

    private int die = 2;
    private int live = 3;

    /** <h2>Not "in place" solution</h2> */
    public void gameOfLifeBF(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbs = getLivesBF(board, i, j, n, m);

                // process result
                if (board[i][j] == 1 && (liveNeighbs == 2 || liveNeighbs == 3) || board[i][j] == 0 && liveNeighbs == 3) {
                    res[i][j] = 1;
                }
            }
        }
        // update matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = res[i][j];
            }
        }
    }

    protected int
    getLivesBF(int[][] board, int i, int j, int n, int m) {
        int lives = 0;
        // top
        if (i > 0 && j > 0 && board[i - 1][j - 1] == 1) lives++;
        if (i > 0 && board[i - 1][j] == 1) lives++;
        if (i > 0 && j < n - 1 && board[i - 1][j + 1] == 1) lives++;
        // left & right
        if (j > 0 && board[i][j - 1] == 1) lives++;
        if (j < n - 1 && board[i][j + 1] == 1) lives++;
        // bottom
        if (i < m - 1 && j > 0 && board[i + 1][j - 1] == 1) lives++;
        if (i < m - 1 && board[i + 1][j] == 1) lives++;
        if (i < m - 1 && j < n - 1 && board[i + 1][j + 1] == 1) lives++;
        return lives;
    }


    /**
     * <h2>"In-place" solution</h2>
     *
     * <pre>
     * Runtime 0ms Beats 100.00% of users with Java
     * Memory 40.62MB Beats 60.04% of users with Java
     * </pre>
     */
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = getLives(board, i, j, n, m);

                // process result
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = live;
                } else if (board[i][j] == 1) {
//                    if (lives == 2 || lives == 3) continue;
                    if (lives < 2 || lives > 3) board[i][j] = die;
                }
            }
        }

        // update matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == die) board[i][j] = 0;
                else if (board[i][j] == live) board[i][j] = 1;
            }
        }
    }

    public int getLives(int[][] board, int i, int j, int n, int m) {
        int lives = 0;

        // top
        if (i > 0 && j > 0 &&
            (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == die)) lives++;
        if (i > 0 &&
            (board[i - 1][j] == 1 || board[i - 1][j] == die)) lives++;
        if (i > 0 && j < n - 1 &&
            (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == die)) lives++;

        // left & right
        if (j > 0 &&
            (board[i][j - 1] == 1 || board[i][j - 1] == die)) lives++;
        if (j < n - 1 &&
            (board[i][j + 1] == 1 || board[i][j + 1] == die)) lives++;

        // bottom
        if (i < m - 1 && j > 0 &&
            (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == die)) lives++;
        if (i < m - 1 &&
            (board[i + 1][j] == 1 || board[i + 1][j] == die)) lives++;
        if (i < m - 1 && j < n - 1 &&
            (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == die)) lives++;
        return lives;
    }

}
