package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import com.smol.solutions.utils.TreeFormatter;
import com.smol.solutions.utils.TreeNode;
import com.smol.solutions.utils.TreeBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

class N0100_SameTreeTest {
    private final TreeFormatter formatter = new TreeFormatter();
    private N0100_SameTree obj;
    private List<Method> methods;
    
    
    @BeforeEach
    void setUp() {
        obj = new N0100_SameTree();
        methods = TUtils.reflectMethods(obj, "isSameTree");
    }
    
    /**
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
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "true;  1,2,3;  1,2,3",
            "true;  1,2,3,4,5,6,7,8,9,10;  1,2,3,4,5,6,7,8,9,10",
            "false;  1,2,3,4;  1,2,3",
            "false;  1,2,3;  1,2,3,4,5",
            "false; 1,2;    1,null,2",
            "false; 1,2,1;  1,1,2",
            "true;      ;   ",
            "false; 1;      ",
            "false;     ;   1",
    })
    void isSameTree(boolean exp, String sLeftTree, String sRightTree) throws InvocationTargetException, IllegalAccessException {
        TreeNode leftTree = TreeBuilder.buildBiTree(TUtils.StringToIntegerArray(sLeftTree, ","));
        TreeNode rightTree = TreeBuilder.buildBiTree(TUtils.StringToIntegerArray(sRightTree, ","));
        
        for (Method m : methods) {
            Assertions.assertEquals(exp,
                    m.invoke(obj,
                            leftTree,
                            rightTree),
                    "\nmethod: " + m.getName() +
                    "\n" + formatter.topDown(leftTree) +
                    "\n" + formatter.topDown(rightTree));
        }
        
    }
}