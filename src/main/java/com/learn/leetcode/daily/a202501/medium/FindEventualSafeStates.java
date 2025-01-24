package com.learn.leetcode.daily.a202501.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/find-eventual-safe-states/description/?envType=daily-question&envId=2025-01-24">Task</a>
 * <br><a href="https://leetcode.com/problems/find-eventual-safe-states/editorial/?envType=daily-question&envId=2025-01-24">Explanation</a>
 * <ul>Topics
 * <li> {@code Depth-First Search, Breadth-First Search, Graph, Topological Sort}
 * </ul>
 * <ul>Hints
 * <li> {@code ...}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code n == graph.length}
 * <li> {@code 1 <= n <= 10^4}
 * <li> {@code 0 <= graph[i].length <= n}
 * <li> {@code 0 <= graph[i][j] <= n - 1}
 * <li> {@code graph[i] is sorted in a strictly increasing order.}
 * <li> {@code The graph may contain self-loops.}
 * <li> {@code The number of edges in the graph will be in the range [1, 4 * 10^4].}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 24.01.25 08:18
 */
public final class FindEventualSafeStates {

    /**
     * Approach 1: Topological Sort Using Kahn's Algorithm
     * <p>
     * {@code Time Complexity O(M + N)}<br>
     * {@code Space Complexity O(M + N)}
     * </p>
     * @param graph
     * @return an array containing all the <b>safe nodes</b> of the graph. The answer should be sorted in <b>ascending</b> order.
     */
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        final int n = graph.length;
        final int[] indegree = new int[n];
        final List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int node : graph[i]) {
                adj.get(node).add(i);
                indegree[i]++;
            }
        }

        final Queue<Integer> q = new LinkedList<>();
        // Push all the nodes with indegree zero in the queue.
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        final boolean[] safe = new boolean[n];
        while (!q.isEmpty()) {
            final int node = q.poll();
            safe[node] = true;

            for (int neighbor : adj.get(node)) {
                // Delete the edge "node -> neighbor".
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        final List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    /**
     * Approach 2: Depth First Search
     * <p>
     * {@code Time Complexity O(M + N)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param graph
     * @return an array containing all the <b>safe nodes</b> of the graph. The answer should be sorted in <b>ascending</b> order.
     */
    public static List<Integer> eventualSafeNodes_DFS(int[][] graph) {
        final int n = graph.length;
        final boolean[] visit = new boolean[n];
        final boolean[] inStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            dfs(i, graph, visit, inStack);
        }

        final List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!inStack[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    public static boolean dfs(
            int node,
            int[][] adj,
            boolean[] visit,
            boolean[] inStack
    ) {
        // If the node is already in the stack, we have a cycle.
        if (inStack[node]) {
            return true;
        }
        if (visit[node]) {
            return false;
        }
        // Mark the current node as visited and part of current recursion stack.
        visit[node] = true;
        inStack[node] = true;
        for (int neighbor : adj[node]) {
            if (dfs(neighbor, adj, visit, inStack)) {
                return true;
            }
        }
        // Remove the node from the stack.
        inStack[node] = false;
        return false;
    }
}
