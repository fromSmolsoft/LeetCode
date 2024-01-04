package com.smol.solutions.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Allows parsing of Strings into their corresponding values and related operations.
 */
public class TUtils {
    
    /**
     * Uses Refection.
     * Filters methods with according to the name.
     */
    public static List<Method> reflectMethods(Class clazz, String filter) {
        return Arrays.stream(clazz.getMethods())
                .filter(m -> m.getName().contains(filter))
                .toList();
    }
    
    /**
     * Uses Refection.
     * Filters methods with according to the name and number of parameters.
     * @param paramTypes Class[] types = array of classes that are used as params.
     * @param clazz      Class to look for methods in
     * @param filter     name of method contains
     */
    public static List<Method> reflectMethods(Class clazz, String filter, Class<?>[] paramTypes) {
        return Arrays.stream(clazz.getMethods())
                .filter(m -> {
                    if (m.getName().contains(filter)) {
                        Class<?>[] mTypes = m.getParameterTypes();
                        if (mTypes.length == paramTypes.length) {
                            // return IntStream.range(0, mTypes.length).allMatch(i -> mTypes[i].equals(paramTypes[i]));
                            return true;
                        }
                    }
                    return false;
                })
                .toList();
    }
    
    /**
     * Uses Refection.
     * Filters methods with according to the name.
     */
    public static List<Method> reflectMethods(Object obj, String filter) {
        return Arrays.stream(obj.getClass().getMethods())
                .filter(m -> m.getName().contains(filter))
                .toList();
    }
    
    /**
     * Converts a string representation of a matrix into a 2D integer array.
     * @param stringMatrix the string representation of the matrix
     * @param outerDelim   the delimiter used to separate the outer elements of the matrix
     * @param innerDelim   the delimiter used to separate the inner elements of the matrix
     * @param remove       the substrings to be removed from each element of the matrix
     * @return the 2D integer array representation of the matrix
     */
    public static int[][] stringToMatrix(String stringMatrix, String outerDelim, String innerDelim, String... remove) {
        String[] temp = TUtils.StringToStringArray(stringMatrix, outerDelim);
        int[][] matrix = new int[temp.length][];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = TUtils.removeSubStrings(temp[i], remove);
            int[] subArray = TUtils.StringToIntArray(temp[i], innerDelim);
            matrix[i] = subArray;
        }
        return matrix;
    }
    
    /**
     * Converts a string representation of a matrix into a two-dimensional string array.
     * @param stringMatrix the string representation of the matrix
     * @param outerDelim   the delimiter used to separate outer elements of the matrix
     * @param innerDelim   the delimiter used to separate inner elements of the matrix
     * @param remove       the substrings to be removed from each outer element of the matrix
     * @return the two-dimensional string array representation of the matrix
     */
    public static String[][] stringToStringMatrix(String stringMatrix, String outerDelim, String innerDelim, String...
            remove) {
        String[] temp = TUtils.StringToStringArray(stringMatrix, outerDelim);
        String[][] matrix = new String[temp.length][];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = TUtils.removeSubStrings(temp[i], remove);
            String[] subArray = TUtils.StringToStringArray(temp[i], innerDelim);
            matrix[i] = subArray;
        }
        return matrix;
    }
    
    /**
     * Copies a 2D array.
     * @param matrix the matrix to be copied
     * @return the copy of the matrix
     */
    public static int[][] copy2DArray(int[][] matrix) {
        int[][] copy = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            copy[i] = new int[matrix[i].length];
            
            for (int j = 0; j < matrix[i].length; j++) copy[i][j] = matrix[i][j];
        }
        return copy;
    }
    
    /**
     * Prints single digits 2d array.
     * @return 2D integer array as matrix without brackets and other symbols etc
     */
    public static String print2DArray(int[][] matrix) {
        int m = matrix.length;
        StringBuilder builder = new StringBuilder(m * matrix[0].length * 2 + m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < matrix[i].length; j++) builder.append(" ").append(matrix[i][j]);
            builder.append("\n");
        }
        return builder.substring(0, builder.length() - 1);
    }
    
    /**
     *Generates a string representation of matrices from a list of matrices, side by side in horizontal .   <p>
     * Suitable only for single digit values within matrices.   <p>
     * Too many matrices may lead to console wrapping.  <p>
     * @param listOfMatrices  a list of matrices
     * @return String with matrices printed side by side
     */
    public static String printMatricesHorisont(List<int[][]> listOfMatrices) {
        
        int length = 0;
        for (int[][] r : listOfMatrices) {
            length = Math.max(length, r.length);
        }
        
        int i = 0;
        StringBuilder bd = new StringBuilder();
        while (length > i) {
            for (int[][] m : listOfMatrices) {
                if (i < m.length) {
                    for (int j = 0; j < m[i].length; j++) bd.append(" ").append(m[i][j]);
                    bd.append("\t");
                } else bd.append("  ".repeat(m[0].length)).append("\t");
            }
            i++;
            bd.append("\n");
        }
        return bd.substring(0, bd.length() - 1);
        
        
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
        if (from == null) return null;
        else if (remove == null) return from;
        
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
        return from.replaceAll(remove, "");
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
     * @return Integer array. Can include `null` values
     * @throws NumberFormatException - if the string does not contain a parsable integer.
     */
    public static Integer[] StringToIntegerArray(String s, String delimiter) {
        if (s == null || s.isEmpty()) return new Integer[]{};
        String[] strings = s.split(delimiter, -1);
        int l = strings.length;
        Integer[] result = new Integer[l];
        
        for (int i = 0; i < l; i++) {
            String temp = strings[i];
            if (!temp.isEmpty())
                if (temp.equals("null")) result[i] = null;
                else result[i] = Integer.parseInt(temp);
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
    
    /**
     * Convert a given string to a string array using a specified delimiter.
     * @param s         the string to be converted
     * @param delimiter the delimiter to split the string
     * @return the resulting string array
     */
    public static String[] StringToStringArray(String s, String delimiter) {
        if (s == null) return new String[]{};
        return s.split(delimiter, -1);
    }
    
    /**
     * Converts a string into a list of strings using a delimiter.
     * @param s         the string to be converted
     * @param delimiter the delimiter used to split the string
     * @return a list of strings obtained by splitting the input string using the delimiter
     */
    public static List<String> StringToStringList(String s, String delimiter) {
        if (s == null || s.isEmpty()) return new ArrayList<>();
        return List.of(s.split(delimiter, -1));
    }
    
    /**
     * Converts a given string into a list of integers using a specified delimiter.
     * @param s         the string to be converted
     * @param delimiter the delimiter used to split the string
     * @return the list of integers extracted from the string
     */
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
