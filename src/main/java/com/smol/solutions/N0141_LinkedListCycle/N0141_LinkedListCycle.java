package com.smol.solutions.N0141_LinkedListCycle;

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
     * Runtime 3ms, Beats 15.24%of users with Java
     * Memory 43.47MB, Beats 62.33%of users with Java
     */
    public boolean hasCycle(ListNode head) {
        boolean       hasCycle = false;
        Set<ListNode> set      = new HashSet<>();
        while (head != null) {
            hasCycle = !set.add(head);
            if (hasCycle) break;
            head = head.next;
        }
        return hasCycle;
    }
}
