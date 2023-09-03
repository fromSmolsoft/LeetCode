package solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _13_RomanToIntegerTest {
    private _13_RomanToInteger obj;

    @BeforeEach
    void setUp() {

        obj = new _13_RomanToInteger();
    }

    /**
     * Input: s = "III";
     * Output: 3;
     * Explanation: III = 3;
     */
    @Test
    void III() {
        String input    = "III";
        int    expected = 3;
        int    actual   = obj.romanToInt(input);
        assertEquals(expected, actual);
    }

    /**
     * Input: s = "LVIII";
     * Output: 58;
     * Explanation: L = 50, V= 5, III = 3.
     */
    @Test
    void LVIII() {
        String input    = "LVIII";
        int    expected = 58;
        int    actual   = obj.romanToInt(input);
        assertEquals(expected, actual);
    }

    /**
     * Input: s = "MCMXCIV";
     * Output: 1994;
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */
    @Test
    void MCMXCIV() {
        String input    = "MCMXCIV";
        int    expected = 1994;
        int    actual   = obj.romanToInt(input);
        assertEquals(expected, actual);
    }
    /**
     * Input: s = "CDXLIV";
     * Output: 1994;
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */
    @Test
    void CDXLIV() {
        String input    = "CDXLIV";
        int    expected = 444;
        int    actual   = obj.romanToInt(input);
        assertEquals(expected, actual);
    }

    /**
     * Input: s = "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMCMXCIX";
     * Output: 99999;
     */
    @Test
    void longNumber() {
        String input    = "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMCMXCIX";
        int    expected = 99999;
        int    actual   = obj.romanToInt(input);
        assertEquals(expected, actual);
    }
}