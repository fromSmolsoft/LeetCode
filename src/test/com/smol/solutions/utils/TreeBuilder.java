package com.smol.solutions.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Binary Tree Builder automates building of binary trees.
 */
public class TreeBuilder<T> {
    
    /**
     * Builds a Binary tree from Integer array.  <p>
     * Tree will be built from root on, in Level-traversal manner also known as  breadth-first.
     * <pre>{@code
     * Example 1: root = [4,2,6,1,3,5,7]
     *     ┌────── (4)   .......... L0
     *     │     /     \
     *     └─►(2)──────►(6) ───┐ .. L1
     *   ┌─── /──\ ──── /──\───┘
     *   └─►(1)─►(3)─►(5)─►(7)   .. L2
     *
     * Example 2: root = [3,9,20,null,null,15,7]
     *      (3)
     *     /  \
     *   (9)  (20)
     *        /  \
     *      (15) (7)
     * }</pre>
     * @param values (Integer[]) array of integers or nulls.
     */
    public static TreeNode buildBiTree(Integer[] values) {
        return createTreeNode(values);
    }
    
    /**
     * Builds a Binary tree from Integer array.  <p>
     * Tree will be built from root on, in Level-traversal manner also known as  breadth-first.
     * <pre>{@code
     * Example 1: root = [4,2,6,1,3,5,7]
     *     ┌────── (4)   .......... L0
     *     │     /     \
     *     └─►(2)──────►(6) ───┐ .. L1
     *   ┌─── /──\ ──── /──\───┘
     *   └─►(1)─►(3)─►(5)─►(7)   .. L2
     *
     * Example 2: root = [3,9,20,null,null,15,7]
     *      (3)
     *     /  \
     *   (9)  (20)
     *        /  \
     *      (15) (7)
     * }</pre>
     * @param values (Integer[]) array of integers or nulls.
     */
    public static <T> T buildBiTree(Integer[] values, Class<T> nodeType) {
        return createTreeNode(values, nodeType);
    }
    
    /**
     * Builds a Binary SubTree, where left nodes have link to their right nodes on same level, from Integer array, in Level Order Traversal using Queue.  <p>
     * The binary tree has the following structure:
     * <pre> {@code
     * class Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }                }</pre>
     * Tree will be built from root on, in Level-traversal manner also known as breadth-first.
     * <pre>{@code
     * Lever order:
     *     ┌────── (4)   .......... L0
     *     │     /     \
     *     └─►(2)──────►(6) ───┐ .. L1
     *   ┌─── /──\ ──── /──\───┘
     *   └─►(1)─►(3)─►(5)─►(7)   .. L2
     * Input: root = [4,2,6,1,3,5,7]
     * }</pre>
     * Tree nodes include `next` pointer that should point to the right node in same level or null if there is no node
     * <pre> {@code
     * Assigning right nodes nodes as 'next':
     * A) not connected |   B) connected
     *         1        |        1 --------> null
     *       /   \      |      /   \
     *      2     3     |     2---->3 -----> null
     *    / \     / \   |   / \     / \
     *   4   5   6   7  |  4-->5-->6-->7 --> null
     * Input: root = [1,2,3,4,5,6,7]
     * Output: [1,#,2,3,#,4,5,6,7,#]
     * }</pre>
     * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
     * <p>
     * @param values (Integer[]) array of integers or nulls. Null represent "no child".
     */
    public static <T> T buildBiTreeWithNext(Integer[] values, Class<T> nodeType) {
        return createNodeLvlConnected(values, nodeType);
    }
    
    /**
     * Builds a Binary SubTree from Integer array in Level Order Traversal using Queue.  <p>
     * <p>
     * Tree will be built from root on, in Level-traversal manner also known as  breadth-first.
     * <pre>{@code
     * Example 1: root = [4,2,6,1,3,5,7]
     *     ┌────── (4)   .......... L0
     *     │     /     \
     *     └─►(2)──────►(6) ───┐ .. L1
     *   ┌─── /──\ ──── /──\───┘
     *   └─►(1)─►(3)─►(5)─►(7)   .. L2
     *
     * Example 2: root = [3,9,20,null,null,15,7]
     *      (3)
     *     /  \
     *   (9)  (20)
     *        /  \
     *      (15) (7)
     * }</pre>
     * @param input (Integer[]) array of integers or nulls.
     */
    private static TreeNode createTreeNode(Integer[] input) {
        if (input == null || input.length == 0) return null;
        
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(input[0]);
        queue.add(root);
        int i = 0;
        
        while (i < input.length && !queue.isEmpty()) {
            
            TreeNode tempNode = queue.poll();
            
            i++;
            if (i < input.length && input[i] != null) {
                tempNode.left = new TreeNode(input[i]);
                queue.add(tempNode.left);
            }
            i++;
            if (i < input.length && input[i] != null) {
                tempNode.right = new TreeNode(input[i]);
                queue.add(tempNode.right);
            }
            
            
        }
        
        return root;
    }
    
