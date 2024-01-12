package com.smol.solutions;

import com.smol.solutions.utils.Node;
import com.smol.solutions.utils.TUtils;
import com.smol.solutions.utils.TreeFormatter;
import com.smol.solutions.utils.TreeBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

class N0116_PopulatingNextRightPointersInEachNodeTest {
    
    private final N0116_PopulatingNextRightPointersInEachNode obj = new N0116_PopulatingNextRightPointersInEachNode();
    private final List<Method> methods = TUtils.reflectMethods(obj.getClass(), "connect");
    private final TreeFormatter treeFormatter = new TreeFormatter();
    
    /**
     * <pre> {@code
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * }</pre>
     * <p>
     *
     * <pre> {@code
     * Example 1:
     *         1                 1 --------> null
     *       /   \             /   \
     *      2     3           2---->3 -----> null
     *    / \     / \       / \     / \
     *   4   5   6   7     4-->5-->6-->7 --> null
     * Input: root = [1,2,3,4,5,6,7]
     * Output: [1,#,2,3,#,4,5,6,7,#]
     * }</pre>
     * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
     * <p> <pre> {@code
     *
     * Example 2:
     * Input: root = []
     * Output: []
     *
     * Constraints:
     * -> The number of nodes in the tree is in the range [0, 212 - 1].
     * -> -1000 <= Node.val <= 1000
     *
     * }</pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "1,#,2,3,#,4,5,6,7,#; 1,2,3,4,5,6,7",
            " ; ",
    })
    void connect(String sExp, String sRoot) {
        sExp = TUtils.removeSubStrings(sExp, ",#");
        Node exp = TreeBuilder.buildBiTreeWithNext(TUtils.StringToIntegerArray(sExp, ","), Node.class);
        Node root = TreeBuilder.buildBiTree(TUtils.StringToIntegerArray(sRoot, ","), Node.class); //Input `root` gets modified by tested methods
        String expMessage = treeFormatter.topDownConnected(exp);
        
        methods.forEach(m -> {
            Node act = null;
            try {
                act = (Node) m.invoke(obj, root);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            
            String actMessage = treeFormatter.topDownConnected(act);
            Assertions.assertEquals(expMessage, actMessage,
                    "\nmethod: " + m.getName() +
                    "\ninp:" + sRoot);
        });
    }
    
}