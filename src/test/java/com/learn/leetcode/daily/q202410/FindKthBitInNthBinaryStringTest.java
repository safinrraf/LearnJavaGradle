package com.learn.leetcode.daily.q202410;

import com.learn.leetcode.daily.w2024.q202410.medium.FindKthBitInNthBinaryString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code ..., ..., ...}
 * </ul>
 * <ul>Hints
 * <li> {@code ...}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 ...}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 19.10.24 20:15
 */
class FindKthBitInNthBinaryStringTest {

    @Test
    void findKthBit1() {
        final var n = 3;
        final var k = 1;
        final var expected = '0';
        final var result = FindKthBitInNthBinaryString.findKthBit(n, k);

        assertEquals(expected, result);
    }

    @Test
    void findKthBit2() {
        final var n = 4;
        final var k = 11;
        final var expected = '1';
        final var result = FindKthBitInNthBinaryString.findKthBit(n, k);

        assertEquals(expected, result);
    }
}