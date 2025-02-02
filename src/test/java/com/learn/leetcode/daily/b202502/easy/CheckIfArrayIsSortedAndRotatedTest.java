package com.learn.leetcode.daily.b202502.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckIfArrayIsSortedAndRotatedTest {

    @Test
    void check1() {
        final int[] nums = {3,4,5,1,2};

        assertTrue(CheckIfArrayIsSortedAndRotated.check(nums));
    }

    @Test
    void check2() {
        final int[] nums = {2,1,3,4};

        assertFalse(CheckIfArrayIsSortedAndRotated.check(nums));
    }

    @Test
    void check3() {
        final int[] nums = {1,2,3};

        assertTrue(CheckIfArrayIsSortedAndRotated.check(nums));
    }

    @Test
    void check4() {
        final int[] nums = {50,1,2,3};

        assertTrue(CheckIfArrayIsSortedAndRotated.check(nums));
    }

    @Test
    void check5() {
        final int[] nums = {50,1};

        assertTrue(CheckIfArrayIsSortedAndRotated.check(nums));
    }

    @Test
    void check6() {
        final int[] nums = {1,2};

        assertTrue(CheckIfArrayIsSortedAndRotated.check(nums));
    }

    @Test
    void check7() {
        final int[] nums = {99};

        assertTrue(CheckIfArrayIsSortedAndRotated.check(nums));
    }

    @Test
    void check8() {
        final int[] nums = {99,1,2,85,23,2};

        assertFalse(CheckIfArrayIsSortedAndRotated.check(nums));
    }

    @Test
    void check12() {
        final int[] nums = {3,4,5,1,2};

        assertTrue(CheckIfArrayIsSortedAndRotated.check2(nums));
    }

    @Test
    void check22() {
        final int[] nums = {2,1,3,4};

        assertFalse(CheckIfArrayIsSortedAndRotated.check2(nums));
    }

    @Test
    void check32() {
        final int[] nums = {1,2,3};

        assertTrue(CheckIfArrayIsSortedAndRotated.check2(nums));
    }

    @Test
    void check42() {
        final int[] nums = {50,1,2,3};

        assertTrue(CheckIfArrayIsSortedAndRotated.check2(nums));
    }

    @Test
    void check52() {
        final int[] nums = {50,1};

        assertTrue(CheckIfArrayIsSortedAndRotated.check2(nums));
    }

    @Test
    void check62() {
        final int[] nums = {1,2};

        assertTrue(CheckIfArrayIsSortedAndRotated.check2(nums));
    }

    @Test
    void check72() {
        final int[] nums = {99};

        assertTrue(CheckIfArrayIsSortedAndRotated.check2(nums));
    }
}