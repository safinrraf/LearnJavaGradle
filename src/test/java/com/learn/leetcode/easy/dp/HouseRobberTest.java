package com.learn.leetcode.easy.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberTest {

    @Test
    void rob1() {
        final var nums = new int[]{2, 1, 1, 2};
        final var expected = 4;
        final var result = HouseRobber.rob(nums);

        assertEquals(expected, result);
    }

    @Test
    void rob2() {
        final var nums = new int[]{1, 2, 3, 1};
        final var expected = 4;
        final var result = HouseRobber.rob(nums);

        assertEquals(expected, result);
    }

    @Test
    void rob3() {
        final var nums = new int[]{2, 7, 9, 3, 1};
        final var expected = 12;
        final var result = HouseRobber.rob(nums);

        assertEquals(expected, result);
    }
}