package com.smol.solutions.N0146_LRUCache;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Optional;

public class LRUCache01Test {
    
    public LRUCacheInterface obj;
    
    @BeforeEach
    void setUp() {
        obj = new LRUCache01(2);
    }
    
    /**
     * <pre>
     * Example 1:
     * Input
     * ["LRUCache", "put",  "put", "get", "put", "get", "put", "get", "get", "get"]
     * [[2],        [1, 1], [2, 2], [1],  [3, 3], [2],  [4, 4], [1],   [3],  [4]]
     * Output
     * [null, null, null, 1, null, -1, null, -1, 3, 4]
     *
     * Explanation
     * LRUCache lRUCache = new LRUCache(2);
     * lRUCache.put(1, 1); // cache is {1=1}
     * lRUCache.put(2, 2); // cache is {1=1, 2=2}
     * lRUCache.get(1);    // return 1
     * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
     * lRUCache.get(2);    // returns -1 (not found)
     * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
     * lRUCache.get(1);    // return -1 (not found)
     * lRUCache.get(3);    // return 3
     * lRUCache.get(4);    // return 4
     *
     * Constraints:
     *     1 <= capacity <= 3000
     *     0 <= key <= 104
     *     0 <= value <= 105
     *     At most 2 * 105 calls will be made to get and put.
     * </pre>
     */
    @Test
    void putsAndGetsCombo() {
        
        Assertions.assertAll("""
                        Combination of puts and gets.
                        LRUCache lRUCache = new LRUCache(2);
                        1)
                        lRUCache.put(1, 1); // cache is {1=1}
                        lRUCache.put(2, 2); // cache is {1=1, 2=2}
                        lRUCache.get(1);    // return 1
                        2)
                        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
                        lRUCache.get(2);    // returns -1 (not found)
                        3)
                        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
                        lRUCache.get(1);    // return -1 (not found)
                        4)
                        lRUCache.get(3);    // return 3
                        5)
                        lRUCache.get(4);    // return 4
                        =>
                        """,
                // 1
                () -> {
                    obj.put(1, 1);
                    obj.put(2, 2);
                    int expected = 1;
                    int actual = obj.get(1);
                    Assertions.assertEquals(expected, actual, "1)\n");
                },
                // 2
                () -> {
                    obj.put(3, 3);
                    int expected = -1;
                    int actual = obj.get(2);
                    Assertions.assertEquals(expected, actual, "2)\n");
                },
                // 3
                () -> {
                    obj.put(4, 4);
                    int expected = -1;
                    int actual = obj.get(1);
                    Assertions.assertEquals(expected, actual, "3)\n");
                },
                // 4
                () -> {
                    int expected = 3;
                    int actual = obj.get(3);
                    Assertions.assertEquals(expected, actual, "4)\n");
                },
                // 5
                () -> {
                    int expected = 4;
                    int actual = obj.get(4);
                    Assertions.assertEquals(expected, actual, "5)\n");
                }
        );
    }
    
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            /* 0        1       2       3       4       5       6       7       8       9   */
            "[LRUCache, put,   put,     get,    put,    get,    put,    get,    get,    get];" +
            "[[2],      [1,1], [2,2],   [1],    [3,3],  [2],    [4,4],  [1],    [3],    [4]];" +
            "[null,     null,  null,    1,      null,   -1,     null,   -1,     3,      4]",
            
            "[LRUCache, put,    put,    put,    put,    get,    get,    get];" +
            "[[2],	    [1,1],	[2,2],	[3,3],	[1,1],	[1],	[2],	[3]];" +
            "[null,     null,   null,   null,   null,   1,      -1,     3]",
            
            "[LRUCache, put,    put,    put,    get,    get,    get];" +
            "[[2],	    [1,1],	[2,2],	[3,3],	[1],	[2],	[3]];" +
            "[null,     null,   null,   null,   -1,     2,      3]",
            
