package com.smol.solutions;

import com.smol.solutions.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <h1>226. Invert Binary Tree</h1>
 * Easy, #Tree, #Depth-First Search, #Breadth-First Search, #Binary Tree    <p>
 * Given the root of a binary tree, invert the tree, and return its root.
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
 *    2           2
 *   ┌┴─┐   ->   ┌┴─┐
 *   3  1        1  3
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
public class N0226_InvertBinaryTree {
    
    /**
     * <h2>Recursion</h2>
     * <pre>
     * Runtime 0ms Beats 100.00% of users with Java
     * Memory 40.75MB Beats 5.97% of users with Java
     * </pre>
     */
    public TreeNode invertTreeR(TreeNode root) {
        if (root == null) return root;
        
        invertTreeR(root.left);
        invertTreeR(root.right);
        
        TreeNode leftNode = root.right;
        root.right = root.left;
        root.left = leftNode;
        
        return root;
    }
    
    /**
     * <h2>Iteration + Queue</h2>
     * <pre>
     * Runtime 0ms Beats 100.00% of users with Java
     * Memory 40.75MB Beats 5.97% of users with Java
     * </pre>
     */
    public TreeNode invertTreeItQ(TreeNode root) {
        
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            
            TreeNode tempNode = queue.poll();
            if (tempNode == null) continue;
            
            TreeNode leftNode = tempNode.right;
            tempNode.right = tempNode.left;
            tempNode.left = leftNode;
            
            queue.add(tempNode.right);
            queue.add(tempNode.left);
            
        }
        return root;
    }
    
    /**
     * <h2>Iteration + Queue</h2>
     * <pre>
     * Runtime 0ms Beats 100.00% of users with Java
     * Memory 40.75MB Beats 5.97% of users with Java
     * </pre>
     */
    public TreeNode invertTreeItS(TreeNode root) {
        
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            
            TreeNode tempNode = stack.pop();
            if (tempNode == null) continue;
            
            TreeNode leftNode = tempNode.right;
            tempNode.right = tempNode.left;
            tempNode.left = leftNode;
            
            stack.push(tempNode.right);
            stack.push(tempNode.left);
        }
        return root;
    }
}
