package com.learn.leetcode.daily.a202501.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting/description/?envType=daily-question&envId=2025-01-26">Task</a>
 * <br><a href="https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting/editorial/?envType=daily-question&envId=2025-01-26">Explanation</a>
 * <ul>Topics
 * <li> {@code Depth-First Search, Graph, Topological Sort}
 * </ul>
 * <ul>Hints
 * <li> {@code From the given array favorite, create a graph where for every index i, there is a directed edge from favorite[i] to i. The graph will be a combination of cycles and chains of acyclic edges. Now, what are the ways in which we can choose employees to sit at the table?}
 * <li> {@code The first way by which we can choose employees is by selecting a cycle of the graph. It can be proven that in this case, the employees that do not lie in the cycle can never be seated at the table (unless the cycle has a length of 2).}
 * <li> {@code The second way is by combining acyclic chains. At most two chains can be combined by a cycle of length 2, where each chain ends on one of the employees in the cycle.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code n == favorite.length}
 * <li> {@code 2 <= n <= 10^5}
 * <li> {@code 0 <= favorite[i] <= n - 1}
 * <li> {@code favorite[i] != i}
 * </ul>
 * <br>@since 1.0.0
 * <br> 26.01.25 19:44
 */
public final class MaximumEmployeesToBeInvitedToMeeting {

    /**
     * Approach 2: Topological Sort to Reduce Non-Cyclic Nodes
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param favorite
     * @return the <b>maximum number of employees</b> that can be invited to the meeting.
     */
    public static int maximumInvitations(int[] favorite) {
        final int n = favorite.length;
        final int[] inDegree = new int[n];

        // Calculate in-degree for each node
        for (int i : favorite) {
            inDegree[i]++;
        }

        // Topological sorting to remove non-cycle nodes
        final Queue<Integer> q = new LinkedList<>();
        for (int person = 0; person < n; ++person) {
            if (inDegree[person] == 0) {
                q.offer(person);
            }
        }

        final int[] depth = new int[n]; // Depth of each node
        Arrays.fill(depth, 1);

        while (!q.isEmpty()) {
            final int currentNode = q.poll();
            final int nextNode = favorite[currentNode];
            depth[nextNode] = Math.max(depth[nextNode], depth[currentNode] + 1);
            if (--inDegree[nextNode] == 0) {
                q.offer(nextNode);
            }
        }

        int longestCycle = 0;
        int twoCycleInvitations = 0;

        // Detect cycles
        for (int person = 0; person < n; ++person) {
            if (inDegree[person] == 0) {
                continue; // Already processed
            }

            int cycleLength = 0;
            int current = person;
            while (inDegree[current] != 0) {
                inDegree[current] = 0; // Mark as visited
                cycleLength++;
                current = favorite[current];
            }

            if (cycleLength == 2) {
                // For 2-cycles, add the depth of both nodes
                twoCycleInvitations += depth[person] + depth[favorite[person]];
            } else {
                longestCycle = Math.max(longestCycle, cycleLength);
            }
        }

        return Math.max(longestCycle, twoCycleInvitations);
    }
}
