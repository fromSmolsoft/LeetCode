package com.smol.solutions;

import com.smol.solutions.utils.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <h1>124. Binary Tree Maximum Path Sum</h1>
 * Hard, #DynamicProgramming, #Tree, #Depth-FirstSearch, #BinaryTree <p>
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.    <p>
 * The path sum of a path is the sum of the node's values in the path.  <p>
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.  <p>
 *
 * <pre>{@code
 * Example 1:
 *     1
 *    ┌┴─┐
 *    2  3
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 *
 * Example 2:
 *  -10
 *  ┌─┴─┐
 *  9  20
 *     ┌┴─┐
 *     15  7
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 *
 * Example 3
 *        5              >5
 *      ┌─┴─┐           ┌─┴─┐
 *      4   8          >4  >8
 *    ┌─┘  ┌┴─┐  ->   ┌─┘  ┌┴─┐
 *   11   13  4     >11  >13  4
 *   ┌┴─┐     └─┐    ┌┴─┐     └─┐
 *   7  2       1   >7  2       1
 * root:[5,4,8,11,null,13,4,7,2,null,null,null,1] *
 * Expected :48
 * Explanation:  7 -> 11 -> 4 -> 5 -> 8 -> 13 , sum = 48
 *
 * Constraints:
 *     The number of nodes in the tree is in the range [1, 3 * 104].
 *     -1000 <= Node.val <= 1000
 * }</pre>
 */
public class N0124_BinaryTreeMaximumPathSum {
    
    /* === Recursive ===  */
    
    int maxR1 = Integer.MIN_VALUE;
    
    /**
     * Calls recursion helper method which updates max variable
     * <pre>
     * Runtime 0ms Beats 100.00% of users with Java
     * Memory 44.53MB Beats 39.28% of users with Java
     * </pre>
     */
    public int maxPathSumR(TreeNode root) {
        helper(root);
        return maxR1;
    }
    
    /**
     * The function recursively calculates the maximum path sum by considering the left and right subtrees of each node. It keeps track of the maximum sum encountered so far and updates it if a larger sum is found. The function returns the maximum sum possible for the current subtree.   <p>
     * In other words:   <p>
     * The function goes from the bottom of the tree to the top, it's in post-order manner.     <p>
     * At every node, it makes a decision, if the sum comes from the left path larger than the right path, it picks the left path and plus the current node's value.    <p>
     * This recursion goes all the way up to the root node.
     */
    public int helper(TreeNode node) {
        if (node == null) return 0;
        
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        
        maxR1 = Math.max(maxR1, left + right + node.val);
        return node.val + Math.max(left, right);
    }
    
    
    /* === Iterative ===  */
    
    public int maxPathSumI(TreeNode root) {
        int result = Integer.MIN_VALUE;
        Map<TreeNode, Integer> maxRootPath = new HashMap<>(); // cache
        maxRootPath.put(null, 0); // for simplicity we want to handle null nodes
        
        for (TreeNode node : topSort(root)) {
            // as we process nodes in post-order their children are already cached
            int left = Math.max(maxRootPath.get(node.left), 0);
            int right = Math.max(maxRootPath.get(node.right), 0);
            
            maxRootPath.put(node, Math.max(left, right) + node.val);
            result = Math.max(left + right + node.val, result);
        }
        return result;
    }
    
    /** just returns the nodes in post-order */
    public Iterable<TreeNode> topSort(TreeNode root) {
        Deque<TreeNode> result = new LinkedList<>();
        
        if (root != null) {
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            
            while (!stack.isEmpty()) {
                TreeNode curr = stack.pop();
                result.push(curr);
                
                if (curr.right != null) stack.push(curr.right);
                if (curr.left != null) stack.push(curr.left);
            }
        }
        return result;
    }
    
}
