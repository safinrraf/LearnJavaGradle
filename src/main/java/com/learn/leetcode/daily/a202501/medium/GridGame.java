package com.learn.leetcode.daily.a202501.medium;

/**
 * <a href="https://leetcode.com/problems/grid-game/?envType=daily-question&envId=2025-01-21">Task</a>
 * <br><a href="https://leetcode.com/problems/grid-game/editorial/?envType=daily-question&envId=2025-01-21">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Matrix, Prefix Sum}
 * </ul>
 * <ul>Hints
 * <li> {@code There are n choices for when the first robot moves to the second row.}
 * <li> {@code Can we use prefix sums to help solve this problem?}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code grid.length == 2}
 * <li> {@code n == grid[r].length}
 * <li> {@code 1 <= n <= 5 * 10^4}
 * <li> {@code 1 <= grid[r][c] <= 105}
 * </ul>
 * <br>@since 1.0.0
 * <br> 21.01.25 08:35
 */
public final class GridGame {

    /**
     * Approach: Prefix and Suffix Sum
     * <p>
     * {@code Time Complexity O(...)}<br>
     * {@code Space Complexity O(...)}
     * </p>
     * @param grid
     * @return the <b>number of points</b> collected by the <b>second</b> robot.
     */
    public static long gridGame(int[][] grid) {
        // Calculate the sum of all the elements for the first row
        long firstRowSum = 0;
        for (int num : grid[0]) {
            firstRowSum += num;
        }
        long secondRowSum = 0;
        long minimumSum = Long.MAX_VALUE;
        for (int turnIndex = 0; turnIndex < grid[0].length; ++turnIndex) {
            firstRowSum -= grid[0][turnIndex];
            // Find the minimum maximum value out of firstRowSum and
            // secondRowSum.
            minimumSum = Math.min(
                    minimumSum,
                    Math.max(firstRowSum, secondRowSum)
            );
            secondRowSum += grid[1][turnIndex];
        }
        return minimumSum;
    }
}
