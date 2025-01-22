package com.learn.leetcode.daily.a202501.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/map-of-highest-peak/description/?envType=daily-question&envId=2025-01-22">Task</a>
 * <br><a href="https://leetcode.com/problems/map-of-highest-peak/editorial/?envType=daily-question&envId=2025-01-22">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Breadth-First Search, Matrix}
 * </ul>
 * <ul>Hints
 * <li> {@code Set each water cell to be 0. The height of each cell is limited by its closest water cell.}
 * <li> {@code Perform a multi-source BFS with all the water cells as sources.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code m == isWater.length}
 * <li> {@code n == isWater[i].length}
 * <li> {@code 1 <= m, n <= 1000}
 * <li> {@code isWater[i][j] is 0 or 1.}
 * <li> {@code There is at least one water cell.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 22.01.25 15:12
 */
public final class MapOfHighestPeak {

    /**
     * Approach 1: Breadth-First Search
     * <p>
     * {@code Time Complexity O(m * n)}<br>
     * {@code Space Complexity O(m * n)}
     * </p>
     * @param isWater
     * @return an integer matrix {@code height} of size {@code m x n} where {@code height[i][j]} is cell {@code (i, j)}'s height. If there are multiple solutions, return <b>any</b> of them.
     */
    public static int[][] highestPeak(int[][] isWater) {
        final int[] dx = { 0, 0, 1, -1 }; // Horizontal movement: right, left, down, up
        final int[] dy = { 1, -1, 0, 0 }; // Vertical movement corresponding to dx

        final int rows = isWater.length;
        final int columns = isWater[0].length;

        // Initialize the height matrix with -1 (unprocessed cells)
        final int[][] cellHeights = new int[rows][columns];
        for (int[] row : cellHeights) {
            Arrays.fill(row, -1);
        }

        // Queue to perform breadth-first search
        final Queue<int[]> cellQueue = new LinkedList<>();

        // Add all water cells to the queue and set their height to 0
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                if (isWater[x][y] == 1) {
                    cellQueue.add(new int[] { x, y });
                    cellHeights[x][y] = 0;
                }
            }
        }

        int heightOfNextLayer = 1; // Initial height for land cells adjacent to water

        // Perform BFS
        while (!cellQueue.isEmpty()) {
            final int layerSize = cellQueue.size();

            // Iterate through all cells in the current layer
            for (int i = 0; i < layerSize; i++) {
                final int[] currentCell = cellQueue.poll();

                // Check all four possible directions for neighboring cells
                for (int d = 0; d < 4; d++) {
                    int neighborX = currentCell[0] + dx[d];
                    int neighborY = currentCell[1] + dy[d];

                    // Check if the neighbor is valid and unprocessed
                    if (
                            isValidCell(neighborX, neighborY, rows, columns) &&
                                    cellHeights[neighborX][neighborY] == -1
                    ) {
                        cellHeights[neighborX][neighborY] = heightOfNextLayer;
                        cellQueue.add(new int[] { neighborX, neighborY });
                    }
                }
            }
            heightOfNextLayer++; // Increment height for the next layer
        }

        return cellHeights;
    }

    /**
     * Approach 2: Dynamic Programming
     * <p>
     * {@code Time Complexity O(m * n)}<br>
     * {@code Space Complexity O(m * n)}
     * </p>
     * @param isWater
     * @return an integer matrix {@code height} of size {@code m x n} where {@code height[i][j]} is cell {@code (i, j)}'s height. If there are multiple solutions, return <b>any</b> of them.
     */
    public static int[][] highestPeak2(int[][] isWater) {
        final int rows = isWater.length;
        final int columns = isWater[0].length;
        final int INF = rows * columns; // Large value to represent uninitialized heights

        // Initialize the cellHeights matrix with INF (unprocessed cells)
        final int[][] cellHeights = new int[rows][columns];
        for (int[] row : cellHeights) {
            Arrays.fill(row, INF);
        }

        // Set the height of water cells to 0
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (isWater[row][col] == 1) {
                    cellHeights[row][col] = 0; // Water cells have height 0
                }
            }
        }

        // Forward pass: updating heights based on top and left neighbors
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int minNeighborDistance = INF; // Initialize minimum neighbor distance

                // Check the cell above
                int neighborRow = row - 1;
                int neighborCol = col;
                if (isValidCell(neighborRow, neighborCol, rows, columns)) {
                    minNeighborDistance = Math.min(
                            minNeighborDistance,
                            cellHeights[neighborRow][neighborCol]
                    );
                }

                // Check the cell to the left
                neighborRow = row;
                neighborCol = col - 1;
                if (isValidCell(neighborRow, neighborCol, rows, columns)) {
                    minNeighborDistance = Math.min(
                            minNeighborDistance,
                            cellHeights[neighborRow][neighborCol]
                    );
                }

                // Set the current cell's height as the minimum of its neighbors + 1
                cellHeights[row][col] = Math.min(
                        cellHeights[row][col],
                        minNeighborDistance + 1
                );
            }
        }

        // Backward pass: updating heights based on bottom and right neighbors
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = columns - 1; col >= 0; col--) {
                int minNeighborDistance = INF; // Initialize minimum neighbor distance

                // Check the cell below
                int neighborRow = row + 1;
                int neighborCol = col;
                if (isValidCell(neighborRow, neighborCol, rows, columns)) {
                    minNeighborDistance = Math.min(
                            minNeighborDistance,
                            cellHeights[neighborRow][neighborCol]
                    );
                }

                // Check the cell to the right
                neighborRow = row;
                neighborCol = col + 1;
                if (isValidCell(neighborRow, neighborCol, rows, columns)) {
                    minNeighborDistance = Math.min(
                            minNeighborDistance,
                            cellHeights[neighborRow][neighborCol]
                    );
                }

                // Set the current cell's height as the minimum of its neighbors + 1
                cellHeights[row][col] = Math.min(
                        cellHeights[row][col],
                        minNeighborDistance + 1
                );
            }
        }

        return cellHeights; // Return the calculated cell heights
    }

    // Function to check if a cell is within the grid boundaries
    private static boolean isValidCell(int x, int y, int rows, int columns) {
        return x >= 0 && y >= 0 && x < rows && y < columns;
    }
}
