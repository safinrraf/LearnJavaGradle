package com.learn.leetcode.daily.x202412.medium;

import com.learn.leetcode.daily.w2024.x202412.medium.ContinuousSubarrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContinuousSubarraysTest {

    @Test
    void continuousSubarrays1() {
        final int[] nums = {5,4,2,4};
        final long expected = 8;
        final long result = ContinuousSubarrays.continuousSubarrays_SortedMap(nums);

        assertEquals(expected, result);
    }

    @Test
    void continuousSubarrays2() {
        final int[] nums = {1,2,3};
        final long expected = 6;
        final long result = ContinuousSubarrays.continuousSubarrays_PriorityQueue(nums);

        assertEquals(expected, result);
    }
}