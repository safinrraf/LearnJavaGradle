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
public final class MaximumNumberOfFishInGridUnionFind {

    /**
     * Approach 3: Union Find Algorithm
     * <p>
     * {@code Time Complexity O(N * M * A(N * M))}<br>
     * {@code Space Complexity O(M * N)}
     * </p>
     * @param grid
     * @return the <b>maximum</b> number of fish the fisher can catch if he chooses his starting cell optimally, or {@code 0} if no water cell exists.
     */
    public static int findMaxFish(int[][] grid) {
        int rowCount = grid.length, columnCount = grid[0].length;
        int totalCells = rowCount * columnCount;

        // Initialize Union-Find structures
        int[] parent = new int[totalCells];
        int[] componentSize = new int[totalCells];
        int[] totalFish = new int[totalCells];

        for (int cellIndex = 0; cellIndex < totalCells; cellIndex++) {
            parent[cellIndex] = cellIndex; // Set initial parent for each cell
            componentSize[cellIndex] = 1; // Set initial size for each cell component
        }

        // Set initial fish count for each cell
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                int cellIndex = row * columnCount + column;
                totalFish[cellIndex] = grid[row][column];
            }
        }

        // Direction vectors for neighbors (right, left, down, up)
        int[] deltaRow = { 0, 0, 1, -1 }, deltaColumn = { 1, -1, 0, 0 };

        // Merge connected components
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                if (grid[row][column] > 0) { // Process only water cells with fish
                    int cellIndex = row * columnCount + column;
                    for (int direction = 0; direction < 4; direction++) {
                        int neighborRow = row + deltaRow[direction];
                        int neighborColumn = column + deltaColumn[direction];
                        if (
                                neighborRow >= 0 &&
                                        neighborRow < rowCount &&
                                        neighborColumn >= 0 &&
                                        neighborColumn < columnCount &&
                                        grid[neighborRow][neighborColumn] > 0
                        ) {
                            int neighborIndex =
                                    neighborRow * columnCount + neighborColumn;
                            unionComponents(
                                    parent,
                                    componentSize,
                                    totalFish,
                                    cellIndex,
                                    neighborIndex
                            );
                        }
                    }
                }
            }
        }

        // Find the maximum fish in any component
        int maxFish = 0;
        for (int cellIndex = 0; cellIndex < totalCells; cellIndex++) {
            if (findParent(parent, cellIndex) == cellIndex) { // Check if cellIndex is a root
                maxFish = Math.max(maxFish, totalFish[cellIndex]);
            }
        }
        return maxFish;
    }

    // Helper function to find the root of a component
    private static int findParent(int[] parent, int cellIndex) {
        if (parent[cellIndex] == cellIndex) {
            return cellIndex;
        }
        return parent[cellIndex] = findParent(parent, parent[cellIndex]); // Path compression
    }

    // Helper function to union two components
    private static void unionComponents(
            int[] parent,
            int[] componentSize,
            int[] totalFish,
            int cellIndex1,
            int cellIndex2
    ) {
        int root1 = findParent(parent, cellIndex1);
        int root2 = findParent(parent, cellIndex2);

        if (root1 != root2) {
            // Union by size to optimize tree height
            if (componentSize[root1] < componentSize[root2]) {
                int temp = root1;
                root1 = root2;
                root2 = temp;
            }
            parent[root2] = root1;
            componentSize[root1] += componentSize[root2];
            totalFish[root1] += totalFish[root2];

        }
    }
}