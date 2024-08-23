package com.learn.leetcode.easy.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringToIntegerTest {

    private static Stream<Arguments> myAtoiTestSource() {
        return Stream.of(
                Arguments.of("-9947483648", -2147483648),
                Arguments.of("1337c0d3", 1337),
                Arguments.of("-1234569", -1234569),
                Arguments.of("0-1", 0),
                Arguments.of("42", 42),
                Arguments.of("-042", -42),
                Arguments.of("   -012", -12),
                Arguments.of("   -018sdf", -18),
                Arguments.of("words and 987", 0),
                Arguments.of("-2147483648", -2147483648),
                Arguments.of("2147483647", 2147483647),
                Arguments.of("9947483647", 2147483647),
                Arguments.of("ABC", 0),
                Arguments.of("-0", 0),
                Arguments.of("-1sdfghjk", -1),
                Arguments.of("", 0),
                Arguments.of("9223372036854775808", 2147483647)
        );
    }

    private static Stream<Arguments> isNotNumericInTestSource() {
        return Stream.of(
                Arguments.of('-', false),
                Arguments.of('c', true),
                Arguments.of(' ', true),
                Arguments.of('9', false),
                Arguments.of('8', false),
                Arguments.of('7', false),
                Arguments.of('6', false),
                Arguments.of('5', false),
                Arguments.of('4', false),
                Arguments.of('3', false),
                Arguments.of('2', false),
                Arguments.of('1', false),
                Arguments.of('0', false),
                Arguments.of('°', true),
                Arguments.of('~', true),
                Arguments.of('U', true)
        );
    }

    @ParameterizedTest
    @MethodSource("myAtoiTestSource")
    void myAtoi(String input, int expected) {
        assertEquals(expected, StringToInteger.myAtoi(input));
    }

    @ParameterizedTest
    @MethodSource("isNotNumericInTestSource")
    void isNotNumericIn(char input, Boolean expected) {
        assertEquals(expected, StringToInteger.isNotNumericIn(input));
    }
}