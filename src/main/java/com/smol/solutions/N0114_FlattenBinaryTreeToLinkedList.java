package com.smol.solutions;

import com.smol.solutions.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <h1>114. Flatten Binary Tree to Linked List</h1>
 * Medium   <p>
 * Given the root of a binary tree, flatten the tree into a "linked list":  <p>
 * -> The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.  <p>
 * -> The "linked list" should be in the same order as a pre-order traversal of the binary tree. <p>
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
 * Follow up: Can you flatten the tree in-place (with O(1) extra space)?
 */
public class N0114_FlattenBinaryTreeToLinkedList {
    
    /**
     * <h2>Iterative, No stack</h2>
     * <p>
     * 1. If the left child exists, we'll find the rightmost node in the left subtree  <p>
     * 2. We'll connect this rightmost node to root.right  <p>
     * 3. Now, move the left subtree to the right and set root.left = null  <p>
     */
    public void flattenI01(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode mostRight = root.left; /* take left node */
                while (mostRight.right != null) mostRight = mostRight.right; /* Get most right node of current root */
                
                mostRight.right = root.right;   // connect current root right child at the end of previously found most right node
                root.right = root.left;         // replace root right with root left
                root.left = null;               // delete reference of root felt
            }
            root = root.right;  // move (current) root to it's (new) right child
        }
    }
    
    /**
     * <h2>using extra space</h2>
     * <pre>
     * Runtime 1ms Beats 30.93% of users with Java
     * Memory 42.41MB Beats 6.16% of users with Java
     * </pre>
     */
    public void flatten01(TreeNode root) {
        if (root == null) return;
        Queue<Integer> vals = new ArrayDeque<>();
        vals.offer(root.val);
        
        collectValues(root.left, vals);
        collectValues(root.right, vals);
        
        TreeNode dummy = new TreeNode();
        dummy.right = root;
        
        while (!vals.isEmpty()) {
            if (dummy.right == null) dummy.right = new TreeNode();
            dummy = dummy.right;
            
            dummy.val = vals.poll();
            dummy.left = null;
            
        }
    }
    
    /**
     * Collects the values from a binary tree and adds them to a queue.
     * @param root the root node of the binary tree
     * @param vals the queue to store the values
     */
    private void collectValues(TreeNode root, Queue<Integer> vals) {
        if (root == null) return;
        vals.offer(root.val);
        
        collectValues(root.left, vals);
        collectValues(root.right, vals);
    }
    
    /**
     * Flattens the given binary tree into a right-skewed tree.
     * @param root the root of the binary tree to flatten
     */
    public void flattenR02(TreeNode root) {
        solve(root, null);
    }
    
    /**
     * Recursively solves the given binary tree by performing a post-order traversal.
     * @param root the current node being processed
     * @param last the rightmost node of the previous subtree
     * @return the modified binary tree with the left subtree set to null, and the right subtree updated
     */
    private TreeNode solve(TreeNode root, TreeNode last) {
        if (root == null) return last;
        root.right = solve(root.left, solve(root.right, last));
        root.left = null;
        return root;
    }
    
}
    
