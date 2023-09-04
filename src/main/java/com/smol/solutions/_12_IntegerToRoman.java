package com.smol.solutions;

/**
 * <h1>12. Integer to Roman</h1>
 * Medium
 * <p>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value   <p>
 * I             1      <p>
 * V             5      <p>
 * X             10     <p>
 * L             50     <p>
 * C             100    <p>
 * D             500    <p>
 * M             1000   <p>
 * <p>
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II. <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used: <p>
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9. <p>
 * X can be placed before L (50) and C (100) to make 40 and 90. <p>
 * C can be placed before D (500) and M (1000) to make 400 and 900. <p>
 * <p>
 * Given an integer, convert it to a roman numeral.
 * <p>
 * Example 1: <p>
 * Input: num = 3 ;
 * Output: "III" ; <p>
 * Explanation: 3 is represented as 3 ones.
 * <p>
 * Example 2: <p>
 * Input: num = 58;
 * Output: "LVIII"; <p>
 * Explanation: L = 50, V = 5, III = 3.
 * <p>
 * Example 3: <p>
 * Input: num = 1994;
 * Output: "MCMXCIV"; <p>
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * <p>
 * Constraints:    1 <= num <= 3999
 */
public class _12_IntegerToRoman {
    /**
     * Runtime 3ms; Beats 98.70% of users with Java
     * Memory 43.24MB; Beats 66.83% of users with Java
     */
    public String intToRoman(int num) {

        StringBuilder roman = new StringBuilder();

        // 1000+ - > M
        int thousands = num / 1000;
        if (thousands > 0) {
            num = num - (1000 * thousands);
            roman.append("M".repeat(thousands));
        }

        // 100+ - > D || C
        int hundreds = num / 100;
        //90
        if (hundreds >= 9) {
            roman.append("CM");
            //60-80
        } else if (hundreds > 5) {
            roman.append("D");
            int i = hundreds - 5;
            roman.append("C".repeat(i));
            //50
        } else if (hundreds == 5) {
            roman.append("D");
            //40
        } else if (hundreds == 4) {
            roman.append("CD");
            //10-30
        } else {
            roman.append("C".repeat(hundreds));
        }
        num = num - (hundreds * 100);

        // 10+ - > L || X
        int ten = num / 10;
        if (ten >= 9) {
            roman.append("XC");
        } else if (ten > 5) {
            roman.append("L");
            int i = ten - 5;
            roman.append("X".repeat(i));
        } else if (ten == 5) {
            roman.append("L");
        } else if (ten == 4) {
            roman.append("XL");
        } else {
            roman.append("X".repeat(ten));
        }
        num = num - (ten * 10);

        // 1+ - > V || I
        int one = num;
        if (one >= 9) {
            roman.append("IX");
        } else if (one > 5) {
            roman.append("V");
            int i = one - 5;
            roman.append("I".repeat(i));
        } else if (one == 5) {
            roman.append("V");
        } else if (one == 4) {
            roman.append("IV");
        } else {
            roman.append("I".repeat(one));
        }
        return roman.toString();
    }


    /**
     *
     */
    public String intToRoman02(int num) {

        int[]    values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs   = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}
