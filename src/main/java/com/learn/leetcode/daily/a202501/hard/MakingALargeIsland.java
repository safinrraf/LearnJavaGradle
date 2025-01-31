package com.learn.leetcode.daily.a202501.hard;

import com.learn.leetcode.common.DisjointSet;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/making-a-large-island/description/?envType=daily-question&envId=2025-01-31">Task</a>
 * <br><a href="https://leetcode.com/problems/making-a-large-island/editorial/?envType=daily-question&envId=2025-01-31">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Depth-First Search, Breadth-First Search, Union Find, Matrix}
 * </ul>
 * <ul>Hints
 * <li> {@code ...}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code n == grid.length}
 * <li> {@code n == grid[i].length}
 * <li> {@code 1 <= n <= 500}
 * <li> {@code grid[i][j] is either 0 or 1.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 31.01.25 08:22
 */
public final class MakingALargeIsland {

    /**
     * Approach 2: Using Disjoint Set Union (DSU).
     * <p>
     * {@code Time Complexity O(N * M)}<br>
     * {@code Space Complexity O(N * M)}
     * </p>
     * @param grid an {@code n x n} binary matrix.
     * @return the size of the largest <b>island</b> in {@code grid} after applying this operation. An island is a 4-directionally connected group of {@code 1}s.
     */
    public static int largestIsland(int[][] grid) {
        final int rows = grid.length;
        final int columns = grid[0].length;

        // Initialize DSU for the entire grid
        final DisjointSet ds = new DisjointSet(rows * columns);

        // Direction vectors for traversing up, down, left, and right
        final int[] rowDirections = { 1, -1, 0, 0 };
        final int[] columnDirections = { 0, 0, 1, -1 };

        // Step 1: Union adjacent `1`s in the grid
        for (int currentRow = 0; currentRow < rows; currentRow++) {
            for (
                    int currentColumn = 0;
                    currentColumn < columns;
                    currentColumn++
            ) {
                if (grid[currentRow][currentColumn] == 1) {
                    // Flatten 2D index to 1D
                    final int currentNode = (columns * currentRow) + currentColumn;

                    for (int direction = 0; direction < 4; direction++) {
                        int neighborRow = currentRow + rowDirections[direction];
                        int neighborColumn =
                                currentColumn + columnDirections[direction];

                        // Check bounds and ensure the neighbor is also `1`
                        if (
                                neighborRow >= 0 &&
                                        neighborRow < rows &&
                                        neighborColumn >= 0 &&
                                        neighborColumn < columns &&
                                        grid[neighborRow][neighborColumn] == 1
                        ) {
                            int neighborNode =
                                    columns * neighborRow + neighborColumn;
                            ds.unionNodes(currentNode, neighborNode);
                        }
                    }
                }
            }
        }

        // Step 2: Calculate the maximum possible island size
        int maxIslandSize = 0;
        // Flag to check if there are any zeros in the grid
        boolean hasZero = false;
        // To store unique roots for a `0`'s neighbors
        final Set<Integer> uniqueRoots = new HashSet<>();

        for (int currentRow = 0; currentRow < rows; currentRow++) {
            for (
                    int currentColumn = 0;
                    currentColumn < columns;
                    currentColumn++
            ) {
                if (grid[currentRow][currentColumn] == 0) {
                    hasZero = true;
                    // Start with the flipped `0`
                    int currentIslandSize = 1;

                    for (int direction = 0; direction < 4; direction++) {
                        int neighborRow = currentRow + rowDirections[direction];
                        int neighborColumn =
                                currentColumn + columnDirections[direction];

                        // Check bounds and ensure the neighbor is `1`
                        if (
                                neighborRow >= 0 &&
                                        neighborRow < rows &&
                                        neighborColumn >= 0 &&
                                        neighborColumn < columns &&
                                        grid[neighborRow][neighborColumn] == 1
                        ) {
                            int neighborNode =
                                    columns * neighborRow + neighborColumn;
                            int root = ds.findRoot(neighborNode);
                            uniqueRoots.add(root);
                        }
                    }

                    // Sum up the sizes of unique neighboring islands
                    for (int root : uniqueRoots) {
                        currentIslandSize += ds.islandSize[root];
                    }

                    // Clear the set for the next `0`
                    uniqueRoots.clear();

                    // Update the result with the largest island size found
                    maxIslandSize = Math.max(maxIslandSize, currentIslandSize);
                }
            }
        }

        // If there are no zeros, the largest island is the entire grid
        if (!hasZero) {
            return rows * columns;
        }

        return maxIslandSize;
    }
}
