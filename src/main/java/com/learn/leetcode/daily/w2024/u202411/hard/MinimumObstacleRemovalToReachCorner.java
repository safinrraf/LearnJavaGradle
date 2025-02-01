package com.learn.leetcode.daily.w2024.u202411.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/description/?envType=daily-question&envId=2024-11-28">Task</a>
 * <br><a href="https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/solutions/6090228/beats-100-efficient-dijkistra-bfs/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Breadth-First Search, Graph, Heap (Priority Queue), Matrix, Shortest Path}
 * </ul>
 * <ul>Hints
 * <li> {@code Model the grid as a graph where cells are nodes and edges are between adjacent cells. Edges to cells with obstacles have a cost of 1 and all other edges have a cost of 0.}
 * <li> {@code Could you use 0-1 Breadth-First Search or Dijkstra’s algorithm?}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code m == grid.length}
 * <li> {@code n == grid[i].length}
 * <li> {@code 1 <= m, n <= 10^5}
 * <li> {@code 2 <= m * n <= 10^5}
 * <li> {@code grid[i][j] is either 0 or 1.}
 * <li> {@code grid[0][0] == grid[m - 1][n - 1] == 0.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 28.11.24 08:21
 */
public final class MinimumObstacleRemovalToReachCorner {

    /**
     *
     * @param grid a 0-indexed 2D integer array grid of size {@code m x n}.
     * @return the minimum number of obstacles to remove, so you can move from the upper left corner {@code (0, 0)} to the lower right corner {@code (m - 1, n - 1)}.
     */
    public static int minimumObstacles(int[][] grid) {
        int nRows = grid.length;
        int nCols = grid[0].length;

        // Directions for moving up, right, down, and left
        final int[][] diffs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        // A deque to perform 0-1 BFS
        final Deque<int[]> deque = new ArrayDeque<>();

        // Distance array initialized to a large value
        int[][] distance = new int[nRows][nCols];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Start from the top-left corner
        deque.offerFirst(new int[]{0, 0});
        distance[0][0] = 0;

        // Perform BFS
        while (!deque.isEmpty()) {
            final int[] current = deque.pollFirst();
            int i = current[0], j = current[1];

            // Check all 4 possible directions
            for (int[] diff : diffs) {
                int newI = i + diff[0];
                int newJ = j + diff[1];

                // Check if the new position is within bounds
                if (newI >= 0 && newI < nRows && newJ >= 0 && newJ < nCols) {
                    int newDistance = distance[i][j] + grid[newI][newJ];

                    // If a shorter path to this cell is found, update it
                    if (newDistance < distance[newI][newJ]) {
                        distance[newI][newJ] = newDistance;

                        // Push to front or back of deque based on cell value
                        if (grid[newI][newJ] == 0) {
                            deque.offerFirst(new int[]{newI, newJ});
                        } else {
                            deque.offerLast(new int[]{newI, newJ});
                        }
                    }
                }
            }
        }

        // Return the distance to the bottom-right corner
        return distance[nRows - 1][nCols - 1];
    }
}
