package com.smol.solutions;


import com.smol.solutions.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <h1>94. Binary Tree Inorder Traversal</h1>
 * Easy <p>
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * <pre>{@code
 * Example 1:
 *     1
 *      \
 *       2
 *      /
 *    3
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
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
 *
 *     The number of nodes in the tree is in the range [0, 100].
 *     -100 <= Node.val <= 100
 * }</pre>
 * Follow up: Recursive solution is trivial, could you do it iteratively? <p>
 * <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">LeetCode</a>
 */
public class N0094_BinaryTreeInorderTraversal {
    
    /** Recursion */
    public List<Integer> inorderTraversalR(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    /** Recursion helper */
    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
    
    /** Iterative */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        TreeNode curr = root;
        
        while (curr != null | !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
            
        }
        return res;
    }
}
