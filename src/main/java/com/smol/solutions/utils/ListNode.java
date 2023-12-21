package com.smol.solutions.utils;

/**
 * <h1>ListNode</h1>
 * Common list node for Linked lists examples.
 */
public class ListNode {
    public int val;
    public ListNode next;
    
    public ListNode() {}
    
    public ListNode(int val) {this.val = val;}
    
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
