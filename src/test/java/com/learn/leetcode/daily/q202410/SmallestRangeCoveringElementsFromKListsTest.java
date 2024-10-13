package com.learn.leetcode.daily.q202410;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SmallestRangeCoveringElementsFromKListsTest {

    @Test
    void smallestRange1() {
        final var nums = List.of(List.of(4,10,15,24,26),List.of(0,9,12,20),List.of(5,18,22,30));
        final var expected = new int[]{20,24};
        final var result = SmallestRangeCoveringElementsFromKLists.smallestRange(nums);

        assertArrayEquals(expected, result);
    }

    @Test
    void smallestRange2() {
        final var nums = List.of(List.of(1,2,3),List.of(1,2,3),List.of(1,2,3));
        final var expected = new int[]{1,1};
        final var result = SmallestRangeCoveringElementsFromKLists.smallestRange(nums);

        assertArrayEquals(expected, result);
    }

    @Test
    void smallestRange3() {
        final var nums = List.of(List.of(4,10,15,24,26),List.of(9,12,20),List.of(5,18,22,30));
        final var expected = new int[]{20,24};
        final var result = SmallestRangeCoveringElementsFromKLists.smallestRange(nums);

        assertArrayEquals(expected, result);
    }

    @Test
    void smallestRange9() {
        final var nums = List.of(List.of(24,26),List.of(20),List.of(22,30));
        final var expected = new int[]{20, 24};
        final var result = SmallestRangeCoveringElementsFromKLists.smallestRange(nums);

        assertArrayEquals(expected, result);
    }
}