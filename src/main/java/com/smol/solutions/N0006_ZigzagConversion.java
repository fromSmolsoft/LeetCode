package com.smol.solutions;

import java.util.Arrays;

/**
 * <h1>6. Zigzag Conversion</h1>
 * <p>
 * Medium <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <pre>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * </pre>
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 *
 * <pre>
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * Example 3:
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 * Constraints:
 *     1 <= s.length <= 1000
 *     s consists of English letters (lower-case and upper-case), ',' and '.'.
 *     1 <= numRows <= 1000
 * </pre>
 */
public class N0006_ZigzagConversion {

    /**
     * <h1> O(n)</h1>
     * each element is iterated only once.  <p>
     * <h2>Logic</h2>
     * Despite nested loops in code, each element is iterated only once because each "sub-loop" starts iteration at index, where previous one ended. <p>
     * - for each row, iterate it's elements only   <p>
     * - whether element belongs to particular row is determined mathematically  <p>
     * Visualisation:
     * <pre>
     *  String s= "ABCDEFGHKL"
     *  numRows = 4;
     * {@code
     *  row  |  String   |   Index `j`
     *    0  |  A     G  |   0     6
     *    1  |  B   F H  |   1   5 7
     *    2  |  C E   K  |   2 4   8
     *    3  |  D     L  |   3     9
     * }</pre> <pre>
     * Math:
     * - 1st row and last row have this step = numRows * 2 - 2 between element
     * - mid rows have additional element in between each element:
     *      - step = numRows * 2 - 2 -> same as row 0 and last
     *      - `j + step - 2 * row`  ->  position + step - 2 * current row
     *      - conditions: mid row additional element has to be added only when on mid row
     * </pre> <pre>
     * Runtime 2ms      Beats 99.79%
     * Memory 43.62MB   Beats 84.16%
     * </pre>
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        if (s.length() <= 1) return s;

        StringBuilder result = new StringBuilder();
        int           step   = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += step) {
                result.append(s.charAt(j));
                if (i != 0 && i != numRows - 1 && (j + step - 2 * i) < s.length()) { //middle rows
                    result.append(s.charAt(j + step - 2 * i));
                }
            }
        }
        return result.toString();
    }


    /**
     * <h1>Brute force</h1>
     * slow
     * <pre>
     * Runtime 37ms     Beats 12.64%
     * Memory 46.06MB   Beats 5.54%
     * </pre>
     */
    public String convertBF(String s, int numRows) {
        if (numRows <= 1) return s;
        char[] original   = s.toCharArray();
        char[][] zigzag = new char[numRows][s.length()];

        int     i          = 0, j = 0;
        boolean descending = true;
        for (char c : original) {
            zigzag[i][j] = c;

            if (i == numRows - 1) descending = false;
            else if (i == 0) descending = true;
            if (descending) i++;
            if (!descending) {
                i--;
                j++;
            }
        }

        StringBuilder output = new StringBuilder();
        for (i = 0; i < zigzag.length; i++) {
            int collumns = zigzag[i].length;
            for (j = 0; j < collumns; j++) {
                if (zigzag[i][j] != 0) output.append(zigzag[i][j]);
            }
        }
        return output.toString();
    }

    /**
     * <h1>StringBuilder array</h1>
     */
    public String convertSA(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) sbs[i] = new StringBuilder();
        int    idx       = 0;
        int    direction = -1;
        char[] chars     = s.toCharArray();
        for (char c : chars) {
            sbs[idx].append(c);
            if (idx == 0 || idx == numRows - 1) direction = -direction;
            idx += direction;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : sbs) res.append(sb);
        return res.toString();
    }


    private void print2DArray(int numRows, char[][] zigzag) {
        for (int k = 0; k < numRows; k++) {
            System.out.println(Arrays.toString(zigzag[k]));
        }
    }
}
