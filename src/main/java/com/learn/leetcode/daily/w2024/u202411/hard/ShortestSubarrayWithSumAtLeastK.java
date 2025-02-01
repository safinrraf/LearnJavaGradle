package com.learn.leetcode.daily.w2024.u202411.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/?envType=daily-question&envId=2024-11-17">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Binary Search, Queue, Sliding Window, Heap (Priority Queue), Prefix Sum, Monotonic Queue}
 * </ul>
 * <ul>Hints
 * <li> {@code ...}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums.length <= 10^5}
 * <li> {@code -10^5 <= nums[i] <= 10^5}
 * <li> {@code 1 <= k <= 109}
 * </ul>
 * <br>@author ChatGPT & radik.safin
 * <br>@since 1.0.0
 * <br> 17.11.24 17:02
 */
public final class ShortestSubarrayWithSumAtLeastK {

    private static class Element {
        public long prefix_sum;
        public int index;

        public Element(long prefix_sum, int index) {
            this.prefix_sum = prefix_sum;
            this.index = index;
        }
    }

    /**
     * {@code Time Complexity O(N)}
     * {@code Space Complexity O(N)}
     *
     * @param nums an integer array
     * @param k
     * @return the length of the shortest non-empty sub-array of {@code nums} with a sum of at least {@code k}. If there is no such sub-array, return {@code -1}.
     */
    public static int shortestSubarray(int[] nums, int k) {
        // Initialize variables
        long prefixSum = 0L; // Use long to avoid overflow
        int minLength = Integer.MAX_VALUE;
        final Deque<Element> deque = new LinkedList<>();

        // Start with a prefix sum of 0 at index -1
        deque.addLast(new Element(0, -1));

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // Check if the front of the deque satisfies the condition
            while (!deque.isEmpty() && prefixSum - deque.peekFirst().prefix_sum >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst().index);
            }

            // Maintain monotonicity of the deque
            while (!deque.isEmpty() && deque.peekLast().prefix_sum >= prefixSum) {
                deque.pollLast();
            }

            // Add the current prefix sum and its index to the deque
            deque.addLast(new Element(prefixSum, i));
        }

        // If minLength was updated, return it; otherwise, return -1
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public int shortestSubarrayEvenFasterAndNotMine(int[] nums, int k) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[] q = new int[n + 1];
        int l = 0, r = 0;
        int ans = n + 1;
        for (int i = 0; i < sum.length; i++) {
            while (r > l && sum[i] >= sum[q[l]] + k)
                ans = Math.min(ans, i - q[l++]);
            while (r > l && sum[i] <= sum[q[r - 1]])
                r--;
            q[r++] = i;
        }
        return ans <= n ? ans : -1;
    }
}
