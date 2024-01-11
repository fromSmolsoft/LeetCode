package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import com.smol.solutions.utils.TreeBuilder;
import com.smol.solutions.utils.TreeFormatter;
import com.smol.solutions.utils.TreeNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class N0124_BinaryTreeMaximumPathSumTest {
    
    private final N0124_BinaryTreeMaximumPathSum obj = new N0124_BinaryTreeMaximumPathSum();
    private final List<Method> methods = TUtils.reflectMethods(obj.getClass(), "maxPathSum", new Class<?>[]{TreeNode.class});
    
    @Test
    void areThereMethodsMaxPathSum() {
        assertFalse(methods.isEmpty());
    }
    
    
    /**
     * Testing all variations of this method.
     * <pre>{@code
     * Example 1:
     *     1
     *   /  \
     *  2    3
     * Input: root = [1,2,3]
     * Output: 6
     * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
     *
     * Example 2:
     *   -10
     *  /  \
     * 9    20
     *     /  \
     *    15   7
     * Input: root = [-10,9,20,null,null,15,7]
     * Output: 42
     * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
     *
     * Example 3
     *        5
     *      ┌─┴─┐
     *      4   8
     *    ┌─┘  ┌┴─┐
     *   11   13  4
     *   ┌┴─┐     └─┐
     *   7  2       1
     * root:[5,4,8,11,null,13,4,7,2,null,null,null,1]
     * Expected :48
     *
     * Constraints:
     *     The number of nodes in the tree is in the range [1, 3 * 104].
     *     -1000 <= Node.val <= 1000
     * }</pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            " 6;  1,2,3",
            "42;-10,9,20,null,null,15,7",
            "48;  5,4,8,11,null,13,4,7,2,null,null,null,1",
            " 2;  2,-1",
            " 3;  1,-2,-3,1,3,-2,null,-1",
            "-1; -1,-2,-3"
    })
    void maxPathSum(int exp, String sRoot) {
        
        methods.forEach(m -> {
            TreeNode root = TreeBuilder.buildBiTree(TUtils.StringToIntegerArray(sRoot, ","));
            try {
                assertEquals(exp, m.invoke(obj, root), "\n" +
                                                       "method: " + m.getName() + "\n" +
                                                       "root:" + sRoot + "\n" +
                                                       new TreeFormatter().topDown(root));
                
            } catch (IllegalAccessException | InvocationTargetException e) {
                fail("Method: \"" + m.getName() + " " + Arrays.toString(m.getParameters()) + "\" failed to get invoked.\n" +
                     "exception: \n" +
                     e.getMessage() + "\n" + e.getCause()
                );
            }
            
        });
        
    }
    
    
}