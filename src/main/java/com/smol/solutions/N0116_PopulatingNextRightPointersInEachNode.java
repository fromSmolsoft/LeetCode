package com.smol.solutions;

import com.smol.solutions.utils.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <h1>116. Populating Next Right Pointers in Each Node</h1>
 * Medium, #Linked List, #Tree, #Depth-FirstSearch, #Breadth-FirstSearch, #BinaryTree
 * <p>
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
 * The binary tree has the following definition:
 * <pre> {@code
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * }</pre>
 * <p>
 *
 * <pre> {@code
 * Example 1:
 *         1                 1 --------> null
 *       /   \             /   \
 *      2     3           2---->3 -----> null
 *    / \     / \       / \     / \
 *   4   5   6   7     4-->5-->6-->7 --> null
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * }</pre>
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * <p> <pre> {@code
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 * -> The number of nodes in the tree is in the range [0, 212 - 1].
 * -> -1000 <= Node.val <= 1000
 *
 * }</pre>
 * Follow-up: <p>
 * -> You may only use constant extra space. <p>
 * -> The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem. <p>
 */
public class N0116_PopulatingNextRightPointersInEachNode {
    
    /**
     * <h2>Iterative solution</h2>
     * <pre>
     * Runtime 3ms Beats    16.15%of users with Java
     * Memory 44.08MB Beats 23.38%of users with Java
     * </pre>
     */
    public Node connectI01(Node root) {
        if (root == null) return null;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            Node right = null;
            int levelWidth = queue.size();
            
            for (int i = 0; i < levelWidth; i++) {
                Node curr = queue.poll();
                
                if (right != null) right.next = curr;
                right = curr;
                
                if (curr == null) continue;
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            
        }
        return root;
    }
    
    
    /**
     * <h2>Iterative, without stack or queue</h2>
     * <pre>
     * Runtime 1ms  Beats 72.48 % of users with Java
     * Memory 44.10MB Beats 23.38 % of users with Java
     * </pre>
     */
    public Node connectI02(Node root) {
        
        Node head = root;
        Node nextHead = new Node(0);
        Node nextTail;
        
        while (head != null) {
            (nextTail = nextHead).next = null;
            
            while (head != null) {
                
                if (head.left != null) {
                    nextTail.next = head.left;
                    nextTail = head.left;
                }
                
                if (head.right != null) {
                    nextTail.next = head.right;
                    nextTail = head.right;
                }
                head = head.next;
            }
            head = nextHead.next;
        }
        return root;
    }
    
    /**
     * <h2>Recursion</h2>
     * Works only for balanced tree with all children non-null.
     * <pre>{@code
     *  Values = {1,2,3,4,5,null,7}
     *       Initial step (after root)     |          Next step
     *               1                     |               1
     *        ┌──────┴───────┐             |        ┌──────┴───────┐
     * root = 2 -----------> 3 = root.next | root = 2 -----------> 3 = root.next
     *   ┌────┴───┐     ┌────┴─────┐       |   ┌────┴───┐     ┌────┴─────┐
     *   4 -----> 5     6          7       |   4        5 --> 6          7
     *   ↑        ↑                        |            ↑     ↑
     * left     right                      |         right  root.next.left
     * }</pre>
     */
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null && root.next != null) {
            if (root.next.left != null) root.right.next = root.next.left;
            else root.right.next = root.next.right;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
    
    
}
