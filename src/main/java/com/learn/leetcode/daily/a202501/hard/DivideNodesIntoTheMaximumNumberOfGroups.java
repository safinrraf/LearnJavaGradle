package com.learn.leetcode.daily.a202501.hard;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/description/?envType=daily-question&envId=2025-01-30">Task</a>
 * <br><a href="https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/editorial/?envType=daily-question&envId=2025-01-30">Explanation</a>
 * <ul>Topics
 * <li> {@code Breadth-First Search, Union Find, Graph}
 * </ul>
 * <ul>Hints
 * <li> {@code If the graph is not bipartite, it is not possible to group the nodes.}
 * <li> {@code Notice that we can solve the problem for each connected component independently, and the final answer will be just the sum of the maximum number of groups in each component.}
 * <li> {@code Finally, to solve the problem for each connected component, we can notice that if for some node v we fix its position to be in the leftmost group, then we can also evaluate the position of every other node. That position is the depth of the node in a bfs tree after rooting at node v.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= n <= 500}
 * <li> {@code 1 <= edges.length <= 10^4}
 * <li> {@code edges[i].length == 2}
 * <li> {@code 1 <= a-i, b-i <= n}
 * <li> {@code a-i != b-i}
 * <li> {@code There is at most one edge between any pair of vertices.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 30.01.25 08:37
 */
public final class DivideNodesIntoTheMaximumNumberOfGroups {

    /**
     * Approach 2: BFS + Union-Find.
     * <p>
     * {@code Time Complexity O(N * (N + M))}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param n a positive integer represents the number of nodes in an undirected graph.
     * @param edges a 2D integer array, where {@code edges[i] = [a-i, b-i]} indicates that there is a bidirectional edge between nodes {@code a-i} and {@code b-i}. Notice that the given graph may be disconnected.
     * @return the maximum number of groups (i.e., maximum {@code m}) into which you can divide the nodes. Return {@code -1} if it is impossible to group the nodes with the given conditions.
     */
    public static int magnificentSets(int n, int[][] edges) {
        final List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        final int[] parent = new int[n];
        final int[] depth = new int[n];
        Arrays.fill(parent, -1);

        // Build the adjacency list and apply Union-Find for each edge
        for (int[] edge : edges) {
            adjList.get(edge[0] - 1).add(edge[1] - 1);
            adjList.get(edge[1] - 1).add(edge[0] - 1);
            union(edge[0] - 1, edge[1] - 1, parent, depth);
        }

        final Map<Integer, Integer> numOfGroupsForComponent = new HashMap<>();

        // For each node, calculate the maximum number of groups for its component
        for (int node = 0; node < n; node++) {
            final int numberOfGroups = getNumberOfGroups(adjList, node, n);
            if (numberOfGroups == -1) {
                return -1; // If invalid split, return -1
            }
            final int rootNode = find(node, parent);
            numOfGroupsForComponent.put(
                    rootNode,
                    Math.max(
                            numOfGroupsForComponent.getOrDefault(rootNode, 0),
                            numberOfGroups
                    )
            );
        }

        // Calculate the total number of groups across all components
        int totalNumberOfGroups = 0;
        for (int numberOfGroups : numOfGroupsForComponent.values()) {
            totalNumberOfGroups += numberOfGroups;
        }
        return totalNumberOfGroups;
    }

    // Function to calculate the number of groups for a given component starting from srcNode
    private static int getNumberOfGroups(
            List<List<Integer>> adjList,
            int srcNode,
            int n
    ) {
        final Queue<Integer> nodesQueue = new LinkedList<>();
        final int[] layerSeen = new int[n];
        Arrays.fill(layerSeen, -1);
        nodesQueue.offer(srcNode);
        layerSeen[srcNode] = 0;
        int deepestLayer = 0;

        // Perform BFS to calculate the number of layers (groups)
        while (!nodesQueue.isEmpty()) {
            int numOfNodesInLayer = nodesQueue.size();
            for (int i = 0; i < numOfNodesInLayer; i++) {
                int currentNode = nodesQueue.poll();
                for (int neighbor : adjList.get(currentNode)) {
                    // If neighbor hasn't been visited, assign it to the next layer
                    if (layerSeen[neighbor] == -1) {
                        layerSeen[neighbor] = deepestLayer + 1;
                        nodesQueue.offer(neighbor);
                    } else {
                        // If the neighbor is already in the same layer, return -1 (invalid partition)
                        if (layerSeen[neighbor] == deepestLayer) {
                            return -1;
                        }
                    }
                }
            }
            deepestLayer++;
        }
        return deepestLayer;
    }

    // Find the root of the given node in the Union-Find structure
    private static int find(int node, int[] parent) {
        while (parent[node] != -1) {
            node = parent[node];
        }
        return node;
    }

    // Union operation to merge two sets
    private static void union(int node1, int node2, int[] parent, int[] depth) {
        node1 = find(node1, parent);
        node2 = find(node2, parent);

        // If both nodes already belong to the same set, no action needed
        if (node1 == node2) {
            return;
        }

        // Union by rank (depth) to keep the tree balanced
        if (depth[node1] < depth[node2]) {
            final int temp = node1;
            node1 = node2;
            node2 = temp;
        }
        parent[node2] = node1;

        // If the depths are equal, increment the depth of the new root
        if (depth[node1] == depth[node2]) {
            depth[node1]++;
        }
    }
}
