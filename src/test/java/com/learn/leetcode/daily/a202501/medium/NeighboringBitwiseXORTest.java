package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NeighboringBitwiseXORTest {

    @Test
    void doesValidArrayExist1() {
        final int[] derived = {1,1,0};

        assertTrue(NeighboringBitwiseXOR.doesValidArrayExist(derived));
    }

    @Test
    void doesValidArrayExist2() {
        final int[] derived = {1,1};

        assertTrue(NeighboringBitwiseXOR.doesValidArrayExist(derived));
    }

    @Test
    void doesValidArrayExist3() {
        final int[] derived = {1,0};

        assertFalse(NeighboringBitwiseXOR.doesValidArrayExist(derived));
    }
}