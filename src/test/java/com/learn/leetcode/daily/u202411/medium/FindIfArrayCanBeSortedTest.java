package com.learn.leetcode.daily.u202411.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindIfArrayCanBeSortedTest {

    @Test
    void canSortArray1() {
        var input = new int[]{8,4,2,30,15};
        var result = FindIfArrayCanBeSorted.canSortArray(input);

        assertTrue(result);
    }

    @Test
    void canSortArray2() {
        var input = new int[]{1,2,3,4,5};
        var result = FindIfArrayCanBeSorted.canSortArray(input);

        assertTrue(result);
    }

    @Test
    void canSortArray3() {
        var input = new int[]{1,32,2,8,2,64,4,8,16,64,64,2,64,256,2,2,2,256,64,64,1,2,256,2,16,256,256,2,1,256,64,8,
                64,16,4,32,256,16,128,8,64,64,32,4,2,16,8,32,8,32,128,2,16,4,16,32,16,2,64,128,8,64,8,64,64,16,256,
                64,1,16,256,1,64,256,128,2,4,128,64,256,16,4,1,8,32,32,8,1,128,1,128,64,32,8,64,256,128,8,256,32};
        var result = FindIfArrayCanBeSorted.canSortArray(input);

        assertTrue(result);
    }

    @Test
    void canSortArray4() {
        var input = new int[]{7, 1};
        var result = FindIfArrayCanBeSorted.canSortArray(input);

        assertFalse(result);
    }
}