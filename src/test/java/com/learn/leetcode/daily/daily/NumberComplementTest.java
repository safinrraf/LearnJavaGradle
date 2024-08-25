package com.learn.leetcode.daily.daily;

import com.learn.leetcode.daily.NumberComplement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberComplementTest {

    @Test
    void findComplement1() {
        assertEquals(2, NumberComplement.findComplementNotMy(5));
    }

    @Test
    void findComplement2() {
        assertEquals(0, NumberComplement.findComplementNotMy(1));
    }
}