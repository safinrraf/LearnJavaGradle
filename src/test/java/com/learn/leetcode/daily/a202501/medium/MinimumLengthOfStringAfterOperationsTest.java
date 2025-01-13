package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumLengthOfStringAfterOperationsTest {

    @Test
    void minimumLength1() {
        final String s = "abaacbcbb";
        final int expected = 5;
        final int answer = MinimumLengthOfStringAfterOperations.minimumLength(s);

        assertEquals(expected, answer);
    }

    @Test
    void minimumLength2() {
        final String s = "aa";
        final int expected = 2;
        final int answer = MinimumLengthOfStringAfterOperations.minimumLength(s);

        assertEquals(expected, answer);
    }
}