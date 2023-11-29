package com.smol.solutions.N0155_minstack;

/**
 * <h2>Nodes</h2>
 * #node #LinkedList
 */
class MinStack05 implements MinStackInterface {

    /** initialize your data structure here. */
    class Node{
        int val;
        int min;
        Node next;

        public Node(int val , int min , Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;

    public MinStack05() {
        head = null;
    }

    public void push(int val) {
        if(head == null)
            head = new Node(val ,val ,null);
        else
            head = new Node(val , Math.min(val ,head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

