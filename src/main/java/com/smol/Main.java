package com.smol;

import com.smol.solutions.*;

import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }

    // Methods ===


    private static void _412_FizzBuzz() {
        int input = 15;

        n412_FizzBuzz solution = new n412_FizzBuzz();
        System.out.println((solution.fizzBuzz(input)).toString());
    }

    private static void _1672_RichestCustomerWealth() {
        int[][] input = new int[][]{{1, 2, 3}, {3, 2, 1}};

        n1672_RichestCustomerWealth solution = new n1672_RichestCustomerWealth();
        System.out.println(solution.maximumWealth(input));

    }

    private static void _167_two_sum_2_input_array_is_sorted() {
        n167_two_sum_2_input_array_is_sorted a167twosum2inputarrayissorted = new n167_two_sum_2_input_array_is_sorted();
        System.out.println(Arrays.toString(a167twosum2inputarrayissorted.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(a167twosum2inputarrayissorted.twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(a167twosum2inputarrayissorted.twoSum(new int[]{-1, 0}, -1)));
    }


    private static void _1480RunningSumOf1dArray() {
        int[]                input             = new int[]{1, 2, 3, 4};
        n1480sum_of_1d_array a1480sumof1darray = new n1480sum_of_1d_array();
        System.out.println(Arrays.toString(a1480sumof1darray.runningSum(input)));
    }


}