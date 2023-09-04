package solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _12_IntegerToRomanTest {

    private _12_IntegerToRoman obj;

    @BeforeEach
    void setUp() {
        obj = new _12_IntegerToRoman();
    }


    @ParameterizedTest
    @CsvSource(value = {
            "2000, MM",
            "1994, MCMXCIV",
            "1700, MDCC",
            "1500, MD",
            "1400, MCD",
            "1100, MC",
            "1000, M",
            "900, CM",
            "800, DCCC",
            "500, D",
            "400, CD",
            "100, C",
            "90, XC",
            "60, LX",
            "50, L",
            "40, XL",
            "10, X",
            "9, IX",
            "6, VI",
            "5, V",
            "4, IV",
            "3, III",
            "1, I"
    })
    void intToRoman(int num, String expected) {
        assertEquals(expected, obj.intToRoman(num));
    }
}