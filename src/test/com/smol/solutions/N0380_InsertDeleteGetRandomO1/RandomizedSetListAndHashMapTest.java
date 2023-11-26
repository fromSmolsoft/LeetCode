package com.smol.solutions.N0380_InsertDeleteGetRandomO1;

import com.smol.solutions.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class RandomizedSetListAndHashMapTest {
    RandomizedSetMustHave obj;

    @BeforeEach
    void init() {
        obj = new RandomizedSetListAndHashMap();
    }

    @DisplayName("insert() should return false if val exists and true if it was added into set")
    @Test
    void insertShouldReturnTrueIfValAdded() {
        Assertions.assertTrue(obj.insert(1));
        Assertions.assertFalse(obj.insert(1));
    }

    @DisplayName("remove() should return true if val exist and was removed")
    @Test
    void removeShouldReturnTrueIfValRemoved() {
        obj.insert(1);
        Assertions.assertFalse(obj.remove(2), "Removing non-exiting value");
        Assertions.assertTrue(obj.remove(1), "Removing existing value");
        Assertions.assertFalse(obj.remove(1), "Removing previously removed value");
    }

    @DisplayName("getRandom() should return random value previously existing in the set")
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "1,2,3",
            "1,5,10",
            "1,10,20,30",
            "10,1,5",
//            ";",
    })
    void getRandom(String input) {
        int[] values = TestUtils.StringToIntArray(input, ",");
        int k = Math.max(4, values.length);

        for (int n : values) obj.insert(n);

        for (int i = 0; i < 2 * k; i++) {
            int act = obj.getRandom();
            boolean actIsInValues = false;
            if (values.length == 0 && act == 0) actIsInValues = true;
            else {
                for (int n : values) {
                    if (n == act) {
                        actIsInValues = true;
                        break;
                    }
                }
            }

            Assertions.assertTrue(actIsInValues,
                    "\nWrong value returned:" + act + " \nis not within:\n " + Arrays.toString(values));
        }
    }
}