package com.learn.leetcode.daily.u202411.medium;

import com.learn.leetcode.daily.w2024.u202411.medium.MaximumXorForEachQuery;
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
 * <br> 08.11.24 08:39
 */
class MaximumXorForEachQueryTest {

    @Test
    void getMaximumXor1() {
        var nums = new int[]{0,1,1,3};
        var maximumBit = 2;
        var expected = new int[]{0,3,2,3};
        var result = MaximumXorForEachQuery.getMaximumXor(nums, maximumBit);

        assertArrayEquals(expected, result);
    }

    @Test
    void getMaximumXor2() {
        var nums = new int[]{2,3,4,7};
        var maximumBit = 3;
        var expected = new int[]{5,2,6,5};
        var result = MaximumXorForEachQuery.getMaximumXor(nums, maximumBit);

        assertArrayEquals(expected, result);
    }

    @Test
    void getMaximumXor3() {
        var nums = new int[]{0,1,2,2,5,7};
        var maximumBit = 3;
        var expected = new int[]{4,3,6,4,6,7};
        var result = MaximumXorForEachQuery.getMaximumXor(nums, maximumBit);

        assertArrayEquals(expected, result);
    }
}