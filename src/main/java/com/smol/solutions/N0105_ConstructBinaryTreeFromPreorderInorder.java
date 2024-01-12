package com.smol.solutions;

import com.smol.solutions.utils.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <h1>105. Construct Binary Tree from Preorder and Inorder Traversal</h1>
 * Medium, #Array, #HashTable, #DivideAndConquer, #Tree, #BinaryTree    <p>
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 * <pre>
 * Example 1:
 *    3
 *  ┌─┴─┐
 *  9  20
 *     ┌┴─┐
 *    15  7
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * Example 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 * Constraints:
 *     1 <= preorder.length <= 3000
 *     inorder.length == preorder.length
 *     -3000 <= preorder[i], inorder[i] <= 3000
 *     preorder and inorder consist of unique values.
 *     Each value of inorder also appears in preorder.
 *     preorder is guaranteed to be the preorder traversal of the tree.
 *     inorder is guaranteed to be the inorder traversal of the tree.
 * </pre>
 */
public class N0105_ConstructBinaryTreeFromPreorderInorder {
    
    /**
     * <h2>Recursion</h2>
     * Runtime 1 ms Beats 93.64 % of users with Java
     * Memory 44.42 MB Beats 11.88 % of users with Java
     */
    public TreeNode buildTreeR(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        
        return buildTreeR(0, 0, inorder.length - 1, preorder, inMap);
    }
    
    /** Helper method. Recursion. */
    private TreeNode buildTreeR(int preStart, int inStart, int inEnd, int[] preorder, Map<Integer, Integer> inMap) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = inMap.get(root.val);
        
        root.left = buildTreeR(preStart + 1, inStart, inIndex - 1, preorder, inMap);
        root.right = buildTreeR(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inMap);
        
        return root;
    }
    
    /**
     * <h2>Iteration, stack</h2>
     */
    public TreeNode buildTreeIS(int[] preorder, int[] inorder) {
        if (inorder == null || inorder.length == 0) return null;
       
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode node = null;
        
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        
        for (int i = 1,j = 0; i < preorder.length; i++) {
            TreeNode cur = new TreeNode(preorder[i]);
            while (!stack.isEmpty() && stack.peek().val == inorder[j]) {
                node = stack.pop();
                j++;
            }
            if (node != null) {
                node.right = cur;
                node = null;
            } else {
                stack.peek().left = cur;
            }
            stack.push(cur);
        }
        return root;
    }
    
}
