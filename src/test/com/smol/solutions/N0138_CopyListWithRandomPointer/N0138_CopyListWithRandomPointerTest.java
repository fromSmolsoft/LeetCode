package com.smol.solutions.N0138_CopyListWithRandomPointer;

import com.smol.solutions.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class N0138_CopyListWithRandomPointerTest {
    
    private N0138_CopyListWithRandomPointer obj;
    
    
    @BeforeEach
    void setUp() {
        obj = new N0138_CopyListWithRandomPointer();
    }
    
    /**
     * <pre>
     *  Example 1:
     *   Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
     *   Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
     *
     *  Example 2:
     *   Input: head = [[1,1],[2,1]]
     *   Output: [[1,1],[2,1]]
     *
     *  Example 3:
     *   Input: head = [[3,null],[3,0],[3,null]]
     *   Output: [[3,null],[3,0],[3,null]]
     *
     *  Constraints:
     *       0 <= n <= 1000
     *       -104 <= Node.val <= 104
     *       Node.random is null or is pointing to some node in the linked list.
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "[[7,null],[13,0],[11,4],[10,2],[1,0]]; [[7,null],[13,0],[11,4],[10,2],[1,0]]",
            "[[1,1],[2,1]]; [[1,1],[2,1]]",
            "[[3,null],[3,0],[3,null]]; [[3,null],[3,0],[3,null]]",
            "[];    []"
    })
    void copyRandomList(String sExpected, String sInput) throws InvocationTargetException, IllegalAccessException {
        Node expected = parseStringToLinkedList(sExpected);
        List<Method> methods = TestUtils.reflectMethods(obj, "copyRandomList");
        
        for (Method m : methods) {
            Node actual = (Node) m.invoke(obj, parseStringToLinkedList(sInput));
            
            while (expected != null) {
                Assertions.assertNotNull(actual, m.getName() + "Actual output is null");
                
                int valExp = expected.val;
                int valAct = actual.val;
                Assertions.assertEquals(valExp, valAct, m.getName());
                
                Integer rndExp = expected.random == null ? null : expected.random.val;
                Integer rndAct = actual.random == null ? null : actual.random.val;
                Assertions.assertEquals(rndExp, rndAct, m.getName());
                
                expected = expected.next;
                actual = actual.next;
            }
        }
    }
    
    /**
     * Helper
     * Converts String representing values array of pairs of Node.val (int value) and Node.random(index of any connected Node within same LinkedList). <p>
     * @param text - takes String like following "[[7,null],[13,0],[11,4],[10,2],[1,0]]"
     * @return Node as filled LinkedList
     */
    private Node parseStringToLinkedList(String text) {
        String[] tempExpected = TestUtils.StringToStringArray(text, "\\],\\[");
        if (tempExpected.length == 1 && tempExpected[0].contains("[]")) return null;
        TestUtils.removeSubStringsFromArray(tempExpected, "\\[", "\\]");
        
        Node head = null;
        List<Node> stack = new ArrayList<>();
        for (int i = tempExpected.length - 1; i >= 0; i--) {
            String s = tempExpected[i].split(",")[0];
            Node node = new Node(Integer.parseInt(s));
            node.next = head;
            head = node;
            stack.add(node);
        }
        
        Node temp = head;
        for (int i = 0; i < tempExpected.length; i++) {
            String s = tempExpected[i].split(",")[1];
            if (!s.contains("null")) {
                temp.random = stack.get(Integer.parseInt(s));
                temp = temp.next;
            }
        }
        return head;
    }
}