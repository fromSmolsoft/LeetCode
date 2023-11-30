package com.smol.solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>224. Basic Calculator</h1>
 * Hard, #Math, #String, #Stack, #Recursion
 * <p>
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.  <p>
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().  <p>
 *
 * <pre>
 * Example 1:
 * Input: s = "1 + 1"
 * Output: 2
 *
 * Example 2:
 * Input: s = " 2-1 + 2 "
 * Output: 3
 *
 * Example 3:
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 *
 * Constraints:
 *     1 <= s.length <= 3 * 105
 *     s consists of digits, '+', '-', '(', ')', and ' '.
 *     s represents a valid expression.
 *     '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
 *     '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
 *     There will be no two consecutive operators in the input.
 *     Every number and running calculation will fit in a signed 32-bit integer.
 * </pre>
 */
public class N0224_BasicCalculator {
    
    /**
     * <h2> Iteration with Stack </h2>
     */
    public int calculate01(String s) {
        
        int res = 0;            // last known result
        int number = 0;         // previous number
        int sign = 1;           // operator logic 1/-1
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                number = 10 * number + (c - '0'); // store digit and combine it with previous number for multi-digits like `12`
            } else if (c == '+') {
                res += sign * number;
                number = 0;     // reset
                sign = 1;       // reset
            } else if (c == '-') {
                res += sign * number;
                number = 0;     // reset
                sign = -1;      // reset
            } else if (c == '(') {
                stack.push(res);    //save result before parentheses
                stack.push(sign);   //save sign calculated before parentheses
                sign = 1;           //reset
                res = 0;            //reset
            } else if (c == ')') {
                res += sign * number;//update result
                number = 0;         //reset
                res *= stack.pop(); //sign before parentheses
                res += stack.pop(); // result calculated before parentheses
            }
            
        }
        if (number != 0) res += sign * number;
        return res;
    }
    
    /**
     * <h2> Iteration with Stack v2</h2>
     */
    public int calculate02(String s) {
        if (s == null) return 0;
        
        int result = 0;
        int sign = 1;
        int num = 0;
        
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(sign);
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
                
            } else if (c == '+' || c == '-') {
                result += sign * num;
                sign = stack.peek() * (c == '+' ? 1 : -1);
                num = 0;
                
            } else if (c == '(') {
                stack.push(sign);
                
            } else if (c == ')') {
                stack.pop();
            }
        }
        
        result += sign * num;
        return result;
    }
    
    /** <h2>Recursion</h2> */
    public int calculate03(String s) {
        if (s.length() == 0) return 0;
        s = "(" + s + ")";
        int[] p = {0};
        return eval(s, p);
    }
    
    /**
     * <h3>Recursion helper method</h3>
     * Calculates value between parentheses.
     */
    private int eval(String s, int[] p) {
        int val = 0;
        int i = p[0];
        int oper = 1; //1:+ -1:-
        int num = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            switch (c) {
                case '+' -> {
                    val = val + oper * num;
                    num = 0;
                    oper = 1;
                    i++;
                }// end of number and set operator
                case '-' -> {
                    val = val + oper * num;
                    num = 0;
                    oper = -1;
                    i++;
                }// end of number and set operator
                case '(' -> {
                    p[0] = i + 1;
                    val = val + oper * eval(s, p);
                    i = p[0];
                } // start a new eval
                case ')' -> {
                    p[0] = i + 1;
                    return val + oper * num; // end current eval and return. Note that we need to deal with the last num
                }
                case ' ' -> {
                    i++;
                    continue;
                }
                default -> {
                    num = num * 10 + c - '0';
                    i++;
                }
            }
        }
        return val;
    }
}