            /* 0        1       2       3       4       5       6       7       8       9   */
            "[LRUCache, put,    put,    get,    put,    get,    put,    get,    get,    get];" +
            "[[2],	    [1,1],	[1,1],	[1],	[3,3],	[2],	[4,4],	[1],	[3],	[4]];" +
            "[null,     null,   null,   1,      null,-  1,      null,   -1,     3,      4]",
            
            "[LRUCache, put,    put,    get,    put,    get,    put,    get,    get,    get];" +
            "[[2],	    [1,1],	[2,2],	[1],	[3,3],	[2],	[4,4],	[1],	[3],	[4]];" +
            "[null,     null,   null,   1,      null,   -1,     null,   -1,     3,      4]",
            
            "[LRUCache, put,    get,    put,    get,    get];" +
            "[[1],	    [2,1],	[2],	[3,2],	[2],    [3]];" +
            "[null,     null,   1,      null,   -1,     2]",
            
            /* 0        1       2       3       4       5       6       7       8       9   */
            "[LRUCache, get,    put,    get,    put,    put,    get,    get];" +
            "[[2],      [2],    [2,6],  [1],    [1,5],  [1,2],  [1],    [2]];" +
            "[null,     -1,     null,   -1,     null,   null,   2,      6]",
            
            "[LRUCache, put,    put,    get,    get,    put,    get,    get,    get];" +
            "[[2],      [2,1],  [3,2],  [3],    [2],    [4,3],  [2],    [3],    [4]];" +
            "[null,     null,   null,   2,      1,      null,   1,      -1,     3]",
            
            "[LRUCache, put,    put,    get,    put,    get,    put,    get,    get,    get];" +
            "[[3],      [1,1],  [2,2],  [1],    [3,3],  [2],    [4,4],  [1],    [3],    [4]];" +
            "[null,     null,   null,   1,      null,   2,      null,   -1,     3,      4]"
        
    })
    void LRUCacheMassTest(String action, String sInputs, String sExpected) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // CLeaning unwanted symbols (actions,input and expected)
        action = TUtils.removeSubStrings(action, "\\[", "\\]", " ", "\t");
        sInputs = TUtils.removeSubStrings(sInputs, " ", "\t");
        sExpected = TUtils.removeSubStrings(sExpected, "\\[", "\\]", " ", "\t");
        
        // Parsing Strings to arrays (actions,input and expected )
        String[] actions = TUtils.StringToStringArray(action, ",");
        String[][] inputs = TUtils.stringToStringMatrix(sInputs, "\\],\\[", ",", "\\[", "\\]");
        String[] expected = TUtils.StringToStringArray(sExpected, ",");
        
        for (int i = 0; i < actions.length; i++) {
            
            //finalizing inputs
            Integer[] input = new Integer[inputs[i].length];
            for (int j = 0; j < inputs[i].length; j++) {
                input[j] = inputs[i][j].equals("null") ? null : Integer.parseInt(inputs[i][j]);
            }
            
            //Invoking actions and inputs on tested unit
            Optional<Integer> actual = takeAction(actions[i], input);
            
            String act = actual.isEmpty() ? "null" : String.valueOf(actual.get());
            String message = """
                    
                    %s) %s %s
                    act: %3.6s
                    exp: %3.6s
                    """.formatted(i, actions[i], Arrays.toString(input), act, expected[i]);
            
            Assertions.assertEquals(expected[i], act, message);
        }
    }
    
    private Optional<Integer> takeAction(String action, Integer[] input) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        
        switch (action) {
            case "LRUCache" -> {
                int capacity = input[0] == null ? 0 : input[0];
                obj = obj.getClass().getConstructor(int.class).newInstance(capacity);
            }
            case "put" -> {
                obj.put(input[0], input[1]);
            }
            case "get" -> {
                return Optional.of(obj.get(input[0]));
            }
            default -> {/*do nothing*/}
        }
        return Optional.empty();
    }
    
    
}
