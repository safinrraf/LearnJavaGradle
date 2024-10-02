package com.learn.leetcode.daily.q202410;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTransformOfAnArrayTest {

    @Test
    void arrayRankTransform0() {
        final var input = new int[]{};
        final var expected = new int[]{};
        final var result = RankTransformOfAnArray.arrayRankTransform(input);

        assertArrayEquals(expected, result);
    }

    @Test
    void arrayRankTransform1() {
        final var input = new int[]{40, 10, 20, 30};
        final var expected = new int[]{4, 1, 2, 3};
        final var result = RankTransformOfAnArray.arrayRankTransform(input);

        assertArrayEquals(expected, result);
    }

    @Test
    void arrayRankTransform2() {
        final var input = new int[]{100, 100, 100};
        final var expected = new int[]{1, 1, 1};
        final var result = RankTransformOfAnArray.arrayRankTransform(input);

        assertArrayEquals(expected, result);
    }

    @Test
    void arrayRankTransform3() {
        final var input = new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12};
        final var expected = new int[]{5,3,4,2,8,6,7,1,3};
        final var result = RankTransformOfAnArray.arrayRankTransform(input);

        assertArrayEquals(expected, result);
    }

    @Test
    void arrayRankTransform4() {
        final var input = new int[]{100, 100, 100, 1};
        final var expected = new int[]{2, 2, 2, 1};
        final var result = RankTransformOfAnArray.arrayRankTransform(input);

        assertArrayEquals(expected, result);
    }

    @Test
    void arrayRankTransform5() {
        final var input = new int[]{100};
        final var expected = new int[]{1};
        final var result = RankTransformOfAnArray.arrayRankTransform(input);

        assertArrayEquals(expected, result);
    }

    @Test
    void arrayRankTransform6() {
        final var input = new int[]{1,2,3,4,5,6,7,8,9};
        final var expected = new int[]{1,2,3,4,5,6,7,8,9};
        final var result = RankTransformOfAnArray.arrayRankTransform(input);

        assertArrayEquals(expected, result);
    }

    @Test
    void arrayRankTransform7() {
        final var input = new int[]{1,2,3,4,5,6,7,8,9,0};
        final var expected = new int[]{2,3,4,5,6,7,8,9,10,1};
        final var result = RankTransformOfAnArray.arrayRankTransform(input);

        assertArrayEquals(expected, result);
    }

    @Test
    void arrayRankTransform8() {
        final var input = new int[]{1,2,3,3,3,4,5,6,7,8,9,0};
        final var expected = new int[]{2,3,4,4,4,5,6,7,8,9,10,1};
        final var result = RankTransformOfAnArray.arrayRankTransform(input);

        assertArrayEquals(expected, result);
    }
}