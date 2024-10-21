package com.learn.leetcode.daily.q202410.medium;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/description/?envType=daily-question&envId=2024-10-11">Task</a>
 * <br><a href="https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/solutions/5897455/python3-9-lines-two-heaps-t-s-94-95/?envType=daily-question&envId=2024-10-11">Explanation</a>
 * <p>
 * <li>Hint 1: Sort times by arrival time.
 *     <ul>
 *         <li> Hm...
 *     </ul>
 *     <li>Hint 2: for each arrival_i find the smallest unoccupied chair and mark it as occupied until leaving_i.
 *     <ul>
 *         <li> Hm...
 *     </ul>
 * </p>
 * <p>
 * <ul><b>Constraints</b>:
 * <li> {@code n == times.length}
 * <li> {@code times[i].length == 2}
 * <li> {@code 1 <= arrivali < leavingi <= 10^5}
 * <li> {@code 0 <= targetFriend <= n - 1}
 * <li> {@code Each arrivali time is distinct.}
 * <li> <b>My additional constraints</b>:
 * <ul>Topics
 * <li> {@code Array, Hash Table, Heap (Priority Queue)}
 * </ul>
 * </ul>
 * </p>
 * <p>
 * <br>@since 1.0.0
 * <br> 11.10.24 20:59
 * </p>
 */
public final class TheNumberOfTheSmallestUnoccupiedChair {
    /**
     * <p>You are given a 0-indexed 2D integer array times where {@code times[i] = [arrival(i), leaving(i)]},
     * indicating the arrival and leaving times of the ith friend respectively,
     * and an integer targetFriend. All arrival times are distinct.
     * </p>
     * <p>Time complexity {@code O(NLogN)}</p>
     * <p>Space complexity {@code O(N)}</p>
     * @param times {@code times[i] = [arrival(i), leaving(i)]}
     * @param targetFriend
     * @return Return the chair number that the friend numbered targetFriend will sit on.
     */
    public static int smallestChair(int[][] times, int targetFriend) {
        final var times_length = times.length;
        final var order = new Integer[times_length];

        Arrays.setAll(order, i -> i);
        Arrays.sort(order, Comparator.comparingInt(a -> times[a][0]));

        final PriorityQueue<Integer> emptySeats = new PriorityQueue<>();
        final PriorityQueue<int[]> takenSeats = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < times_length; i++) {
            emptySeats.offer(i);
        }

        for (int i : order) {
            final var arrival = times[i][0];
            final var leave = times[i][1];

            while (!takenSeats.isEmpty() && takenSeats.peek()[0] <= arrival) {
                emptySeats.offer(takenSeats.poll()[1]);
            }

            final var seat = emptySeats.poll();

            if (i == targetFriend) {
                return seat;
            }

            takenSeats.offer(new int[]{leave, seat});
        }

        return -1;
    }
}
