package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import com.smol.solutions.utils.TreeBuilder;
import com.smol.solutions.utils.TreeFormatter;
import com.smol.solutions.utils.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class N0144_BinaryTreePreorderTraversalTest {
    
    private final N0144_BinaryTreePreorderTraversal obj = new N0144_BinaryTreePreorderTraversal();
    private final List<Method> methods = TUtils.reflectMethods(obj.getClass(), "preorderTraversal", new Class<?>[]{TreeNode.class});
    
    /**
     * <pre>{@code
     * Example 1:
     *     1
     *      \
     *       2
     *      /
     *    3
     * Input: root = [1,null,2,3]
     * Output: [1,2,3]
     *
     * Example 2:
     * Input: root = []
     * Output: []
     *
     * Example 3:
     * Input: root = [1]
     * Output: [1]
     *
     * Constraints:
     *     The number of nodes in the tree is in the range [0, 100].
     *     -100 <= Node.val <= 100
     * }</pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "1,2,3; 1,null,2,3",
            "1,4,2,3; 1,4,3,2",
            " ; ",
            "1;1"
    })
    void preorderTraversal(String sExp, String sRoot) {
        List<Integer> expList = TUtils.StringToIntList(sExp, ",");
        TreeNode root = TreeBuilder.buildBiTree(TUtils.StringToIntegerArray(sRoot, ","));
        
        methods.forEach(m -> {
            try {
                assertEquals(expList, m.invoke(obj, root),
                        "\n" + new TreeFormatter().topDown(root));
            } catch (IllegalAccessException | InvocationTargetException e) {
                fail("method:" + m.getName() + "failed during invoking.\n" + e.getCause());
            }
            
        });
    }
}