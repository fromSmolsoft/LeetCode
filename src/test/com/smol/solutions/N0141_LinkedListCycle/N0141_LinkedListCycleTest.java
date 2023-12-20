package com.smol.solutions.N0141_LinkedListCycle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import com.smol.solutions.utils.ListNode;

import java.util.Arrays;

class N0141_LinkedListCycleTest {

    @ParameterizedTest
    @CsvSource(value = {
            "true,  1,  3;2;0;0;-4",
            "true,  0,  1;2",
            "false, -1, 1",
            "true,  6,  3;2;0;-4;10;-35;220"
    })
    void hasCycle(boolean expected, int pos, String listValues) {

        int[]    values    = Arrays.stream(listValues.split(";")).mapToInt(Integer::parseInt).toArray();
        ListNode head      = new ListNode(values[0]);
        ListNode tail      = head;
        ListNode cycleNode = null;

        for (int i = 0; i < values.length; i++) {
            //Create new node
            ListNode node = new ListNode(values[i]);
            //assign new node to current tail.next
            tail.next = node;
            //if we are at position of node cycle should point to, save the node
            if (i == pos) cycleNode = node;
            //update tail:  tail >> node
            tail = tail.next;
        }
        //insert saved cycleNode to the end of the list to create a cycle
        tail.next = cycleNode;
        ListNode result = head.next;
        head.next = null;
        //get result from tested method
        boolean actual = new N0141_LinkedListCycle().hasCycle(result);

        //actual test
        Assertions.assertEquals(expected, actual);
    }
}