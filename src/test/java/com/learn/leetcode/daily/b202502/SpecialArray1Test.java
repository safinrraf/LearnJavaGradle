package com.learn.leetcode.daily.b202502;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecialArray1Test {

    @Test
    void isArraySpecial1() {
        final int[] nums = {1};

        assertTrue(SpecialArray1.isArraySpecial(nums));
    }

    @Test
    void isArraySpecial2() {
        final int[] nums = {2,1,4};

        assertTrue(SpecialArray1.isArraySpecial(nums));
    }

    @Test
    void isArraySpecial3() {
        final int[] nums = {4,3,1,6};

        assertFalse(SpecialArray1.isArraySpecial(nums));
    }

    @Test
    void isArraySpecial4() {
        final int[] nums = {1,2,1,2,1,2,1,1};

        assertFalse(SpecialArray1.isArraySpecial(nums));
    }
}