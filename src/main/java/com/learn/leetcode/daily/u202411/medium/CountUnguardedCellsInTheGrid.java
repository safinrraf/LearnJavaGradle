package com.learn.leetcode.daily.u202411.medium;

/**
 * <a href="https://leetcode.com/problems/count-unguarded-cells-in-the-grid/description/?envType=daily-question&envId=2024-11-21">Task</a>
 * <br><a href="https://leetcode.com/problems/count-unguarded-cells-in-the-grid/solutions/6067031/beats-100-video-full-explain-3-approaches/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Matrix, Simulation}
 * </ul>
 * <ul>Hints
 * <li> {@code Create a 2D array to represent the grid. Can you mark the tiles that can be seen by a guard?}
 * <li> {@code Iterate over the guards, and for each of the 4 directions, advance the current tile and mark the tile. When should you stop advancing?}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= m, n <= 10^5}
 * <li> {@code 2 <= m * n <= 10^5}
 * <li> {@code 1 <= guards.length, walls.length <= 5 * 10^4}
 * <li> {@code 2 <= guards.length + walls.length <= m * n}
 * <li> {@code guards[i].length == walls[j].length == 2}
 * <li> {@code 0 <= row-i, row-j < m}
 * <li> {@code 0 <= col-i, col-j < n}
 * <li> {@code All the positions in guards and walls are unique.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 21.11.24 08:22
 */
public final class CountUnguardedCellsInTheGrid {

    /**
     * Depth-First Search solution
     *
     * {@code Time Complexity O(Mn)}
     * {@code Space Complexity O(Mn)}
     *
     * @param m
     * @param n
     * @param guards
     * @param walls
     * @return
     */
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        // 0 = free, 1 = guard, 2 = wall, 3 = guardable

        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }

        for (int[] guard : guards) {
            markGuarded(grid, guard[0], guard[1], m, n);
        }

        int res = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 0) {
                    res++;
                }
            }
        }

        return res;
    }

    private static void markGuarded(int[][] grid, int r, int c, int m, int n) {
        for (int row = r + 1; row < m; row++) {
            if (grid[row][c] == 1 || grid[row][c] == 2) break;
            grid[row][c] = 3;
        }
        for (int row = r - 1; row >= 0; row--) {
            if (grid[row][c] == 1 || grid[row][c] == 2) break;
            grid[row][c] = 3;
        }
        for (int col = c + 1; col < n; col++) {
            if (grid[r][col] == 1 || grid[r][col] == 2) break;
            grid[r][col] = 3;
        }
        for (int col = c - 1; col >= 0; col--) {
            if (grid[r][col] == 1 || grid[r][col] == 2) break;
            grid[r][col] = 3;
        }
    }
}
