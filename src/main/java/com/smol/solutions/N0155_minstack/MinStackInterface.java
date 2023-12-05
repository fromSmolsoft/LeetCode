package com.smol.solutions.N0155_minstack;

/**
 * <h1>155. Min Stack</h1>
 * Medium, #stack, #design
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.<p>
 * Implement the MinStack class: <p>
 * -   MinStack() initializes the stack object.     <p>
 * -   void push(int val) pushes the element val onto the stack.        <p>
 * -   void pop() removes the element on the top of the stack.      <p>
 * -   int top() gets the top element of the stack.     <p>
 * -   int getMin() retrieves the minimum element in the stack.     <p>
 * You must implement a solution with O(1) time complexity for each function.   <p>
 * <pre>
 * Example 1:
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 * </pre>
 * Constraints: <p>
 * ->   -231 <= val <= 231 - 1  <p>
 * ->   Methods pop, top and getMin operations will always be called on non-empty stacks.   <p>
 * ->   At most 3 * 104 calls will be made to push, pop, top, and getMin.   <p>
 * <p>
 * Your MinStack object will be instantiated and called as such:    <p>
 * - MinStack obj = new MinStack();   <p>
 * - obj.push(val);   <p>
 * - obj.pop();   <p>
 * - int param_3 = obj.top(); <p>
 * - int param_4 = obj.getMin();      <p>
 */
public interface MinStackInterface {

    public void push(int val);

    public void pop();

    public int top();

    public int getMin();


}
