package com.smol.solutions;

/**
 * <h1>343. Integer Break</h1>
 * Medium <p>
 * Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
 * <p>
 * Return the maximum product you can get.
 *
 * <pre>
 * Example 1:
 * Input: n = 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 *
 * Example 2:
 * Input: n = 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 *
 * Constraints:
 *     2 <= n <= 58
 * </pre>
 */
public class N0343_IntegerBreak {

    /**
     * <h1>Maxima and Minima </h1>
     * <pre>
     * Basically searching got extremes of function.
     * In this case max. product `p` with min. number of elements `k>= 2` can be achieved depending on `n` value as follows:
     *  - if `1 < n < 4` because has to be `k >= 2` for :
     *          - `n=2` is p= `1*1`
     *          - `n=3` is p= `2*1`
     *  - if `n % 3== 0`, then calculate `k` number of elements is `k= n/3` power `m= k`  and `p=3^(m)`. Ideal case.
     *  - if `n` can't without remainder `r`:
     *      - if `r= 1` but in this case p=...3*1 < p=...2*2, so single `3` has to be moved to `r` so now `k-= 1`, `r= 4` divided into `a=2`, `b=2` and finally `p= 3^(k-1)*a*b`
     *      - if `r= 2` is simple `p= 3^(k) * r`
     *
     * Runtime 0ms,     Beats 100.00%of users with Java
     * Memory 38.90MB,  Beats 85.29%of users with Java     *
     * </pre>
     */
    public int integerBreak(int n) {

        if (n == 2) return 1; // n= 2= 1+1 case
        if (n == 3) return 2; // n= 3= 2+1 case

        int remainder = n % 3;
        int a, b      = 1; // init 1 -> doesn't affect multiplication (0 can't be used)

        if (remainder == 1) {  // r= 4 = 2+2 case
            remainder = 4;
            a = b = 2;
        } else a = remainder == 0 ? 1 : remainder;  // r= 5 = 2+3 or r=0 case

        n -= remainder;
        int power = n / 3;
        return (int) Math.pow(3, power) * a * b;
    }
}
