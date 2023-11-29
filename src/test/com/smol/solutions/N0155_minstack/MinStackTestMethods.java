package com.smol.solutions.N0155_minstack;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Random;

/**
 * <h2>Common method for MinStackTests</h2>
 * Each MinStackTest uses same sets of methods but on different object(class) <p>
 * To stay "DRY", common methods "pool" was written.
 *
 * <pre>
 * Example 1:
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 * </pre>
 * Constraints: <p>
 * ->   -231 <= val <= 231 - 1  <p>
 * ->   Methods pop, top and getMin operations will always be called on non-empty stacks.   <p>
 * ->   At most 3 * 104 calls will be made to push, pop, top, and getMin.   <p>
 */
class MinStackTestMethods {

    protected static final int[] nums = genRandomInts(5, 9);

    protected static void pushTopGetMin01(MinStackInterface obj) {
        obj.push(-1);
        obj.top();
        Assertions.assertEquals(-1, obj.getMin());
    }

    protected static void pushTop(MinStackInterface obj) {
        for (int i = nums.length - 1; i >= 0; i--) {
            obj.push(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            Assertions.assertEquals(nums[i], obj.top(),
                    "\nnums = " + Arrays.toString(nums) +
                    "\nnums[" + (i) + "] = " + nums[i]);
            obj.pop();
        }
    }

    protected static void pushPop(MinStackInterface obj) {
        for (int i = nums.length - 1; i >= 0; i--) obj.push(nums[i]);

        int i = 0;
        while (i < nums.length / 2) {
            obj.pop();
            i++;
        }
        while (i < nums.length) {
            Assertions.assertEquals(nums[i], obj.top(),
                    "\nnums = " + Arrays.toString(nums) +
                    "\nnums[" + (i) + "] = " + nums[i]);
            obj.pop();
            i++;
        }
    }

    protected static void pushGetMin(MinStackInterface obj) {
        int n = nums.length / 2;

        int expected = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) expected = Math.min(expected, nums[i]);

        for (int i = n - 1; i >= 0; i--) obj.push(nums[i]);
        Assertions.assertEquals(expected, obj.getMin(),
                "\nnums = " + Arrays.toString(nums));
    }

    protected static void pushPopGetMin(MinStackInterface obj) {
        int n = nums.length / 2;
        int expected = Integer.MAX_VALUE;

        //in reverse order so stack is not reversed
        for (int i = n - 1; i >= 0; i--) {
            expected = Math.min(expected, nums[i]); //find min
            obj.push(nums[i]); // push into stack
        }

        //peek and pop half of the stack
        for (int i = n / 2 - 1; i >= 1; i--) {
            if (obj.top() == expected) {
                obj.pop();
                expected = Integer.MAX_VALUE;

                //update expected min
                for (int j = i - 1; j > 0; j--) {
                    expected = Math.min(expected, nums[j]);
                }
            } else obj.pop();
        }

        Assertions.assertEquals(expected, obj.getMin(),
                "\nnums = " + Arrays.toString(nums));
    }

    /**
     * @param n   - number of generated numbers
     * @param max - max positive and min negative number
     * @return int [] of generated numbers
     */
    private static int[] genRandomInts(int n, int max) {
        max = Math.abs(max);
        Random rnd = new Random(System.currentTimeMillis());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = rnd.nextInt(-max, max);
        }
        return nums;
    }
}