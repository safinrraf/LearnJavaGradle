package com.learn.leetcode.daily.q202410.medium;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/description/?envType=daily-question&envId=2024-10-29">Task</a>
 * <br><a href="https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/solutions/5980453/list-most-common-interview-matrix-beats-100-explained-step-by-step/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Dynamic Programming, Matrix}
 * </ul>
 * <ul>Hints
 * <li> {@code Consider using dynamic programming to find the maximum number of moves that can be made from each cell.}
 * <li> {@code The final answer will be the maximum value in cells of the first column.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code m == grid.length}
 * <li> {@code n == grid[i].length}
 * <li> {@code 2 <= m, n <= 1000}
 * <li> {@code 4 <= m * n <= 10^5}
 * <li> {@code 1 <= grid[i][j] <= 106}
 * </ul>
 * <br>@since 1.0.0
 * <br> 29.10.24 21:43
 */
public final class MaximumNumberOfMovesInGrid {
    /**
     *
     * @param grid
     * @return the maximum number of moves that you can perform.
     */
    public int maxMoves(int[][] grid) {
        // Get dimensions of the grid
        int m = grid.length;    // number of rows
        int n = grid[0].length; // number of columns

        // res will store the rightmost column we can reach
        int res = 0;

        // dp array stores the maximum number of moves possible to reach each cell
        // in the current column we're processing
        int[] dp = new int[m];

        // Iterate through each column from left to right (starting from column 1)
        for (int j = 1; j < n; j++) {
            // leftTop keeps track of the dp value from the cell above-left
            int leftTop = 0;
            // found indicates if we can reach any cell in current column
            boolean found = false;

            // Iterate through each row in current column
            for (int i = 0; i < m; i++) {
                // cur will store the maximum moves to reach current cell
                int cur = -1;
                // Store dp[i] for next iteration's leftTop
                int nxtLeftTop = dp[i];

                // Check move from top-left cell (if valid)
                if (i - 1 >= 0 && leftTop != -1 && grid[i][j] > grid[i - 1][j - 1]) {
                    cur = Math.max(cur, leftTop + 1);
                }

                // Check move from direct left cell (if valid)
                if (dp[i] != -1 && grid[i][j] > grid[i][j - 1]) {
                    cur = Math.max(cur, dp[i] + 1);
                }

                // Check move from bottom-left cell (if valid)
                if (i + 1 < m && dp[i + 1] != -1 && grid[i][j] > grid[i + 1][j - 1]) {
                    cur = Math.max(cur, dp[i + 1] + 1);
                }

                // Update dp array for current cell
                dp[i] = cur;
                // Update found flag if we can reach current cell
                found = found || (dp[i] != -1);
                // Update leftTop for next row's iteration
                leftTop = nxtLeftTop;
            }

            // If we can't reach any cell in current column, break
            if (!found) break;
            // Update result to current column if we can reach it
            res = j;
        }

        // Return the maximum number of moves possible
        return res;
    }
}
