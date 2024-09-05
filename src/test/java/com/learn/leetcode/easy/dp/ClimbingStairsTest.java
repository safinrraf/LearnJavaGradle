package com.learn.leetcode.easy.dp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(7, 21),
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(33, 5702887),
                Arguments.of(39, 102334155)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void climbStairs(int input, int expected) {
        assertEquals(expected, ClimbingStairs.climbStairs(input));
    }
}