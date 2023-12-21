package com.smol.solutions;

import com.smol.solutions.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <h1>100. Same Tree</h1>
 * Easy, #Tree, #Depth-FirstSearch, #Breadth-FirstSearch, #BinaryTree  <p>
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.  <p>
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.  <p>
 * <pre>{@code
 * Example 1:
 *      (1)         (1)
 *     /   \   =   /   \
 *   (2)   (3)   (2)   (3)
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 *
 * Example 2:
 *     (1)         (1)
 *    /       ≠      \
 *  (2)               (2)
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 *
 * Example 3:
 *      (1)         (1)
 *     /   \   ≠   /   \
 *   (2)   (1)   (1)   (2)
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 * Constraints:
 *     The number of nodes in both trees is in the range [0, 100].
 *     -104 <= Node.val <= 104
 * }</pre>
 */
public class N0100_SameTree {
    
    /**
     * <h2>Recursion</h2>
     * <pre>
     * Runtime 0 ms Beats 100.00 % of users with Java
     * Memory 40.96 MB Beats 5.09 % of users with Java
     * </pre>
     */
    public boolean isSameTreeR(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        
        return isSameTreeR(p.left, q.left) && isSameTreeR(p.right, q.right);
    }
    
    /**
     * <h2>Iteration, stack</h2>
     * <pre>
     * Runtime 0 ms Beats 100.00 % of users with Java
     * Memory 40.30 MB Beats 29.37 % of users with Java
     * </pre>
     */
    public boolean isSameTreeIt01(TreeNode p, TreeNode q) {
        
        Deque<TreeNode> pStack = new LinkedList<>();
        Deque<TreeNode> qStack = new LinkedList<>();
        
        pStack.push(p);
        qStack.push(q);
        
        while (!pStack.isEmpty() && !qStack.isEmpty()) {
            
            p = pStack.pop();
            q = qStack.pop();
            
            if (p == null && q == null) continue;
            else if (p == null || q == null || p.val != q.val) return false;
            
            pStack.push(p.right);
            pStack.push(p.left);
            qStack.push(q.right);
            qStack.push(q.left);
        }
        return true;
    }
    
    /**
     * <h2>Iteration, queue</h2>
     * <pre>
     * Runtime 0 ms Beats 100.00 % of users with Java
     * Memory 40.90 MB Beats 5.09 % of users with Java
     * </pre>
     */
    public boolean isSameTreeIt02(TreeNode p, TreeNode q) {
        Deque<TreeNode> queue = new LinkedList<>();
        
        queue.add(p);
        queue.add(q);
        
        while (!queue.isEmpty()) {
            
            p = queue.poll();
            q = queue.poll();
            
            if (p == null && q == null) continue;
            else if (p == null || q == null || p.val != q.val) return false;
            
            queue.add(p.left);
            queue.add(q.left);
            queue.add(p.right);
            queue.add(q.right);
        }
        return true;
    }
}

