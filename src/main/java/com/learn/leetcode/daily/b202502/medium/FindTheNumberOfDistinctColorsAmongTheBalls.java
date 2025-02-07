package com.learn.leetcode.daily.b202502.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/description/?envType=daily-question&envId=2025-02-07">Task</a>
 * <br><a href="https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/editorial/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Hash Table, Simulation}
 * </ul>
 * <ul>Hints
 * <li> {@code Use two HashMaps to maintain the color of each ball and the set of balls with each color.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= limit <= 10^9}
 * <li> {@code 1 <= n == queries.length <= 10^5}
 * <li> {@code queries[i].length == 2}
 * <li> {@code 0 <= queries[i][0] <= limit}
 * <li> {@code 1 <= queries[i][1] <= 10^9}
 * </ul>
 * <br>@since 1.0.0
 * <br> 07.02.25 08:26
 */
public final class FindTheNumberOfDistinctColorsAmongTheBalls {

    /**
     * Approach 2: Two Hash Maps.
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param limit
     * @param queries
     * @return an array {@code result} of length {@code n}, where {@code result[i]} denotes the number of distinct colors after {@code i-th} query.
     */
    public static int[] queryResults(int limit, int[][] queries) {
        final int N = queries.length;
        final int[] result = new int[N];
        final Map<Integer, Integer> colorMap = new HashMap<>();
        final Map<Integer, Integer> ballMap = new HashMap<>();

        // Iterate through queries
        for (int i = 0; i < N; i++) {
            // Extract ball label and color from query
            final int ball = queries[i][0];
            final int color = queries[i][1];

            // Check if ball is already colored
            if (ballMap.containsKey(ball)) {
                // Decrement count of the previous color on the ball
                int prevColor = ballMap.get(ball);
                colorMap.put(prevColor, colorMap.get(prevColor) - 1);

                // If there are no balls with previous color left, remove color from color map
                if (colorMap.get(prevColor) == 0) {
                    colorMap.remove(prevColor);
                }
            }
            // Set color of ball to the new color
            ballMap.put(ball, color);

            // Increment the count of the new color
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);

            result[i] = colorMap.size();
        }
        return result;
    }
}
