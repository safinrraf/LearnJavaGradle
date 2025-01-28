package com.learn.leetcode.daily.a202501.medium;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/description/?envType=daily-question&envId=2025-01-28">Task</a>
 * <br><a href="https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/editorial/?envType=daily-question&envId=2025-01-28">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Depth-First Search, Breadth-First Search, Union Find, Matrix}
 * </ul>
 * <ul>Hints
 * <li> {@code Run DFS from each non-zero cell.}
 * <li> {@code Each time you pick a cell to start from, add up the number of fish contained in the cells you visit.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code m == grid.length}
 * <li> {@code n == grid[i].length}
 * <li> {@code 1 <= m, n <= 10}
 * <li> {@code 0 <= grid[i][j] <= 10}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 28.01.25 08:26
 */
public final class MaximumNumberOfFishInGrid {

    /**
     * Approach 1: Depth-First Search
     * <p>
     * {@code Time Complexity O(M * N)}<br>
     * {@code Space Complexity O(M * N)}
     * </p>
     * @param grid
     * @return the <b>maximum</b> number of fish the fisher can catch if he chooses his starting cell optimally, or {@code 0} if no water cell exists.
     */
    public static int findMaxFish(int[][] grid) {
        final int rows = grid.length;
        final int cols = grid[0].length;
        int maxFishCount = 0;

        // A 2D array to track visited cells
        final boolean[][] visited = new boolean[rows][cols];

        // Iterate through all cells in the grid
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Start a DFS for unvisited land cells (fish available)
                if (grid[row][col] > 0 && !visited[row][col]) {
                    maxFishCount = Math.max(
                            maxFishCount,
                            calculateFishes(grid, visited, row, col)
                    );
                }
            }
        }

        // Return the maximum fish count found
        return maxFishCount;
    }

    // Helper function to count the number of fishes in a connected component
    private static int calculateFishes(
            int[][] grid,
            boolean[][] visited,
            int row,
            int col
    ) {
        // Check boundary conditions, water cells, or already visited cells
        if (
                row < 0 ||
                        row >= grid.length ||
                        col < 0 ||
                        col >= grid[0].length ||
                        grid[row][col] == 0 ||
                        visited[row][col]
        ) {
            return 0;
        }

        // Mark the current cell as visited
        visited[row][col] = true;

        // Accumulate the fish count from the current cell and its neighbors
        return (
                grid[row][col] +
                        calculateFishes(grid, visited, row, col + 1) +
                        calculateFishes(grid, visited, row, col - 1) +
                        calculateFishes(grid, visited, row + 1, col) +
                        calculateFishes(grid, visited, row - 1, col)
        );
    }
}
