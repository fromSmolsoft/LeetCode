package com.smol.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N0012_IntegerToRomanTest {


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
        N0012_IntegerToRoman obj = new N0012_IntegerToRoman();

        Method[] method = N0012_IntegerToRoman.class.getDeclaredMethods();

       try {
            for (Method m : method) {
                if (m.getName().startsWith("intToRoman")) {
                    System.out.printf("method: " + m.getName());
                    String actual = (String) m.invoke(obj, num);
                    System.out.printf("->expected: %s, actual: %s\n", expected, actual);
                    assertEquals(expected, actual);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        assertEquals(expected, obj.intToRoman(num));

    }
}