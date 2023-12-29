package com.smol.solutions;

import com.smol.solutions.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <h1>112. Path Sum</h1>
 * Easy, #Tree, #Depth-First, #Breadth-First, #BinaryTree
 * <p>
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * <p>
 * A leaf is a node with no children.
 *
 * <pre> {@code
 * Example 1:
 *       5
 *     ┌─┴─┐
 *     4   8
 *   ┌─┘  ┌┴─┐
 *  11   13  4
 *  ┌┴─┐     └─┐
 *  7  2       1
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 *
 * Example 2:
 *       1
 *      ┌┴─┐
 *      2  3
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * Explanation: There two root-to-leaf paths in the tree:
 * (1 --> 2): The sum is 3.
 * (1 --> 3): The sum is 4.
 * There is no root-to-leaf path with sum = 5.
 *
 * Example 3:
 * Input: root = [], targetSum = 0
 * Output: false
 * Explanation: Since the tree is empty, there are no root-to-leaf paths.
 *
 * Constraints:
 *     The number of nodes in the tree is in the range [0, 5000].
 *     -1000 <= Node.val <= 1000
 *     -1000 <= targetSum <= 1000
 * }</pre>
 */
public class N0112_PathSum {
    
    /**
     * <h2> Iterative + stack </h2>
     */
    public boolean hasPathSumIt(TreeNode root, int targetSum) {
        if (root == null) return false;
        
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> sums = new LinkedList<>();
        
        stack.push(root);
        sums.push(root.val);
        
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            int currSum = sums.pop();
            
            if (curr == null) continue;
            else if (curr.left == null && curr.right == null && currSum == targetSum) return true;
            
            if (curr.left != null) {
                stack.push(curr.left);
                sums.push(curr.left.val + currSum);
            }
            if (curr.right != null) {
                stack.push(curr.right);
                sums.push(curr.right.val + currSum);
            }
            
        }
        return false;
    }
    
    /**
     * <h2>Recursion</h2>
     */
    public boolean hasPathSumR(TreeNode root, int targetSum) {
        if (root == null) return false; //
        if (root.left == null && root.right == null) return targetSum == root.val; //leas node (no children)
        return hasPathSumR(root.left, targetSum - root.val) || hasPathSumR(root.right, targetSum - root.val);
    }
    
    
}
