package com.smol.solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>150. Evaluate Reverse Polish Notation</h1>
 * Medium #Array #Math #Stack
 * <p>
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * <p>
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * <p>
 * Note that:   <p>
 * - The valid operators are '+', '-', '*', and '/'.   <p>
 * - Each operand may be an integer or another expression. <p>
 * - The division between two integers always truncates toward zero.   <p>
 * - There will not be any division by zero.   <p>
 * - The input represents a valid arithmetic expression in a reverse polish notation.  <p>
 * - The answer and all the intermediate calculations can be represented in a 32-bit integer.  <p>
 *
 * <pre>
 * Example 1:
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 *
 * Example 2:
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 *
 * Example 3:
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 * Constraints:
 *     1 <= tokens.length <= 104
 *     tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 * </pre>
 */
public class N0150_EvaluateReversePolishNotation {

    /**
     * <h2>ArrayDeque as stack</h2>
     * #stack #Deque <p>
     * Loop for all tokens as follows:<p>
     * - if token is digit -> stores it into stack <p>
     * - If token is operator -> retrieves 2 digits from top of the stack, switches their order, applies math of the operator, stores resul into the stack.     <p>
     * Final result is digit on top of the stack (and presumably only digit in the stuck if input was valid)
     * <pre>
     * Runtime 5 ms Beats 97.45% of users with Java
     * Memory 43.14MB Beats 58.41% of users with Java
     * </pre>
     * @return int calculated from tokens.
     */
    public int evalRPN(String[] tokens) {
        Deque<Integer> nums = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i].equals("+")) {
                nums.addFirst(nums.pollFirst() + nums.pollFirst());

            } else if (tokens[i].equals("-")) {
                nums.addFirst(-nums.pollFirst() + nums.pollFirst());

            } else if (tokens[i].equals("*")) {
                nums.addFirst(nums.pollFirst() * nums.pollFirst());

            } else if (tokens[i].equals("/")) {
                int b = nums.pollFirst();
                int a = nums.pollFirst();
                nums.addFirst(a / b);

            } else {
                nums.addFirst(Integer.valueOf(tokens[i]));
            }
        }
        return nums.pollFirst();
    }

    /** <h2>Array, no Stack</h2> */
    public int evalRPNNoStack(String[] tokens) {
        int[] ls = new int[tokens.length / 2 + 1];
        int index = 0;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    ls[index - 2] = ls[index - 2] + ls[index - 1];
                    index--;
                    break;
                case "-":
                    ls[index - 2] = ls[index - 2] - ls[index - 1];
                    index--;
                    break;
                case "*":
                    ls[index - 2] = ls[index - 2] * ls[index - 1];
                    index--;
                    break;
                case "/":
                    ls[index - 2] = ls[index - 2] / ls[index - 1];
                    index--;
                    break;
                default:
                    ls[index++] = Integer.parseInt(token);
                    break;
            }
        }
        return ls[0];
    }
}
