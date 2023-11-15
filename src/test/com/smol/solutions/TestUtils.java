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

    /**
     * Trims then removes specified char from each end of each string <p>
     * - For "paired" symbols like brackets and quotes it is required to input both left and right variants <p>
     * - Order has to follow exactly the one in the data e.g. to remove {} and []  in {[word]} params have to be: char... {,[,],} <p>
     * - Chars are removed from both ends so e.g. single quote or letter will be removed from both ends each time they are in params <p>
     * - Some characters have to be escaped according to the Java rules  \.[]{}()<>*+-=!?^$| <p>
     */
    public static void removeCharsFromStrings(String[] strings, String... remove) {
        for (int i = 0; i < strings.length; i++) {

            String element = strings[i];
            for (String c : remove) {

                element = element.trim();
                if (element.startsWith(c)) element = element.substring(1);
                if (element.endsWith(c)) element = element.substring(0, element.length() - 1);

            }

            strings[i] = element;
        }
    }


    public static int[] StringToIntArray(String s, String delimiter) {
        if (s == null || s.isEmpty()) return new int[]{};
        String[] strings = s.split(delimiter, -1);
        int l = strings.length;
        int[] result = new int[l];

        for (int i = 0; i < l; i++) {
            String temp = strings[i];
            if (!temp.isEmpty())
                result[i] = Integer.parseInt(temp);
        }
        return result;
    }

    public static String[] StringToStringArray(String s, String delimiter) {
        if (s == null) return new String[]{};
        return s.split(delimiter, -1);
    }

    public static List<String> StringToStringList(String s, String delimiter) {
        if (s == null || s.isEmpty()) return new ArrayList<>();
        return List.of(s.split(delimiter, -1));

    }

    /**
     * @param s            string to be split
     * @param delimiter
     * @param removeQuotes any value triggers removal of either single or double quotes
     * @return list of strings
     */
    public static List<String> StringToStringList(String s, String delimiter, int removeQuotes) {
        if (s == null || s.isEmpty()) return new ArrayList<>();
        String[] split = StringToStringArray(s, delimiter);
        removeQuotesStrArr(split);
        return List.of(split);
    }

    public static List<Integer> StringToIntList(String s, String delimiter) {
        if (s == null || s.isEmpty()) return new ArrayList<>();
        String[] strings = s.split(delimiter, -1);
        int l = strings.length;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            String temp = strings[i];
            if (!temp.isEmpty())
                result.add(Integer.parseInt(temp));
        }
        return result;


    }
}
