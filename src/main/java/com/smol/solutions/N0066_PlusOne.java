package com.smol.solutions;

/**
 * <h1>66. Plus One</h1>
 * Easy <p>
 * <p>
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 * <p>
 * Increment the large integer by one and return the resulting array of digits.
 * <pre>
 *
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 *
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 *
 * Example 3:
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 *
 * Constraints:
 *     1 <= digits.length <= 100
 *     0 <= digits[i] <= 9
 *     digits does not contain any leading 0's.
 * </pre>
 */
public class N0066_PlusOne {

    /**
     * <pre>
     * Logic:
     * - increment last digit by 1
     * - loop to increment other digits according to the math rules
     *      e.g. [9]->[1,0], or [1,9,9]->[2,0,0]
     * - exit loop if nothing left to increment
     * - return original input array if length was enough, otherwise returns new extended array
     *
     * Runtime 0ms,     Beats 100.00%of users with Java
     * Memory 41.16MB,  Beats 16.31%of users with Java
     *
     * @return original input array if it was long enough, otherwise new extended array
     * </pre>
     */
    public int[] plusOne(int[] digits) {

        int addition = 0;
        int l        = digits.length - 1;

        digits[l]++;  //increments by 1

        for (int i = l; i >= 0; i--) {
            int temp = digits[i] + addition;

            if (temp <= 9) {
                digits[i] = temp;
                return digits;
            } else {
                addition = temp / 10;
                digits[i] = 0; // if increment was `> 1` it'd be `temp % 10;`

                //extends length of the array by 1 to prevent "index out of boundary"
                if (i == 0) {
                    int[] extended = new int[l + 2];
                    extended[0] = addition;
                    for (int j = 0; j <= l; j++) {
                        extended[j + 1] = digits[j];
                    }
                    digits = extended;
                }
            }
        }
        return digits;
    }

}
