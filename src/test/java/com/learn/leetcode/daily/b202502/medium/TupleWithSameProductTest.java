package com.learn.leetcode.daily.b202502.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TupleWithSameProductTest {

    @Test
    void tupleSameProduct1() {
        final int[] nums = {2,3,4,6};
        final int expected = 8;
        final int answer = TupleWithSameProduct.tupleSameProduct(nums);

        assertEquals(expected, answer);
    }

    @Test
    void tupleSameProduct2() {
        final int[] nums = {1,2,4,5,10};
        final int expected = 16;
        final int answer = TupleWithSameProduct.tupleSameProduct(nums);

        assertEquals(expected, answer);
    }
}