package com.smol.solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>20. Valid Parentheses</h1>
 * Easy <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. <p>
 * An input string is valid if: <p>
 * <p>
 * Open brackets must be closed by the same type of brackets. <p>
 * Open brackets must be closed in the correct order. <p>
 * Every close bracket has a corresponding open bracket of the same type. <p>
 * <p>
 * Example 1: <p>
 * Input: s = "()" <p>
 * Output: true <p>
 * <p>
 * Example 2: <p>
 * Input: s = "()[]{}" <p>
 * Output: true <p>
 * <p>
 * Example 3: <p>
 * Input: s = "(]" <p>
 * Output: false <p>
 * <p>
 * Constraints: <p>
 * 1 <= s.length <= 104 <p>
 * s consists of parentheses only '()[]{}'. <p>
 */
public class N0020_ValidParentheses {

    /**
     * Runtime 2ms,Beats 83.96%of users with Java   <p>
     * Memory 40.79MB, Beats 23.17%of users with Java   <p>
     */
    public boolean isValid(String s) {
        char[]         leftBrackets  = {'(', '{', '['};
        char[]         rightBrackets = {')', '}', ']'};
        char[]         chars         = s.toCharArray();
        Deque<Integer> stack         = new ArrayDeque<>();

        for (char c : chars) {
            for (int i = 0; i < leftBrackets.length; i++) {
                if (c == leftBrackets[i]) stack.addFirst(i);
                else if (c == rightBrackets[i]) {
                    if (stack.isEmpty() || stack.removeFirst() != i) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

}
