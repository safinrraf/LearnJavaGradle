package com.learn.leetcode.daily.x202412.medium;

import com.learn.leetcode.daily.w2024.x202412.medium.TwoBestNonOverlappingEvents;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoBestNonOverlappingEventsTest {

    @Test
    void maxTwoEvents1() {
        final int[][] events = {{1,3,2},{4,5,2},{2,4,3}};
        final int expected = 4;
        final int result = TwoBestNonOverlappingEvents.maxTwoEvents(events);

        assertEquals(expected, result);
    }

    @Test
    void maxTwoEvents2() {
        final int[][] events = {{1,3,2},{4,5,2},{1,5,5}};
        final int expected = 5;
        final int result = TwoBestNonOverlappingEvents.maxTwoEvents(events);

        assertEquals(expected, result);
    }

    @Test
    void maxTwoEvents3() {
        final int[][] events = {{1,5,3},{1,5,1},{6,6,5}};
        final int expected = 8;
        final int result = TwoBestNonOverlappingEvents.maxTwoEvents(events);

        assertEquals(expected, result);
    }
}