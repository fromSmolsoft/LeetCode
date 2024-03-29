package com.smol.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class n0004_MedianOfTwoSortedArraysTest {
    N0004_MedianOfTwoSortedArrays obj;

    @BeforeEach
    void setUp() {
        obj = new N0004_MedianOfTwoSortedArrays();

    }

    //todo parameterized test
    @Test
    void findMedianSortedArrays() {
        int[]  input1    = new int[]{1, 2, 3, 4, 5};
        int[]  input2    = new int[]{10, 11, 12, 13, 14};
        double expected3 = 7.5d;
        assertEquals(expected3, obj.findMedianSortedArrays(input1, input2));
        assertEquals(expected3, obj.findMedianSortedArrays01(input1, input2));

    }


    @Test
    void preTest2() {
        int[]  input1   = new int[]{1, 2};
        int[]  input2   = new int[]{20, 21};
        double expected = 11d;
        assertEquals(expected, obj.findMedianSortedArrays(input1, input2));
        assertEquals(expected, obj.findMedianSortedArrays01(input1, input2));
    }

    @Test
    void preTest3() {
        int[]  input1   = new int[]{1, 2};
        int[]  input2   = new int[]{25, 30};
        int[]  merged   = new int[]{1, 2, 25, 30};
        double expected = getMedian1(merged);
        assertEquals(expected, obj.findMedianSortedArrays(input1, input2));
        assertEquals(expected, obj.findMedianSortedArrays01(input1, input2));
    }

    /** caclulate median of sorted array */
    private double getMedian1(int[] input) {
        int length = input.length;
        return length % 2 == 0 ? (double) (input[length / 2 - 1] + input[length / 2]) / 2 : input[length / 2];
    }
    
}