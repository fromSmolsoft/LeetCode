package com.smol.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>273. Integer to English Words
 * </h1>
 * Hard
 * 2.8K
 * 6K
 * Companies
 * <p>
 * Convert a non-negative integer num to its English words representation.
 * <p>
 * Example 1:
 * <p>
 * Input: num = 123;
 * Output: "One Hundred Twenty Three"
 * <p>
 * Example 2:
 * <p>
 * Input: num = 12345;
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * <p>
 * Example 3:
 * <p>
 * Input: num = 1234567;
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * <p>
 * Constraints:
 * <p>
 * 0 <= num <= 231 - 1
 */
public class n273_IntegerToEnglishWords {

    public String numberToWords(int num) {
        StringBuilder res = new StringBuilder();

        Map<Integer, String> dictionary = new HashMap<>();
        dictionary.put(0, "");
        dictionary.put(1, "One");
        dictionary.put(2, "Two");
        dictionary.put(3, "Three");
        dictionary.put(4, "Four");
        dictionary.put(5, "Five");
        dictionary.put(6, "Six");
        dictionary.put(7, "Seven");
        dictionary.put(8, "Eight");
        dictionary.put(9, "Nine");
        dictionary.put(10, "Ten");

        dictionary.put(11, "Eleven");
        dictionary.put(12, "Twelve");
        dictionary.put(13, "Thirteen");
        dictionary.put(14, "Fourteen");
        dictionary.put(15, "Fifteen");
        dictionary.put(16, "Sixteen");
        dictionary.put(17, "Seventeen");
        dictionary.put(18, "Eighteen");
        dictionary.put(19, "Nineteen");

        dictionary.put(20, "Twenty");
        dictionary.put(30, "Thirty");
        dictionary.put(40, "Forty");
        dictionary.put(50, "Fifty");
        dictionary.put(60, "Sixty");
        dictionary.put(70, "Seventy");
        dictionary.put(80, "Eighty");
        dictionary.put(90, "Ninety");
        dictionary.put(100, "Hundred");
        dictionary.put(1000, "Thousand");
        dictionary.put(1000000, "Million");

        //todo
        // logic e.g. 2000 -> 2000/1000 = 2  -> 2 = "two" + "thousand"

        return res.toString();
    }

}
