package com.smol.solutions;

import java.util.List;

public class TestUtils {


    public int[] convertStringToIntArray(String s, String delimiter) {
        if (s == null || s.isEmpty()) return new int[]{};
        String[] strings = s.split(delimiter, -1);
        int      l       = strings.length;
        int[]    result  = new int[l];

        for (int i = 0; i < l; i++) {

            String temp = strings[i];
            if (!temp.isEmpty())
                result[i] = Integer.parseInt(temp);
        }
        return result;
    }

    public String[] convertStringToStringArray(String s, String delimiter) {
        if (s == null) return new String[]{};
        return s.split(delimiter, -1);
    }

    public List<String> convertStringToList(String s, String delimiter) {
        return List.of(s.split(delimiter, -1));
    }
}
