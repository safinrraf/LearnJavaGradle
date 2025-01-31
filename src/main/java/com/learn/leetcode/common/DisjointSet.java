package com.learn.leetcode.common;

/**
 * <a href="">Task</a>
 * <br><a href="https://leetcode.com/problems/making-a-large-island/editorial/?envType=daily-question&envId=2025-01-31">Explanation</a>
 * <ul>Topics
 * <li> {@code ..., ..., ...}
 * </ul>
 * <ul>Hints
 * <li> {@code ...}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 ...}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 31.01.25 08:33
 */
public final class DisjointSet {
    public int[] parent;
    public int[] islandSize;

    // Constructor to initialize DSU with `n` elements
    public DisjointSet(int n) {
        parent = new int[n];
        islandSize = new int[n];
        for (int node = 0; node < n; node++) {
            // Each node is its own parent initially with size 1
            parent[node] = node;
            islandSize[node] = 1;
        }
    }

    // Function to find the root of a node with path compression
    public int findRoot(int node) {
        if (parent[node] == node) return node;
        return parent[node] = findRoot(parent[node]); // Path compression
    }

    // Function to union two sets based on size
    public void unionNodes(int nodeA, int nodeB) {
        int rootA = findRoot(nodeA);
        int rootB = findRoot(nodeB);

        // Already in the same set
        if (rootA == rootB) return;

        // Union by size: Attach the smaller island to the larger one
        if (islandSize[rootA] < islandSize[rootB]) {
            // Attach rootA to rootB
            parent[rootA] = rootB;
            // Update size of rootB's island
            islandSize[rootB] += islandSize[rootA];
        } else {
            // Attach rootB to rootA
            parent[rootB] = rootA;
            // Update size of rootA's island
            islandSize[rootA] += islandSize[rootB];
        }
    }
}
