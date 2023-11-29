package com.smol.solutions.N0155_minstack;

import java.util.LinkedList;

/**
 * @author <a href="https://leetcode.com/problems/min-stack/solutions/3176175/solution/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
class MinStack03 implements MinStackInterface {

    LinkedList<TplusMin> stack;

    public MinStack03() {
        stack = new LinkedList<>();
    }

    public void push(int val) {
        int newMin;
        if (stack.size() == 0) {
            newMin = val;
        } else {
            int currentMin = stack.getFirst().min;
            newMin = val < currentMin ? val : currentMin;
        }
        stack.addFirst(new TplusMin(val, newMin));
    }

    public void pop() {
        stack.removeFirst();
    }

    public int top() {
        return stack.peekFirst().val;
    }

    public int getMin() {
        return stack.peekFirst().min;
    }

    private class TplusMin {
        int val;
        int min;

        public TplusMin(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}

