package com.smol.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N0048_RotateImageTest {

    private N0048_RotateImage obj;

    @BeforeEach
    void setUp() {
        obj = new N0048_RotateImage();
    }

    /**
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
     * </pre>     *
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "[[7,4,1],[8,5,2],[9,6,3]]; [[1,2,3],[4,5,6],[7,8,9]]",
            "[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]; [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]"
    })
    void rotate(String sExpected, String sInput) {

        String[] sExpTemp = TestUtils.StringToStringArray(sExpected, "],\\[");
        String[] sInpTemp = TestUtils.StringToStringArray(sInput, "],\\[");

        int[][] expected = new int[sExpTemp.length][];
        int[][] input = new int[sInpTemp.length][];

        for (int i = 0; i < sExpTemp.length; i++) {
            String temp = TestUtils.removeSubStrings(sExpTemp[i], "\\[", "\\]");
            expected[i] = TestUtils.StringToIntArray(temp, ",");
        }

        for (int i = 0; i < sInpTemp.length; i++) {
            String temp = TestUtils.removeSubStrings(sInpTemp[i], "\\[", "\\]");
            input[i] = TestUtils.StringToIntArray(temp, ",");
        }

        int[][] actual = new int[input.length][];


//        actual = Arrays.copyOf(input, input.length);
        System.arraycopy(input,0,actual,0,input.length);

        obj.rotate(actual);
        assertEquals(Arrays.deepToString(expected), Arrays.deepToString(actual), """
                 \nmirroring
                 inp: %s
                 exp: %s
                 act: %s

                """.formatted(Arrays.deepToString(input), Arrays.deepToString(expected), Arrays.deepToString(actual)));


        System.arraycopy(input,0,actual,0,input.length);
        obj.rotate4W(actual);
        assertEquals(Arrays.deepToString(expected), Arrays.deepToString(actual), """
                 \n4-ways
                 inp: %s
                 exp: %s
                 act: %s
                                
                """.formatted(Arrays.deepToString(input), Arrays.deepToString(expected), Arrays.deepToString(actual)));
    }


}