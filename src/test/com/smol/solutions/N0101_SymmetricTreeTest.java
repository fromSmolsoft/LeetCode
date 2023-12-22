package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import com.smol.solutions.utils.TreeFormatter;
import com.smol.solutions.utils.TreeNode;
import com.smol.solutions.utils.Trees;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

class N0101_SymmetricTreeTest {
    
    @SuppressWarnings("rawtypes")
    private final Class[] myTypes = {TreeNode.class};
    private final List<Method> methods = TUtils.reflectMethods(N0101_SymmetricTree.class, "isSymmetric", myTypes);
    private N0101_SymmetricTree obj;
    
    @BeforeEach
    void setObj() {
        obj = new N0101_SymmetricTree();
    }
    
    /**
     * <pre>{@code
     * Example 1:
     *      1
     *   ┌──┴──┐
     *   2     2
     *  ┌┴─┐  ┌┴─┐
     *  3  4  4  3
     * Input: root = [1,2,2,3,4,4,3]
     * Output: true
     *
     * Example 2:
     *     1
     *   ┌─┴──┐
     *   2    2
     *   └─┐  └─┐
     *     3    3
     * Input: root = [1,2,2,null,3,null,3]
     * Output: false
     *
     * Constraints:
     *     The number of nodes in the tree is in the range [1, 1000].
     *     -100 <= Node.val <= 100
     * }</pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "true;  1,2,2,3,4,4,3",
            "false; 1,2,2,null,3,null,3",
            "true;  1,2,2,3,4,4,3,5,6,7,8,8,7,6,5,9,10,11,12,13,14,15,16,16,15,14,13,12,11,10,9",
            "false; 1,2,2,3,4,4,3,5,6,7,8,8,7,6,5,9,10,11,12,13,14,15,16,16,15,14,13,12,11,10",
    })
    void isSymmetric(boolean exp, String sRoot) throws InvocationTargetException, IllegalAccessException {
        TreeNode root = Trees.buildBiTree(TUtils.StringToIntegerArray(sRoot, ","));
        
        for (Method m : methods) {
            boolean act = (boolean) m.invoke(obj, root);
            Assertions.assertEquals(exp, act,
                    "\nmethod:" + m.getName() +
                    "\nroot: " + sRoot +
                    "\n" +
                    new TreeFormatter().topDown(root) +
                    "\n"
            );
        }
        
    }
}