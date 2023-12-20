package com.smol.solutions.N0141_LinkedListCycle;
import com.smol.solutions.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * <h1>141. Linked List Cycle</h1>
 * Easy<p>
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.<p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.<p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.<p>
 * <p>
 * Example 1:<p>
 * Input: head = [3,2,0,-4], pos = 1<p>
 * Output: true<p>
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).<p>
 * <p>
 * Example 2:<p>
 * Input: head = [1,2], pos = 0<p>
 * Output: true<p>
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.<p>
 * <p>
 * Example 3:<p>
 * Input: head = [1], pos = -1<p>
 * Output: false<p>
 * Explanation: There is no cycle in the linked list.<p>
 * <p>
 * Constraints:<p>
 * The number of the nodes in the list is in the range [0, 104].<p>
 * -105 <= Node.val <= 105<p>
 * pos is -1 or a valid index in the linked-list.<p>
 * <p>
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?<p>
 */

public class N0141_LinkedListCycle {


    /**
     * <h1>Two pointers</h1>
     * fast solution    <p>
     * "Floyd's Cycle-Finding" Algorithm ("hare and tortoise" algorithm)<p>
     * Two pointers slow and fast   <p>
     * Slow pointer moves single node at a time, fast pointer moves two nodes at a time.    <p>
     * Slow pointer reaches the middle of the list at the time fast pointer reaches the end.    <p>
     * <p>
     * Runtime 0ms, Beats 100.00%of users with Java     <p>
     * Memory  43.46MB, Beats 62.33%of users with Java  <p>
     * <p>
     * Determines whether a linked list has a cycle.
     * @param head the head of the linked list
     * @return true if the linked list has a cycle, false otherwise
     */
    public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        // Floyd's Cycle-Finding Algorithm (hare and tortoise algorithm)
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }

    /**
     * <h1>HashSet / Hash Table solution</h1>
     * intuitive, easy to understand but slow solution <p>
     * <p>
     * Runtime 3ms, Beats 15.24%of users with Java <p>
     * Memory 42.96MB, Beats 96.28% users with Java <p>
     * <p>
     * Determines whether a linked list has a cycle.
     * @param head the head of the linked list
     * @return true if the linked list has a cycle, false otherwise
     */
    public boolean hasCycle01(ListNode head) {
        boolean       hasCycle = false;
        Set<ListNode> set      = new HashSet<>();
        while (!hasCycle && head != null) {
            hasCycle = !set.add(head);
            head = head.next;
        }
        return hasCycle;
    }

}
