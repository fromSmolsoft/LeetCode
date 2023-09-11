package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N2810_FaultyKeyboardTest {

    @ParameterizedTest
    @CsvSource(value = {
            "string,    rtsng",
            "poiinter,  ponter",
            "biiiiiia,  ba",
            "ahoj,      ahoj"
    })
    void finalString(String s, String expected) {
        Assertions.assertEquals(expected, (new N2810_FaultyKeyboard()).finalString(s));
    }
}