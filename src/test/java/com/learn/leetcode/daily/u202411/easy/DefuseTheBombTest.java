package com.learn.leetcode.daily.u202411.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefuseTheBombTest {

    @Test
    void decrypt1() {
        final int[] code = {5,7,1,4};
        final int k = 3;
        final int[] expected = {12,10,16,13};
        final int[] result = DefuseTheBomb.decrypt(code, k);

        assertArrayEquals(expected, result);
    }

    @Test
    void decrypt2() {
        final int[] code = {1,2,3,4};
        final int k = 0;
        final int[] expected = {0,0,0,0};
        final int[] result = DefuseTheBomb.decrypt(code, k);

        assertArrayEquals(expected, result);
    }

    @Test
    void decrypt2_1() {
        final int[] code = {1};
        final int k = 0;
        final int[] expected = {0};
        final int[] result = DefuseTheBomb.decrypt(code, k);

        assertArrayEquals(expected, result);
    }

    @Test
    void decrypt3() {
        final int[] code = {2,4,9,3};
        final int k = -2;
        final int[] expected = {12,5,6,13};
        final int[] result = DefuseTheBomb.decrypt(code, k);

        assertArrayEquals(expected, result);
    }

    @Test
    void decrypt4() {
        final int[] code = {2,4,9,3};
        final int k = 1;
        final int[] expected = {4,9,3,2};
        final int[] result = DefuseTheBomb.decrypt(code, k);

        assertArrayEquals(expected, result);
    }

    @Test
    void decrypt5() {
        final int[] code = {2,4,9,3};
        final int k = -1;
        final int[] expected = {3,2,4,9};
        final int[] result = DefuseTheBomb.decrypt(code, k);

        assertArrayEquals(expected, result);
    }

    @Test
    void decrypt6() {
        final int[] code = {0,0,0,0};
        final int k = -1;
        final int[] expected = {0,0,0,0};
        final int[] result = DefuseTheBomb.decrypt(code, k);

        assertArrayEquals(expected, result);
    }

    @Test
    void decrypt7() {
        final int[] code = {1,1,1,1};
        final int k = -10;
        final int[] expected = {10,10,10,10};
        final int[] result = DefuseTheBomb.decrypt(code, k);

        assertArrayEquals(expected, result);
    }

    @Test
    void decrypt8() {
        final int[] code = {1,1,1,1};
        final int k = 10;
        final int[] expected = {10,10,10,10};
        final int[] result = DefuseTheBomb.decrypt(code, k);

        assertArrayEquals(expected, result);
    }

    @Test
    void decrypt9() {
        final int[] code = {1};
        final int k = 10;
        final int[] expected = {10};
        final int[] result = DefuseTheBomb.decrypt(code, k);

        assertArrayEquals(expected, result);
    }
}