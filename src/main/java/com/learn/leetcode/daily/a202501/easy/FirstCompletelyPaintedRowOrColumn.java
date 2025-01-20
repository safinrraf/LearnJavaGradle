package com.learn.leetcode.daily.a202501.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/first-completely-painted-row-or-column/description/?envType=daily-question&envId=2025-01-20">Task</a>
 * <br><a href="https://leetcode.com/problems/first-completely-painted-row-or-column/editorial/?envType=daily-question&envId=2025-01-20">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Hash Table, Matrix}
 * </ul>
 * <ul>Hints
 * <li> {@code Can we use a frequency array?}
 * <li> {@code Pre-process the positions of the values in the matrix.}
 * <li> {@code Traverse the array and increment the corresponding row and column frequency using the pre-processed positions.}
 * <li> {@code If the row frequency becomes equal to the number of columns, or vice-versa return the current index.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code m == mat.length}
 * <li> {@code n = mat[i].length}
 * <li> {@code arr.length == m * n}
 * <li> {@code 1 <= m, n <= 10^5}
 * <li> {@code 1 <= m * n <= 10^5}
 * <li> {@code 1 <= arr[i], mat[r][c] <= m * n}
 * <li> {@code All the integers of arr are unique.}
 * <li> {@code All the integers of mat are unique.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 20.01.25 08:24
 */
public final class FirstCompletelyPaintedRowOrColumn {

    /**
     * Approach 3: Reverse Mapping
     * <p>
     * {@code Time Complexity O(M * N)}<br>
     * {@code Space Complexity O(M * N)}
     * </p>
     * @param arr
     * @param mat
     * @return the smallest index {@code i} at which either a row or a column will be completely painted in {@code mat}.
     */
    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        // Map to store the index of each number in the arr
        final Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            numToIndex.put(arr[i], i);
        }

        int result = Integer.MAX_VALUE;
        final int numCols = mat[0].length;

        // Check for the earliest row to be completely painted
        for (final int[] value : mat) {
            // Tracks the greatest index in this row
            int lastElementIndex = Integer.MIN_VALUE;
            for (int col = 0; col < numCols; col++) {
                final int indexVal = numToIndex.get(value[col]);
                lastElementIndex = Math.max(lastElementIndex, indexVal);
            }
            // Update result with the minimum index where this row is fully painted
            result = Math.min(result, lastElementIndex);
        }

        // Check for the earliest column to be completely painted
        for (int col = 0; col < numCols; col++) {
            int lastElementIndex = Integer.MIN_VALUE;
            for (final int[] ints : mat) {
                final int indexVal = numToIndex.get(ints[col]);
                lastElementIndex = Math.max(lastElementIndex, indexVal);
            }
            // Update result with the minimum index where this column is fully painted
            result = Math.min(result, lastElementIndex);
        }

        return result;
    }
}
