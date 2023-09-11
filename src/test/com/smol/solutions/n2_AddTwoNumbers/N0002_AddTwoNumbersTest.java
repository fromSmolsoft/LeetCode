package com.smol.solutions.n2_AddTwoNumbers;

import com.smol.solutions.N0002_addtwonumbers.ListNode;
import com.smol.solutions.N0002_addtwonumbers.N0002_AddTwoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N0002_AddTwoNumbersTest {

    private N0002_AddTwoNumbers obj;

    /** Generates a ListNode from a given array */
    private static ListNode getListNode(int[] values) {
        ListNode listNode = null;
        for (int i = values.length - 1; i >= 0; i--) {
            listNode = new ListNode(values[i], listNode);

        }
        return listNode;
    }

    /** Tests the individual nodes */
    private static void testIndividualNodes(ListNode actual, int[] expectedArray) {
        for (int i = 0; i < expectedArray.length; i++) {
            System.out.print("Node: " + i + "; ");
            assertEquals(expectedArray[i], actual.val);
            actual = actual.next;
        }
        System.out.println("\n");
    }

    @BeforeEach
    void setUp() {

        obj = new N0002_AddTwoNumbers();
    }

    @Test
    void addTwoNumbersBasicAddition() {
//        Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] Explanation: 342 + 465 = 807.
        ListNode l1            = getListNode(new int[]{2, 4, 3});
        ListNode l2            = getListNode(new int[]{5, 6, 4});
        ListNode actual        = obj.addTwoNumbers(l1, l2);
        int[]    expectedArray = {7, 0, 8};
//        int[]    expectedArray = {8, 0, 7};
        testIndividualNodes(actual, expectedArray);
    }

    @Test
    void addTwoNumbersDifferentLengthOfLists() {
        // Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
        ListNode l1            = getListNode(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2            = getListNode(new int[]{9, 9, 9, 9});
        ListNode actual        = obj.addTwoNumbers(l1, l2);
        int[]    expectedArray = {8, 9, 9, 9, 0, 0, 0, 1};
//        int[] expectedArray = {1, 0, 0, 0, 9, 9, 9, 8};

        testIndividualNodes(actual, expectedArray);
    }

    @Test
    void addTwoNumbersZeros() {
        //Input: l1 = [0], l2 = [0] Output: [0]
        ListNode l1            = getListNode(new int[]{0});
        ListNode l2            = getListNode(new int[]{0});
        ListNode actual        = obj.addTwoNumbers(l1, l2);
        int[]    expectedArray = {0};
        testIndividualNodes(actual, expectedArray);
    }

    @Test
    void addTwoNumbers16() {
        //Input: l1 = [2,4,9], l2 = [5,6,4,9], Expected Output: [7,0,4,0,1]
        ListNode l1            = getListNode(new int[]{2, 4, 9});
        ListNode l2            = getListNode(new int[]{5, 6, 4, 9});
        ListNode actual        = obj.addTwoNumbers(l1, l2);
        int[]    expectedArray = {7, 0, 4, 0, 1};
        testIndividualNodes(actual, expectedArray);
    }

    @Test
    void addTwoNumbersShortAndLong() {
        //Input: l1 = [9], l2 = [1,9,9 ,9,9,9, 9,9,9, 9] Output: [0,0,0, 0,0,0, 0,0,0, 0,1]

        ListNode l1            = getListNode(new int[]{9});
        ListNode l2            = getListNode(new int[]{1, 9, 9, 9, 9, 9, 9, 9, 9, 9});
        ListNode actual        = obj.addTwoNumbers(l1, l2);
        int[]    expectedArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        testIndividualNodes(actual, expectedArray);
    }


}