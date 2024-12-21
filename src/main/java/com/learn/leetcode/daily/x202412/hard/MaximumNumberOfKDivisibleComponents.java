package com.learn.leetcode.daily.x202412.hard;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-k-divisible-components/description/?envType=daily-question&envId=2024-12-21">Task</a>
 * <br><a href="https://leetcode.com/problems/maximum-number-of-k-divisible-components/solutions/6156598/maximum-number-of-k-divisible-components/?envType=daily-question&envId=2024-12-21">Explanation</a>
 * <ul>Topics
 * <li> {@code Tree, Depth-First Search}
 * </ul>
 * <ul>Hints
 * <li> {@code Root the tree at node 0.}
 * <li> {@code If a leaf node is not divisible by k, it must be in the same component as its parent node so we merge it with its parent node.}
 * <li> {@code If a leaf node is divisible by k, it will be in its own components so we separate it from its parent node.}
 * <li> {@code In each step, we either cut a leaf node down or merge a leaf node. The number of nodes on the tree reduces by one. Repeat this process until only one node is left.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= n <= 3 * 10^4}
 * <li> {@code edges.length == n - 1}
 * <li> {@code edges[i].length == 2}
 * <li> {@code 0 <= a-i, b-i < n}
 * <li> {@code values.length == n}
 * <li> {@code 0 <= values[i] <= 10^9}
 * <li> {@code 1 <= k <= 10^9}
 * <li> {@code Sum of values is divisible by k.}
 * <li> {@code The input is generated such that edges represents a valid tree.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 21.12.24 19:21
 */
public final class MaximumNumberOfKDivisibleComponents {

    /**
     * Approach 1: Depth-First-Search (DFS)
     * <p>
     * {@code Time Complexity O(N + M)}<br>
     * {@code Space Complexity O(N + M)}
     * </p>
     * @param n number of nodes of the <b>undirected tree</b>.
     * @param edges a 2D integer array edges of length {@code n - 1}, where {@code edges[i] = [a-i, b-i]} indicates that there is an edge between nodes {@code a-i} and {@code b-i} in the tree.
     * @param values a <b>0-indexed</b> integer array of length {@code n}, where {@code values[i]} is the value associated with the {@code i-th} node, and an integer {@code k}.
     * @param k divisor of the sum of array components.
     * @return the <b>maximum number of components</b> in any valid split.
     */
    public static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // Step 1: Create adjacency list from edges
        final List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adjList[node1].add(node2);
            adjList[node2].add(node1);
        }

        // Step 2: Initialize component count
        final int[] componentCount = new int[1]; // Use array to pass by reference

        // Step 3: Start DFS traversal from node 0
        dfs(0, -1, adjList, values, k, componentCount);

        // Step 4: Return the total number of components
        return componentCount[0];
    }

    private static int dfs(
            int currentNode,
            int parentNode,
            List<Integer>[] adjList,
            int[] nodeValues,
            int k,
            int[] componentCount) {
        // Step 1: Initialize sum for the current subtree
        int sum = 0;

        // Step 2: Traverse all neighbors
        for (int neighborNode : adjList[currentNode]) {
            if (neighborNode != parentNode) {
                // Recursive call to process the subtree rooted at the neighbor
                sum += dfs(
                        neighborNode,
                        currentNode,
                        adjList,
                        nodeValues,
                        k,
                        componentCount
                );
                sum %= k; // Ensure the sum stays within bounds
            }
        }

        // Step 3: Add the value of the current node to the sum
        sum += nodeValues[currentNode];
        sum %= k;

        // Step 4: Check if the sum is divisible by k
        if (sum == 0) {
            componentCount[0]++;
        }

        // Step 5: Return the computed sum for the current subtree
        return sum;
    }

    /**
     * Approach 2: Breadth-First Search (BFS)
     * <p>
     * {@code Time Complexity O(N + M)}<br>
     * {@code Space Complexity O(N + M)}
     * </p>
     * @param n number of nodes of the <b>undirected tree</b>.
     * @param edges a 2D integer array edges of length {@code n - 1}, where {@code edges[i] = [a-i, b-i]} indicates that there is an edge between nodes {@code a-i} and {@code b-i} in the tree.
     * @param values a <b>0-indexed</b> integer array of length {@code n}, where {@code values[i]} is the value associated with the {@code i-th} node, and an integer {@code k}.
     * @param k divisor of the sum of array components.
     * @return the <b>maximum number of components</b> in any valid split.
     */
    public static int maxKDivisibleComponents_BFS(int n, int[][] edges, int[] values, int k) {
        // Base case: if there are less than 2 nodes, return 1
        if (n < 2) {
            return 1;
        }

        int componentCount = 0;
        final Map<Integer, Set<Integer>> graph = new HashMap<>();

        // Step 1: Build the graph
        for (int[] edge : edges) {
            final int node1 = edge[0], node2 = edge[1];
            graph.computeIfAbsent(node1, key -> new HashSet<>()).add(node2);
            graph.computeIfAbsent(node2, key -> new HashSet<>()).add(node1);
        }

        // Convert values to long to prevent overflow
        final long[] longValues = new long[values.length];
        for (int i = 0; i < values.length; i++) {
            longValues[i] = values[i];
        }

        // Step 2: Initialize the BFS queue with leaf nodes (nodes with only one connection)
        final Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                queue.add(entry.getKey());
            }
        }

        // Step 3: Process nodes in BFS order
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            // Find the neighbor node
            int neighborNode = -1;
            if (
                    graph.get(currentNode) != null &&
                            !graph.get(currentNode).isEmpty()
            ) {
                neighborNode = graph.get(currentNode).iterator().next();
            }

            if (neighborNode >= 0) {
                // Remove the edge between current and neighbor
                graph.get(neighborNode).remove(currentNode);
                graph.get(currentNode).remove(neighborNode);
            }

            // Check divisibility of the current node's value
            if (longValues[currentNode] % k == 0) {
                componentCount++;
            } else if (neighborNode >= 0) {
                // Add current node's value to the neighbor
                longValues[neighborNode] += longValues[currentNode];
            }

            // If the neighbor becomes a leaf node, add it to the queue
            if (
                    neighborNode >= 0 &&
                            graph.get(neighborNode) != null &&
                            graph.get(neighborNode).size() == 1
            ) {
                queue.add(neighborNode);
            }
        }

        return componentCount;
    }

    /**
     * Approach 3: Topological Sort / Onion Sort
     * <p>
     * {@code Time Complexity O(N + M)}<br>
     * {@code Space Complexity O(N + M)}
     * </p>
     * @param n number of nodes of the <b>undirected tree</b>.
     * @param edges a 2D integer array edges of length {@code n - 1}, where {@code edges[i] = [a-i, b-i]} indicates that there is an edge between nodes {@code a-i} and {@code b-i} in the tree.
     * @param values a <b>0-indexed</b> integer array of length {@code n}, where {@code values[i]} is the value associated with the {@code i-th} node, and an integer {@code k}.
     * @param k divisor of the sum of array components.
     * @return the <b>maximum number of components</b> in any valid split.
     */
    public static int maxKDivisibleComponents_Topological_Sort__Onion_Sort(int n, int[][] edges, int[] values, int k) {
        if (n < 2) {
            return 1; // Handle the base case where the graph has fewer than 2 nodes.
        }

        int componentCount = 0;
        final List<List<Integer>> graph = new ArrayList<>();
        final int[] inDegree = new int[n];

        // Build the graph and calculate in-degrees
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>()); // Initialize the adjacency list for each node.
        }
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
            inDegree[node1]++;
            inDegree[node2]++;
        }

        // Convert values to long to prevent overflow
        final long[] longValues = new long[n];
        for (int i = 0; i < n; i++) {
            longValues[i] = values[i];
        }

        // Initialize the queue with nodes having in-degree of 1 (leaf nodes)
        final Queue<Integer> queue = new LinkedList<>();
        for (int node = 0; node < n; node++) {
            if (inDegree[node] == 1) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            final int currentNode = queue.poll();
            inDegree[currentNode]--;

            long addValue = 0;

            // Check if the current node's value is divisible by k
            if (longValues[currentNode] % k == 0) {
                componentCount++;
            } else {
                addValue = longValues[currentNode];
            }

            // Propagate the value to the neighbor nodes
            for (int neighborNode : graph.get(currentNode)) {
                if (inDegree[neighborNode] == 0) {
                    continue;
                }

                inDegree[neighborNode]--;
                longValues[neighborNode] += addValue;

                // If the neighbor node's in-degree becomes 1, add it to the queue
                if (inDegree[neighborNode] == 1) {
                    queue.offer(neighborNode);
                }
            }
        }

        return componentCount;
    }

}
