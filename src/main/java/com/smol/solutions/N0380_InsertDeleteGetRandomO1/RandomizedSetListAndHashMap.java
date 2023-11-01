package com.smol.solutions.N0380_InsertDeleteGetRandomO1;

import java.util.*;

/**
 * Using ArrayList & HashMap <p>
 * Time Complexity: All function have average O(1)<p>
 * Space Complexity: O(N)<p>
 * N = Number of values currently stored in the data structure.
 */
public class RandomizedSetListAndHashMap implements RandomizedSetMustHave {
    List<Integer> nums;
    Map<Integer, Integer> indexMap;
    Random random;

    public RandomizedSetListAndHashMap() {
        nums = new ArrayList<>();
        indexMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }

        indexMap.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }

        int idx = indexMap.get(val);
        int lastIdx = nums.size() - 1;
        if (idx != lastIdx) {
            int lastVal = nums.get(lastIdx);
            nums.set(idx, lastVal);
            indexMap.put(lastVal, idx);
        }
        nums.remove(lastIdx);
        indexMap.remove(val);
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }

}
