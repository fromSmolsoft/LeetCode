package com.smol.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N0412_FizzBuzzTest {

    @ParameterizedTest
    @CsvSource(value = {
            "15, 1|2|Fizz|4|Buzz|Fizz|7|8|Fizz|Buzz|11|Fizz|13|14|FizzBuzz",
            "3, 1|2|Fizz",
            "5, 1|2|Fizz|4|Buzz"
    })
    void fizzBuzz(int n, String expected) {
        List<String> actualList   = new N0412_FizzBuzz().fizzBuzz(n);
        List<String> expectedList = Arrays.asList(expected.split("\\|"));
        assertEquals(expectedList, actualList);
    }

}