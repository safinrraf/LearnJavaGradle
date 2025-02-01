package com.learn.leetcode.daily.u202411.medium;

import com.learn.leetcode.daily.w2024.u202411.medium.PrimeSubtractionOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeSubtractionOperationTest {

    @Test
    void primeSubOperation1() {
        int[] nums = {4,9,6,10};
        var expected = true;
        var result = PrimeSubtractionOperation.primeSubOperation(nums);

        assertEquals(expected, result);
    }

    @Test
    void primeSubOperation2() {
        int[] nums = {6,8,11,12};
        var expected = true;
        var result = PrimeSubtractionOperation.primeSubOperation(nums);

        assertEquals(expected, result);
    }

    @Test
    void primeSubOperation3() {
        int[] nums = {5,8,3};
        var expected = false;
        var result = PrimeSubtractionOperation.primeSubOperation(nums);

        assertEquals(expected, result);
    }

    @Test
    void primeSubOperation4() {
        int[] nums = {1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};
        var expected = true;
        var result = PrimeSubtractionOperation.primeSubOperation(nums);

        assertEquals(expected, result);
    }

    @Test
    void primeSubOperation5() {
        int[] nums = {1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
                1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};
        var expected = false;
        var result = PrimeSubtractionOperation.primeSubOperation(nums);

        assertEquals(expected, result);
    }

    @Test
    void primeSubOperation6() {
        int[] nums = {2,2};
        var expected = false;
        var result = PrimeSubtractionOperation.primeSubOperation(nums);

        assertEquals(expected, result);
    }

    @Test
    void primeSubOperation7() {
        int[] nums = {998,2};
        var expected = true;
        var result = PrimeSubtractionOperation.primeSubOperation(nums);

        assertEquals(expected, result);
    }

    @Test
    void primeSubOperation8() {
        int[] nums = {15,20,17,7,16};
        var expected = true;
        var result = PrimeSubtractionOperation.primeSubOperation(nums);

        assertEquals(expected, result);
    }
}