package com.smol.solutions.n_2_addtwonumbers;

/**
 * <h1>2. Add Two Numbers</h1>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * <p>
 * Example 2:
 * <p>
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * <p>
 * Example 3:
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class _2_AddTwoNumbers {


    /**
     * Runtime
     * 1ms
     * Beats 100.00% of users with Java
     * <p>
     * Memory
     * Details
     * 43.70MB
     * Beats 20.12%of users with Java
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int      addition = 0;
        ListNode listNode = null;

        while (l1 != null && l2 != null) {

            int sum = l1.val + l2.val + addition;
            addition = 0;
            if (sum >= 10) {
                addition = sum / 10;
                sum = sum % 10;
            }

            listNode = new ListNode(sum, listNode);
            //next input nodes
            l1 = l1.next;
            l2 = l2.next;
        }
        //for different lengths of lists
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum  = val1 + val2 + addition;
            addition = 0;
            if (sum >= 10) {
                addition = sum / 10;
                sum = sum % 10;
            }
            listNode = new ListNode(sum, listNode);
            //next input nodes
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (addition != 0) {
            listNode = new ListNode(addition, listNode);
        }
        //reverse order
        ListNode result = null;
        for (ListNode node = listNode; node != null; node = node.next) {
            result = new ListNode(node.val, result);
        }
        return result;
    }

    /**
     * Alternative solution
     * - same as mine but simpler
     */

    public ListNode addTwoNumbers02(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail      = dummyHead;
        int      carry     = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum   = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }


    /**
     * String-long parsing based solution
     * Doesn't work ork for big numbers > Long.MAX_VALUE
     */
    public ListNode addTwoNumbers01(ListNode l1, ListNode l2) {
        String val1 = "";
        for (ListNode node = l1; node != null; node = node.next) {
            val1 = String.valueOf(node.val).concat(val1);
        }

        String val2 = "";
        for (ListNode node = l2; node != null; node = node.next) {

            val2 = String.valueOf(node.val).concat(val2);
        }

        long   sum    = Long.parseLong(val1) + Long.parseLong(val2);
        String sumStr = String.valueOf(sum);

        ListNode result = null;

        for (char c : sumStr.toCharArray()) {
            System.out.println(c);
            result = new ListNode(Integer.parseInt(String.valueOf(c)), result);
        }
        return result;
    }


}



