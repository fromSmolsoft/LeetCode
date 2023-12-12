package com.smol.solutions.N0086_PartitionList;

import com.smol.solutions.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

class N0086_PartitionListTest {
    
    private N0086_PartitionList obj;
    
    @BeforeEach
    void setUp() {
        obj = new N0086_PartitionList();
    }
    
    /**
     * <pre>{@code
     * Example 1:
     *         ▼  ▼     ▼
     *      1->4->3->2->5->2
     *             ↓
     *               ▼  ▼  ▼
     *      1->2->2->4->3->5
     *
     * Input: head = [1,4,3,2,5,2], x = 3
     * Output: [1,2,2,4,3,5]
     *
     * Example 2:
     * Input: head = [2,1], x = 2
     * Output: [1,2]
     *
     * Constraints:
     *     The number of nodes in the list is in the range [0, 200].
     *     -100 <= Node.val <= 100
     *     -200 <= x <= 200
     * }</pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "1,2,2,4,3,5;   1,4,3,2,5,2;    3",
            "1,4,3,2,5,2;   1,4,3,2,5,2;   -1",
            "1,4,3,2,2,5;   1,4,3,2,5,2;    5",
            "1,4,3,2,5,2;   1,4,3,2,5,2;    6",
            "1,2;           2,1;            2",
            "2,1;           2,1;            1",
    })
    void partition(String sExp, String sHead, int x) throws InvocationTargetException, IllegalAccessException {
        
        List<Method> methods = TestUtils.reflectMethods(obj, "partition");
        
        for (Method m : methods) {
            ListNode actual = (ListNode) m.invoke(obj, stringToNode(sHead), x);
            ListNode expected = stringToNode(sExp);
            String message = getMessage(m, sHead, sExp, actual);
            
            while (expected != null) {
                Assertions.assertNotNull(actual, "\nact: Too short" + message);
                Assertions.assertEquals(expected.val, actual.val, "\nact: val mismatch" + message);
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
        for (int i : TestUtils.StringToIntArray(sHead, ",")) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return head.next;
    }
}
