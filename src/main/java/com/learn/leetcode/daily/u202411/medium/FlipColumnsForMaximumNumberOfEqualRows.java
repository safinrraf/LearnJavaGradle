package com.learn.leetcode.daily.u202411.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/?envType=daily-question&envId=2024-11-22">Task</a>
 * <br><a href="https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/solutions/6070318/beats-100-video-full-explain-simple-short/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Hash Table, Matrix}
 * </ul>
 * <ul>Hints
 * <li> {@code Flipping a subset of columns is like doing a bitwise XOR of some number K onto each row. We want rows X with X ^ K = all 0s or all 1s. This is the same as X = X^K ^K = (all 0s or all 1s) ^ K, so we want to count rows that have opposite bits set. For example, if K = 1, then we count rows X = (00000...001, or 1111....110).}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code m == matrix.length}
 * <li> {@code n == matrix[i].length}
 * <li> {@code 1 <= m, n <= 300}
 * <li> {@code matrix[i][j] is either 0 or 1.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 22.11.24 08:23
 */
public final class FlipColumnsForMaximumNumberOfEqualRows {

    /**
     * {@code Time Complexity O(...)}
     * {@code Space Complexity O(...)}
     *
     * @param matrix
     * @return
     */
    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patFreq = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            if (row[0] == 0) {
                for (int bit : row) pattern.append(bit);
            } else {
                for (int bit : row) pattern.append(bit ^ 1);
            }
            patFreq.merge(pattern.toString(), 1, Integer::sum);
        }

        return Collections.max(patFreq.values());
    }
}
