package com.smol.solutions;

import com.smol.solutions.utils.Node;
import com.smol.solutions.utils.TUtils;
import com.smol.solutions.utils.TreeFormatter;
import com.smol.solutions.utils.Trees;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

class N0117_PopulatingNextRightPointersInEachNodeIITest {
    
    private final N0117_PopulatingNextRightPointersInEachNodeII obj = new N0117_PopulatingNextRightPointersInEachNodeII();
    private final List<Method> methods = TUtils.reflectMethods(obj.getClass(), "connect");
    private final TreeFormatter treeFormatter = new TreeFormatter();
    

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "1,#,2,3,#,4,5,6,7,#;                               1,2,3,4,5,6,7",
            "1,#,2,3,#,4,5,null,7,#;                            1,2,3,4,5,null,7",
            "1,#,2,3,#,4,null,null,5,#;                         1,2,3,4,null,null,5",
            "1,2;                                               1,2",
            "0,#,2,4,#,1,null,3,-1,#,5,1,null,6,null,8,#;       0,2,4,1,null,3,-1,5,1,null,6,null,8",
            "1,#,2,3,#,4,5,null,6,#,7,null,null,null,null,8,#;  1,2,3,4,5,null,6,7,null,null,null,null,8",
            "                                                ;  ",
    })
    void connect(String sExp, String sRoot) {
        sExp = TUtils.removeSubStrings(sExp, ",#");
        Node exp = Trees.buildBiTreeWithNext(TUtils.StringToIntegerArray(sExp, ","), Node.class);
        Node root = Trees.buildBiTree(TUtils.StringToIntegerArray(sRoot, ","), Node.class);
        String expMessage = treeFormatter.topDownConnected(exp);

        methods.forEach(m -> {
            Node act = null;
            try {
                act = (Node) m.invoke(obj, root);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            
            String actMessage = treeFormatter.topDownConnected(act);
            Assertions.assertEquals(expMessage, actMessage,
                    "\nmethod: " + m.getName() +
                    "\ninp:" + sRoot);
        });
    }
}