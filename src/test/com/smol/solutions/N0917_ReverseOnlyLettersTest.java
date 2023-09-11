package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0917_ReverseOnlyLettersTest {

    @ParameterizedTest
    @CsvSource(value = {
            "ab-cd,                 dc-ba",
            "a-bC-dEf-ghIj,         j-Ih-gfE-dCba",
            "Test1ng-Leet=code-Q!,  Qedo1ct-eeLg=ntse-T!",
            "1abc, 1cba"
    })
    void tereverseOnlyLettersst(String s, String expected) {
        Assertions.assertEquals(expected, new N0917_ReverseOnlyLetters().reverseOnlyLetters(s));
    }
}