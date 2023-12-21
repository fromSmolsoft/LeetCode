package com.smol.solutions;

import com.smol.solutions.N0092_ReverseLinkedListII;
import com.smol.solutions.utils.ListNode;
import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

class N0092_ReverseLinkedListIITest {
    
    private N0092_ReverseLinkedListII obj;
    
    @BeforeEach
    void setUp() {
        obj = new N0092_ReverseLinkedListII();
    }
    
    /**
     * <pre>
     * Example 1:
     * Input: head = [1,2,3,4,5], left = 2, right = 4
     * Output: [1,4,3,2,5]
     *
     * Example 2:
     * Input: head = [5], left = 1, right = 1
     * Output: [5]
     *
     * Constraints:
     *     The number of nodes in the list is n.
     *     1 <= n <= 500
     *     -500 <= Node.val <= 500
     *     1 <= left <= right <= n
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "1,4,3,2,5;     1,2,3,4,5;  2;  4",
            "4,3,2,1,5;     1,2,3,4,5;  1;  4",
            "5,4,3,2,1;     1,2,3,4,5;  1;  5",
            "5;             5;          1;  1"
        
    })
    void reverseBetween(String sExp, String sHead, int left, int right) throws InvocationTargetException, IllegalAccessException {
        ListNode expected = stringToNode(sExp);
        List<Method> methods = TUtils.reflectMethods(obj, "reverseBetween");
        
        for (Method m : methods) {
            ListNode actual = (ListNode) m.invoke(obj, stringToNode(sHead), left, right);
            int maxNodes = 500;
            while (expected != null) {
                Assertions.assertTrue(maxNodes >= 0, "More than 500 nodes");
                
                Assertions.assertNotNull(actual);
                Assertions.assertEquals(expected.val, actual.val, "\nmethod: " + m.getName() + "\ninp: " + sHead + "\nexp: " + sExp + "\nact: " + nodeToString(actual));
                
                expected = expected.next;
                actual = actual.next;
                maxNodes--;
            }
        }
        
        
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