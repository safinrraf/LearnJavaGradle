package com.learn.leetcode.daily.b202502.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckIfOneStringSwapCanMakeStringsEqualTest {

    @Test
    void areAlmostEqual1() {
        final String s1 = "bank";
        final String s2 = "kanb";

        assertTrue(CheckIfOneStringSwapCanMakeStringsEqual.areAlmostEqual(s1, s2));
    }

    @Test
    void areAlmostEqual2() {
        final String s1 = "attack";
        final String s2 = "defend";

        assertFalse(CheckIfOneStringSwapCanMakeStringsEqual.areAlmostEqual(s1, s2));
    }

    @Test
    void areAlmostEqual3() {
        final String s1 = "kelb";
        final String s2 = "kelb";

        assertTrue(CheckIfOneStringSwapCanMakeStringsEqual.areAlmostEqual(s1, s2));
    }

    @Test
    void areAlmostEqual4() {
        final String s1 = "abc";
        final String s2 = "cba";

        assertTrue(CheckIfOneStringSwapCanMakeStringsEqual.areAlmostEqual(s1, s2));
    }

    @Test
    void areAlmostEqual5() {
        final String s1 = "abcr";
        final String s2 = "cbaf";

        assertFalse(CheckIfOneStringSwapCanMakeStringsEqual.areAlmostEqual(s1, s2));
    }

    @Test
    void areAlmostEqual6() {
        final String s1 = "ab";
        final String s2 = "cb";

        assertFalse(CheckIfOneStringSwapCanMakeStringsEqual.areAlmostEqual(s1, s2));
    }

    @Test
    void areAlmostEqual7() {
        final String s1 = "aabb";
        final String s2 = "bbaa";

        assertFalse(CheckIfOneStringSwapCanMakeStringsEqual.areAlmostEqual(s1, s2));
    }

    @Test
    void areAlmostEqual8() {
        final String s1 = "npv";
        final String s2 = "zpn";

        assertFalse(CheckIfOneStringSwapCanMakeStringsEqual.areAlmostEqual(s1, s2));
    }
}