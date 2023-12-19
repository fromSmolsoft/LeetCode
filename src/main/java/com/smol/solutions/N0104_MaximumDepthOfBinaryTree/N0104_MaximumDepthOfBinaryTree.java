package com.smol.solutions.N0104_MaximumDepthOfBinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/** <h1>104. Maximum Depth of Binary Tree</h1> */
public class N0104_MaximumDepthOfBinaryTree implements N0104_MDOBT {
    
    /**
     * <h2>Recursive solution</h2>
     * #Recursion <p>
     * if the node does not exist, return 0. Otherwise, return the 1+the longer distance of its subtree.
     * <pre>
     * Runtime 0 ms Beats 100.00 % of users with Java
     * Memory 41.42 MB Beats 64.45 % of users with Java
     * </pre>
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.max(left, right) + 1;
    }
    
    /**
     * <h2> Iterative solution</h2>
     * #Iteration #Stack <p>
     * iterates nodes from root further deep down into tree.    <p>
     * - Stores node's children in stack, if children exist and Stores depth incremented counter in second stack    <p>
     * - If node has no children saves max depth if it is bigger than previous value.   <p>
     * - Pops each stored node and counter from stack to repeat process.    <p>
     * <pre>
     * Runtime 2 ms Beats 11.40 % of users with Java
     * Memory 41.63 MB Beats 47.48 % of users with Java
     * </pre>
     */
    public int maxDepthIt01(TreeNode root) {
        if (root == null) return 0;
        int max = 1;
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Integer> depths = new ArrayDeque<>();
        
        nodes.push(root);
        depths.push(1);
        
        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.pop();
            int depth = depths.pop();
            
            if (curr.left == null && curr.right == null) {
                max = Math.max(max, depth);
            }
            
            if (curr.right != null) {
                nodes.push(curr.right);
                depths.push(depth + 1);
            }
            if (curr.left != null) {
                nodes.push(curr.left);
                depths.push(depth + 1);
            }
        }
        
        return max;
    }
    
    /**
     * <h2> Breadth-First Search, Iterative with Queue </h2>
     * #Queue #Breadth-FirstSearch
     * <p>
     */
    public int maxDepthIt02(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            count++;
        }
        return count;
    }
    
}
