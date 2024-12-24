package com.learn.leetcode.daily.x202412.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/description/?envType=daily-question&envId=2024-12-24">Task</a>
 * <br><a href="https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/solutions/6156821/find-minimum-diameter-after-merging-two-trees/?envType=daily-question&envId=2024-12-24">Explanation</a>
 * <ul>Topics
 * <li> {@code Tree, Depth-First Search, Breadth-First Search, Graph}
 * </ul>
 * <ul>Hints
 * <li> Suppose that we connected node a in tree1 with node b in tree2. The diameter length of the resulting tree will be the largest of the following 3 values:
 * <ul>
 * <li>The diameter of tree 1.
 * <li>The diameter of tree 2.
 * <li>The length of the longest path that starts at node a and that is completely within Tree 1 + The length of the longest path that starts at node b and that is completely within Tree 2 + 1.
 * </ul>
 * <br><p>The added one in the third value is due to the additional edge that we have added between trees 1 and 2.</p>
 *
 * <li> {@code Values 1 and 2 are constant regardless of our choice of a and b. Therefore, we need to pick a and b in such a way that minimizes value 3.}
 * <li> {@code If we pick a and b optimally, they will be in the diameters of Tree 1 and Tree 2, respectively. Exactly which nodes of the diameter should we pick?}
 * <li> {@code a is the center of the diameter of tree 1, and b is the center of the diameter of tree 2.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= n, m <= 10^5}
 * <li> {@code edges1.length == n - 1}
 * <li> {@code edges2.length == m - 1}
 * <li> {@code edges2.length == m - 1}
 * <li> {@code edges1[i].length == edges2[i].length == 2}
 * <li> {@code edges1[i] = [a-i, b-i]}
 * <li> {@code 0 <= a-i, b-i < n}
 * <li> {@code edges2[i] = [u-i, v-i]}
 * <li> {@code 0 <= u-i, v-i < m}
 * <li> {@code The input is generated such that edges1 and edges2 represent valid trees.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 24.12.24 15:06
 */
public final class FindMinimumDiameterAfterMergingTwoTrees_DepthFirstSearch {

    /**
     * Approach 2: Depth First Search
     * <p>The <b>diameter</b> of a tree is the length of the longest path between any two nodes in the tree.</p>
     * <p>
     * {@code Time Complexity O(N + M)}<br>
     * {@code Space Complexity O(N + M)}
     * </p>
     * @param edges1
     * @param edges2
     * @return the <b>minimum</b> possible <b>diameter</b> of the resulting tree.
     */
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        // Calculate the number of nodes for each tree (number of edges + 1)
        final int n = edges1.length + 1;
        final int m = edges2.length + 1;

        // Build adjacency lists for both trees
        final List<List<Integer>> adjList1 = buildAdjList(n, edges1);
        final List<List<Integer>> adjList2 = buildAdjList(m, edges2);

        // Calculate the diameter of both trees
        final int diameter1 = findDiameter(adjList1, 0, -1).getFirst(); // Start DFS for Tree 1
        final int diameter2 = findDiameter(adjList2, 0, -1).getFirst(); // Start DFS for Tree 2

        // Calculate the diameter of the combined tree
        int combinedDiameter =
                (int) Math.ceil(diameter1 / 2.0) +
                        (int) Math.ceil(diameter2 / 2.0) +
                        1;

        // Return the maximum diameter among the two trees and the combined tree
        return Math.max(Math.max(diameter1, diameter2), combinedDiameter);
    }

    // Helper function to build an adjacency list from an edge list
    private List<List<Integer>> buildAdjList(int size, int[][] edges) {
        final List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return adjList;
    }

    // Helper function to find the diameter of a tree
    // Returns the diameter and the depth of the node's subtree
    private Pair findDiameter(
            List<List<Integer>> adjList,
            int node,
            int parent
    ) {
        int maxDepth1 = 0, maxDepth2 = 0; // Tracks the two largest depths from the current node
        int diameter = 0; // Tracks the diameter of the subtree

        for (int neighbor : adjList.get(node)) {
            if (neighbor == parent) continue; // Skip the parent to avoid cycles

            // Recursively calculate the diameter and depth of the neighbor's subtree
            final Pair result = findDiameter(adjList, neighbor, node);
            final int childDiameter = result.getFirst();
            final int depth = result.getSecond() + 1; // Increment depth to include edge to neighbor

            // Update the maximum diameter of the subtree
            diameter = Math.max(diameter, childDiameter);

            // Update the two largest depths from the current node
            if (depth > maxDepth1) {
                maxDepth2 = maxDepth1;
                maxDepth1 = depth;
            } else if (depth > maxDepth2) {
                maxDepth2 = depth;
            }
        }

        // Update the diameter to include the path through the current node
        diameter = Math.max(diameter, maxDepth1 + maxDepth2);

        // Return the diameter and the longest depth
        return new Pair(diameter, maxDepth1);
    }

    // Simple Pair class for storing results of the findDiameter function
    class Pair {

        private int first;
        private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }
}
