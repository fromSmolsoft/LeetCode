package com.smol.solutions;

import com.smol.solutions.utils.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <h1>117. Populating Next Right Pointers in Each Node II</h1>
 * Medium, #Linked List, #Tree, #Depth-FirstSearch, #Breadth-FirstSearch, #BinaryTree
 * <p>
 * Given a binary tree:
 * <pre> {@code
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * }</pre>
 * <p>
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.  <p>
 * Initially, all next pointers are set to NULL. <p>
 *
 * <pre> {@code
 * Example 1:
 *      1             1 --> null
 *     / \           / \
 *    2   3         2-> 3 --> null
 *   / \   \       / \   \
 *  4   5   7     4-->5-->7 --> null
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * }</pre>
 * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * <p> <pre> {@code
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 *     The number of nodes in the tree is in the range [0, 6000].
 *     -100 <= Node.val <= 100
 * }</pre>
 * Follow-up: <p>
 * -> You may only use constant extra space. <p>
 * -> The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem. <p>
 */
public class N0117_PopulatingNextRightPointersInEachNodeII {
    
    //todo recursion
    
    
    /**
     * <h2>Iterative solution</h2>
     * <pre>
     * Runtime 3ms Beats 38.04%of users with Java
     * Memory 44.09MB Beats22.93%of users with Java
     * </pre>
     */
    public Node connectI01(Node root) {
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            Node right = null;
            int width = queue.size();
            
            for (int i = 0; i < width; i++) {
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
     * Runtime 1ms  Beats 60.86 % of users with Java
     * Memory 44.10MB Beats 10.67 % of users with Java
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
     * <pre>{@code
     *  Values = {1,2,3,4,5,null,7}
     *       Initial step (after root)     |          Next step
     *               1                     |               1
     *        ┌──────┴───────┐             |        ┌──────┴───────┐
     * root = 2 -----------> 3 = root.next | root = 2 -----------> 3 = root.next
     *   ┌────┴───┐     ┌----└─────┐       |   ┌────┴───┐     ┌----└─────┐
     *   4 -----> 5   (null)       7       |   4        5 -------------> 7
     *   ↑        ↑                        |            ↑   (null)       ↑
     * left     right                      |         right          root.next.right
     * }</pre>
     */
    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
   
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = getNextHasChildrenNode(root);
        }
   
        if (root.left == null) {
            root.right.next = getNextHasChildrenNode(root);
        }
   
        if (root.right == null) {
            root.left.next = getNextHasChildrenNode(root);
        }
   
        // right should go first
        root.right = connect(root.right);
        root.left = connect(root.left);
   
        return root;
    }
    
    public Node getNextHasChildrenNode(Node root) {
        while (root.next != null) {
            if (root.next.left != null) {
                return root.next.left;
            }
            if (root.next.right != null) {
                return root.next.right;
            }
            
            root = root.next;
        }
        
        return null;
    }
    
    /*
     *  order of  calls     | order of resolving
     *  4. recursion call   | 1. resolved
     *  3. recursion call   | 2. resolved
     *  2. recursion call   | 3. resolved
     *  1. recursion call   | 4. resolved
     *  ------------------  | ------------
     *  ↑  init method call | final result
     *
     * It will reverse
     * */
    
}
