package com.learn.leetcode.daily.x202412.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TakeGiftsFromTheRichestPileTest {

    @Test
    void pickGifts1() {
        final int[] gifts = {25,64,9,4,100};
        final int k = 4;
        final long expected = 29;
        final long result = TakeGiftsFromTheRichestPile.pickGifts(gifts, k);

        assertEquals(expected, result);
    }

    @Test
    void pickGifts2() {
        final int[] gifts = {1,1,1,1};
        final int k = 4;
        final long expected = 4;
        final long result = TakeGiftsFromTheRichestPile.pickGifts(gifts, k);

        assertEquals(expected, result);
    }
}