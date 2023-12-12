package com.smol.solutions.N0086_PartitionList;

/**
 * <h1>86. Partition List</h1>
 * Medium, #LinkedList
 * <p>
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * <pre>{@code
 * Example 1:
 *         ▼  ▼     ▼
 *      1->4->3->2->5->2
 *             ↓
 *               ▼  ▼  ▼
 *      1->2->2->4->3->5
 *
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 *
 * Example 2:
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 *
 * Constraints:
 *     The number of nodes in the list is in the range [0, 200].
 *     -100 <= Node.val <= 100
 *     -200 <= x <= 200
 * }</pre>
 */
public class N0086_PartitionList {
    
    /**
     * Iterates list: <p>
     * - Separates head into two LinkedList by each node's value according to the given param `x`. <p>
     * Reconnects and returns lists as one. <p>
     * <pre>
     * Runtime 0 ms Beats 100.00 % of users with Java
     * Memory 41.56 MB Beats 8.44 % of users with Java
     * </pre>
     */
    public ListNode partition(ListNode head, int x) {
        
        ListNode leftHead = new ListNode(-1);
        ListNode rightHead = new ListNode(-1);
        
        ListNode leftTail = leftHead;
        ListNode rightTail = rightHead;
        
        while (head != null) {
            if (head.val < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        rightTail.next = null;
        leftTail.next = rightHead.next;
        
        return leftHead.next;
    }
    
    
}
