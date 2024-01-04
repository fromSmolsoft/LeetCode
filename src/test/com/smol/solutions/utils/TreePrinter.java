package com.smol.solutions.utils;

import java.util.LinkedList;
import java.util.Queue;

public class TreePrinter {
    
    /**
     * @param root the root node of the binary tree
     * @return the string representation of the inorder traversal
     */
    public <T> String printInorder(T root) {
        StringBuilder stringBuilder = new StringBuilder();
        return printInorder(root, stringBuilder);
    }
    
    private <T> String printInorder(T root, StringBuilder stringBuilder) {
        if (root == null) return "[]";
        
        printInorder(getLeftChild(root));
        stringBuilder.append(getNodeValue(root)).append(',');
        printInorder(getRightChild(root));
        
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }
    
    /**
     * @param root the root node of the binary tree
     * @return the string representation of the preorder traversal
     */
    public <T> String printPreorder(T root) {
        StringBuilder stringBuilder = new StringBuilder();
        return printPreorder(root, stringBuilder);
    }
    
    private <T> String printPreorder(T root, StringBuilder stringBuilder) {
        if (root == null) return "[]";
        
        stringBuilder.append(getNodeValue(root)).append(',');
        printPreorder(getLeftChild(root));
        printPreorder(getRightChild(root));
        
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }
    
    /**
     * @param root the root node of the binary tree
     * @return the string representation of the postorder traversal
     */
    public <T> String printPostorder(T root) {
        StringBuilder stringBuilder = new StringBuilder();
        return printPostorder(root, stringBuilder);
    }
    
    private <T> String printPostorder(T root, StringBuilder stringBuilder) {
        if (root == null) return "";
        
        printPostorder(getLeftChild(root));
        printPostorder(getRightChild(root));
        stringBuilder.append(getNodeValue(root)).append(',');
        
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }
    
    /**
     * Prints the level order traversal of a binary tree.
     * @param root the root node of the binary tree
     * @return a string representation of the level order traversal
     */
    public <T> String printLevelOrder(T root) {
        if (root == null) return "";
        Queue<T> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder stringBuilder = new StringBuilder();
        
        while (!queue.isEmpty()) {
            T currNode = queue.poll();
            if (currNode != null) {
                stringBuilder.append(getNodeValue(currNode)).append(",");
                
                queue.offer(getLeftChild(currNode));
                queue.offer(getRightChild(currNode));
            } else stringBuilder.append("null").append(",");
        }
        
        char[] remove = "null,".toCharArray();
        int i = stringBuilder.length() - 1, j = remove.length - 1;
        for (; i >= 0; i--, j--) {
            if (j < 0) j = remove.length - 1;
            if (stringBuilder.charAt(i) != remove[j]) break;
        }
        return stringBuilder.substring(0, i + 1);
    }
    
    // === Generic getters
    private <T> int getNodeValue(T node) {
        try {
            return (int) node.getClass().getField("val").get(node);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    
    private <T> T getLeftChild(T node) {
        try {
            return (T) node.getClass().getField("left").get(node);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    
    private <T> T getRightChild(T node) {
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
