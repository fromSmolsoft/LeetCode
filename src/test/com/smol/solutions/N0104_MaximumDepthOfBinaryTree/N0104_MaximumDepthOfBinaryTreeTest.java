package com.smol.solutions.N0104_MaximumDepthOfBinaryTree;

import com.smol.solutions.utils.TUtils;
import com.smol.solutions.utils.TreeFormatter;
import com.smol.solutions.utils.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;


class N0104_MaximumDepthOfBinaryTreeTest {
    
    private N0104_MDOBT obj;
    private List<Method> methods;
    private TreeFormatter formatter;
    
    @BeforeEach
    void setObj() {
        obj = new N0104_MaximumDepthOfBinaryTree();
        //obj = obj.getClass().getConstructor(int.class).newInstance(); // reflection
        methods = TUtils.reflectMethods(obj, "maxDepth");
        formatter = new TreeFormatter();
    }
    
    /**
     * <pre> {@code
     * Example 1:
     *      (3)
     *     /  \
     *   (9)  (20)
     *        /  \
     *      (15) (7)
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 3
     *
     * Example 2:
     * Input: root = [1,null,2]
     * Output: 2
     *
     * Constraints:
     *     The number of nodes in the tree is in the range [0, 104].
     *     -100 <= Node.val <= 100
     * }</pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "3;3,9,20,null,null,15,7",
            "2;1,null,2",
            "0;",
            "3;1,1,1,1,1,1,1"
    })
    void maxDepth(int expected, String sRoot) throws InvocationTargetException, IllegalAccessException {
        
        Integer[] vals = TUtils.StringToIntegerArray(sRoot, ",");
        String message;
        TreeNode root = buildBiTree(vals);
        if (vals.length > 0) {
            message = "\nRoot:" +
                      "\n" + formatter.topDown(root) +
                      "\n";
        } else message = "";
        for (Method m : methods) {
            Assertions.assertEquals(expected, m.invoke(obj, root), "\n" + m.getName() + "\n" + message);
        }
        
    }
    
    private TreeNode buildBiTree(Integer[] values) {
        TreeNode root = createTreeNode(values, 1);
        return root;
    }
    
    private TreeNode createTreeNode(Integer[] input, int index) {
        if (index <= input.length) {
            Integer value = input[index - 1];
            if (value != null) {
                TreeNode t = new TreeNode(value);
                t.left = createTreeNode(input, index * 2);
                t.right = createTreeNode(input, index * 2 + 1);
                return t;
            }
        }
        return null;
    }
}