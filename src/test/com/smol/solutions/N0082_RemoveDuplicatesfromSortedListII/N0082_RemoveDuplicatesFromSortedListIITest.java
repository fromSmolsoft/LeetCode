package com.smol.solutions.N0082_RemoveDuplicatesfromSortedListII;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

class N0082_RemoveDuplicatesFromSortedListIITest {
    
    private N0082_RemoveDuplicatesFromSortedListII obj;
    
    @BeforeEach
    void setUp() {
        obj = new N0082_RemoveDuplicatesFromSortedListII();
    }
    
    /**
     * <pre>{@code
     * Example 1:
     *      1->2->3->3->4->4->5
     *               ↓
     *      1->2------------->5
     *
     * Input: head = [1,2,3,3,4,4,5]
     * Output: [1,2,5]
     *
     * Example 2:
     *      1->1->1->2->3
     *                 ↓
     *               2->3
     *
     * Input: head = [1,1,1,2,3]
     * Output: [2,3]
     * }
     *
     * Constraints:
     *     The number of nodes in the list is in the range [0, 300].
     *     -100 <= Node.val <= 100
     *     The list is guaranteed to be sorted in ascending order.
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "1,2,5;     1,2,3,3,4,4,5",
            "2,3;       1,1,1,2,3",
            "2,4,6;     1,1,2,3,3,4,5,5,6,7,7",
            " ;         "
    })
    void deleteDuplicates(String sExp, String sHead) throws InvocationTargetException, IllegalAccessException {
        
        List<Method> methods = TUtils.reflectMethods(obj, "deleteDuplicates");
        
        for (Method method : methods) {
            ListNode expected = stringToNode(sExp);
            ListNode head = stringToNode(sHead);
            ListNode actual = (ListNode) method.invoke(obj, head);
            String message = getMessage(method, sHead, sExp, actual);
            
            if (expected == null) Assertions.assertNull(actual, "\nact: Expected to be null." + message);
            
            while (expected != null) {
                
                Assertions.assertNotNull(actual, "\nact: Shorter than expected." + message);
                Assertions.assertEquals(expected.val, actual.val, message);
                
                actual = actual.next;
                expected = expected.next;
            }
        }
    }
    
    private String getMessage(Method m, String input, String expected, ListNode actual) {
        return "\nmethod: " + m.getName() +
               "\ninp : " + input +
               "\nexp : " + expected +
               "\nact : " + nodeToString(actual) +
               "\n";
    }
    
    private String getMessage(Method m, ListNode input, ListNode expected, ListNode actual) {
        return "\nmethod: " + m.getName() +
               "\ninp : " + nodeToString(input) +
               "\nexp : " + nodeToString(expected) +
               "\nact : " + nodeToString(actual) +
               "\n";
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
    
    private ListNode stringToNode(String sHead) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        for (int i : TUtils.StringToIntArray(sHead, ",")) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return head.next;
    }
}