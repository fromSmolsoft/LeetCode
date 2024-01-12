package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class N1420_ArrayMaximumExactlyKComparisonsTest {

    final N1420_ArrayMaximumExactlyKComparisons obj = new N1420_ArrayMaximumExactlyKComparisons();

    @DisplayName("There are/is:")
    @ParameterizedTest
    @CsvSource(value = {
            /*name              exp  n  m   k*/
            " multiple arrays:,  6,  2, 3,  1",
            " no array       :,  0,  5, 2,  3",
            " single array   :,  1,  9, 1,  1",
    })
    void numOfArrays(String desc, int exp, int n, int m, int k) {
        int actual = obj.numOfArrays(n, m, k);
        Assertions.assertEquals(exp,actual,desc);
    }
}