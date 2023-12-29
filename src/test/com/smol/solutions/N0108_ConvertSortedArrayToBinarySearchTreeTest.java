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

class N0108_ConvertSortedArrayToBinarySearchTreeTest {
    private final N0108_ConvertSortedArrayToBinarySearchTree obj = new N0108_ConvertSortedArrayToBinarySearchTree();
    private final Class<?>[] types = {int[].class};
    private final List<Method> methods = TUtils.reflectMethods(N0108_ConvertSortedArrayToBinarySearchTree.class, "sortedArrayToBST", types);
    
    /**
     * <pre>{@code
     * Example 1:
     *      0     |     0
     *    ┌─┴──┐  |   ┌─┴──┐
     *   -3    9  |  -10   5
     *  ┌─┘  ┌─┘  |   └─┐  └─┐
     * -10   5    |    -3    9
     *
     * Input: nums = [-10,-3,0,5,9]
     * Output: [0,-3,9,-10,null,5]
     * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
     *
     * Example 2:
     *     3  |  1
     *   ┌─┘  |  └─┐
     *   1    |    3
     *
     * Input: nums = [1,3]
     * Output: [3,1]
     * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
     *
     * Constraints:
     *     1 <= nums.length <= 104
     *     -104 <= nums[i] <= 104
     *     nums is sorted in a strictly increasing order.
     * }</pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "0,-3,9,-10,null,5; 0,-10,5,null,-3,null,9; -10,-3,0,5,9",
            "3,1;               1,null,3;                1,3",
            "3,1,5,0,2,4;       2,0,4,null,1,3,5;        0,1,2,3,4,5",
            "3,2,5,1,null,4;    3,1,4,null,2,null,5;     1,2,3,4,5",
            "0,-1,1;            0,-1,1;                 -1,0,1",
            "0;                 0;                       0",
            "1,0;               0,null,1;                0,1",
        
    })
    void sortedArrayToBST(String sExp1, String sExp2, String sNums) throws InvocationTargetException, IllegalAccessException {
        TreeNode exp1 = Trees.buildBiTree(TUtils.StringToIntegerArray(sExp1, ","));
        TreeNode exp2 = Trees.buildBiTree(TUtils.StringToIntegerArray(sExp2, ","));
        int[] nums = TUtils.StringToIntArray(sNums, ",");
        
        TreeFormatter formatter = new TreeFormatter();
        String sExpRoot1 = formatter.topDown(exp1);
        String sExpRoot2 = formatter.topDown(exp2);
        
        for (Method m : methods) {
            TreeNode root = (TreeNode) m.invoke(obj, (Object) nums);
            String sRoot = formatter.topDown(root);
            System.out.println(sRoot);
            Assertions.assertTrue(sRoot.equals(sExpRoot1) || sRoot.equals(sExpRoot2),
                    "\nnums:" + sNums +
                    "\nexp1\n" + sExpRoot1 +
                    "\nexp2\n" + sExpRoot2 +
                    "\nact\n" + sRoot
            );
        }
    }
}