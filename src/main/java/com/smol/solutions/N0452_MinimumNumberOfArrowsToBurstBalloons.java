package com.smol.solutions;


import java.util.Arrays;

/**
 * <h1>452. Minimum Number of Arrows to Burst Balloons</h1>
 * Medium
 * <p>
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
 * <p>
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 * <p>
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 *
 * <pre>
 *
 * Example 0:
 * Input: points = [[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]
 * Output: 2
 *      |Interval 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10| 11| 12|
 *      |  0|  9| X | X | X | X | X | X |[X]| X | X | X |   |   |   |
 *      |  0|  6| X | X | X | X | X | X |[X]|   |   |   |   |   |   |
 *      |  2|  9|   |   | X | X | X | X |[X]| X | X | X |   |   |   |
 *      |  2|  8|   |   | X | X | X | X |[X]| X | X |   |   |   |   |
 *      |  3|  9|   |   |   | X | X | X |[X]| X | X | X |   |   |   |
 *      |  3|  8|   |   |   | X | X | X |[X]| X | X |   |   |   |   |
 *      |  3|  9|   |   |   | X | X | X |[X]| X | X | X |   |   |   |
 *      |  6|  8|   |   |   |   |   |   |[X]| X | X |   |   |   |   |
 *      |  7| 12|   |   |   |   |   |   |   | X | X |[X]| X | X | X |
 *      |  9| 10|   |   |   |   |   |   |   |   |   |[X]| X |   |   |
 *
 *
 * Example 1:
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
 * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 *
 * Example 2:
 * Input: points = [[1,2],[3,4],[5,6],[7,8]]
 * Output: 4
 * Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
 *
 * Example 3:
 * Input: points = [[1,2],[2,3],[3,4],[4,5]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
 * - Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
 *
 *
 * Constraints:
 *     1 <= points.length <= 105
 *     points[i].length == 2
 *     -231 <= xstart < xend <= 231 - 1
 * </pre>
 */
public class N0452_MinimumNumberOfArrowsToBurstBalloons {

    /**
     * <pre>
     * Runtime 57 ms    Beats 25.58% of users with Java
     * Memory 77.76 MB  Beats6.55% of users with Java
     * </pre>
     */
    public int findMinArrowShots(int[][] points) {
        // sort arrays by their starts then ends in acs order
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        // find groups of intervals that all overlaps in single spot and count the groups aka arrows
        int i = 1, arrows = 1;
        int[] intersection = new int[2];
        intersection[0] = points[0][0];
        intersection[1] = points[0][1];

        while (i < points.length) {
            if (intersection[0] <= intersection[1]) {
                intersection[0] = Math.max(intersection[0], points[i][0]);
                intersection[1] = Math.min(intersection[1], points[i][1]);
            }
            if (intersection[0] > intersection[1]) {
                arrows++;
                intersection[0] = points[i][0];
                intersection[1] = points[i][1];
            }
            i++;
        }
        return arrows;
    }
}
