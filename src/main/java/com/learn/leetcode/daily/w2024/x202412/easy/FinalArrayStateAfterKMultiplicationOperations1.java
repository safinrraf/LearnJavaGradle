package com.learn.leetcode.daily.w2024.x202412.easy;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/description/?envType=daily-question&envId=2024-12-16">Task</a>
 * <br><a href="https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/solutions/6117755/final-array-state-after-k-multiplication-operations-i/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Math, Heap (Priority Queue), Simulation}
 * </ul>
 * <ul>Hints
 * <li> {@code Maintain sorted pairs (nums[index], index) in a priority queue.}
 * <li> {@code Simulate the operation k times.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums.length <= 100}
 * <li> {@code 1 <= nums[i] <= 100}
 * <li> {@code 1 <= k <= 10}
 * <li> {@code 1 <= multiplier <= 5}
 * </ul>
 * <br>@since 1.0.0
 * <br> 16.12.24 08:36
 */
public final class FinalArrayStateAfterKMultiplicationOperations1 {

    /**
     *
     * <p>
     * {@code Time Complexity O(N + k *logN)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param nums an integer array.
     * @param k number of operations.
     * @param multiplier multiplier.
     * @return an integer array denoting the final state of {@code nums} after performing all {@code k} operations.
     */
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        final PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            int valueComparison = Integer.compare(a[0], b[0]);
            if (valueComparison == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return valueComparison;
        });

        for (int i = 0; i < nums.length; i++) {
            heap.offer(new int[] { nums[i], i });
        }

        while (k-- > 0) {
            int[] smallest = heap.poll();
            int index = smallest[1];

            nums[index] *= multiplier;
            heap.offer(new int[] { nums[index], index });
        }

        return nums;
    }
}
