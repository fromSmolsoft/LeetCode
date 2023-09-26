package com.smol.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * <h1>202. Happy Number</h1>
 * Easy     <p>
 * Write an algorithm to determine if a number n is happy.      <p>
 * A happy number is a number defined by the following process:     <p>
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.      <p>
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.        <p>
 * Those numbers for which this process ends in 1 are happy.        <p>
 * Return true if n is a happy number, and false if not.        <p>
 * <p>
 * Example 1:       <p>
 * Input: n = 19        <p>
 * Output: true     <p>
 * Explanation:     <p>
 * 1² + 9² = 82     <p>
 * 8² + 2² = 68     <p>
 * 6² + 8² = 100        <p>
 * 1² + 0² + 0² = 1     <p>
 * <p>
 * Example 2:       <p>
 * Input: n = 2     <p>
 * Output: false        <p>
 * <p>
 * Constraints:     <p>
 * 1 <= n <= 2³¹ - 1        <p>
 */
public class N0202_HappyNumber {


    /**
     * <h1>Set of seen numbers</h1>
     * Runtime 1ms, Beats 85.98%of users with Java      <p>
     * Memory  39.82MB, Beats 25.80%of users with Java      <p>
     * <p>
     * Saves seen numbers.  <p>
     * If a number is seen for the first time, it is added to the set   <p>
     * If any number is seen twice, it means that endless loop exists and it is not a happy number. <p>
     * <p>
     * Repeats the process until the number equals 1    <p>
     */
    public boolean isHappy01(int n) {
        //set to keep track of seen numbers
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = squareSumDigits(n);
        }
        return n == 1;
    }

    /**
     * <h1>"Floyd's cycle-finding algorithm"</h1>
     * Runtime 1ms, Beats 85.98%of users with Java      <p>
     * Memory 39.53MB, Beats 50.60%of users with Java       <p>
     * <p>
     * also known as "Tortoise and the Hare algorithm"      <p>
     * two pointers: slow and fast, slow computes once and fast computes twice at a time
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = squareSumDigits(slow); //computes once
            fast = squareSumDigits(squareSumDigits(fast)); //computes twice
            if (slow == 1) return true; //it's happy number and there's no endless loop
        } while (slow != fast); // repeat until slow and fast are equal = endless loop
        return false; //endless loop
    }

    /**
     * <h1>Square sum of digits</h1>
     * helper method <p>
     * divides number into single digits, squares each one of them and sums them
     */
    private int squareSumDigits(int n) {
        int sum = 0;
        while (n != 0) {
            int singleDigit = n % 10;
            sum += singleDigit * singleDigit;
            n /= 10;
        }
        return sum;
    }
}
