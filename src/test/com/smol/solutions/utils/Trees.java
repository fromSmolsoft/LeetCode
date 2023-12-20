package com.smol.solutions.utils;

public class Trees {
    
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
        return createTreeNode(values, 1);
    }
    /**
     * Builds a Binary SubTree from Integer array.  <p>
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
     * @param index root index, 1 is first element that is root of all roots
     */
    private static TreeNode createTreeNode(Integer[] input, int index) {
        if (index <= input.length) {
            Integer value = input[index - 1];
            if (value != null) {
                TreeNode t = new TreeNode(value);
                t.left = createTreeNode(input, index * 2);
                t.right = createTreeNode(input, index * 2 + 1);
                return t;
            }
        }
        return null;
    }
}
