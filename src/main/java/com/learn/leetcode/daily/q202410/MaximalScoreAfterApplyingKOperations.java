package com.learn.leetcode.daily.q202410;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/maximal-score-after-applying-k-operations/description/?envType=daily-question&envId=2024-10-14">Task</a>
 * <br><a href="">Explanation</a>
 * <li>Hint 1: It is always optimal to select the greatest element in the array.
 * <li>Hint 2: Use a heap to query for the maximum in O(log n) time.
 * <ul>Topics
 * <li> {@code Array, Greedy, Heap (Priority Queue)}
 * </ul>
 * <p>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 14.10.24 19:32
 * </p>
 */
public final class MaximalScoreAfterApplyingKOperations {
    /**
     * <p>Time complexity {@code NLogN}</p>
     * <p>Space complexity {@code O(N)}</p>
     * @param nums
     * @param k
     * @return the maximum possible score you can attain after applying exactly k operations.
     */
    public long maxKelements(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, (a, b)->b-a);
        long result = 0L;

        for(final var item: nums) {
            pq.offer(item);
        }

        while(!pq.isEmpty() && k-- > 0) {
            result += pq.peek();
            pq.add((int) Math.ceil(pq.poll()/3.0));
        }

        return result;
    }
}
