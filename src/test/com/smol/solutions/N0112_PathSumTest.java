package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import com.smol.solutions.utils.TreeFormatter;
import com.smol.solutions.utils.TreeNode;
import com.smol.solutions.utils.Trees;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

class N0112_PathSumTest {
    
    private final N0112_PathSum obj = new N0112_PathSum();
    private final Class<?>[] types = {TreeNode.class, int.class};
    private final List<Method> list = TUtils.reflectMethods(N0112_PathSum.class, "hasPathSum", types);
    
    /**
     * <pre> {@code
     * Example 1:
     *       5
     *     ┌─┴─┐
     *     4   8
     *   ┌─┘  ┌┴─┐
     *  11   13  4
     *  ┌┴─┐     └─┐
     *  7  2       1
     *
     * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
     * Output: true
     * Explanation: The root-to-leaf path with the target sum is shown.
     *
     * Example 2:
     *       1
     *      ┌┴─┐
     *      2  3
     * Input: root = [1,2,3], targetSum = 5
     * Output: false
     * Explanation: There two root-to-leaf paths in the tree:
     * (1 --> 2): The sum is 3.
     * (1 --> 3): The sum is 4.
     * There is no root-to-leaf path with sum = 5.
     *
     * Example 3:
     * Input: root = [], targetSum = 0
     * Output: false
     * Explanation: Since the tree is empty, there are no root-to-leaf paths.
     *
     * Constraints:
     *     The number of nodes in the tree is in the range [0, 5000].
     *     -1000 <= Node.val <= 1000
     *     -1000 <= targetSum <= 1000
     * }</pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "true; 22; 5,4,8,11,null,13,4,7,2,null,null,null,1",
            "false; 5; 1,2,3",
            "false; 0; ",
            "false; 1; 1,2",
            "true; -5; -2,null,-3",
            "true;  7; 8,9,-6,null,null,5,9"
    })
    void hasPathSum(boolean exp, int targetSum, String sRoot) throws InvocationTargetException, IllegalAccessException {
        TreeNode root = Trees.buildBiTree(TUtils.StringToIntegerArray(sRoot, ","));
        
        for (Method m : list) {
            boolean act = (boolean) m.invoke(obj, root, targetSum);
            Assertions.assertEquals(exp, act,
                    "\nmethod: " + m.getName() +
                    "\nroot:" + sRoot + "\n" + new TreeFormatter().topDown(root));
        }
        
    }
}