package com.learn.leetcode.easy.dp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciBottomUpTabulationTest {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(0L, 0L),
                Arguments.of(1L, 1L),
                Arguments.of(2L, 1L),
                Arguments.of(3L, 2L),
                Arguments.of(4L, 3L),
                Arguments.of(5L, 5L),
                Arguments.of(6L, 8L),
                Arguments.of(7L, 13L),
                Arguments.of(8L, 21L),
                Arguments.of(9L, 34L),
                Arguments.of(10L, 55L),
                Arguments.of(11L, 89L),
                Arguments.of(12L, 144L),
                Arguments.of(13L, 233L),
                Arguments.of(14L, 377L),
                Arguments.of(15L, 610L),
                Arguments.of(33L, 3524578L),
                Arguments.of(78L, 8944394323791464L)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void fibonacciBottomUpTabulation(long input, long expected) {
        assertEquals(expected, FibonacciBottomUpTabulation.fibonacciBottomUpTabulation(input));
    }
}