package com.learn.leetcode.daily.q202409;

import com.learn.leetcode.daily.w2024.q202409.FindTheLengthOfTheLongestCommonPrefix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTheLengthOfTheLongestCommonPrefixTest {

    @Test
    void longestCommonPrefix1() {
        final var arr1 = new int[]{1, 10, 100};
        final var arr2 = new int[]{1000};
        final var result = FindTheLengthOfTheLongestCommonPrefix.longestCommonPrefix(arr1, arr2);

        assertEquals(3, result);
    }
}