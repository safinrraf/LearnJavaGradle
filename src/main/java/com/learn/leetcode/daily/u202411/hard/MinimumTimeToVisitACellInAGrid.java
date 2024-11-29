package com.learn.leetcode.daily.u202411.hard;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/description/?envType=daily-question&envId=2024-11-29">Task</a>
 * <br><a href="https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/solutions/6083425/video-beats-100-dijkstra-s-algorithm/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Breadth-First Search, Graph, Heap (Priority Queue), Matrix, Shortest Path, Dijkstra’s algorithm}
 * </ul>
 * <ul>Hints
 * <li> {@code Try using some algorithm that can find the shortest paths on a graph.}
 * <li> {@code Consider the case where you have to go back and forth between two cells of the matrix to unlock some other cells.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code m == grid.length}
 * <li> {@code n == grid[i].length}
 * <li> {@code 2 <= m, n <= 1000}
 * <li> {@code 4 <= m * n <= 10^5}
 * <li> {@code 0 <= grid[i][j] <= 10^5}
 * <li> {@code grid[0][0] == 0}
 * </ul>
 * <br>@since 1.0.0
 * <br> 29.11.24 08:29
 */
public final class MinimumTimeToVisitACellInAGrid {

    private static final int[][] MOVES = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    /**
     * {@code Time Complexity O(R * C * Log(R * C))}
     * {@code Space Complexity O(R * C)}
     *
     * @param grid
     * @return the minimum time required in which you can visit the bottom-right cell of the matrix. If you cannot visit the bottom-right cell, then return {@code -1}.
     */
        public static int minimumTime(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;

            if (grid[0][1] > 1 && grid[1][0] > 1) {
                return -1;
            }

            final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            boolean[][] seen = new boolean[rows][cols];

            pq.offer(new int[]{0, 0, 0}); // time, row, col
            seen[0][0] = true;

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int time = curr[0];
                int row = curr[1];
                int col = curr[2];

                for (int[] dir : MOVES) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow < 0 || newRow >= rows ||
                            newCol < 0 || newCol >= cols ||
                            seen[newRow][newCol]) {
                        continue;
                    }

                    int newTime = time + 1;
                    if (grid[newRow][newCol] > newTime) {
                        int wait = ((grid[newRow][newCol] - newTime + 1) / 2) * 2;
                        newTime += wait;
                    }

                    if (newRow == rows - 1 && newCol == cols - 1) {
                        return newTime;
                    }

                    seen[newRow][newCol] = true;
                    pq.offer(new int[]{newTime, newRow, newCol});
                }
            }

            return -1;
        }
    }