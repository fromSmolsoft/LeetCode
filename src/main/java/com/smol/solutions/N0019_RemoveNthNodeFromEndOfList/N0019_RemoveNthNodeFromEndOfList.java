package com.smol.solutions.N0019_RemoveNthNodeFromEndOfList;

/**
 * <h1>19. Remove Nth Node From End of List</h1>
 * Medium  <p>
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * <pre>
 * Example 1:
 *      1->2->3->4->5
 *               ↓
 *      1->2->3---->5
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 * Constraints:
 *     The number of nodes in the list is sz.
 *     1 <= sz <= 30
 *     0 <= Node.val <= 100
 *     1 <= n <= sz
 * </pre>
 * Follow up: Could you do this in one pass?
 * @see <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class N0019_RemoveNthNodeFromEndOfList {
    
    /**
     * <h2>Two pointers</h2>
     * iterate and keep track of  nTh previous node from current node.  <p>
     * After iteration bypass nTh previous node to its next.next node.  <p>
     * <pre>{@code
     *  Example: head= [1,2,3,4,5], n = 2
     *
     *  1) Find n-th-1 node
     *       i= 0   1  [2]
     *                  ↓
     *   curr = 1-> 2->[3]-> 4-> 5
     *   catch edge case `if (i==n)`;
     *
     *  2) Iterate till the end from both current node
     *      and from original head of the list
     *                   ↓
     *    curr = 3-> 4->[5]
     *   prevN = head
     *                   ↓
     *   prevN = 1-> 2->[3]-> 4-> 5
     *
     *  3)  Bypass node following prevN from end of the list
     *
     *    prevN =       3->4->5
     *    prevN =       3---->5 (removed n-th node from the end of original list)
     *     head = 1->2->3---->5
     * }</pre>
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        
        int i = 0;
        // find n-th-1 node (`curr`) from the beginning
        ListNode curr = head;
        while (curr != null && i <= n) {
            curr = curr.next;
            i++;
        }
        
        if (i == n) return head.next;  // when n == list length (edge case)
        
        // original head is now nth elements behind current node
        ListNode preN = head;
        while (curr != null) {  // iterate till the end
            preN = preN.next;   // move nth previous
            curr = curr.next;   // move current
        }
        // bypass node following after nth previous node
        preN.next = preN.next.next;
        return head;
    }
    
    /** Two pointers concise version */
    public ListNode removeNthFromEnd01(ListNode head, int n) {
        
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        start.next = head;
        
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return start.next;
    }
}
