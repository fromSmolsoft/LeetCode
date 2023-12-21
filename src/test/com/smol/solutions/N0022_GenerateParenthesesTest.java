package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Method;
import java.util.List;

class N0022_GenerateParenthesesTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1, ()",
            "2, (());()()",
            "3, ((()));(()());(())();()(());()()()",
            "4 ,(((())));((()()));((())());((()))();(()(()));(()()());(()())();(())(());(())()();()((()));()(()());()(())();()()(());()()()()",
    })
    void generateParenthesis(int input, String expected) {
        TUtils utils = new TUtils();
        N0022_GenerateParentheses obj   = new N0022_GenerateParentheses();

        List<String> expectedStrings = List.of(utils.StringToStringArray(expected, ";"));
        List<String> actual;

        Method[] methods = N0022_GenerateParentheses.class.getDeclaredMethods();
        for (Method m : methods) {
            String name = m.getName();
            if (name.startsWith("generateParenthesis")) {
                System.out.println("method: " + name);
                try {
                    actual = (List<String>) m.invoke(obj, input);
                    Assertions.assertEquals(expectedStrings, actual, name);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}