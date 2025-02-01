package com.learn.leetcode.daily.w2024.u202411.hard;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/valid-arrangement-of-pairs/description/?envType=daily-question&envId=2024-11-30">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Depth-First Search, Graph, Eulerian Circuit, Hierholzer’s algorithm, Fleury's Algorithm}
 * </ul>
 * <ul>Hints
 * <li> {@code Could you convert this into a graph problem?}
 * <li> {@code Consider the pairs as edges and each number as a node.}
 * <li> {@code We have to find an Eulerian path of this graph. Hierholzer’s algorithm can be used.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= pairs.length <= 10^5}
 * <li> {@code pairs[i].length == 2}
 * <li> {@code 0 <= starti, endi <= 10^9}
 * <li> {@code start-i != end-i}
 * <li> {@code No two pairs are exactly the same.}
 * <li> {@code There exists a valid arrangement of pairs.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 30.11.24 16:30
 */
@Slf4j
public final class ValidArrangementOfPairs {

    public static class MyPair {
        int start;
        int end;

        public MyPair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * <p>Steps to Solve</p>
     * <li> Build a graph where nodes are {@code start} and {@code end} values, and edges are given by {@code pairs}.
     * <li> Compute the in-degree and out-degree of each node to identify the starting node (where {@code out−degree} > {@code in−degree}).
     * <li> Perform a hierarchical DFS to construct the Eulerian Path and reverse it to get the correct order of pairs.
     *
     * @param pairs a 0-indexed 2D integer array pairs where {@code pairs[i] = [start-i, end-i]}.
     * @return any valid arrangement of {@code pairs}.
     */
    public static int[][] validArrangement(int[][] pairs) {
        // Step 1: Build the graph
        final Map<Integer, Stack<Integer>> graph = new HashMap<>();
        final Map<Integer, Integer> inDegree = new HashMap<>();
        final Map<Integer, Integer> outDegree = new HashMap<>();

        for (int[] pair : pairs) {
            final int start = pair[0];
            final int end = pair[1];
            graph.putIfAbsent(start, new Stack<>());
            graph.putIfAbsent(end, new Stack<>());
            graph.get(start).push(end);

            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        // Step 2: Find the starting node
        int startNode = pairs[0][0]; // Default starting point
        for (int node : graph.keySet()) {
            if (outDegree.getOrDefault(node, 0) > inDegree.getOrDefault(node, 0)) {
                startNode = node;
                break;
            }
        }

        // Step 3: Perform Eulerian Path traversal
        final LinkedList<MyPair> result = new LinkedList<>();
        dfs(graph, startNode, result);

        // Convert list to 2D array
        final int[][] output = new int[pairs.length][2];
        int index = 0;
        for (final var pair : result) {
            output[index++] = new int[]{pair.start, pair.end};
        }

        return output;
    }

    private static void dfs(Map<Integer, Stack<Integer>> graph, int node, LinkedList<MyPair> result) {
        final Stack<Integer> neighbors = graph.get(node);
        while (neighbors != null && !neighbors.isEmpty()) {
            final int next = neighbors.pop();
            dfs(graph, next, result);
            result.addFirst(new MyPair(node, next)); // Add pair in reverse order
        }
    }
}
