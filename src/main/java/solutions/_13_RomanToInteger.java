package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>13. Roman to Integer
 * </h1>
 * <p>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol   Value   <p>
 * I         1      <p>
 * V         5      <p>
 * X         10     <p>
 * L         50     <p>
 * C         100    <p>
 * D         500    <p>
 * M         1000   <p>
 * <p>
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * <p>
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 15 <p>
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M'). <p>
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999]. <p>
 */
public class _13_RomanToInteger {

    /**
     * Runtime 4ms Beats 75.88%of users with Java <p>
     * Memory 43.63MB Beats 64.29%of users with Java <p>
     */
    public int romanToInt(String s) {
        //create hashmap fo roman numerals
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        // initialize helper variables
        int length   = s.length();
        int previous = 0;
        int result   = 0;
        //iterate through the string from end to start
        for (int i = length - 1; i >= 0; i--) {
            int value = map.get(s.charAt(i));
            //compare current and previous values
            if (previous <= value) {
                result += value;
            } else {
                result -= previous;
                result += (previous - value);
            }
            previous = value;
        }
        return result;
    }
}
