package com.smol.solutions.N0703_KthLargestElementInStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KthLargestTest {



    /**
     * <pre>
     * Input
     * ["KthLargest", "add", "add", "add", "add", "add"]
     * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
     * Output
     * [null, 4, 5, 5, 8, 8]
     * Explanation
     * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
     * kthLargest.add(3);   // return 4
     * kthLargest.add(5);   // return 5
     * kthLargest.add(10);  // return 5
     * kthLargest.add(9);   // return 8
     * kthLargest.add(4);   // return 8
     * </pre>
     */
    @Test
    void add1() {
        int[] nums = {4, 5, 8, 2};
        int   k    = 3;

        KthLargest obj = new KthLargest(k, nums);

        Assertions.assertEquals(4, obj.add(3));
        Assertions.assertEquals(5, obj.add(5));
        Assertions.assertEquals(5, obj.add(10));
        Assertions.assertEquals(8, obj.add(9));
        Assertions.assertEquals(8, obj.add(4));
    }

    @Test
    void add2() {
        int[] nums = {};
        int   k    = 1;

        KthLargest obj = new KthLargest(k, nums);

        Assertions.assertEquals(-3, obj.add(-3));
        Assertions.assertEquals(-2, obj.add(-2));
        Assertions.assertEquals(-2, obj.add(-4));
        Assertions.assertEquals(0, obj.add(0));
        Assertions.assertEquals(4, obj.add(4));

    }
    @Test
    void add3() {
        int[] nums = {0};
        int   k    = 2;

        KthLargest obj = new KthLargest(k, nums);

        Assertions.assertEquals(-1, obj.add(-1));
        Assertions.assertEquals(0, obj.add(1));
        Assertions.assertEquals(0, obj.add(-2));
        Assertions.assertEquals(0, obj.add(-4));
        Assertions.assertEquals(1, obj.add(3));

    }
}