package com.smol.solutions.utils;

/**
 * <h1>Binary tree node.</h1>
 * Definition for a binary tree node for case "104. Maximum Depth of Binary Tree".
 */
public class TreeNode {
    
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode() {}
    
    public TreeNode(int val) {this.val = val;}
    
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
