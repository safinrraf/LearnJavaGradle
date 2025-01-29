package com.learn.leetcode.daily.a202501.medium;

/**
 * <a href="https://leetcode.com/problems/redundant-connection/description/?envType=daily-question&envId=2025-01-29">Task</a>
 * <br><a href="https://leetcode.com/problems/redundant-connection/editorial/?envType=daily-question&envId=2025-01-29">Explanation</a>
 * <ul>Topics
 * <li> {@code Depth-First Search, Breadth-First Search, Union Find, Graph}
 * </ul>
 * <ul>Hints
 * <li> {@code ...}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code n == edges.length}
 * <li> {@code 3 <= n <= 1000}
 * <li> {@code edges[i].length == 2}
 * <li> {@code 1 <= a-i < b-i <= edges.length}
 * <li> {@code a-i != b-i}
 * <li> {@code There are no repeated edges.}
 * <li> {@code The given graph is connected.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 29.01.25 08:24
 */
public final class RedundantConnection {

    /**
     * Approach 3: Disjoint Set Union (DSU)
     * <p>
     * {@code Time Complexity O(...)}<br>
     * {@code Space Complexity O(...)}
     * </p>
     * @param edges
     * @return an edge that can be removed so that the resulting graph is a tree of {@code n} nodes. If there are multiple answers, return the answer that occurs last in the input.
     */
    public static int[] findRedundantConnection(int[][] edges) {
        final int N = edges.length;

        final DSU dsu = new DSU(N);
        for (int[] edge : edges) {
            // If union returns false, we know the nodes are already connected
            // and hence we can return this edge.
            if (!dsu.doUnion(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
        }

        return new int[] {}; // This line should theoretically never be reached
    }

    private static class DSU {

        private final int[] size;
        private final int[] representative;

        // Initialize DSU class, size of each component will be one and each node
        // will be representative of its own.
        public DSU(int N) {
            size = new int[N];
            representative = new int[N];

            for (int node = 0; node < N; node++) {
                size[node] = 1;
                representative[node] = node;
            }
        }

        // Returns the ultimate representative of the node.
        public int find(int node) {
            if (representative[node] == node) {
                return node;
            }

            return representative[node] = find(representative[node]);
        }

        // Returns true if node nodeOne and nodeTwo belong to different component and update the
        // representatives accordingly, otherwise returns false.
        public boolean doUnion(int nodeOne, int nodeTwo) {
            nodeOne = find(nodeOne);
            nodeTwo = find(nodeTwo);

            if (nodeOne == nodeTwo) {
                return false;
            } else {
                if (size[nodeOne] > size[nodeTwo]) {
                    representative[nodeTwo] = nodeOne;
                    size[nodeOne] += size[nodeTwo];
                } else {
                    representative[nodeOne] = nodeTwo;
                    size[nodeTwo] += size[nodeOne];
                }
                return true;
            }
        }
    }
}
