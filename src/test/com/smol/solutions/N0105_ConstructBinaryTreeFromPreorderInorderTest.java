package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import com.smol.solutions.utils.TreeFormatter;
import com.smol.solutions.utils.TreeNode;
import com.smol.solutions.utils.Trees;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

class N0105_ConstructBinaryTreeFromPreorderInorderTest {
    
    private final N0105_ConstructBinaryTreeFromPreorderInorder obj = new N0105_ConstructBinaryTreeFromPreorderInorder();
    @SuppressWarnings("rawtypes")
    private final Class[] types = {TreeNode.class, TreeNode.class};
    private final List<Method> methods = TUtils.reflectMethods(N0105_ConstructBinaryTreeFromPreorderInorder.class, "buildTree", types);
    
    
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "3,9,20,null,null,15,7; 3,9,20,15,7; 9,3,15,20,7",
            "-1; -1; -1",
            "0,1; 0,1; 1,0",
            "1,2; 1,2; 2,1",
            "1,2,null,3,null,4; 1,2,3,4; 4,3,2,1"
        
    })
    void buildTree(String sExp, String sPreorder, String sInorder) throws InvocationTargetException, IllegalAccessException {
        TreeNode expected = Trees.buildBiTree(TUtils.StringToIntegerArray(sExp, ","));
        int[] preorder = TUtils.StringToIntArray(sPreorder, ",");
        int[] inorder = TUtils.StringToIntArray(sInorder, ",");
        
        String exp = new TreeFormatter().topDown(expected);
        String message =
                "\npreorder: " + Arrays.toString(preorder) +
                "\ninorder : " + Arrays.toString(inorder) +
                "\nexpected:\n" + exp;
        
        for (Method m : methods) {
            TreeNode actual = (TreeNode) m.invoke(obj, preorder, inorder);
            String act = new TreeFormatter().topDown(actual);
            
            Assertions.assertEquals(exp, act,
                    "\nmethod: " + m.getName() +
                    message +
                    "\nactual:\n" + act);
        }
    }
}