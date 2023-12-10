package com.smol.solutions.N0019_RemoveNthNodeFromEndOfList;

import com.smol.solutions.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

class N0019_RemoveNthNodeFromEndOfListTest {
    
    private N0019_RemoveNthNodeFromEndOfList obj;
    
    @BeforeEach
    void setUp() {
        obj = new N0019_RemoveNthNodeFromEndOfList();
    }
    
    /**
     * <pre>
     * Example 1:
     *      1->2->3->4->5
     *      ↓  ↓  ↓  ↓  ↓
     *      1->2->3---->5
     * Input: head = [1,2,3,4,5], n = 2
     * Output: [1,2,3,5]
     *
     * Example 2:
     * Input: head = [1], n = 1
     * Output: []
     *
     * Example 3:
     * Input: head = [1,2], n = 1
     * Output: [1]
     *
     * Constraints:
     *     The number of nodes in the list is sz.
     *     1 <= sz <= 30
     *     0 <= Node.val <= 100
     *     1 <= n <= sz
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "1,2,3,5;  2;  1,2,3,4,5",
            "1,2,4,5;  3;  1,2,3,4,5",
            
            "2,3,4,5;  5;  1,2,3,4,5",
            
            "1,2,3,4;  1;  1,2,3,4,5",
            "1;        1;  1,2",
            
            " ;        1;  1",
    })
    void removeNthFromEnd(String sExp, int k, String sHead) {
        
        ListNode expected = stringToLinkedList(sExp);
        ListNode head = stringToLinkedList(sHead);
        
        List<Method> methods = TestUtils.reflectMethods(obj, "removeNthFromEnd");
        
        methods.forEach(method -> {
            ListNode actual = copyLinkedList(head);
            
            try {
                actual = (ListNode) method.invoke(obj, actual, k);
            } catch (IllegalAccessException | InvocationTargetException e) {
                Assertions.fail("Something went wrong when invoking methods in tested object.");
            }
            ListNode exp = expected;
            int i = 0;
            while (exp != null) {
                Assertions.assertNotNull(actual, "Actual has less nodes then expected outcome." + getMessage(head, expected, actual, method));
                Assertions.assertEquals(exp.val, actual.val, "Values differ at index:" + i + " <= " + getMessage(head, expected, actual, method));
                i++;
                exp = exp.next;
                actual = actual.next;
            }
        });
    }
    
    private ListNode copyLinkedList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode copy = dummy;
        while (head != null) {
            dummy.next = new ListNode(head.val);
            dummy = dummy.next;
            head = head.next;
        }
        return copy.next;
    }
    
    private String getMessage(ListNode head, ListNode expected, ListNode actual, Method method) {
        return "\nmethod: " + method.getName() +
               "\ninp: " + nodeToString(head) +
               "\nexp: " + nodeToString(expected) +
               "\nact: " + nodeToString(actual);
    }
    
    private ListNode stringToLinkedList(String head) {
        int[] vals = TestUtils.StringToIntArray(head, ",");
        
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        for (int i : vals) {
            dummy.next = new ListNode(i);
            dummy = dummy.next;
        }
        return result.next;
    }
    
    private String nodeToString(ListNode actual) {
        ListNode toBePrinted = actual;
        StringBuilder text = new StringBuilder();
        while (toBePrinted != null) {
            text.append(toBePrinted.val).append(',');
            toBePrinted = toBePrinted.next;
        }
        return !text.isEmpty() ? text.substring(0, text.length() - 1) : "";
    }
}