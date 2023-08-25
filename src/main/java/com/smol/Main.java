package com.smol;

import _1480sum_of_1d_array.Solution;

import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        _1_two_sum();

    }

    private static void _1_two_sum() {
        _1_two_sum.Solution solution = new _1_two_sum.Solution();
        int[] nums   = {2, 7, 11, 15};
        int   target = 9;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }


    private static void _1480RunningSumOf1dArray() {
        int[]    input    = new int[]{1, 2, 3, 4};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.runningSum(input)));
    }


}