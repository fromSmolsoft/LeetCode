package com.smol.solutions.N0146_LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

/** <h2>LinkedHashMap</h2> */
public class LRUCache02 implements LRUCacheInterface {
    private final int CAPACITY;
    private LinkedHashMap<Integer, Integer> map;
    
    /** <h2>LinkedHashMap</h2> */
    public LRUCache02(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}
    

