package com.learn.leetcode.daily.q202410.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/?envType=daily-question&envId=2024-10-12">Task</a>
 * <br><a href="">Explanation</a>
 * <p>
 * <li>Hint 1: Can you find a different way to describe the question?
 *     <ul>
 *         <li> Hm...
 *     </ul>
 *     <li>Hint 2: The minimum number of groups we need is equivalent to the maximum number of intervals that overlap at some point. How can you find that?
 *     <ul>
 *         <li> Hm...
 *     </ul>
 * </p>
 * <p>
 * <br>@since 1.0.0
 * <br>12.10.24 11:00
 * </p>
 */
public final class DivideIntervalsIntoMinimumNumberOfGroups {
    /**
     * <p>Two intervals intersect if there is at least one common number between them.
     * For example, the intervals [1, 5] and [5, 8] intersect.</p>
     * <p>Time complexity {@code O(NLogN)}</p>
     * <p>Space complexity {@code O(N)}</p>
     * @param intervals You are given a 2D integer array intervals
     *                  <br>where {@code intervals[i] = [left(i), right(i)]} represents the inclusive interval [left(i), right(i)].
     * @return the minimum number of groups you need to make.
     */
    public static int minGroups(int[][] intervals) {
        // Sort the array by the first element of each sub-array (start time)
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        final PriorityQueue<Integer> min_heap = new PriorityQueue<>();

        for (final var interval : intervals) {
            final var start = interval[0];
            final var end = interval[1];

            if (min_heap.isEmpty()) {
                min_heap.offer(end);
                continue;
            }

            if (min_heap.peek() >= start) {
                min_heap.offer(end);
            } else {
                min_heap.poll();
                min_heap.offer(end);
            }
        }
        return min_heap.size();
    }
}
