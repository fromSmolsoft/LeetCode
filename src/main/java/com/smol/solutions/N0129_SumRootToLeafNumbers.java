package com.smol.solutions;

import com.smol.solutions.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


/**
 * <h1>129. Sum Root to Leaf Numbers</h1>
 * Medium, Tree, Depth-FirstSearch, BinaryTree <p>
 * You are given the root of a binary tree containing digits from 0 to 9 only. <p>
 * Each root-to-leaf path in the tree represents a number. <p>
 * - For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123. <p>
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.  <p>
 * A leaf node is a node with no children. <p>
 * <pre>{@code
 * Example 1:
 *      1
 *    /   \
 *   2     3
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 *
 * Example 2:
 *           4
 *         /   \
 *       9      4
 *      / \
 *     5   1
 * Input: root = [4,9,0,5,1]
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 1000].
 * 0 <= Node.val <= 9
 * The depth of the tree will not exceed 10.
 * }</pre>
 */
public class N0129_SumRootToLeafNumbers {
    
    int sum = 0;
    
    /**
     * Calculates the sum of numbers formed by digits from all possible root to leaf paths in a binary tree. <p>
     * Algorithm:   <p>
     * This function performs a level order traversal on the binary tree using two
     * queues. Starting from the root node, it iteratively visits each node and
     * store the value of each child node by adding the current node's value
     * multiplied by 10 to form a number. If a node is a leaf node, formed value is added to the sum.
     * Finally, it returns the sum of all leaf node values.
     * @param root the root node of the binary tree
     * @return the sum of all the numbers formed by the root to leaf paths in the binary tree
     */
    public int sumNumbersI01(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        Queue<Integer> nums = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nums.offer(root.val);
        nodes.offer(root);
        int sum = 0;
        
        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.poll();
            int num = nums.poll();
            
            if (curr.left == null && curr.right == null) sum += num;
            
            if (curr.left != null) {
                nodes.offer(curr.left);
                nums.offer(curr.left.val + num * 10);
            }
            
            if (curr.right != null) {
                nodes.offer(curr.right);
                nums.offer(curr.right.val + num * 10);
            }
        }
        return sum;
    }
    
    /**
     * Calculates the sum of  numbers formed by digits from all possible root to leaf paths in a binary tree.
     * <p>
     * This function performs a level order traversal on the binary tree using a
     * queue. Starting from the root node, it iteratively visits each node and
     * updates the value of each child node by adding the current node's value
     * multiplied by 10 to form a number. If a node is a leaf node, its value is added to the sum.
     * Finally, it returns the sum of all leaf node values.
     * <pre>
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 41.01 MB Beats 17.86% of users with Java
     * </pre>
     * @param root the root node of the binary tree
     * @return the sum of all numbers in the binary tree
     */
    public int sumNumbersI02(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        int sum = 0;
        
        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.poll();
            int num = curr.val;
            
            if (curr.left == null && curr.right == null) sum += num;
            
            if (curr.left != null) {
                curr.left.val = curr.left.val + num * 10;
                nodes.offer(curr.left);
            }
            if (curr.right != null) {
                curr.right.val = curr.right.val + num * 10;
                nodes.offer(curr.right);
            }
        }
        return sum;
    }
    
    /**
     * Calculates the sum of all numbers formed from all digits in all root-leaf paths in the binary tree.
     * @param root the root of the binary tree
     * @return the sum of all numbers in the binary tree
     */
    public int sumNumbersR01(TreeNode root) {
        return helper(root, 0);
    }
    
    /**
     * Recursively calculates the sum of all numbers formed from all digits in all root-leaf paths in the binary tree.
     * @param root the root node of the binary tree
     * @param prev the value from the previous level of the tree
     * @return the sum of values in the binary tree
     */
    private int helper(TreeNode root, int prev) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return prev * 10 + root.val;
        
        int lSum = helper(root.left, prev * 10 + root.val);
        int rSum = helper(root.right, prev * 10 + root.val);
        
        return lSum + rSum;
    }
    
    public int sumNumbersRS(TreeNode root) {
        helper(root, "");
        return sum;
    }
    
    public void helper(TreeNode root, String str) {
        if (root == null) return;
        str += root.val;
        
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(str);
            return;
        }
        helper(root.left, str);
        helper(root.right, str);
    }
    
}