    /**
     * Builds a Binary SubTree from Integer array in Level Order Traversal using Queue.  <p>
     * <b>Requires node with following fields</b>
     * <pre>{@code
     * public class TreeNode {
     *     public int val;
     *     public TreeNode left;
     *     public TreeNode right;
     *     //rest of the code
     * }</pre>
     * <p>
     * Tree will be built from root on, in Level-traversal manner also known as  breadth-first.
     * <pre>{@code
     * Example 1: root = [4,2,6,1,3,5,7]
     *     ┌────── (4)   .......... L0
     *     │     /     \
     *     └─►(2)──────►(6) ───┐ .. L1
     *   ┌─── /──\ ──── /──\───┘
     *   └─►(1)─►(3)─►(5)─►(7)   .. L2
     *
     * Example 2: root = [3,9,20,null,null,15,7]
     *      (3)
     *     /  \
     *   (9)  (20)
     *        /  \
     *      (15) (7)
     * }</pre>
     * @param input    (Integer[]) array of integers or nulls.
     * @param nodeType is used to identify class (type) of the used node
     */
    private static <T> T createTreeNode(Integer[] input, Class<T> nodeType) {
        if (input == null || input.length == 0) return null;
        
        Deque<T> queue = new LinkedList<>();
        
        T root = createNode(nodeType, input[0]);
        queue.add(root);
        int i = 0;
        
        while (i < input.length && !queue.isEmpty()) {
            T tempNode = queue.poll();
            
            i++;
            if (i < input.length && input[i] != null) {
                T leftChild = createNode(nodeType, input[i]);
                setLeftChild(tempNode, leftChild);
                queue.add(leftChild);
            }
            i++;
            if (i < input.length && input[i] != null) {
                T rightChild = createNode(nodeType, input[i]);
                setRightChild(tempNode, rightChild);
                queue.add(rightChild);
            }
            
            
        }
        
        return root;
    }
    
    /**
     * Builds a Binary SubTree, where left nodes have link to their right nodes on same level, from Integer array, in Level Order Traversal using Queue.  <p>
     * The binary tree has the following definition:
     * <pre> {@code
     * class Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }                }</pre>
     * Tree will be built from root on, in Level-traversal manner also known as breadth-first.
     * <pre>{@code
     * Lever order:
     *     ┌────── (4)   .......... L0
     *     │     /     \
     *     └─►(2)──────►(6) ───┐ .. L1
     *   ┌─── /──\ ──── /──\───┘
     *   └─►(1)─►(3)─►(5)─►(7)   .. L2
     * Input: root = [4,2,6,1,3,5,7]
     * }</pre>
     * Tree nodes include `next` pointer that should point to the right node in same level or null if there is no node
     * <pre> {@code
     * Assigning right nodes nodes as 'next':
     * A) not connected |   B) connected
     *         1        |        1 --------> null
     *       /   \      |      /   \
     *      2     3     |     2---->3 -----> null
     *    / \     / \   |   / \     / \
     *   4   5   6   7  |  4-->5-->6-->7 --> null
     * Input: root = [1,2,3,4,5,6,7]
     * Output: [1,#,2,3,#,4,5,6,7,#]
     * }</pre>
     * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
     * <p>
     * @param input (Integer[]) array of integers or nulls. Null represent "no child".
     */
    private static Node createNodeLvlConnected(Integer[] input) {
        if (input == null || input.length == 0) return null;
        
        Deque<Node> queue = new LinkedList<>();
        Node root = new Node(input[0]);
        queue.add(root);
        int i = 0;
        
        while (i < input.length && !queue.isEmpty()) {
            int size = queue.size();
            Node mostRight = null;
            
            for (int j = 0; j < size; j++) {
                Node tempNode = queue.poll();
                
                if (mostRight != null) mostRight.next = tempNode;
                mostRight = tempNode;
                
                i++;
                if (i < input.length && input[i] != null) {
                    tempNode.left = new Node(input[i]);
                    queue.add(tempNode.left);
                }
                i++;
                if (i < input.length && input[i] != null) {
                    tempNode.right = new Node(input[i]);
                    queue.add(tempNode.right);
                }
                
            }
            
        }
        
        return root;
    }
    
