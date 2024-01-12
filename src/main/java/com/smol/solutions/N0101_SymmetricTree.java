package com.smol.solutions;

import com.smol.solutions.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <h1>101. Symmetric Tree</h1>
 * Easy <p>
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * <pre>{@code
 * Example 1:
 *      1
 *   ┌──┴──┐
 *   2     2
 *  ┌┴─┐  ┌┴─┐
 *  3  4  4  3
 *
 * Input:  root = [1,2,2,3,4,4,3]
 * Output: true
 *
 * Example 2:
 *     1
 *   ┌─┴──┐
 *   2    2
 *   └─┐  └─┐
 *     3    3
 * Input:  root = [1,2,2,null,3,null,3]
 * Output: false
 *
 * Constraints:
 *     The number of nodes in the tree is in the range [1, 1000].
 *     -100 <= Node.val <= 100
 * }</pre>
 * Follow up: Could you solve it both recursively and iteratively?
 */
public class N0101_SymmetricTree {
    
    /**
     * <h2>Iteration</h2>
     * Divides tree to two sub-trees `A` and `B`
     * Uses queues to store `TreeNode`s in traversal order
     * <pre>{@code
     * root = [1,2,2,3,4,4,3]
     *            (root)
     *               1
     *           ┌───┴───┐
     * subTrees (A)     (B)
     *           2       2
     *          ┌┴─┐    ┌┴─┐
     *          3  4    4  3
     * }</pre>
     * Iterates both sub-trees in same but mirrored order and looks for first difference.
     * <pre>{@code
     *     1ts     |     2nd      |     3rd
     *  (A)   (B)  |  (A)   (B)   | (A)    (B)
     *  [2]   [2]  |   2     2    |  2      2
     *  ┌┴─┐  ┌┴─┐ |  ┌┴─┐  ┌┴─┐  | ┌┴─┐   ┌┴─┐
     *  3  4  4  3 | [3] 4  4 [3] | 3 [4] [4]  3
     * }
     * Runtime 1ms Beats 15.57 % of users with Java
     * Memory 41.28 MB Beats 10.92 % of users with Java
     * </pre>
     */
    public boolean isSymmetricItQ(TreeNode root) {
        
        Queue<TreeNode> aQue = new LinkedList<>();
        Queue<TreeNode> bQue = new LinkedList<>();
        
        aQue.add(root.left);
        bQue.add(root.right);
        
        while (!aQue.isEmpty() && !bQue.isEmpty()) {
            TreeNode aNode = aQue.poll();
            TreeNode bNode = bQue.poll();
            
            if (aNode == null && bNode == null) continue;
            else if (aNode == null || bNode == null || aNode.val != bNode.val) return false;
            
            //order of adding lefts & rights is important
            aQue.add(aNode.left);
            aQue.add(aNode.right);
            
            bQue.add(bNode.right);
            bQue.add(bNode.left);
        }
        return true;
    }
    
    /**
     * <h2>Iteration</h2>
     * Divides tree to two sub-trees `A` and `B`
     * Uses stacks to store `TreeNode`s in reversed traversal order
     * <pre>{@code
     * root = [1,2,2,3,4,4,3]
     *            (root)
     *               1
     *           ┌───┴───┐
     * subTrees (A)     (B)
     *           2       2
     *          ┌┴─┐    ┌┴─┐
     *          3  4    4  3
     * }</pre>
     * Iterates both sub-trees in same but mirrored order and looks for first difference.
     * <pre>{@code
     *     1ts     |     2nd      |     3rd
     *  (A)   (B)  |  (A)   (B)   | (A)    (B)
     *  [2]   [2]  |   2     2    |  2      2
     *  ┌┴─┐  ┌┴─┐ |  ┌┴─┐  ┌┴─┐  | ┌┴─┐   ┌┴─┐
     *  3  4  4  3 | [3] 4  4 [3] | 3 [4] [4]  3
     * }
     * Runtime 1 ms Beats 15.57 % of users with Java
     * Memory 41.48 MB Beats 5.65 % of users with Java
     * </pre>
     */
    
    public boolean isSymmetricItS(TreeNode root) {
        
        Deque<TreeNode> aStack = new LinkedList<>();
        Deque<TreeNode> bStack = new LinkedList<>();
        
        aStack.push(root.left);
        bStack.push(root.right);
        
        while (!aStack.isEmpty() && !bStack.isEmpty()) {
            TreeNode aNode = aStack.pop();
            TreeNode bNode = bStack.pop();
            
            if (aNode == null && bNode == null) continue;
            else if (aNode == null || bNode == null || aNode.val != bNode.val) return false;
            
            //order of pushing lefts & rights is important
            aStack.push(aNode.right);
            aStack.push(aNode.left);
            
            bStack.push(bNode.left);
            bStack.push(bNode.right);
        }
        return true;
    }
    
    /**
     * <h2>Recursion</h2>
     * <pre>
     * Runtime 0 ms Beats 100.00 % of users with Java
     * Memory 41.62 MB Beats 5.65 % of users with Java
     * </pre>
     */
    public boolean isSymmetricR(TreeNode root) {
        if (root == null) return true;
        return isSymmetricR(root.left, root.right);
    }
    
    /**
     * <h3>Recursion logic</h3>
     * Method is overloading it's caller.
     */
    public boolean isSymmetricR(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return isSymmetricR(a.left, b.right) && isSymmetricR(a.right, b.left);
    }
}
