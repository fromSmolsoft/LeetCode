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
public class N273_IntegerToEnglishWords {

    /**
     * Runtime 5ms,    Beats 70.17% of users with Java <p>
     * Memory 42.23MB, Beats 8.03% of users with Java <p>
     */
    public String numberToWords(int num) {

        //zero
        if (num == 0) {
            return "Zero";
        }
        //dictionary
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


        // billions
        int bills = num / 1000000000;
        num %= 1000000000;

        //millions
        int     mils      = num / 1000000;
        boolean isMillion = (mils > 0);
        num %= 1000000;
        int hundredsOfMills = 0;
        int tensOfMills     = 0;

        if (isMillion) {
            hundredsOfMills = mils / 100;
            mils %= 100;
            if (mils > 19) {
                tensOfMills = mils / 10;
                mils %= 10;
            }
        }

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
        if (num > 19) {
            tens = num / 10;
            num %= 10;
        }
        int ones = num;

        //String concatenation
        StringJoiner res = new StringJoiner(" ");
        //billions
        if (bills > 0) res.add(dictionary.get(bills)).add(dictionary.get(1000000000));

        //millions
        if (isMillion) {
            if (hundredsOfMills > 0) res.add(dictionary.get(hundredsOfMills)).add(dictionary.get(100));
            if (tensOfMills > 0) res.add(dictionary.get(tensOfMills * 10));
            if (mils > 0) res.add(dictionary.get(mils));
            res.add(dictionary.get(1000000));
        }

        //thousands
        if (isThousand) {
            if (hundredsOfThousands > 0) res.add(dictionary.get(hundredsOfThousands)).add(dictionary.get(100));
            if (tensOfThousands > 0) res.add(dictionary.get(tensOfThousands * 10));
            if (thousands > 0) res.add(dictionary.get(thousands));
            res.add(dictionary.get(1000));
        }
        //hundreds
        if (hundreds > 0) res.add(dictionary.get(hundreds)).add(dictionary.get(100));

        //tens
        if (tens > 0) res.add(dictionary.get(tens * 10));
        if (ones > 0) res.add(dictionary.get(ones));

        return res.toString();
    }

}
