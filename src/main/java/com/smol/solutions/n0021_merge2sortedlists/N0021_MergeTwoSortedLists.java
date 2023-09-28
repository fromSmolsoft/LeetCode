package com.smol.solutions.n0021_merge2sortedlists;

/**
 * 21. Merge Two Sorted Lists
 * Easy <p>
 * You are given the heads of two sorted linked lists list1 and list2. <p>
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists. <p>
 * Return the head of the merged linked list. <p>
 * <p>
 * Example 1: <p>
 * Input: list1 = [1,2,4], list2 = [1,3,4] <p>
 * Output: [1,1,2,3,4,4] <p>
 * <p>
 * Example 2: <p>
 * Input: list1 = [], list2 = [] <p>
 * Output: [] <p>
 * <p>
 * Example 3: <p>
 * Input: list1 = [], list2 = [0] <p>
 * Output: [0] <p>
 * <p>
 * Constraints: <p>
 * The number of nodes in both lists is in the range [0, 50]. <p>
 * -100 <= Node.val <= 100 <p>
 * Both list1 and list2 are sorted in non-decreasing order. <p>
 */
public class N0021_MergeTwoSortedLists {

    /**
     * Runtime 0ms, Beats 100.00%of users with Java     <p>
     * Memory 41.30MB, Beats 61.50%of users with Java   <p>
     * Logic: <p>
     * If value from list1 is smaller or equal add list1 as next node, else add list two as next node
     * @return merged list1 + list2 in asc sorted order (1>2>3) of nodes values
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1); //marks "beginning" of the linked list
        ListNode tail    = preHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 == null ? list2 : list1;
        return preHead.next;
    }
}


