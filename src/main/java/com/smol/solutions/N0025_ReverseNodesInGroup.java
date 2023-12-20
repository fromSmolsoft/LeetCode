package com.smol.solutions;

import com.smol.solutions.utils.ListNode;

/**
 * <h1>25. Reverse Nodes in k-Group</h1>
 * Hard, #LinkedList, #Recursion
 * <p>
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * <p>
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 * <pre>
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 * Example 2:
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 * Constraints:
 *     The number of nodes in the list is n.
 *     1 <= k <= n <= 5000
 *     0 <= Node.val <= 1000
 * </pre>
 * Follow-up: Can you solve the problem in O(1) extra memory space?
 */
public class N0025_ReverseNodesInGroup {
    
    /**
     * Walks through linkedList and applies reverse function.
     * <pre>
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 44.08 MB Beats 5.41% of users with Java
     * </pre>
     * @author <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/solutions/11423/short-but-recursive-java-code-with-comments/?envType=study-plan-v2&envId=top-interview-150">yellowstone</a>
     */
    public ListNode reverseKGroup00(ListNode head, int k) {
        ListNode begin;
        if (head == null || head.next == null || k == 1)
            return head;    // quick quit for edge cases
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        begin = dummy;
        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {   // if k is multiple of current node index
                begin = reverse(begin, head.next);  //reverse between begin - end (head.next)
                head = begin.next;  // moves head after begin so possible end (head.next) is also updated
            } else {
                head = head.next;   // moves head so possible end (head.next) is also updated
            }
        }
        return dummy.next;
    }
    
    /**
     * Reverse a link list between begin and end exclusively
     * <pre>
     * an example:
     * a linked list:
     * 0->1->2->3->4->5->6
     * |           |
     * begin       end
     * after call begin = reverse(begin, end)
     *
     * 0->3->2->1->4->5->6
     *          |  |
     *      begin  end
     * </pre>
     * @return the reversed list's 'begin' node, which is the precedence of node end
     * @author <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/solutions/11423/short-but-recursive-java-code-with-comments/?envType=study-plan-v2&envId=top-interview-150">yellowstone</a>
     */
    public ListNode reverse(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        ListNode next, first;
        ListNode prev = begin;
        first = curr;
        while (curr != end) {
            next = curr.next;   // save next node for later use
            curr.next = prev;   // switch original next for previous node
            prev = curr;        // switch previous for current
            curr = next;        // switch current for next
        }
        begin.next = prev;
        first.next = curr;
        return first;
    }
    
    /**
     * <h2>Concise</h2>
     * @author <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/solutions/11423/short-but-recursive-java-code-with-comments/comments/12145">ofLucas</a>
     */
    public ListNode reverseKGroup01(ListNode head, int k) {
        int n = 0;
        for (ListNode i = head; i != null; n++, i = i.next) ; //count nodes.
        
        ListNode dmy = new ListNode(0);  //dummy pre-head
        dmy.next = head;
        for (ListNode prev = dmy, tail = head; n >= k; n -= k) {
            for (int i = 1; i < k; i++) {
                ListNode next = tail.next.next;
                tail.next.next = prev.next;
                prev.next = tail.next;
                tail.next = next;
            }
            prev = tail;
            tail = tail.next;
        }
        return dmy.next;
    }
    
    /**
     * <h2> Recursion</h2>
     * @author <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/solutions/11423/short-but-recursive-java-code-with-comments/?envType=study-plan-v2&envId=top-interview-150">shpolsky</a>
     */
    public ListNode reverseKGroup02(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup01(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
}
