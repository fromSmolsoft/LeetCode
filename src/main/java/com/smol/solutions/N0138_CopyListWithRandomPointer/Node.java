package com.smol.solutions.N0138_CopyListWithRandomPointer;

public class Node {
    int val;
    Node next;
    Node random;
    
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
