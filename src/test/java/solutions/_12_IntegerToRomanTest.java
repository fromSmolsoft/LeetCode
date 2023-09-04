package solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _12_IntegerToRomanTest {


    private _12_IntegerToRoman obj;

    @BeforeEach
    void setUp() {
        obj = new _12_IntegerToRoman();
    }

    /**
     * Input: num = 3;
     * Output: "III";
     * Explanation: 3 is represented as 3 ones.
     */
    @Test
    void n3() {
        int    num      = 3;
        String expected = "III";

        String actual = obj.intToRoman(num);
        assertEquals(expected, actual);
    }

    /**
     * Input: num = 58;
     * Output: "LVIII";
     */
    @Test
    void n58() {
        int    num      = 58;
        String expected = "LVIII";

        String actual = obj.intToRoman(num);
        assertEquals(expected, actual);
    }

    /**
     * Input: num = 1994;
     * Output: "MCMXCIV";
     */
    @Test
    void n1994() {
        int    num      = 1994;
        String expected = "MCMXCIV";

        String actual = obj.intToRoman(num);
        assertEquals(expected, actual);
    }

    /**
     *
     */
    @Test
    void n1900() {
        int    num      = 1900;
        String expected = "MCM";

        String actual = obj.intToRoman(num);
        assertEquals(expected, actual);
    }

    @Test
    void n1500() {
        int    num      = 1500;
        String expected = "MD";

        String actual = obj.intToRoman(num);
        assertEquals(expected, actual);
    }

    @Test
    void n2000() {
        int    num      = 2000;
        String expected = "MM";

        String actual = obj.intToRoman(num);
        assertEquals(expected, actual);
    }
}