package solutions;

/**
 * <h1>4. Median of Two Sorted Arrays</h1>
 * Hard
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2];
 * Output: 2.00000;
 * Explanation: merged array = [1,2,3] and median is 2.;
 * <p>
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4];
 * Output: 2.50000;
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.;
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m;
 * nums2.length == n;
 * 0 <= m <= 1000;
 * 0 <= n <= 1000;
 * 1 <= m + n <= 2000;
 * -106 <= nums1[i], nums2[i] <= 106;
 * <p>
 * Accepted 2.1M;
 * Submissions 5.5M;
 * Acceptance Rate 37.3%;
 */

public class _4_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int   max    = nums1.length + nums2.length;
        int[] merged = new int[max];
        int   k      = 0;
        int   kMax   = nums1.length;
        int   l      = 0;
        int   lMax   = nums2.length;
        for (int i = 0; i < max; i++) {
            if (k < kMax && l < lMax) {
                if (nums1[k] < nums2[l]) {
                    merged[i] = nums1[k];
                    k++;
                } else {
                    merged[i] = nums2[l];
                    l++;
                }
            } else if (k < kMax) {
                merged[i] = nums1[k];
                k++;
            } else if (l < lMax) {
                merged[i] = nums2[l];
                l++;
            }
        }
        return max % 2 == 0 ? (double) (merged[max / 2 - 1] + merged[max / 2]) / 2 : merged[max / 2];
    }
}
