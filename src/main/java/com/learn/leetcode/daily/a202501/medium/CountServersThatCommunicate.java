package com.learn.leetcode.daily.a202501.medium;

/**
 * <a href="https://leetcode.com/problems/count-servers-that-communicate/description/?envType=daily-question&envId=2025-01-23">Task</a>
 * <br><a href="https://leetcode.com/problems/count-servers-that-communicate/editorial/?envType=daily-question&envId=2025-01-23">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Depth-First Search, Breadth-First Search, Union Find, Matrix, Counting}
 * </ul>
 * <ul>Hints
 * <li> {@code Store number of computer in each row and column.}
 * <li> {@code Count all servers that are not isolated.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code m == grid.length}
 * <li> {@code n == grid[i].length}
 * <li> {@code 1 <= m <= 250}
 * <li> {@code 1 <= n <= 250}
 * <li> {@code grid[i][j] == 0 or 1}
 * </ul>
 * <br>@since 1.0.0
 * <br> 23.01.25 15:54
 */
public final class CountServersThatCommunicate {

    /**
     * Approach 1: Brute-Force
     * <p>
     * {@code Time Complexity O(M * N * (M + N))}<br>
     * {@code Space Complexity O(M * N * (M + N))}
     * </p>
     * @param grid
     * @return the number of servers that communicate with any other server.
     */
    public static int countServers(int[][] grid) {
        final int numRows = grid.length;
        final int numCols = numRows > 0 ? grid[0].length : 0;
        int communicableServersCount = 0;

        // Traverse through the grid
        for (int row = 0; row < numRows; ++row) {
            for (int col = 0; col < numCols; ++col) {
                if (grid[row][col] == 1) {
                    boolean canCommunicate = false;

                    // Check for communication in the same row
                    for (int otherCol = 0; otherCol < numCols; ++otherCol) {
                        if (otherCol != col && grid[row][otherCol] == 1) {
                            canCommunicate = true;
                            break;
                        }
                    }

                    // If a server was found in the same row, increment
                    // communicableServersCount
                    if (canCommunicate) {
                        communicableServersCount++;
                    } else {
                        // Check for communication in the same column
                        for (int otherRow = 0; otherRow < numRows; ++otherRow) {
                            if (otherRow != row && grid[otherRow][col] == 1) {
                                canCommunicate = true;
                                break;
                            }
                        }

                        // If a server was found in the same column, increment
                        // communicableServersCount
                        if (canCommunicate) {
                            communicableServersCount++;
                        }
                    }
                }
            }
        }

        return communicableServersCount;
    }

    /**
     * Approach 2: Track Using Two Arrays
     * <p>
     * {@code Time Complexity O(M * N)}<br>
     * {@code Space Complexity O(M + N)}
     * </p>
     * @param grid
     * @return the number of servers that communicate with any other server.
     */
    public static int countServers_1(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        final int[] rowCounts = new int[grid[0].length];
        final int[] colCounts = new int[grid.length];

        // Count servers in each row and each column
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rowCounts[col]++;
                    colCounts[row]++;
                }
            }
        }

        int communicableServersCount = 0;

        // Count servers that can communicate (in the same row or column)
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    if (rowCounts[col] > 1 || colCounts[row] > 1) {
                        communicableServersCount++;
                    }
                }
            }
        }

        return communicableServersCount;
    }
}
