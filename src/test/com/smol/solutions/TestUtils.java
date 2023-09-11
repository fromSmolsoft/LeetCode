package com.smol.solutions;

import java.util.Arrays;

public class TestUtils {


    public  int[] convertStringToArray(String s, String delimiter) {
        String[] strings = s.split(delimiter);
        return Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
    }
}