    /**
     * Builds a Binary SubTree, where left nodes have link to their right nodes on same level, from Integer array, in Level Order Traversal using Queue.  <p>
     * The binary tree has the following definition:
     * <pre> {@code
     * class Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }                }</pre>
     * Tree will be built from root on, in Level-traversal manner also known as breadth-first.
     * <pre>{@code
     * Lever order:
     *     ┌────── (4)   .......... L0
     *     │     /     \
     *     └─►(2)──────►(6) ───┐ .. L1
     *   ┌─── /──\ ──── /──\───┘
     *   └─►(1)─►(3)─►(5)─►(7)   .. L2
     * Input: root = [4,2,6,1,3,5,7]
     * }</pre>
     * Tree nodes include `next` pointer that should point to the right node in same level or null if there is no node
     * <pre> {@code
     * Assigning right nodes nodes as 'next':
     * A) not connected |   B) connected
     *         1        |        1 --------> null
     *       /   \      |      /   \
     *      2     3     |     2---->3 -----> null
     *    / \     / \   |   / \     / \
     *   4   5   6   7  |  4-->5-->6-->7 --> null
     * Input: root = [1,2,3,4,5,6,7]
     * Output: [1,#,2,3,#,4,5,6,7,#]
     * }</pre>
     * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
     * <p>
     * @param input (Integer[]) array of integers or nulls. Null represent "no child".
     */
    public static <T> T createNodeLvlConnected(Integer[] input, Class<T> nodeType) {
        if (input == null || input.length == 0) return null;
        
        Deque<T> queue = new LinkedList<>();
        T root = createNode(nodeType, input[0]);
        queue.add(root);
        int i = 0;
        
        while (i < input.length && !queue.isEmpty()) {
            int size = queue.size();
            T mostRight = null;
            
            for (int j = 0; j < size; j++) {
                T tempNode = queue.poll();
                
                if (mostRight != null) setNext(mostRight, tempNode);
                mostRight = tempNode;
                
                i++;
                if (i < input.length && input[i] != null) {
                    T left = createNode(nodeType, input[i]);
                    setLeftChild(tempNode, left);
                    queue.add(left);
                }
                i++;
                if (i < input.length && input[i] != null) {
                    T right = createNode(nodeType, input[i]);
                    setRightChild(tempNode, right);
                    queue.add(right);
                }
                
            }
            
        }
        
        return root;
    }
    
    private static <T> T createNode(Class<T> nodeClass, Object value) {
        try {
            Constructor<T> constructor = nodeClass.getConstructor();
            T node = constructor.newInstance();
            setNodeValue(node, value);
            return node;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // === Generic setters ===
    private static <T> void setNodeValue(T node, Object value) {
        try {
            Field valField = node.getClass().getField("val");
            valField.set(node, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static <T> void setLeftChild(T node, T child) {
        try {
            Field leftField = node.getClass().getField("left");
            leftField.set(node, child);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static <T> void setRightChild(T node, T child) {
        try {
            Field rightField = node.getClass().getField("right");
            rightField.set(node, child);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static <T> void setNext(T node, T next) {
        try {
            Field rightField = node.getClass().getField("next");
            rightField.set(node, next);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // === Generic getters ===
    private static <T> int getNodeValue(T node) {
        try {
            return (int) node.getClass().getField("val").get(node);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static <T> T getLeftChild(T node) {
        try {
            return (T) node.getClass().getField("left").get(node);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static <T> T getRightChild(T node) {
        try {
            return (T) node.getClass().getField("right").get(node);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static <T> T getNext(T node) {
        try {
            return (T) node.getClass().getField("next").get(node);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
