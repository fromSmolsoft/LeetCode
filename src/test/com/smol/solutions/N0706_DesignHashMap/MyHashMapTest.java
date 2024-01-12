package com.smol.solutions.N0706_DesignHashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

class MyHashMapTest {
    
    private static final MyHashMap obj = new MyHashMap();
    
    
    @DisplayName("All around test")
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            /*exp   method    key     val*/
            "null;  put;      1;      1;",
            "null;  put;      2;      2;",
            "1;     get;      1;       ;",
            "-1;    get;      3;       ;",
            "null;  put;      2;      1;",
            "1;     get;      2;       ;",
            "null;  remove;   2;       ;",
            "-1;    get;      2;       ;",
    })
    void arrayVersion(String exp, String m, int key, Integer val) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String message = ">" + m + "| " + key + "| " + val + "| " + exp + "<";
        
        if (m.equals("put")) {
            obj.put(key, val);
            Assertions.assertEquals(val, obj.get(key), "\n" + message + "\nget(key) after put(key,val)");
        }
        
        if (m.equals("get")) {
            int actual = obj.get(key);
            Integer expected = Objects.equals(exp, "null") ? null : Integer.valueOf(exp);
            Assertions.assertEquals(expected, actual, "\n" + message + "\nget(key)");
        }
        
        if (m.equals("remove")) {
            obj.remove(key);
            Assertions.assertEquals(-1, obj.get(key), "\n" + message + "\nget(key) after remove(key)");
        }
    }
}