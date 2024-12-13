package com.learn.leetcode.daily.x202412.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindScoreOfAnArrayAfterMarkingAllElementsTest {

    @Test
    void findScore1() {
        final int[] nums = {2,1,3,4,5,2};
        final long expected = 7;
        final long result = FindScoreOfAnArrayAfterMarkingAllElements.findScore(nums);

        assertEquals(expected, result);
    }

    @Test
    void findScore2() {
        final int[] nums = {2,3,5,1,3,2};
        final long expected = 5;
        final long result = FindScoreOfAnArrayAfterMarkingAllElements.findScore(nums);

        assertEquals(expected, result);
    }
}