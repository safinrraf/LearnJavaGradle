package com.learn.leetcode.daily.a202501.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FirstCompletelyPaintedRowOrColumnTest {

    @Test
    void firstCompleteIndex1() {
        final int[] arr = {1,3,4,2};
        final int[][] mat = {{1,4}, {2,3}};
        final int expected = 2;
        final int answer = FirstCompletelyPaintedRowOrColumn.firstCompleteIndex(arr, mat);

        assertEquals(expected, answer);
    }

    @Test
    void firstCompleteIndex2() {
        final int[] arr = {2,8,7,4,1,3,5,6,9};
        final int[][] mat = {{3,2,5}, {1,4,6}, {8,7,9}};
        final int expected = 3;
        final int answer = FirstCompletelyPaintedRowOrColumn.firstCompleteIndex(arr, mat);

        assertEquals(expected, answer);
    }
}