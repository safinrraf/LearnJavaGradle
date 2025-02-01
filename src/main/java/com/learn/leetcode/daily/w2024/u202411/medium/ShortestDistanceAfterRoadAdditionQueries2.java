package com.learn.leetcode.daily.w2024.u202411.medium;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/description/?envType=daily-question&envId=2024-11-27">Task</a>
 * <br><a href="https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/solutions/6087071/video-beats-100-explained-step-by-step/?envType=daily-question&envId=2024-11-27">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Breadth-First Search, Graph, Dijkstra}
 * </ul>
 * <ul>Hints
 * <li> {@code Maintain the graph and use an efficient shortest path algorithm after each update.}
 * <li> {@code We use BFS/Dijkstra for each query.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 3 <= n <= 500}
 * <li> {@code 1 <= queries.length <= 500}
 * <li> {@code queries[i].length == 2}
 * <li> {@code 0 <= queries[i][0] < queries[i][1] < n}
 * <li> {@code 1 < queries[i][1] - queries[i][0]}
 * <li> {@code There are no repeated roads among the queries.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 27.11.24 08:17
 */
public final class ShortestDistanceAfterRoadAdditionQueries2 {

    /**
     *
     * @param n the number of cities numbered from {@code 0} to {@code n - 1}.
     * @param queries a 2D integer array.
     * @return an array {@code answer} where for each {@code i} in the range {@code [0, queries.length - 1]}, {@code answer[i]} is the length of the shortest path from city {@code 0} to city {@code n - 1} after processing the first {@code i + 1} queries.
     */
    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            adj.get(i).add(i + 1);
        }

        List<Integer> resList = new ArrayList<>();
        for (int[] query : queries) {
            adj.get(query[0]).add(query[1]);
            resList.add(shortestPath(adj, n));
        }

        return resList.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int shortestPath(List<List<Integer>> adj, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0}); // node, length
        Set<Integer> visit = new HashSet<>();
        visit.add(0);

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cur = curr[0];
            int length = curr[1];

            if (cur == n - 1) return length;

            for (int nei : adj.get(cur)) {
                if (!visit.contains(nei)) {
                    q.offer(new int[]{nei, length + 1});
                    visit.add(nei);
                }
            }
        }
        return -1;
    }
}
