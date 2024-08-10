package com.learn.leetcode.easy.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionOfTwoArrays2Test {

    @Test
    void intersect1() {
        final var arr1 = new int[]{1,2,2,1};
        final var arr2 = new int[]{2,2};
        final var expected = new int[]{2,2};

        final var result = IntersectionOfTwoArrays2.intersect(arr1, arr2);

        assertArrayEquals(expected, result);
    }

    @Test
    void intersect2() {
        final var arr1 = new int[]{4,9,5};
        final var arr2 = new int[]{9,4,9,8,4};
        final var expected = new int[]{4,9};

        final var result = IntersectionOfTwoArrays2.intersect(arr1, arr2);

        assertArrayEquals(expected, result);
    }

    @Test
    void intersect3() {
        final var arr1 = new int[]{1,2,3,4,5,5,5};
        final var arr2 = new int[]{5,7,8,5,6,5};
        final var expected = new int[]{5,5,5};

        final var result = IntersectionOfTwoArrays2.intersect(arr1, arr2);

        assertArrayEquals(expected, result);
    }

    @Test
    void intersect4() {
        final var arr1 = new int[]{987};
        final var arr2 = new int[]{987};
        final var expected = new int[]{987};

        final var result = IntersectionOfTwoArrays2.intersect(arr1, arr2);

        assertArrayEquals(expected, result);
    }

    @Test
    void intersect5() {
        final var arr1 = new int[]{987};
        final var arr2 = new int[]{987,987,987,987,987,987,987,987};
        final var expected = new int[]{987};

        final var result = IntersectionOfTwoArrays2.intersect(arr1, arr2);

        assertArrayEquals(expected, result);
    }

    @Test
    void intersect6() {
        final var arr1 = new int[]{1,2,2,1};
        final var arr2 = new int[]{2};
        final var expected = new int[]{2};

        final var result = IntersectionOfTwoArrays2.intersect(arr1, arr2);

        assertArrayEquals(expected, result);
    }

    @Test
    void intersect7() {
        final var arr1 = new int[]{5,5,5,5};
        final var arr2 = new int[]{5,5,5,5};
        final var expected = new int[]{5,5,5,5};

        final var result = IntersectionOfTwoArrays2.intersect(arr1, arr2);

        assertArrayEquals(expected, result);
    }

    @Test
    void intersect8() {
        final var arr1 = new int[]{5,5,5,5};
        final var arr2 = new int[]{3,3,3,3};
        final var expected = new int[]{};

        final var result = IntersectionOfTwoArrays2.intersect(arr1, arr2);

        assertArrayEquals(expected, result);
    }

    @Test
    void intersect9() {
        final var arr1 = new int[]{5,5,5,5,6,7,8,0,100,102,7};
        final var arr2 = new int[]{100,3,102,3,5,7,7};
        final var expected = new int[]{5,7,7,100,102};

        final var result = IntersectionOfTwoArrays2.intersect(arr1, arr2);

        assertArrayEquals(expected, result);
    }

    @Test
    void intersect10() {
        final var arr1 = new int[]{3,1,2};
        final var arr2 = new int[]{1,1};
        final var expected = new int[]{1};

        final var result = IntersectionOfTwoArrays2.intersect(arr1, arr2);

        assertArrayEquals(expected, result);
    }

    @Test
    void intersect11() {
        final var arr1 = new int[]{3,1,1,1,2};
        final var arr2 = new int[]{1,0,0,0,0,0,0,0,0,1};
        final var expected = new int[]{1,1};

        final var result = IntersectionOfTwoArrays2.intersect(arr1, arr2);

        assertArrayEquals(expected, result);
    }

    @Test
    void intersect12() {
        final var arr1 = new int[]{2,1};
        final var arr2 = new int[]{1,2};
        final var expected = new int[]{1,2};

        final var result = IntersectionOfTwoArrays2.intersect(arr1, arr2);

        assertArrayEquals(expected, result);
    }
}