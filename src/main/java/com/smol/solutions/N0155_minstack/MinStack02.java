package com.smol.solutions.N0155_minstack;

import java.util.Stack;

/**
 * <h2>Stack, concise </h2>
 * #stack
 * stores old min value alongside pushed new value if new value is new min  <p>
 * when pop() is called first peek() if top of stack == min, if yes it pop() it out of stack and then again calls min= pop(), else it just pop() value  <p>
 */
public class MinStack02 implements MinStackInterface {

   private Stack<Integer> stack = new Stack<>();
   private int min = Integer.MAX_VALUE;

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.peek() == min) {
            stack.pop();
            min = stack.pop();
        } else stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

}