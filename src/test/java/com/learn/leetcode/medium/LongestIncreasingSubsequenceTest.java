package com.learn.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LongestIncreasingSubsequenceTest {

    @Test
    void lengthOfLIS1() {
        var input = new int[]{10,9,2,5,3,7,101,18};
        var result = LongestIncreasingSubsequence.lengthOfLIS(input);
        var expected = 4;

        assertEquals(expected, result);
    }
}