package com.smol.solutions;

import com.smol.solutions.utils.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <h1>106. Construct Binary Tree from Inorder and Postorder Traversal</h1>
 * Medium
 * <p>
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 *
 * <pre>{@code
 * Example 1:
 *
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 *
 * Example 2:
 *
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 *
 * Constraints:
 *     1 <= inorder.length <= 3000
 *     postorder.length == inorder.length
 *     -3000 <= inorder[i], postorder[i] <= 3000
 *     inorder and postorder consist of unique values.
 *     Each value of postorder also appears in inorder.
 *     inorder is guaranteed to be the inorder traversal of the tree.
 *     postorder is guaranteed to be the postorder traversal of the tree.
 * }</pre>
 */
public class N0106_ConstructBinaryTreeFromInorderPostorder {
    
    /**
     * <h2>Recursion </h2>
     * Builds a binary tree using the given inorder and postorder traversal arrays.
     * <pre>
     * Runtime    1 ms Beats 97.14 % of users with Java
     * Memory 44.56 MB Beats 7.09 % of users with Java
     * </pre>
     * @param inorder   the inorder traversal array
     * @param postorder the postorder traversal array
     * @return the root node of the constructed binary tree
     */
    public TreeNode buildTreeR(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) return null;
        
        Map<Integer, Integer> inMap = new HashMap<>();  //map <val, index> of inorder
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);  // fill in the map
        
        return buildTreeR(0, inorder.length - 1, postorder.length - 1, inMap, postorder);
    }
    
    /**
     * Builds a binary tree from the given inorder map and postorder traversal array.
     * <h3>how the algorithm works:</h3>
     * - The algorithm builds a binary tree using two inputs: the inorder map and the postorder traversal array. The inorder map stores the index of each element in the inorder traversal array.<p>
     * - The algorithm starts by checking if the starting index of the postorder array (postStart) is less than 0 or if the starting index of the inorder array (inStart) is greater than the ending index of the inorder array (inEnd). If either of these conditions is true, it means there are no more elements to build the tree, so it returns null.<p>
     * - If the conditions are not met, the algorithm creates a new tree node with the value at index postStart in the postorder array. This node becomes the root of the current subtree.<p>
     * - The algorithm then finds the index of the root value in the inorder map. This helps determine the elements in the left and right subtrees of the current root.<p>
     * <p>
     * - To build the left subtree, the algorithm recursively calls itself, passing the following parameters:<p>
     * - - inStart: the starting index of the inorder array <p>
     * - - curr - 1: the index of the root value in the inorder array minus 1   <p>
     * - - postStart - 1: the index of the root value in the postorder array minus 1    <p>
     * - - inMap: the inorder map   <p>
     * - - postorder: the postorder array   <p>
     * <p>
     * - To build the right subtree, the algorithm recursively calls itself, passing the following parameters:    <p>
     * - - curr + 1: the index of the root value in the inorder array plus 1    <p>
     * - - inEnd: the ending index of the inorder array <p>
     * - - postStart - (inEnd - curr) - 1: the index of the root value in the postorder array minus the difference between inEnd and curr minus 1   <p>
     * - - inMap: the inorder map   <p>
     * - - postorder: the postorder array   <p>
     * - - The algorithm assigns the left and right subtrees to the root node and returns the root node.    <p>
     * <p>
     * - By recursively building the left and right subtrees, the algorithm constructs the entire binary tree.    <p>
     * @param inStart   the starting index of the inorder traversal array
     * @param inEnd     the ending index of the inorder traversal array
     * @param postStart the starting index of the postorder traversal array
     * @param inMap     a map that stores the index of each element in the inorder traversal array
     * @param postorder the postorder traversal array
     * @return the root node of the binary tree
     */
    public TreeNode buildTreeR(int inStart, int inEnd, int postStart, Map<Integer, Integer> inMap, int[] postorder) {
        if (postStart < 0 || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(postorder[postStart]);
        int curr = inMap.get(root.val);
        
        root.left = buildTreeR(
                inStart,
                curr - 1,
                postStart - (inEnd - curr) - 1,
                inMap,
                postorder);
        
        root.right = buildTreeR(
                curr + 1,
                inEnd,
                postStart - 1,
                inMap,
                postorder);
        
        return root;
    }
    
    public TreeNode buildTreeI(int[] inorder, int[] postorder) {
        // find root in postOrder(last in postOrder)
        // find root in inOrder
        // left / right child (subtrees) are next to root inOrder
        
        if (inorder.length == 0) return null;
        
        Map<Integer, Integer> inMap = new HashMap<>();  //map <val, index> of inorder
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);  // fill in the map
        
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        stack.push(root);
        
        for (int in = inorder.length - 1, po = postorder.length - 2; po >= 0; po--) {
            
            while (!stack.isEmpty() && stack.peek().val == inorder[in]) {
                prev = stack.pop();
                in--;
            }
            
            TreeNode cur = new TreeNode(postorder[po]);
            if (prev != null) {
                prev.left = cur;
                prev = null;
                
            } else stack.peek().right = cur;
            stack.push(cur);
            
        }
        
        return root;
    }
}
