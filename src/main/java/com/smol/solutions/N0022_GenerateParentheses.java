package com.smol.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>22. Generate Parentheses</h1> <p>
 * Medium <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses. <p>
 * <p>
 * Example 1: <p>
 * Input: n = 3 <p>
 * Output: ["((()))","(()())","(())()","()(())","()()()"] <p>
 * <p>
 * Example 2: <p>
 * Input: n = 1 <p>
 * Output: ["()"] <p>
 * <p>
 * Constraints: <p>
 * 1 <= n <= 8 <p>
 */
public class N0022_GenerateParentheses {


    /**
     * <h1>Recursion backtracking</h1>
     * example n=2:
     * <pre>
     *   {@code
     *   								   	(0, 0, '')
     *   								 	    |
     *   									(1, 0, '(')
     *   								   /           \
     *   							(2, 0, '((')      (1, 1, '()')
     *   							   /                 \
     *   						(2, 1, '(()')           (2, 1, '()(')
     *   						   /                       \
     *   					(2, 2, '(())')                (2, 2, '()()')
     *   						      |                                 |
     *   					res.append('(())')             res.append('()()')
     *   }
     *   </pre>
     * <p>
     * Runtime  1ms, Beats 90.67%of users with Java     <p>
     * Memory 43.49MB, Beats 50.13%of users with Java   <p>
     * @param n number of parenthesis pairs
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        if (open < max) backtrack(list, str + "(", open + 1, close, max);
        if (close < open) backtrack(list, str + ")", open, close + 1, max);
    }

    /** Recursion - subtraction from count of parents */
    public List<String> generateParenthesis02(int n) {
        List<String> list = new ArrayList<>();
        recursion(list, n, 0, "");
        return list;
    }

    private void recursion(List<String> list, int left, int right, String s) {
        if (left == 0 && right == 0) {
            list.add(s);
            return;
        }

        if (left > 0) recursion(list, left - 1, right + 1, s + "(");
        if (right > 0) recursion(list, left, right - 1, s + ")");
    }
}
