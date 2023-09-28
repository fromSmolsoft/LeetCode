package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0009_PalindromeNumberTest {

    N0009_PalindromeNumber obj = new N0009_PalindromeNumber();


    @ParameterizedTest
    @CsvSource(value = {
            "true,  121",
            "true,  123454321",
            "false,  -121",
            "false, 123",
    })
    void isPalindrome(boolean expected, int num) {
        Assertions.assertEquals(expected, obj.isPalindrome(num));
    }

}