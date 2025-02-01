package com.learn.leetcode.daily.w2024.x202412.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/take-gifts-from-the-richest-pile/description/?envType=daily-question&envId=2024-12-12">Task</a>
 * <br><a href="https://leetcode.com/problems/take-gifts-from-the-richest-pile/solutions/6137820/beats-100-proof-beginner-freindly-java-concise-code/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Heap (Priority Queue), Simulation}
 * </ul>
 * <ul>Hints
 * <li> {@code How can you keep track of the largest gifts in the array}
 * <li> {@code What is an efficient way to find the square root of a number?}
 * <li> {@code Can you keep adding up the values of the gifts while ensuring they are in a certain order?}
 * <li> {@code Can we use a priority queue or heap here?}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= gifts.length <= 10^3}
 * <li> {@code 1 <= gifts[i] <= 10^9}
 * <li> {@code 1 <= k <= 10^3}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 12.12.24 08:20
 */
public final class TakeGiftsFromTheRichestPile {

    /**
     *
     * <p>
     * {@code Time Complexity O(NLogN)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param gifts an integer array {@code gifts} denotes the number of gifts in various piles.
     * @param k number of seconds.
     * @return the number of gifts remaining after {@code k} seconds.
     */
    public static long pickGifts(int[] gifts, int k) {
        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(gifts).forEach(maxHeap::add);

        for (int i = 0; i < k && maxHeap.peek() > 1; i++) {
            final var x = maxHeap.poll();
            maxHeap.add((int) Math.sqrt(x));
        }

        return maxHeap.stream().mapToLong(val -> val).sum();
    }
}
