package com.learn.leetcode.easy.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateArrayTest {
    @Test
    void rotateTest1() {
        final int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        final int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        RotateArray.rotate(input, 1);

        assertArrayEquals(expected, input);
    }

    @Test
    void rotateTest2() {
        final int[] input = {1};
        final int[] expected = {1};
        RotateArray.rotate(input, 1000);

        assertArrayEquals(expected, input);
    }

    @Test
    void rotateTest3() {
        final int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        final int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        RotateArray.rotate(input, 0);

        assertArrayEquals(expected, input);
    }

    @Test
    void rotateTest4() {
        final int[] input = {1,2,3,4,5,6,7};
        final int[] expected = {5,6,7,1,2,3,4};
        RotateArray.rotate(input, 3);

        assertArrayEquals(expected, input);
    }

    @Test
    void rotateTest5() {
        final int[] input = {-1,-100,3,99};
        final int[] expected = {3,99,-1,-100};
        RotateArray.rotate(input, 2);

        assertArrayEquals(expected, input);
    }
}