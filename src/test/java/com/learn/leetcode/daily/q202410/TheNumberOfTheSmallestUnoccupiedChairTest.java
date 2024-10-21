package com.learn.leetcode.daily.q202410;

import com.learn.leetcode.daily.q202410.medium.TheNumberOfTheSmallestUnoccupiedChair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheNumberOfTheSmallestUnoccupiedChairTest {

    /**
     * Explanation:
     * - Friend 0 arrives at time 1 and sits on chair 0.
     * - Friend 1 arrives at time 2 and sits on chair 1.
     * - Friend 1 leaves at time 3 and chair 1 becomes empty.
     * - Friend 0 leaves at time 4 and chair 0 becomes empty.
     * - Friend 2 arrives at time 4 and sits on chair 0.
     * Since friend 1 sat on chair 1, we return 1.
     */
    @Test
    void smallestChair1() {
        final var input = new int[][]{{1,4},{2,3},{4,6}};
        final var targetFriend = 1;
        final var expected = 1;
        final var result = TheNumberOfTheSmallestUnoccupiedChair.smallestChair(input, targetFriend);

        assertEquals(expected, result);
    }

    /**
     * Explanation:
     * - Friend 1 arrives at time 1 and sits on chair 0.
     * - Friend 2 arrives at time 2 and sits on chair 1.
     * - Friend 0 arrives at time 3 and sits on chair 2.
     * - Friend 1 leaves at time 5 and chair 0 becomes empty.
     * - Friend 2 leaves at time 6 and chair 1 becomes empty.
     * - Friend 0 leaves at time 10 and chair 2 becomes empty.
     * Since friend 0 sat on chair 2, we return 2.
     */
    @Test
    void smallestChair2() {
        final var input = new int[][]{{3,10},{1,5},{2,6}};
        final var targetFriend = 0;
        final var expected = 2;
        final var result = TheNumberOfTheSmallestUnoccupiedChair.smallestChair(input, targetFriend);

        assertEquals(expected, result);
    }
}