package com.smol.solutions;
import com.smol.solutions.utils.ListNode;

/**
 * <h1>876. Middle of the Linked List</h1>
 * Given the head of a singly linked list, return the middle node of the linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [1, 100].
 * 1 <= Node.val <= 100
 */
public class N0876_MiddleOfLinkedList {
    /**
     * Uses 2 pointers slow and fast.<p>
     * Slow pointer moves single node at a time, fast pointer moves two nodes at a time.<p>
     * Slow pointer reaches the middle of the list at the time fast pointer reaches the end.<p>
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
