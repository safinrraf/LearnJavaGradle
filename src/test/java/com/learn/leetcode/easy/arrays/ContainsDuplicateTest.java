package com.learn.leetcode.easy.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateTest {

    @Test
    void containsDuplicate1() {
        final var input = new int[]{1,2,3,1};

        assertTrue(ContainsDuplicate.containsDuplicate(input));
    }

    @Test
    void containsDuplicate2() {
        final var input = new int[]{1,2,3,4};

        assertFalse(ContainsDuplicate.containsDuplicate(input));
    }

    @Test
    void containsDuplicate3() {
        final var input = new int[]{1,1,1,3,3,4,3,2,4,2};

        assertTrue(ContainsDuplicate.containsDuplicate(input));
    }
}