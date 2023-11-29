package com.smol.solutions.N0155_minstack;

import java.util.Stack;


/**
 * <h2>Stack of Pairs</h2>
 * #stack #pair
 */
class MinStack04 implements MinStackInterface {

    private Stack<Pair<Integer, Integer>> stack;

    public MinStack04() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Pair<>(val, val));
        } else {
            int min = Math.min(stack.peek().getValue(), val);
            stack.push(new Pair<>(val, min));
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.peek().getKey();
    }

    public int getMin() {
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.peek().getValue();
    }

    private class Pair<T, T1> {
        private T key;
        private T1 val;

        private Pair(T key, T1 val) {
            this.key = key;
            this.val = val;
        }

        public T getKey() {return key;}

        public T1 getValue() {return val;}
    }
}

