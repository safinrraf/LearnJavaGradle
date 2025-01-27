package com.learn.leetcode.daily.a202501.medium;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/course-schedule-iv/description/?envType=daily-question&envId=2025-01-27">Task</a>
 * <br><a href="https://leetcode.com/problems/course-schedule-iv/editorial/?envType=daily-question&envId=2025-01-27">Explanation</a>
 * <ul>Topics
 * <li> {@code Depth-First Search, Breadth-First Search, Graph, Topological Sort}
 * </ul>
 * <ul>Hints
 * <li> {@code Imagine if the courses are nodes of a graph. We need to build an array isReachable[i][j].}
 * <li> {@code Start a bfs from each course i and assign for each course j you visit isReachable[i][j] = True.}
 * <li> {@code Answer the queries from the isReachable array.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 2 <= numCourses <= 100}
 * <li> {@code 0 <= prerequisites.length <= (numCourses * (numCourses - 1) / 2)}
 * <li> {@code prerequisites[i].length == 2}
 * <li> {@code 0 <= a-i, b-i <= numCourses - 1}
 * <li> {@code a-i != b-i}
 * <li> {@code All the pairs [a-i, b-i] are unique.}
 * <li> {@code The prerequisites graph has no cycles.}
 * <li> {@code 1 <= queries.length <= 10^4}
 * <li> {@code 1 <= queries.length <= 10^4}
 * <li> {@code 0 <= u-i, v-i <= numCourses - 1}
 * <li> {@code u-i != v-i}
 * </ul>
 * <br>@since 1.0.0
 * <br> 27.01.25 08:27
 */
public final class CourseSchedule4 {

    /**
     * Approach 3: Topological Sort - Kahn's Algorithm.
     * <p>
     * {@code Time Complexity O(N^3 + Q)}<br>
     * {@code Space Complexity O(N^2)}
     * </p>
     * @param numCourses
     * @param prerequisites
     * @param queries
     * @return a boolean array {@code answer}, where {@code answer[j]} is the answer to the {@code j-th} query.
     */
    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        final Map<Integer, List<Integer>> adjList = new HashMap<>();
        final int[] indegree = new int[numCourses];

        for (int[] edge : prerequisites) {
            adjList
                    .computeIfAbsent(edge[0], k -> new ArrayList<>())
                    .add(edge[1]);
            indegree[edge[1]]++;
        }

        final Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // Map from the node as key to the set of prerequisite nodes.
        final Map<Integer, Set<Integer>> nodePrerequisites = new HashMap<>();

        while (!q.isEmpty()) {
            final int node = q.poll();

            for (int adj : adjList.getOrDefault(node, new ArrayList<>())) {
                // Add node and prerequisites of the node to the prerequisites of adj
                nodePrerequisites
                        .computeIfAbsent(adj, k -> new HashSet<>())
                        .add(node);
                for (int prereq : nodePrerequisites.getOrDefault(
                        node,
                        new HashSet<>()
                )) {
                    nodePrerequisites.get(adj).add(prereq);
                }

                indegree[adj]--;
                if (indegree[adj] == 0) {
                    q.offer(adj);
                }
            }
        }

        final List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            answer.add(
                    nodePrerequisites
                            .getOrDefault(query[1], new HashSet<>())
                            .contains(query[0])
            );
        }

        return answer;
    }
}
