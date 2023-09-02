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

    /**
     * O(m+n)
     * 2ms, 44.7MB
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int   max    = nums1.length + nums2.length;
        int[] merged = new int[max];
        int   k      = 0;
        int   kMax   = nums1.length;
        int   l      = 0;
        int   lMax   = nums2.length;

        int i = 0;
        while (k < kMax && l < lMax) {
            if (nums1[k] < nums2[l]) {
                merged[i++] = nums1[k++];
            } else {
                merged[i++] = nums2[l++];
            }
        }
        while (k < kMax) {
            merged[i++] = nums1[k++];
        }
        while (l < lMax) {
            merged[i++] = nums2[l++];
        }
        return max % 2 == 0 ? (double) (merged[max / 2 - 1] + merged[max / 2]) / 2 : merged[max / 2];
    }

    /**
     *  O(log(m+n)) <p>
     *
     *
     * <p><p>
     * @param nums1 [] array
     * @param nums2 [] array
     * @return median of nums1 and nums2 merged array
     */

    public double findMedianSortedArrays01(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0;
        }

        if (nums1 == null) {
            int n = nums2.length;
            return nums2[(n - 1) / 2] * 0.5 + nums2[n / 2] * 0.5;
        }

        if (nums2 == null) {
            int n = nums1.length;
            return nums1[(n - 1) / 2] * 0.5 + nums1[n / 2] * 0.5;
        }

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // choose shorter to binary search
        int n     = nums1.length;
        int m     = nums2.length;
        int left  = 0;
        int right = n;

        while (left < right) {
            int i = (left + right) / 2;
            int j = (n + m) / 2 - i;

            if (nums1[i] < nums2[j - 1]) {
                left = i + 1;
            } else {
                right = i;
            }
        }

        int first  = left;
        int second = (n + m) / 2 - left;

        int shorterLeft  = first == 0 ? Integer.MIN_VALUE : nums1[first - 1];
        int shorterRight = first == n ? Integer.MAX_VALUE : nums1[first];

        int longerLeft  = second == 0 ? Integer.MIN_VALUE : nums2[second - 1];
        int longerRight = second == m ? Integer.MAX_VALUE : nums2[second];

        if ((n + m) % 2 == 1) {
            return Math.min(shorterRight, longerRight);
        } else {
            return Math.max(shorterLeft, longerLeft) * 0.5 + Math.min(shorterRight, longerRight) * 0.5;
        }


    }
}
