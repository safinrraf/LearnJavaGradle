package com.learn.leetcode.daily.q202410.medium;

import com.learn.leetcode.daily.w2024.q202410.medium.SplitStringIntoTheMaxNumberOfUniqueSubstrings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplitStringIntoTheMaxNumberOfUniqueSubstringsTest {

    @Test
    void maxUniqueSplit1() {
        final var input = "ababccc";
        final var result = SplitStringIntoTheMaxNumberOfUniqueSubstrings.maxUniqueSplit(input);
        final var expected = 5;

        assertEquals(expected, result);
    }

    @Test
    void maxUniqueSplit2() {
        final var input = "aba";
        final var result = SplitStringIntoTheMaxNumberOfUniqueSubstrings.maxUniqueSplit(input);
        final var expected = 2;

        assertEquals(expected, result);
    }

    @Test
    void maxUniqueSplit3() {
        final var input = "aa";
        final var result = SplitStringIntoTheMaxNumberOfUniqueSubstrings.maxUniqueSplit(input);
        final var expected = 1;

        assertEquals(expected, result);
    }
}