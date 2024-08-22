package com.learn.leetcode.medium.daily;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberComplementTest {

    @Test
    void findComplement1() {
        assertEquals(2, NumberComplement.findComplement(5));
    }

    @Test
    void findComplement2() {
        assertEquals(0, NumberComplement.findComplement(1));
    }
}