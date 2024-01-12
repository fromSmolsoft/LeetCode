package com.smol.solutions;

import com.smol.solutions.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <h1>145. Binary Tree Postorder Traversal</h1>
 * Easy
 * <p>
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 * <pre>{@code
 * Example 1:
 *     1
 *      \
 *       2
 *      /
 *    3
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 *
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 *
 * Constraints:
 *     The number of the nodes in the tree is in the range [0, 100].
 *     -100 <= Node.val <= 100
 * }</pre>
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class N0145_BinaryTreePostorderTraversal {
    
    /** Recursion */
    public List<Integer> postorderTraversalR(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    /** Recursion helper */
    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }
    
    /** Iterative */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            list.add(0, curr.val); //<= reverses order in a list
            
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }
        return list;
    }
    
}
