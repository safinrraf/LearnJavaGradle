package com.learn.leetcode.daily.x202412.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumNumberOfIntegersToChooseFromRange1Test {

    @Test
    void maxCount1() {
        final int[] banned = {1,6,5};
        final int n = 5;
        final int maxSum = 6;
        final int expected = 2;
        final int result = MaximumNumberOfIntegersToChooseFromRange1.maxCount(banned, n, maxSum);

        assertEquals(expected, result);
    }

    @Test
    void maxCount2() {
        final int[] banned = {1,2,3,4,5,6,7};
        final int n = 8;
        final int maxSum = 1;
        final int expected = 0;
        final int result = MaximumNumberOfIntegersToChooseFromRange1.maxCount(banned, n, maxSum);

        assertEquals(expected, result);
    }

    @Test
    void maxCount3() {
        final int[] banned = {11};
        final int n = 7;
        final int maxSum = 50;
        final int expected = 7;
        final int result = MaximumNumberOfIntegersToChooseFromRange1.maxCount(banned, n, maxSum);

        assertEquals(expected, result);
    }
}