package com.smol.solutions.N0021_merge2sortedlists;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

class N0021_MergeTwoSortedListsTest {

    private static final TUtils utils = new TUtils();
    private static final N0021_MergeTwoSortedLists obj   = new N0021_MergeTwoSortedLists();

    @ParameterizedTest
    @CsvSource(value = {
            "'' ,'' ,'' ",
            "'' , 0,0 ",
            "1;2;4,     1;3;4,  1;1;2;3;4;4",
    })
    void mergeTwoLists(String inp1, String inp2, String exp) {

        ListNode      input1   = covertIntToListNode(inp1);
        ListNode      input2   = covertIntToListNode(inp2);
        ListNode      expected = covertIntToListNode(exp);
        ListNode      actual   = obj.mergeTwoLists(input1, input2);
        List<Integer> expList  = new ArrayList<>();
        List<Integer> actList  = new ArrayList<>();

        while (expected != null) {
            expList.add(expected.val);
            expected = expected.next;
        }

        if (actual != null) {
            while (actual != null) {
                actList.add(actual.val);
                actual = actual.next;
            }
        }

        Assertions.assertArrayEquals(expList.toArray(), actList.toArray());
    }


    /**
     * Helper method. Generated ListNode from values within a string
     */
    private ListNode covertIntToListNode(String inp1) {
        ListNode prehead = new ListNode(-1);
        ListNode tail    = prehead;
        int[]    values  = utils.StringToIntArray(inp1, ";");

        for (int i : values) {
            tail.next = new ListNode(i);
            tail = tail.next;
        }
        return prehead.next;
    }
}