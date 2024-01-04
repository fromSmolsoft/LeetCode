package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import com.smol.solutions.utils.TreeFormatter;
import com.smol.solutions.utils.TreeNode;
import com.smol.solutions.utils.TreeBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

class N0106_ConstructBinaryTreeFromInorderPostorderTest {
    
    private final N0106_ConstructBinaryTreeFromInorderPostorder obj = new N0106_ConstructBinaryTreeFromInorderPostorder();
    private final Class<?>[] types = new Class[]{int[].class, int[].class};
    private final List<Method> methods = TUtils.reflectMethods(N0106_ConstructBinaryTreeFromInorderPostorder.class, "buildTree", types);
    
    /**
     * <pre>{@code
     * Example 1:
     *   3
     * ┌─┴─┐
     * 9  20
     *    ┌┴─┐
     *   15  7
     * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
     * Output: [3,9,20,null,null,15,7]
     *
     * Example 2:
     *
     * Input: inorder = [-1], postorder = [-1]
     * Output: [-1]
     *
     * Constraints:
     *     1 <= inorder.length <= 3000
     *     postorder.length == inorder.length
     *     -3000 <= inorder[i], postorder[i] <= 3000
     *     inorder and postorder consist of unique values.
     *     Each value of postorder also appears in inorder.
     *     inorder is guaranteed to be the inorder traversal of the tree.
     *     postorder is guaranteed to be the postorder traversal of the tree.
     * }</pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "3,9,20,null,null,15,7; 9,3,15,20,7;    9,15,7,20,3",
            "-1; -1; -1",
            "1,2,3,4,5,null,6;  4,2,5,1,3,6;  4,5,2,6,3,1",
            "1,null,2,null,3,null,4,null,5;     1,2,3,4,5; 5,4,3,2,1",
            "1,2,null,3,null,4,null,5,null,6;   6,5,4,3,2,1;   6,5,4,3,2,1",
            "1,5,3,9,null,7;    9,5,1,7,3;  9,5,7,3,1",
            "1,2,3,4,5,null,7,8,null,9,null,6;  8,4,2,9,5,1,3,6,7;  8,4,9,5,2,6,7,3,1"
    })
    void buildTree(String sExp, String sInorder, String sPostorder) throws InvocationTargetException, IllegalAccessException {
        TreeNode expRoot = TreeBuilder.buildBiTree(TUtils.StringToIntegerArray(sExp, ","));
        int[] inOrder = TUtils.StringToIntArray(sInorder, ",");
        int[] postOrder = TUtils.StringToIntArray(sPostorder, ",");
        
        TreeFormatter formatter = new TreeFormatter();
        
        String exp = formatter.topDown(expRoot);
        String in = "\ninOrder  :" + Arrays.toString(inOrder);
        String post = "\npostOrder: " + Arrays.toString(postOrder);
        
        for (Method m : methods) {
            String act = formatter.topDown((TreeNode) m.invoke(obj, inOrder, postOrder));
            String message = in + post;
            
            Assertions.assertEquals(exp, act, "\n" + message);
        }
    }
}