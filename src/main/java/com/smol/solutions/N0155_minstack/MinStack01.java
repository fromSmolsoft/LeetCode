package com.smol.solutions.N0155_minstack;

import java.util.LinkedList;

/**
 * <h2>LinkedList</h2>
 * #LinkedList
 * Uses LinkedList as stack <p>
 * when pop() is called, is popped value == min, iterates LinkedList to update min value
 * <pre>
 * Runtime  4 ms    Beats 98.26 % of users with Java
 * Memory 47.46 MB  Beats11.74% of users with Java
 * </pre>
 */
class MinStack01 implements MinStackInterface {

    private final LinkedList<Integer> stack;
    private int min;

    public MinStack01() {
        min = Integer.MAX_VALUE;
        stack = new LinkedList<>();
    }

    public void push(int val) {
        min = Math.min(min, val);
        stack.push(val);
    }

    public void pop() {
        if (!stack.isEmpty() && stack.pollFirst() == min) {
            min = Integer.MAX_VALUE;
            for (int i : stack) {
                min = Math.min(min, i);
            }
        }
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return min;
    }
}

