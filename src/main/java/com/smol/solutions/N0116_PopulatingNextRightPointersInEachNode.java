package com.smol.solutions;

import com.smol.solutions.utils.Node;

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
     *
     */
    public Node connect(Node root) {
        //todo
        return new Node();
    }
    
    
}
