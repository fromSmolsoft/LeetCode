package com.smol.solutions;

import com.smol.solutions.utils.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class N0114_FlattenBinaryTreeToLinkedListTest {
    
    private final N0114_FlattenBinaryTreeToLinkedList obj = new N0114_FlattenBinaryTreeToLinkedList();
    private final List<Method> methods = TUtils.reflectMethods(obj.getClass(), "flatten", new Class<?>[]{TreeNode.class});
    private final TreeFormatter tf = new TreeFormatter();
    
    /**
     * <pre>{@code
     * Example 1:
     *    1        1
     *  ┌─┴──┐     └─┐
     *  2    5       2
     * ┌┴─┐  └─┐ =>  └─┐
     * 3  4    6       3
     *                 └─┐
     *                   4
     *                   └─┐
     *                     5
     *                     └─┐
     *                       6
     * Input: root = [1,2,5,3,4,null,6]
     * Output: [1,null,2,null,3,null,4,null,5,null,6]
     *
     * Example 2:
     * Input: root = []
     * Output: []
     *
     * Example 3:
     * Input: root = [0]
     * Output: [0]
     *
     * Constraints:
     *     The number of nodes in the tree is in the range [0, 2000].
     *     -100 <= Node.val <= 100
     * }</pre>
     * Tested method modifies input!
     * @param sExp  The expected string representation of the flattened binary tree.
     * @param sRoot The input string representation of the binary tree to be flattened.
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "1,null,2,null,3,null,4,null,5,null,6;  1,2,5,3,4,null,6",
            " ; ",
            "0;0",
            "1,null,2,null,4,null,3,null,5,null,6,null,8,null,11,null,14,null,19,null,7,null,9,null,10,null,12,null,15,null,20,null,21,null,16,null,22,null,23,null,13,null,17,null,24,null,25,null,18;  " +
            "1,2,3,4,null,5,null,null,null,6,7,8,null,9,10,11,null,null,null,12,13,null,14,15,16,17,18,null,19,20,21,22,23,24,25"
    })
    void flatten(String sExp, String sRoot) {
        TreeNode exp = TreeBuilder.buildBiTree(TUtils.StringToIntegerArray(sExp, ","), TreeNode.class);
        String expMessage = tf.topDown(exp);
        
        methods.forEach(m -> {
            TreeNode root = TreeBuilder.buildBiTree(TUtils.StringToIntegerArray(sRoot, ","), TreeNode.class);
            String inpMessage = "\n" + tf.topDown(root);
            try {
                m.invoke(obj, root);
            } catch (IllegalAccessException | InvocationTargetException e) {
                fail("\nFailed to invoke " +
                     "\nmethod: " + m.getName() +
                     "\nroot:" + inpMessage +
                     "\n" + e.getMessage());
            }
            
            assertEquals(expMessage,
                    tf.topDown(root),
                    "\nmethod: " + m.getName() +
                    "\nroot:" + sRoot +
                    inpMessage);
        });
    }
    
    /**
     * Generates random bi-tree to use it in testing method: flatten()
     */
    @Test
    void rndflatten() {
        Random rnd = new Random();
        int size = 50, nulls = 20;
        
        List<Integer> rootVals = new LinkedList<>();
        List<Integer> expVals = new LinkedList<>();
        
        IntStream.rangeClosed(1, size).forEach(i -> {
            rootVals.add(i);
            expVals.add(i);
            expVals.add(null);
        });
        
        IntStream
                .range(0, nulls)
                .map(index -> rnd.nextInt(1, size - 1))
                .forEach(index -> rootVals.add(index, null));
        
        expVals.remove(expVals.size() - 1);
        
        //String Root
        String sRoot = TUtils.removeSubStrings(rootVals.toString(), "\\[", "\\]", " ");
        
        //String Expected
        TreeNode root = TreeBuilder.buildBiTree(TUtils.StringToIntegerArray(sRoot, ","));
        flattenTree(root);
        String expected = new TreePrinter().printLevelOrder(root);
        
        flatten(expected, sRoot);
    }
    
    /**
     * Flattens a tree into linked list using node's right child-only by solving it recursively.
     * @param root the root node of the tree
     */
    private void flattenTree(TreeNode root) {
        flattenTree(root, null);
    }
    
    /**
     * Recursively solves the tree by modifying the structure of the nodes. <p>
     * Flattens a tree into linked list using node's right child-only by solving it recursively.
     * @param root the root node of the tree
     * @param last the last node of the tree
     * @return the modified root node of the tree
     */
    private TreeNode flattenTree(TreeNode root, TreeNode last) {
        if (root == null) return last;
        root.right = flattenTree(root.left, flattenTree(root.right, last));
        root.left = null;
        return root;
    }
}