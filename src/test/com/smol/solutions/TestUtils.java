package com.smol.solutions;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {


    /** Trims then removes either single or double quotes from each String [] strings */
    private static void removeQuotesStrArr(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            String element = strings[i].trim();
            if (element.startsWith("\'") && element.endsWith("\'") || element.startsWith("\"") && element.endsWith("\""))
                element = element.substring(1, element.length() - 1);
            strings[i] = (element);
        }
    }

    public int[] StringToIntArray(String s, String delimiter) {
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

    public String[] StringToStringArray(String s, String delimiter) {
        if (s == null) return new String[]{};
        return s.split(delimiter, -1);
    }

    public List<String> StringToStringList(String s, String delimiter) {
        return List.of(s.split(delimiter, -1));

    }

    /**
     * @param s string to be split
     * @param delimiter
     * @param removeQuotes  any value triggers removal of either single or double quotes
     * @return list of strings
     */
    public List<String> StringToStringList(String s, String delimiter, int removeQuotes) {
        String[] split = StringToStringArray(s, delimiter);
        removeQuotesStrArr(split);
        return List.of(split);
    }

    public List<Integer> StringToIntList(String s, String delimiter) {
        if (s == null || s.isEmpty()) return new ArrayList<>();
        String[]      strings = s.split(delimiter, -1);
        int           l       = strings.length;
        List<Integer> result  = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            String temp = strings[i];
            if (!temp.isEmpty())
                result.add(Integer.parseInt(temp));
        }
        return result;


    }
}
