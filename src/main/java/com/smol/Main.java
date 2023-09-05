package com.smol;

import com.smol.solutions.*;
import com.smol.solutions.n_876_MiddleOfLinkedList.ListNode;
import com.smol.solutions.n_876_MiddleOfLinkedList._876_MiddleOfLinkedList;

import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }

    // Methods ===

    private static void _225_ImplementStackUsingQueues() {
        //tested via test class
    }

    private static void _383_RansomNote() {
        n383_RansomNote solution = new n383_RansomNote();
        System.out.println("Expected:true , output:" + solution.canConstruct("aa", "aab"));
        System.out.println("Expected:false, output:" + solution.canConstruct("aa", "ab"));
        System.out.println("Expected:false, output:" + solution.canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi"));
    }

    private static void _876_MiddleOfLinkedList() {
        //input
        ListNode head  = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        //output
        _876_MiddleOfLinkedList solution = new _876_MiddleOfLinkedList();
        System.out.println(solution.middleNode(head).val);
        System.out.println(solution.middleNode(head2).val);
    }

    private static void _1342_NumberOfStepsToReduceNumberToZero() {
        n1342_NumberOfStepsToReduceNumberToZero solution = new n1342_NumberOfStepsToReduceNumberToZero();
        System.out.println(solution.numberOfSteps(14));
    }

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

    private static void _1_two_sum() {
        n1_two_sum a1twosum = new n1_two_sum();
        int[]      nums     = {2, 7, 11, 15};
        int        target   = 9;
        System.out.println(Arrays.toString(a1twosum.twoSum(nums, target)));
    }


    private static void _1480RunningSumOf1dArray() {
        int[]                input             = new int[]{1, 2, 3, 4};
        n1480sum_of_1d_array a1480sumof1darray = new n1480sum_of_1d_array();
        System.out.println(Arrays.toString(a1480sumof1darray.runningSum(input)));
    }


}