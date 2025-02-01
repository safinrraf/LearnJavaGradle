package com.learn.leetcode.daily.x202412.medium;

import com.learn.leetcode.daily.w2024.x202412.medium.MinimumLimitOfBallsInBag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumLimitOfBallsInBagTest {

    @Test
    void minimumSize1() {
        final int[] nums = {9};
        final int maxOperations = 2;
        final int expected = 3;
        final int result = MinimumLimitOfBallsInBag.minimumSize(nums, maxOperations);

        assertEquals(expected, result);
    }

    @Test
    void minimumSize2() {
        final int[] nums = {2,4,8,2};
        final int maxOperations = 4;
        final int expected = 2;
        final int result = MinimumLimitOfBallsInBag.minimumSize(nums, maxOperations);

        assertEquals(expected, result);
    }
}