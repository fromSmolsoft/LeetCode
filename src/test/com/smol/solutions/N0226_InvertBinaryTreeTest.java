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
import java.util.List;

class N0226_InvertBinaryTreeTest {
    
    private final TreeFormatter formatter = new TreeFormatter();
    private final List<Method> methods = TUtils.reflectMethods(N0226_InvertBinaryTree.class, "invertTree");
    private final N0226_InvertBinaryTree obj = new N0226_InvertBinaryTree();
    
    /**
     * <pre>{@code
     * Example 1:
     *      4            4
     *   ┌──┴──┐      ┌──┴──┐
     *   7     2  ->  2     7
     *  ┌┴─┐  ┌┴─┐   ┌┴─┐  ┌┴─┐
     *  9  6  3  1   1  3  6  9
     * Input: root = [4,2,7,1,3,6,9]
     * Output: [4,7,2,9,6,3,1]
     *
     * Example 2:
     *   2         2
     *  ┌┴─┐  ->  ┌┴─┐
     *  3  1      1  3
     * Input: root = [2,1,3]
     * Output: [2,3,1]
     *
     * Example 3:
     * Input: root = []
     * Output: []
     *
     * Constraints:
     *     The number of nodes in the tree is in the range [0, 100].
     *     -100 <= Node.val <= 100
     * }</pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "4,7,2,9,6,3,1; 4,2,7,1,3,6,9",
            "2,3,1; 2,1,3",
            " ; ",
            "4,null,2,3,1,null,null,9,6;  4,2,null,1,3,6,9",
            "4,2,null,1,3,6,9;  4,null,2,3,1,null,null,9,6",
            "1,null,2,3,null,null,4,5;  1,2,null,null,3,4,null,null,5"
    })
    void invertTree(String sExp, String sRoot) throws InvocationTargetException, IllegalAccessException {
        Integer[] expData = TUtils.StringToIntegerArray(sExp, ",");
        Integer[] rootData = TUtils.StringToIntegerArray(sRoot, ",");
        
        TreeNode expected = TreeBuilder.buildBiTree(expData);
        String messageExp = formatter.topDown(expected);
        
        for (Method m : methods) {
            TreeNode root = TreeBuilder.buildBiTree(rootData);
            String messageRoot = formatter.topDown(root);
            TreeNode actual = (TreeNode) m.invoke(obj, root);
            String messageActual = formatter.topDown(actual);
            String message = "\nmethod:  \n" + m.getName() +
                             "\nroot:    \n" + messageRoot +
                             "\nexpected:\n" + messageExp +
                             "\nactual:  \n" + messageActual;
            
            Assertions.assertEquals(messageExp, messageActual, message);
        }
    }
}