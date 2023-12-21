package com.smol.solutions;

import com.smol.solutions.N0025_ReverseNodesInGroup;
import com.smol.solutions.utils.ListNode;
import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

class N0025_ReverseNodesInGroupTest {
    
    private N0025_ReverseNodesInGroup obj;
    
    @BeforeEach
    void setUp() {
        obj = new N0025_ReverseNodesInGroup();
    }
    
    /**
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
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "2,1,4,3,5; 1,2,3,4,5;  2",
            "3,2,1,4,5; 1,2,3,4,5;  3",
            "5,4,3,2,1; 1,2,3,4,5;  5",
            "1;         1;          1",
    })
    void reverseKGroup(String sExp, String sHead, int k) throws InvocationTargetException, IllegalAccessException {
        ListNode expected0 = stringToNode(sExp);
        List<Method> methods = TUtils.reflectMethods(obj, "reverseKGroup");
        
        for (Method m : methods) {
            ListNode actual0 = (ListNode) m.invoke(obj, stringToNode(sHead), k);
            ListNode actual = actual0;
            
            ListNode expected = expected0;
            for (int i = 0; expected != null; i++) {
                
                Assertions.assertNotNull(actual, getMessage(m, i, expected0, actual0, "act is null\n"));
                Assertions.assertEquals(expected.val, actual.val, getMessage(m, i, expected0, actual0, ""));
                
                actual = actual.next;
                expected = expected.next;
            }
        }
        
    }
    
    private String getMessage(Method m, int i, ListNode expected0, ListNode actual0, String x) {
        return "\nmethod: " + m.getName() +
               "\ni   : " + i +
               "\nexp : " + nodeToString(expected0) +
               "\nact : " + nodeToString(actual0) +
               "\n" + x;
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