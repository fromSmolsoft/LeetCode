package com.smol.solutions;

import java.util.Arrays;
import java.util.List;

public class TestUtils {


    public int[] convertStringToIntArray(String s, String delimiter) {
        String[] strings = s.split(delimiter);
        return Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
    }


    public String[] convertStringToStringArray(String s, String delimiter) {
        String[] strings = s.split(delimiter);
        return strings;
    }

    public List<String> convertStringToList(String s, String delimiter) {
        return List.of(s.split(delimiter));
    }
}
