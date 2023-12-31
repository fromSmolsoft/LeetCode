package com.smol.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N0383_RansomNoteTest {


    @ParameterizedTest
    @CsvSource(value = {
            "aa, aab, true",
            "aa, ab, false",
            "fihjjjjei, hjibagacbhadfaefdjaeaebgi, false"
    })
    void canConstruct(String ransomNote, String magazine, boolean expected) {
        N0383_RansomNote obj = new N0383_RansomNote();
        assertEquals(expected, obj.canConstruct(ransomNote, magazine));
        assertEquals(expected, obj.canConstructASCII(ransomNote, magazine));
    }
}