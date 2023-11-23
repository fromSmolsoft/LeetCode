package com.smol.solutions;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {


    public static int[][] copy2DArray(int[][] matrix) {
        int[][] copy = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            copy[i] = new int[matrix[i].length];

            for (int j = 0; j < matrix[i].length; j++) copy[i][j] = matrix[i][j];
        }
        return copy;
    }

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
    public static void trimStrings(String[] strings, String... remove) {
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

    /**
     * Trims ends then removes specified character sequences from each string <p>
     * @param strings array of strings that have characters to be removed from.
     * @param remove  Character sequences to be removed. Multiple sequences can be added. Certain characters must be escaped according to the Java rules  \.[]{}()<>*+-=!?^$| <p>
     */
    public static void removeSubStringsFromArray(String[] strings, String... remove) {
        for (int i = 0; i < strings.length; i++) {
            String element = strings[i];
            element = element.trim();
            for (String s : remove) {
                element = removeSubString(element, s);
            }
            strings[i] = element;
        }
    }

    /**
     * Trims ends then removes specified character sequences from each string <p>
     * @param from   string that have characters to be removed from.
     * @param remove Character sequences to be removed. Multiple sequences can be added. Certain characters must be escaped according to the Java rules  \.[]{}()<>*+-=!?^$| <p>
     */
    public static String removeSubStrings(String from, String... remove) {
        from = from.trim();
        for (String s : remove) {
            from = removeSubString(from, s);
        }
        return from;
    }


    /**
     * Removes characters sequence (String) from a String
     * @param from   String that has characters to be removed from.
     * @param remove Character sequence (String) to be removed
     * @return new String without removed characters
     */
    public static String removeSubString(String from, String remove) {
        StringBuilder builder = new StringBuilder(from.length());
        for (int i = 0; i < from.length(); i++) {
            if (remove.indexOf(from.charAt(i)) < 0) {
                builder.append(from.charAt(i));
            }
        }
        return builder.toString();
    }


    /**
     * @throws NumberFormatException - if the string does not contain a parsable integer.
     */
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

    /**
     * Parses values in String into character array.
     * @param s         input String has to only include single char followed by delimiter and so on.  All leading and trailing space will be removed.
     * @param delimiter can be multiple chars long e.g. `...`
     */
    public static char[] StringToCharArray(String s, String delimiter) {
        if (s == null || s.isEmpty()) return new char[]{};
        String[] strings = s.split(delimiter, -1);

        int l = strings.length;
        char[] result = new char[l];

        for (int i = 0; i < l; i++) {
            String temp = strings[i].trim();
            if (!temp.isEmpty()) result[i] = temp.charAt(0);
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
