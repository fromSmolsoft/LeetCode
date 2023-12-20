package com.smol.solutions.N0061_RotateList;

import com.smol.solutions.utils.ListNode;

/**
 * <h1>61. Rotate List</h1>
 * Medium
 * <p>
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * <pre>{@code
 * Example 1:
 * head    :    1->2->3->4->5
 * rotate 1:    5->1->2->3->4
 * rotate 2:    4->5->1->2->3
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 *
 * Example 2:
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 * }
 *
 * Constraints:
 *     The number of nodes in the list is in the range [0, 500].
 *     -100 <= Node.val <= 100
 *     0 <= k <= 2 * 109
 * </pre>
 */
public class N0061_RotateList {
    
    /**
     * <h2>Two pointers in 2 partial loops</h2>
     * Should at worse go trough two passes.
     * <h3>Logic:</h3>
     * 1) Find k-th node        <p>
     * 2) Use that to find k-th node from the end       <p>
     * 3) Reconnect k-th node from the end to old head      <p>
     * <pre>
     * Runtime 0 ms Beats 100.00 % of users with Java
     * Memory 41.61 MB Beats 29.82 % of users with Java
     * </pre>
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        
        for (int i = 1; i <= k; i++) {
            head = head.next;
            if (head == null) { // when k > list size
                head = dummyHead.next; // reset head
                k = k % i;  // reduce big k to less than single iteration
                i = 0;      // reset increment
            }
        }
        if (head == dummyHead.next) return head;
        
        ListNode moved = dummyHead.next;
        while (head.next != null) {
            moved = moved.next;
            head = head.next;
        }
        
        ListNode oldHead = dummyHead.next;
        dummyHead.next = moved.next;
        moved.next = null;
        head.next = oldHead;
        
        return dummyHead.next;
    }
    
    /**
     * <h2>Counting nodes first</h2>
     *
     */
    public ListNode rotateRight01(ListNode head, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        
        int i;
        for (i = 0; fast.next != null; i++)//Get the total length
            fast = fast.next;
        
        for (int j = i - n % i; j > 0; j--) //Get the i-n%i th node
            slow = slow.next;
        
        fast.next = dummy.next; //Do the rotation
        dummy.next = slow.next;
        slow.next = null;
        
        return dummy.next;
    }
}
