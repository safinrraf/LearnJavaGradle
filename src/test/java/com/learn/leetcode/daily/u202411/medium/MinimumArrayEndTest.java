package com.learn.leetcode.daily.u202411.medium;

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
 * <br> 09.11.24 15:41
 */
class MinimumArrayEndTest {

    @Test
    void minEnd1() {
        var n = 3;
        var x = 4;
        var expected = 6L;
        var result = MinimumArrayEnd.minEnd(n, x);

        assertEquals(expected, result);
    }

    @Test
    void minEnd2() {
        var n = 2;
        var x = 7;
        var expected = 15L;
        var result = MinimumArrayEnd.minEnd(n, x);

        assertEquals(expected, result);
    }

    @Test
    void minEnd3() {
        var n = 6715154;
        var x = 7193485;
        var expected = 55012476815L;
        var result = MinimumArrayEnd.minEnd(n, x);

        assertEquals(expected, result);
    }

    @Test
    void minEnd4() {
        var n = 12;
        var x = 9;
        var expected = 47L;
        var result = MinimumArrayEnd.minEnd(n, x);

        assertEquals(expected, result);
    }
}