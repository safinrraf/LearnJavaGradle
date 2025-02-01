package com.learn.leetcode.daily.q202409;

import com.learn.leetcode.daily.w2024.q202409.MinimumTimeDifference;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinimumTimeDifferenceTest {

    @Test
    void findMinDifference1() {
        final var input = List.of("23:59", "00:00");
        final var expected = 1;
        final var result = MinimumTimeDifference.findMinDifference(input);

        assertEquals(expected, result);
    }

    @Test
    void findMinDifference2() {
        final var input = List.of("00:00","23:59","00:00");
        final var expected = 0;
        final var result = MinimumTimeDifference.findMinDifference(input);

        assertEquals(expected, result);
    }

    @Test
    void findMinDifference3() {
        final var input = List.of("00:15","23:59","00:10", "23:56", "17:01", "17:02");
        final var expected = 1;
        final var result = MinimumTimeDifference.findMinDifference(input);

        assertEquals(expected, result);
    }

    @Test
    void findMinDifference4() {
        final var input = List.of("23:59", "23:00", "00:02");
        final var expected = 3;
        final var result = MinimumTimeDifference.findMinDifference(input);

        assertEquals(expected, result);
    }
}