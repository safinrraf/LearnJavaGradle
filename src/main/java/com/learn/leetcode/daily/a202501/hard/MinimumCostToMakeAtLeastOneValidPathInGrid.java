package com.learn.leetcode.daily.a202501.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description/?envType=daily-question&envId=2025-01-18">Task</a>
 * <br><a href="https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/editorial/?envType=daily-question&envId=2025-01-18">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Breadth-First Search, Graph, Heap (Priority Queue), Matrix, Shortest Path}
 * </ul>
 * <ul>Hints
 * <li> {@code Build a graph where grid[i][j] is connected to all the four side-adjacent cells with weighted edge. the weight is 0 if the sign is pointing to the adjacent cell or 1 otherwise.}
 * <li> {@code Do BFS from (0, 0) visit all edges with weight = 0 first. the answer is the distance to (m -1, n - 1).}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code m == grid.length}
 * <li> {@code n == grid[i].length}
 * <li> {@code 1 <= m, n <= 100}
 * <li> {@code 1 <= grid[i][j] <= 4}
 * </ul>
 * <br>@since 1.0.0
 * <br> 18.01.25 17:37
 */
public final class MinimumCostToMakeAtLeastOneValidPathInGrid {

    // Direction vectors: right, left, down, up (matching grid values 1,2,3,4)
    private static int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    /**
     * Approach 1: Dynamic Programming
     * <p>
     * {@code Time Complexity O((n * m)^2)}<br>
     * {@code Space Complexity O(n * m)}
     * </p>
     * @param grid
     * @return the minimum cost to make the grid have at least one valid path.
     */
    public static int minCost(int[][] grid) {
        final int numRows = grid.length;
        final int numCols = grid[0].length;
        final int[][] minChanges = new int[numRows][numCols];

        // Initialize all cells with max value
        for (int[] row : minChanges) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minChanges[0][0] = 0;

        while (true) {
            // Store previous state to check for convergence
            final int[][] prevState = new int[numRows][numCols];
            for (int row = 0; row < numRows; row++) {
                prevState[row] = Arrays.copyOf(minChanges[row], numCols);
            }

            // Forward pass: check cells coming from left and top
            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numCols; col++) {
                    // Check cell above
                    if (row > 0) {
                        minChanges[row][col] = Math.min(
                                minChanges[row][col],
                                minChanges[row - 1][col] +
                                        (grid[row - 1][col] == 3 ? 0 : 1)
                        );
                    }
                    // Check cell to the left
                    if (col > 0) {
                        minChanges[row][col] = Math.min(
                                minChanges[row][col],
                                minChanges[row][col - 1] +
                                        (grid[row][col - 1] == 1 ? 0 : 1)
                        );
                    }
                }
            }

            // Backward pass: check cells coming from right and bottom
            for (int row = numRows - 1; row >= 0; row--) {
                for (int col = numCols - 1; col >= 0; col--) {
                    // Check cell below
                    if (row < numRows - 1) {
                        minChanges[row][col] = Math.min(
                                minChanges[row][col],
                                minChanges[row + 1][col] +
                                        (grid[row + 1][col] == 4 ? 0 : 1)
                        );
                    }
                    // Check cell to the right
                    if (col < numCols - 1) {
                        minChanges[row][col] = Math.min(
                                minChanges[row][col],
                                minChanges[row][col + 1] +
                                        (grid[row][col + 1] == 2 ? 0 : 1)
                        );
                    }
                }
            }

            // If no changes were made in this iteration, we've found optimal solution
            if (Arrays.deepEquals(prevState, minChanges)) {
                break;
            }
        }

        return minChanges[numRows - 1][numCols - 1];
    }

    /**
     * Approach 2: Dijkstra's Algorithm
     * <p>
     * {@code Time Complexity O(n * m * log(n * m))}<br>
     * {@code Space Complexity O(n * m)}
     * </p>
     * @param grid
     * @return the minimum cost to make the grid have at least one valid path.
     */
    public static int minCost1(int[][] grid) {
        final int numRows = grid.length;
        final int numCols = grid[0].length;

        // Min-heap ordered by cost. Each element is [cost, row, col]
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, 0, 0 });

        // Track minimum cost to reach each cell
        final int[][] minCost = new int[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            Arrays.fill(minCost[row], Integer.MAX_VALUE);
        }
        minCost[0][0] = 0;

        while (!pq.isEmpty()) {
            final int[] curr = pq.poll();
            final int cost = curr[0], row = curr[1], col = curr[2];

            // Skip if we've found a better path to this cell
            if (minCost[row][col] != cost) continue;

            // Try all four directions
            for (int dir = 0; dir < 4; dir++) {
                final int newRow = row + dirs[dir][0];
                final int newCol = col + dirs[dir][1];

                // Check if new position is valid
                if (
                        newRow >= 0 &&
                                newRow < numRows &&
                                newCol >= 0 &&
                                newCol < numCols
                ) {
                    // Add cost=1 if we need to change direction
                    int newCost = cost + (dir != (grid[row][col] - 1) ? 1 : 0);

                    // Update if we found a better path
                    if (minCost[newRow][newCol] > newCost) {
                        minCost[newRow][newCol] = newCost;
                        pq.offer(new int[] { newCost, newRow, newCol });
                    }
                }
            }
        }

        return minCost[numRows - 1][numCols - 1];
    }

    /**
     * Approach 3: 0-1 Breadth-First Search
     * <p>
     * {@code Time Complexity O((n * m))}<br>
     * {@code Space Complexity O(n * m)}
     * </p>
     * @param grid
     * @return the minimum cost to make the grid have at least one valid path.
     */
    public static int minCost2(int[][] grid) {
        final int numRows = grid.length;
        final int numCols = grid[0].length;

        // Track minimum cost to reach each cell
        final int[][] minCost = new int[numRows][numCols];
        for (int[] row : minCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Use deque for 0-1 BFS - add zero cost moves to front, cost=1 to back
        final Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[] { 0, 0 });
        minCost[0][0] = 0;

        while (!deque.isEmpty()) {
            final int[] curr = deque.pollFirst();
            final int row = curr[0], col = curr[1];

            // Try all four directions
            for (int dir = 0; dir < 4; dir++) {
                final int newRow = row + dirs[dir][0];
                final int newCol = col + dirs[dir][1];
                final int cost = (grid[row][col] != (dir + 1)) ? 1 : 0;

                // If position is valid and we found a better path
                if (
                        isValid(newRow, newCol, numRows, numCols) &&
                                minCost[row][col] + cost < minCost[newRow][newCol]
                ) {
                    minCost[newRow][newCol] = minCost[row][col] + cost;

                    // Add to back if cost=1, front if cost=0
                    if (cost == 1) {
                        deque.offerLast(new int[] { newRow, newCol });
                    } else {
                        deque.offerFirst(new int[] { newRow, newCol });
                    }
                }
            }
        }

        return minCost[numRows - 1][numCols - 1];
    }

    // Check if coordinates are within grid bounds
    private static boolean isValid(int row, int col, int numRows, int numCols) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }
}
