package com.smol.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

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
        dictionary.put(1000000000, "Billion");

        //todo bills and hundreds and thousands of mills
        int mils = num / 1000000;
        num %= 1000000;

        //thousands
        int     thousands  = num / 1000;
        boolean isThousand = (thousands > 0);
        num %= 1000;
        int hundredsOfThousands = 0;
        int tensOfThousands     = 0;

        if (isThousand) {
            hundredsOfThousands = thousands / 100;
            thousands %= 100;
            if (thousands > 19) {
                tensOfThousands = thousands / 10;
                thousands %= 10;
            }
        }

        //hundreds
        int hundreds = num / 100;
        num %= 100;

        //tens
        int tens = 0;
        int ones;
        if (num > 19) {
            tens = num / 10;
            num %= 10;
        }
        ones = num;

        StringJoiner res = new StringJoiner(" ");
        if (mils > 0) {
            res.add(dictionary.get(mils)).add(dictionary.get(1000000));
        }
        //thousands
        if (isThousand) {
            if (hundredsOfThousands > 0) {
                res.add(dictionary.get(hundredsOfThousands)).add(dictionary.get(100));
            }

            if (tensOfThousands > 0) {
                res.add(dictionary.get(tensOfThousands * 10));
            }
            if (thousands > 0) {
                res.add(dictionary.get(thousands));
            }

            res.add(dictionary.get(1000));
        }
        if (hundreds > 0) {
            res.add(dictionary.get(hundreds)).add(dictionary.get(100));
        }

        //fixme Ten Two -> twelve
        if (tens > 0) {
            res.add(dictionary.get(tens * 10));
        }
        if (ones > 0) {
            res.add(dictionary.get(ones));
        }

        return res.toString();
    }

}
