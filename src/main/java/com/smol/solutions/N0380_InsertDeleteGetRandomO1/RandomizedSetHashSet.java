package com.smol.solutions.N0380_InsertDeleteGetRandomO1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * <h1>Using HashSet</h1>
 * <pre>
 * Runtime 115ms    Beats 14.69%
 * Memory 85.58MB   Beats 88.84%
 * </pre>
 */
public class RandomizedSetHashSet implements RandomizedSetMustHave {

    private final Set<Integer> set;
    private final Random random;

    public RandomizedSetHashSet() {
        set = new HashSet<>();
        random = new Random();
    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {

        int n = random.nextInt(set.size());
        int count = 0;

        for (int i : set) {
            if (count == n) return i;
            count++;
        }
        return 0;

    }
}
