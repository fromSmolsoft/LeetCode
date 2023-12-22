package com.smol.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * <h1>36. Valid Sudoku</h1>
 * Medium<p>
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * - Each row must contain the digits 1-9 without repetition. <p>
 * - Each column must contain the digits 1-9 without repetition. <p>
 * - Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * <p>
 * Note: <p>
 * - A Sudoku board (partially filled) could be valid but is not necessarily solvable.<p>
 * - Only the filled cells need to be validated according to the mentioned rules.<p>
 *
 *
 * <pre>
 * Example 1:
 * -------------------
 * |5|3| | |7| | | | |
 * |-+-+-|-+-+-|-+-+-|
 * |6| | |1|9|5| | | |
 * |-+-+-|-+-+-|-+-+-|
 * | |9|8| | | | |6| |
 * |-----------------|
 * |8| | | |6| | | |3|
 * |-+-+-|-+-+-|-+-+-|
 * |4| | |8| |3| | |1|
 * |-+-+-|-+-+-|-+-+-|
 * |7| | | |2| | | |6|
 * |-----------------|
 * | |6| | | | | | | |
 * |-+-+-|-+-+-|-+-+-|
 * | | | |4|1|9| | | |
 * |-+-+-|-+-+-|-+-+-|
 * | | | | |8| | | | |
 * -------------------
 *
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 *
 * Example 2:
 *
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 * Constraints:
 *
 *     board.length == 9
 *     board[i].length == 9
 *     board[i][j] is a digit 1-9 or '.'.
 * </pre>
 */
public class N0036_ValidSudoku {

    /**
     * <h2>Brute force</h2>
     * <pre>
     * Runtime 2ms Beats 83.04%of users with Java
     * Memory 43.32MB Beats 52.27%of users with Java
     * </pre>
     */
    public boolean isValidSudoku(char[][] board) {

        int rows = board.length;
        int columns = board[0].length; //all rows are of same length

        // rows check = in each row compare all indexes/ columns
        for (char[] chars : board) { //in each row

            int[] seen = new int[columns + 1];
            for (int i = 0; i < columns; i++) {

                //skip none digits
                if (!Character.isDigit(chars[i])) continue;

                // if not seen, save char
                if (seen[chars[i] - '0'] == 0) seen[chars[i] - '0'] = i + 1;
                    //else end it here
                else return false;
            }
        }

        // columns check = compare different rows with same index/column
        for (int j = 0; j < columns; j++) {
            int[] seen = new int[rows + 1];
            for (int i = 0; i < rows; i++) {

                //skip none digits
                if (!Character.isDigit(board[i][j])) continue;

                // if not seen, save char
                if (seen[board[i][j] - '0'] == 0) seen[board[i][j] - '0'] = i + 1;
                    //else end it here
                else return false;
            }
        }

        //3x3 check = check 1st 3 rows and columns than move on next 3x3
        int[] seen = new int[10];
        int i = 0, j = 0;
        while (i < rows && j < columns) {

            //skip none digits
            if (Character.isDigit(board[i][j])) {
                // if not seen, save char
                if (seen[board[i][j] - '0'] == 0) seen[board[i][j] - '0'] = i + 1;
                else return false;
            }

            if (j == 8 && (i + 1) % 3 == 0) { // end of the board, start checking new 3x3 on left bellow previously checked
                seen = new int[10];
                i++;
                j = 0;
            } else if ((j + 1) % 3 == 0 && (i + 1) % 3 == 0) { // move to  next 3x3 on the right
                seen = new int[10];
                i -= 2;
                j++;
            } else if ((j + 1) % 3 == 0) {   // move down
                i++;
                j -= 2;
            } else j++;  // move to the right
        }

        return true;
    }

    /**
     * <h2>Set of String to store seen</h2>
     * Collect the set of things we see, encoded as strings. For example:
     * <p>
     * - '4' in row 7 is encoded as "(4)7".  <p>
     * - '4' in column 7 is encoded as "7(4)".  <p>
     * - '4' in the top-right block is encoded as "0(4)2".  <p>
     * <p>
     * Scream false if we ever fail to add something because it was already added (i.e., seen before).
     * @author StefanPochmann @ <a href="https://leetcode.com/problems/valid-sudoku/solutions/15472/short-simple-java-using-strings/?envType=study-plan-v2&envId=top-interview-150">...</a>
     */
    public boolean isValidSudokuS(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in column " + j) ||
                        !seen.add(number + " in block " + i / 3 + "-" + j / 3))
                        return false;
            }
        }
        return true;
    }
}
