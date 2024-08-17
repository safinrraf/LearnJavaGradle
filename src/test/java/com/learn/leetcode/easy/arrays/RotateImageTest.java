package com.learn.leetcode.easy.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateImageTest {

    @Test
    void rotate1() {
        final var input = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        final var expected = new int[][]{
                {7,4,1},
                {8,5,2},
                {9,6,3}};

        RotateImage.rotate(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void rotate2() {
        final var input = new int[][]{
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}};
        final var expected = new int[][]{
                {15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}};

        RotateImage.rotate(input);
        assertArrayEquals(expected, input);
    }
}