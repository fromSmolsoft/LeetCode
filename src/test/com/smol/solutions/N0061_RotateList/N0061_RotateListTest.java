package com.smol.solutions.N0061_RotateList;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

class N0061_RotateListTest {
    
    private N0061_RotateList obj;
    
    @BeforeEach
    void setUp() {
        obj = new N0061_RotateList();
    }
    
    /**
     * <pre>{@code
     * Example 1:
     * head    :    1->2->3->4->5
     * rotate 1:    5->1->2->3->4
     * rotate 2:    4->5->1->2->3
     *
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [4,5,1,2,3]
     *
     * Example 2:
     * Input: head = [0,1,2], k = 4
     * Output: [2,0,1]
     * }
     *
     * Constraints:
     *     The number of nodes in the list is in the range [0, 500].
     *     -100 <= Node.val <= 100
     *     0 <= k <= 2 * 109
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "4,5,1,2,3; 1,2,3,4,5;  2",
            "4,5,1,2,3; 1,2,3,4,5;  7",
            "1,2,3,4,5; 1,2,3,4,5;  5",
            "1,2,3,4,5; 1,2,3,4,5;  1000",
            "1,2,3,4,5; 1,2,3,4,5;  0",
            "2,0,1;     0,1,2;      4",
            ";              ;       1"
    })
    void rotateRight(String sExp, String sHead, int k) throws InvocationTargetException, IllegalAccessException {
        List<Method> methods = TUtils.reflectMethods(obj, "rotateRight");
        
        for (Method method : methods) {
            ListNode expected = stringToNode(sExp);
            ListNode head = stringToNode(sHead);
            ListNode actual = (ListNode) method.invoke(obj, head, k);
            
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