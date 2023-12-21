package com.smol.solutions;

import com.smol.solutions.utils.ListNode;

/**
 * <h1>92. Reverse Linked List II</h1>
 * Medium, #LinkedList
 * <p>
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 * <pre>
 * Example 1:
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 *
 * Example 2:
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 * Constraints:
 *     The number of nodes in the list is n.
 *     1 <= n <= 500
 *     -500 <= Node.val <= 500
 *     1 <= left <= right <= n
 * </pre>
 * Follow up: Could you do it in one pass?
 */
public class N0092_ReverseLinkedListII {
    
    
    /**
     * <pre>
     * Runtime 0 ms Beats 100.00 % of users with Java
     * Memory 40.26 MB Beats 39.46 % of users with Java
     * </pre>
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //array to store to be `reversed` nodes +  `before` + `after` nodes. Alternatively `before` and `after` nodes can be stored separately
        ListNode[] nodes = new ListNode[right - left + 1 + 2];
        
        //shallow copy of head for iteration
        ListNode temp = head;
        
        // capturing  left-1>= nodes <= right, where the left >= node < right is to be reversed in order.
        for (int i = 0; temp != null; i++) {
            if ((left - 2) == i) nodes[nodes.length - 2] = temp; //get node before reversed
            else if ((left - 1) <= i && i < (right)) nodes[i - (left - 1)] = temp; //get to be reversed nodes
            else if (i == right) {  // get after reversed node
                nodes[nodes.length - 1] = temp;
                break;
            }
            temp = temp.next;
        }
        // edge case when left pointed to original head
        if (nodes[nodes.length - 2] == null) {
            nodes[nodes.length - 2] = new ListNode(-1);
            head = nodes[right - left];
        }
        
        //iterate array backwards to reverse order and fill in nodes
        for (int i = right - left; 0 <= i; i--) {
            nodes[nodes.length - 2].next = nodes[i];
            nodes[nodes.length - 2] = nodes[nodes.length - 2].next;
        }
        //insert the `after` node to ensure continuity
        nodes[nodes.length - 2].next = nodes[nodes.length - 1];
        
        return head;
    }
    
    /** Simply just reverse the list along the way using 4 pointers: dummy, pre, start, then */
    public ListNode reverseBetween01(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i<m-1; i++) pre = pre.next;
        
        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed
        
        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5
        
        for(int i=0; i<n-m; i++)
        {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        
        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
        return dummy.next;
    }
    
}

