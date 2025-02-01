package com.learn.leetcode.daily.u202411.medium;

import com.learn.leetcode.daily.w2024.u202411.medium.ShortestSubarrayToBeRemovedToMakeArraySorted;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ShortestSubarrayToBeRemovedToMakeArraySortedTest {

    @Test
    void findLengthOfShortestSubarray1() {
        final int[] arr = {1,2,3,10,4,2,3,5};
        final var expected = 3;
        final var result = ShortestSubarrayToBeRemovedToMakeArraySorted.findLengthOfShortestSubarray(arr);

        assertEquals(expected, result);
    }

    @Test
    void findLengthOfShortestSubarray2() {
        final int[] arr = {5,4,3,2,1};
        final var expected = 4;
        final var result = ShortestSubarrayToBeRemovedToMakeArraySorted.findLengthOfShortestSubarray(arr);

        assertEquals(expected, result);
    }

    @Test
    void findLengthOfShortestSubarray3() {
        final int[] arr = {1,2,3};
        final var expected = 0;
        final var result = ShortestSubarrayToBeRemovedToMakeArraySorted.findLengthOfShortestSubarray(arr);

        assertEquals(expected, result);
    }

    @Test
    void findLengthOfShortestSubarray4() {
        final int[] arr = {2,2,2,1,1,1};
        final var expected = 3;
        final var result = ShortestSubarrayToBeRemovedToMakeArraySorted.findLengthOfShortestSubarray(arr);

        assertEquals(expected, result);
    }

    @Test
    void findLengthOfShortestSubarray5() {
        final int[] arr = {1,2,3,10,0,7,8,9};
        final var expected = 2;
        final var result = ShortestSubarrayToBeRemovedToMakeArraySorted.findLengthOfShortestSubarray(arr);

        assertEquals(expected, result);
    }
}