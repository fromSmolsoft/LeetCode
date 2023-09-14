package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N0020_ValidParenthesesTest {

    @ParameterizedTest
    @CsvSource(value = {
            "true, ()",
            "true, ()[]{}",
            "false, (]",
            "true, ([])",
            "false, ({)}",
            "false, void public (){[ int a = 5 }",
            "false, [",
            "false, ]"
    })
    void isValid(boolean expected, String input) {
        Assertions.assertEquals(expected, new N0020_ValidParentheses().isValid(input));
    }
}