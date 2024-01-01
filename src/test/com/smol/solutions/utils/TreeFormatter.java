package com.smol.solutions.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>BinaryTree printer</h1>
 * "prints" nicely formatted BinaryTree.    <p>
 * Requires TreeNode to include these fields :
 * <pre>{@code
 *   public class TreeNode {
 *      public int val;
 *      public TreeNode left;
 *      public TreeNode right;
 *      ...
 *      }
 *  }
 * }</pre>
 */
public class TreeFormatter {
    int padding = 2; // minimum number of horizontal spaces between two node data
    
    private int indent(List<String> lines, int margin) {
        // If negative, prefix all lines with spaces and return 0
        if (margin >= 0) return margin;
        String spaces = " ".repeat(-margin);
        int i = 0;
        for (var line : lines) {
            lines.set(i++, spaces + line);
        }
        return 0;
    }
    
    private List<String> merge(List<String> left, List<String> right) {
        // Merge two arrays, where the right strings are indented so there is no overlap
        int minSize = Math.min(left.size(), right.size());
        int offset = 0;
        for (int i = 0; i < minSize; i++) {
            offset = Math.max(offset, left.get(i).length() + padding - right.get(i).replaceAll("\\S.*", "").length());
        }
        indent(right, -indent(left, offset));
        for (int i = 0; i < minSize; i++) {
            left.set(i, left.get(i) + right.get(i).substring(left.get(i).length()));
        }
        if (right.size() > minSize) {
            left.addAll(right.subList(minSize, right.size()));
        }
        return left;
    }
    
    
    /**
     * Root node must include corresponding fields:
     * <pre>{@code
     *   public class Node {
     *      public int val;
     *      public TreeNode left;
     *      public TreeNode right;
     *   }
     * }</pre>
     * @param root - root of binary tree
     * @return String with formatted BinaryTree
     */
    public <T> String topDown(T root) {
        if (root == null) return "";
        List<String> lines = buildLines(root);
        return String.join("\n", lines.subList(1, lines.size()));
    }
    
    public <T> String topDownConnected(T root) {
        if (root == null) return "";
        List<String> lines = buildLinesConnected(root);
        return String.join("\n", lines.subList(1, lines.size()));
    }
    
    private <T> List<String> buildLines(T node) {
        if (node == null) return new ArrayList<>();
        List<String> lines = merge(buildLines(getLeftChild(node)), buildLines(getRightChild(node)));
        int half = String.valueOf(getNodeValue(node)).length() / 2;
        int i = half;
        if (lines.size() > 0) {
            String line;
            i = lines.get(0).indexOf("*"); // Find index of first subtree
            if (getRightChild(node) == null) {
                line = " ".repeat(i) + "┌─┘";
                i += 2;
            } else if (getLeftChild(node) == null) {
                line = " ".repeat(i = indent(lines, i - 2)) + "└─┐";
            } else {
                int dist = lines.get(0).length() - 1 - i; // Find distance between subtree roots
                line = String.format("%s┌%s┴%s┐", " ".repeat(i), "─".repeat(dist / 2 - 1), "─".repeat((dist - 1) / 2));
                i += dist / 2;
            }
            lines.set(0, line);
        }
        lines.add(0, " ".repeat(indent(lines, i - half)) + getNodeValue(node));
        lines.add(0, " ".repeat(i + Math.max(0, half - i)) + "*"); // Add a marker for caller
        return lines;
    }
    
    private <T> List<String> buildLinesConnected(T node) {
        if (node == null) return new ArrayList<>();
        String next = ">";
        List<String> lines = merge(buildLines(getLeftChild(node)), buildLines(getRightChild(node)));
        int half = (String.valueOf(getNodeValue(node)).length() +
                    next.length() +
                    (getNext(node) != null ? String.valueOf(getNodeValue(getNext(node))).length() : 0)
                   ) / 2;
        int i = half;
        if (lines.size() > 0) {
            String line;
            i = lines.get(0).indexOf("*"); // Find index of first subtree
            if (getRightChild(node) == null) {
                line = " ".repeat(i) + "┌─┘";
                i += 2;
            } else if (getLeftChild(node) == null) {
                line = " ".repeat(i = indent(lines, i - 2)) + "└─┐";
            } else {
                int dist = lines.get(0).length() - 1 - i; // Find distance between subtree roots
                line = String.format("%s┌%s┴%s┐", " ".repeat(i), "─".repeat(dist / 2 - 1), "─".repeat((dist - 1) / 2));
                i += dist / 2;
            }
            lines.set(0, line);
        }
        String value = getNodeValue(node) + next + (getNext(node) != null ? getNodeValue(getNext(node)) : "");
        lines.add(0, " ".repeat(indent(lines, i - half)) + value);
        lines.add(0, " ".repeat(i + Math.max(0, half - i)) + "*"); // Add a marker for caller
        return lines;
    }
    
    // === Generic getters
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
    
    
    // None generic version
//    private List<String> buildLines(TreeNode node) {
//        if (node == null) return new ArrayList<>();
//        List<String> lines = merge(buildLines(node.left), buildLines(node.right));
//        int half = String.valueOf(node.val).length() / 2;
//        int i = half;
//        if (lines.size() > 0) {
//            String line;
//            i = lines.get(0).indexOf("*"); // Find index of first subtree
//            if (node.right == null) {
//                line = " ".repeat(i) + "┌─┘";
//                i += 2;
//            } else if (node.left == null) {
//                line = " ".repeat(i = indent(lines, i - 2)) + "└─┐";
//            } else {
//                int dist = lines.get(0).length() - 1 - i; // Find distance between subtree roots
//                line = String.format("%s┌%s┴%s┐", " ".repeat(i), "─".repeat(dist / 2 - 1), "─".repeat((dist - 1) / 2));
//                i += dist / 2;
//            }
//            lines.set(0, line);
//        }
//        lines.add(0, " ".repeat(indent(lines, i - half)) + node.val);
//        lines.add(0, " ".repeat(i + Math.max(0, half - i)) + "*"); // Add a marker for caller
//        return lines;
//    }
//
//    /**
//     * @return String with formatted BinaryTree
//     */
//    public String topDown(TreeNode root) {
//        if (root == null) return "";
//        List<String> lines = buildLines(root);
//        return String.join("\n", lines.subList(1, lines.size()));
//    }
//
}
