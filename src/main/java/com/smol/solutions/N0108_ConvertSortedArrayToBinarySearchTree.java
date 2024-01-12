package com.smol.solutions;

import com.smol.solutions.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <h1>108. Convert Sorted Array to Binary Search Tree</h1>
 * Easy
 * <p>
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced
 * binary search tree.
 * <pre>{@code
 * Example 1:
 *             0
 *          ┌──┴──┐
 *         -3     9
 *        ┌─┴   ┌─┴
 *      -10     5
 *
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 *         0
 *     ┌───┴──┐
 *   -10      5
 *     ┴──┐   ┴──┐
 *       -3      9
 *
 * Input: nums = [1,3]
 * Output: [3,1]
 *
 * Example 3:
 *     3
 *  ┌──┴───┐
 *  1      5
 * ┌┴─┐  ┌─┘
 * 0  2  4
 * Input: nums= [0,1,2,3,4,5]
 * Output:[3,1,5,0,2,4]
 *
 * Constraints:
 *     1 <= nums.length <= 104
 *     -104 <= nums[i] <= 104
 *     nums is sorted in a strictly increasing order.
 * }</pre>
 */
public class N0108_ConvertSortedArrayToBinarySearchTree {
    
    
    /**
     * Calls recursion method.
     * <pre>
     * Runtime    0 ms Beats 100.00 % of users with Java
     * Memory 43.38 MB Beats 56.75 % of users with Java
     * </pre>
     */
    public TreeNode sortedArrayToBSTR(int[] nums) {
        if (nums == null || nums.length < 1) return null;
        return sortedArrayToBSTR(0, nums.length - 1, nums);
    }
    
    
    /** Recursion */
    private TreeNode sortedArrayToBSTR(int start, int end, int[] nums) {
        if (start > end) return null;
        
        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        
        root.left = sortedArrayToBSTR(start, middle - 1, nums);
        root.right = sortedArrayToBSTR(middle + 1, end, nums);
        
        return root;
    }
    
    /**
     * <h2>Iterative solution</h2>
     * @author <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/solutions/3103720/clean-java-iterative-solution-very-intuitive/">FaangSucks</a>
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        var root = new TreeNode();
        Queue<Subtree> q = new LinkedList<>();
        q.offer(new Subtree(root, 0, nums.length - 1));
        
        while (!q.isEmpty()) {
            int lvlSize = q.size();
            for (int i = 0; i < lvlSize; i++) {
                Subtree node = q.poll();
                TreeNode curr = node.node;
                int l = node.l, r = node.r;
                
                int mid = (r + l) / 2;
                curr.val = nums[mid];
                
                // add both children with ranges to q
                // left
                if (mid > l) {
                    curr.left = new TreeNode();
                    q.offer(new Subtree(curr.left, l, mid - 1));
                }
                
                // right
                if (r > mid) {
                    curr.right = new TreeNode();
                    q.offer(new Subtree(curr.right, mid + 1, r));
                }
            }
        }
        
        return root;
    }
    
    /** Helper class to iterative solution */
    class Subtree {
        TreeNode node;
        int l;
        int r;
        
        Subtree(TreeNode node, int l, int r) {
            this.l = l;
            this.r = r;
            this.node = node;
        }
    }
    
    
}
