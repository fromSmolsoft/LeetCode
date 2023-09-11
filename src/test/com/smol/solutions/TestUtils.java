package com.smol.solutions;

import java.util.Arrays;

public class TestUtils {


    public int[] convertStringToIntArray(String s, String delimiter) {
        String[] strings = s.split(delimiter);
        return Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
    }


    public String[] convertStringToIntStringArray(String s, String delimiter) {
        String[] strings = s.split(delimiter);
        return strings;
    }
}
