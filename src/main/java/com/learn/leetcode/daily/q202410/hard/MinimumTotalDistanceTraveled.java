package com.learn.leetcode.daily.q202410.hard;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/minimum-total-distance-traveled/description/?envType=daily-question&envId=2024-10-31">Task</a>
 * <br><a href="https://leetcode.com/problems/minimum-total-distance-traveled/solutions/5988185/beats-100-working-31-10-2024-explained-step-by-step-happy-halloween-night-shift/?envType=daily-question&envId=2024-10-31">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Dynamic Programming, Sorting}
 * </ul>
 * <ul>Hints
 * <li> {@code Sort robots and factories by their positions.}
 * <li> {@code After sorting, notice that each factory should repair some subsegment of robots.}
 * <li> {@code Find the minimum total distance to repair first i robots with first j factories.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= robot.length, factory.length <= 100}
 * <li> {@code factory[j].length == 2}
 * <li> {@code -10^9 <= robot[i], position j <= 10^9}
 * <li> {@code 0 <= limitj <= robot.length}
 * <li> {@code The input will be generated such that it is always possible to repair every robot.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 31.10.24 16:53
 */
public final class MinimumTotalDistanceTraveled {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // Sort robots and factories by position for optimal assignment
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        int m = robot.size();
        int n = factory.length;

        // dp[i][j] represents min total distance for robots[i:] using factories[j:]
        long[][] dp = new long[m + 1][n + 1];

        // Set last column to MAX_VALUE as boundary condition
        for (int i = 0; i < m; i++) {
            dp[i][n] = Long.MAX_VALUE;
        }

        // Process each factory from right to left
        for (int j = n - 1; j >= 0; j--) {
            // Track cumulative distance from current factory to robots
            long prefix = 0;
            // Use deque to maintain potential optimal assignments
            Deque<Pair<Integer, Long>> qq = new ArrayDeque<>();
            // Initialize with boundary condition
            qq.offer(new Pair<>(m, 0L));

            // Process each robot from right to left
            for (int i = m - 1; i >= 0; i--) {
                // Add distance from current robot to current factory
                prefix += Math.abs(robot.get(i) - factory[j][0]);

                // Remove assignments that exceed factory capacity
                while (!qq.isEmpty() && qq.peekFirst().getKey() > i + factory[j][1]) {
                    qq.pollFirst();
                }

                // Remove suboptimal assignments
                while (!qq.isEmpty() && qq.peekLast().getValue() >= dp[i][j + 1] - prefix) {
                    qq.pollLast();
                }

                // Add current state to deque
                qq.offerLast(new Pair<>(i, dp[i][j + 1] - prefix));
                // Update dp with optimal assignment
                dp[i][j] = qq.peekFirst().getValue() + prefix;
            }
        }

        // Return minimum total distance for all robots
        return dp[0][0];
    }

    // Helper class to store key-value pairs
    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
