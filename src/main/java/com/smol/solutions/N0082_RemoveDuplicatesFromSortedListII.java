package com.smol.solutions;

import com.smol.solutions.utils.ListNode;

/**
 * <h1>82. Remove Duplicates from Sorted List II</h1>
 * Medium, #LinkedList #TwoPointers
 * <p>
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 * <pre>{@code
 * Example 1:
 *      1->2->3->3->4->4->5
 *               ↓
 *      1->2------------->5
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 *
 * Example 2:
 *      1->1->1->2->3
 *                 ↓
 *               2->3
 *
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 * }
 *
 * Constraints:
 *     The number of nodes in the list is in the range [0, 300].
 *     -100 <= Node.val <= 100
 *     The list is guaranteed to be sorted in ascending order.
 * </pre>
 */
public class N0082_RemoveDuplicatesFromSortedListII {
    
    /***/
    public ListNode deleteDuplicates00(ListNode head) {
        if (head == null) return head;
        ListNode result = new ListNode(-1);
        ListNode slow = result;
        ListNode fast = head;
        slow.next = fast;
        
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            
            if (slow.next != fast) {
                slow.next = fast.next;
                fast = slow.next;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return result.next;
    }
    
    /**
     * <h2>No nested loops</h2>
     * <pre>
     * Runtime 0 ms Beats 100.00 % of users with Java
     * Memory 43.27 MB Beats 28.91% of users with Java
     * </pre>
     */
    public ListNode deleteDuplicates01(ListNode head) {
        if (head == null) return head;
        ListNode result = new ListNode(-1);
        ListNode slow = result;
        ListNode fast = head;
        slow.next = fast;
        
        while (fast != null) {
            
            if (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            } else if (slow.next != fast) {
                slow.next = fast.next;
                fast = slow.next;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
            
        }
        return result.next;
    }
    
        /** <h2> No dummy head</h2> */
    public ListNode deleteDuplicates02(ListNode head) {
        
        ListNode pre = null;
        ListNode curr = head;
        
        while (curr != null && curr.next != null) {
            
            if (curr.val != curr.next.val) {
                pre = curr;
                curr = curr.next;
            } else {
                while (curr.next != null && curr.next.val == curr.val) curr = curr.next;
                if (pre != null) pre.next = curr.next;
                else head = curr.next;   /* when head was dupe */
                curr = curr.next;
            }
        }
        return head;
    }
}
