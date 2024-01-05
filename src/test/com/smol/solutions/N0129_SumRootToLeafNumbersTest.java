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

class N0129_SumRootToLeafNumbersTest {
    
    private final N0129_SumRootToLeafNumbers obj = new N0129_SumRootToLeafNumbers();
    private final List<Method> methods = TUtils.reflectMethods(obj.getClass(), "sumNumbers", new Class<?>[]{TreeNode.class});
    private final TreeFormatter tf = new TreeFormatter();
    
    /**
     * <pre>{@code
     * Example 1:
     *      1
     *    /   \
     *   2     3
     * Input: root = [1,2,3]
     * Output: 25
     * Explanation:
     * The root-to-leaf path 1->2 represents the number 12.
     * The root-to-leaf path 1->3 represents the number 13.
     * Therefore, sum = 12 + 13 = 25.
     *
     * Example 2:
     *           4
     *         /   \
     *       9      4
     *      / \
     *     5   1
     * Input: root = [4,9,0,5,1]
     * Output: 1026
     * Explanation:
     * The root-to-leaf path 4->9->5 represents the number 495.
     * The root-to-leaf path 4->9->1 represents the number 491.
     * The root-to-leaf path 4->0 represents the number 40.
     * Therefore, sum = 495 + 491 + 40 = 1026.
     *
     * Constraints:
     * The number of nodes in the tree is in the range [1, 1000].
     * 0 <= Node.val <= 9
     * The depth of the tree will not exceed 10.
     * }</pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "25;    1,2,3",
            "1026;  4,9,0,5,1",
            "0;     0",
            "9;     9",
            "10;    1,0"
        
    })
    void sumNumbers(int exp, String sRoot) {
        
        methods.forEach(m -> {
            int act;
            TreeNode root = TreeBuilder.buildBiTree(TUtils.StringToIntegerArray(sRoot, ","));
            try {
                act = (int) m.invoke(obj, root);
            } catch (IllegalAccessException | InvocationTargetException e) {
                fail("\nmethod:" + m.getName() + "failed to be invoked" +
                     "\nroot:" + sRoot +
                     "\n" + tf.topDown(root));
                act = exp * (-1);
            }
            assertEquals(exp, act, "\nmethod:" + m.getName() +
                                   "\nroot:" + sRoot +
                                   "\n" + tf.topDown(root));
        });
        
    }
}