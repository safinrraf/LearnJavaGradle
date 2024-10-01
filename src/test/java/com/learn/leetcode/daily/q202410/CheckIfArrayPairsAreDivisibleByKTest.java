package com.learn.leetcode.daily.q202410;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckIfArrayPairsAreDivisibleByKTest {

    @Test
    void canArrange1() {
        final var input = new int[]{1,2,3,4,5,10,6,7,8,9};
        final var k = 5;
        final var result = CheckIfArrayPairsAreDivisibleByK.canArrange(input, k);

        assertTrue(result);
    }

    @Test
    void canArrange2() {
        final var input = new int[]{1,2,3,4,5,6};
        final var k = 7;
        final var result = CheckIfArrayPairsAreDivisibleByK.canArrange(input, k);

        assertTrue(result);
    }

    @Test
    void canArrange3() {
        final var input = new int[]{1,2,3,4,5,6};
        final var k = 10;
        final var result = CheckIfArrayPairsAreDivisibleByK.canArrange(input, k);

        assertFalse(result);
    }
}