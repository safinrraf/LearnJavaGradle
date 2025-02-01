package com.learn.leetcode.daily.u202411.medium;

import com.learn.leetcode.daily.w2024.u202411.medium.MinimumNumberOfChangesToMakeBinaryStringBeautiful;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MinimumNumberOfChangesToMakeBinaryStringBeautifulTest {

    @Test
    void minChanges1() {
        var input = "1001";
        var expected = 2;
        var result = MinimumNumberOfChangesToMakeBinaryStringBeautiful.minChanges(input);

        assertEquals(expected, result);
    }

    @Test
    void minChanges2() {
        var input = "10";
        var expected = 1;
        var result = MinimumNumberOfChangesToMakeBinaryStringBeautiful.minChanges(input);

        assertEquals(expected, result);
    }

    @Test
    void minChanges3() {
        var input = "0000";
        var expected = 0;
        var result = MinimumNumberOfChangesToMakeBinaryStringBeautiful.minChanges(input);

        assertEquals(expected, result);
    }

    @Test
    void minChanges4() {
        var input = "10010100000111001101011000000010110011";
        var expected = 8;
        var result = MinimumNumberOfChangesToMakeBinaryStringBeautiful.minChanges(input);

        assertEquals(expected, result);
    }
}