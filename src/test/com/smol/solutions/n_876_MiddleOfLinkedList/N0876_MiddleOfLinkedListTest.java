package com.smol.solutions.n_876_MiddleOfLinkedList;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N0876_MiddleOfLinkedListTest {


    @ParameterizedTest
    @CsvSource(value = {
            "12345, 345",
            "123456, 456",
    })
    void test(String input, String expected) {
        char[]                   iChars = input.toCharArray();
        char[]                   eChars = expected.toCharArray();
        N0876_MiddleOfLinkedList obj    = new N0876_MiddleOfLinkedList();
        ListNode                 head   = new ListNode(Integer.parseInt(String.valueOf(iChars[0])));
        for (int i = 1; i < iChars.length; i++) {
            int value = Integer.parseInt(String.valueOf(iChars[i]));
            head = new ListNode(value, head);
        }
        ListNode head2 = new ListNode(Integer.parseInt(String.valueOf(eChars[0])));
        for (int i = 1; i < eChars.length; i++) {
            int value = Integer.parseInt(String.valueOf(eChars[i]));
            head = new ListNode(value, head2);
        }
        ListNode result = obj.middleNode(head);
        assertEquals(head2, result);
    }
}