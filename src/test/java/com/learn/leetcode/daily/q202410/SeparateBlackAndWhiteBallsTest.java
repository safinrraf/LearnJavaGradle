package com.learn.leetcode.daily.q202410;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparateBlackAndWhiteBallsTest {

    @Test
    void minimumSteps1() {
        final var input = "101";
        final var expected = 1L;
        final var result = SeparateBlackAndWhiteBalls.minimumSteps(input);

        assertEquals(expected, result);
    }

    @Test
    void minimumSteps2() {
        final var input = "100";
        final var expected = 2L;
        final var result = SeparateBlackAndWhiteBalls.minimumSteps(input);

        assertEquals(expected, result);
    }

    @Test
    void minimumSteps3() {
        final var input = "0111";
        final var expected = 0L;
        final var result = SeparateBlackAndWhiteBalls.minimumSteps(input);

        assertEquals(expected, result);
    }

    @Test
    void minimumSteps4() {
        final var input = "101010100010001";
        final var expected = 33L;
        final var result = SeparateBlackAndWhiteBalls.minimumSteps(input);

        assertEquals(expected, result);
    }

    @Test
    void minimumSteps5() {
        final var input = "111111111111111111111111111111111111111110011";
        final var expected = 82L;
        final var result = SeparateBlackAndWhiteBalls.minimumSteps(input);

        assertEquals(expected, result);
    }

    @Test
    void minimumSteps6() {
        final var input = "1111110000000000000000000000000000000000001011";
        final var expected = 223L;
        final var result = SeparateBlackAndWhiteBalls.minimumSteps(input);

        assertEquals(expected, result);
    }

    @Test
    void minimumSteps7() {
        final var input = "11110000";
        final var expected = 16L;
        final var result = SeparateBlackAndWhiteBalls.minimumSteps(input);

        assertEquals(expected, result);
    }

    @Test
    void minimumSteps8() {
        final var input = "110011001100";
        final var expected = 24L;
        final var result = SeparateBlackAndWhiteBalls.minimumSteps(input);

        assertEquals(expected, result);
    }

    @Test
    void minimumSteps9() {
        final var input = "10101010";
        final var expected = 10L;
        final var result = SeparateBlackAndWhiteBalls.minimumSteps(input);

        assertEquals(expected, result);
    }

    @Test
    void minimumSteps10() {
        final var input = "10000";
        final var expected = 4L;
        final var result = SeparateBlackAndWhiteBalls.minimumSteps(input);

        assertEquals(expected, result);
    }

    @Test
    void minimumSteps11() {
        final var input = "10111110100001001001101111110111000001000100110001111101010011011101011101001101101" +
                "000110010110001001010001010001101001111010101111001101101011010001111101001101011011111001110" +
                "011111111011001010011001000000011010100010000010011011111010101010100100110000110100011000111" +
                "101001001101100001011011100000000001001110101110011110010110011100110111001010010011000101111" +
                "111000011111011000010011001000100011100000111101111111100001010000100100110010010101100000100" +
                "110010111111111000010010011001100000000111011010110101010011010101001001000001011111001010000" +
                "010011100100100100110000110001100001110011000010101011001010111011100101001010101111000110011" +
                "001111010001100010010100000001111001100101111000000010111001101101101010000101110010001101101" +
                "010001001111011001011011110101001110010101001100100100111110101001100001011111111101001010110" +
                "001111111011011101011101101100110100110011000110001000000101011101100101111010101100110101100" +
                "110100100000000011101101001000111010010101010111111110000100111101100010010110010001111010001" +
                "100010101010101100100101111001101111101110101000010000101010000010110100101111110111100010110" +
                "010001110110101000110100100001111101100111000011110100100111101110010110100011001110110101010" +
                "111011100101100100110100111001110000101000011001111011100101000111010111100110111101011101101" +
                "100001101100111110000101011010001000111111100011101110100111110101100110011010100010100111011" +
                "00000011101001100010101101000111100";
        final var expected = 245899L;
        final var result = SeparateBlackAndWhiteBalls.minimumSteps(input);

        assertEquals(expected, result);
    }

    @Test
    void minimumSteps12() {
        final var input = "001110001110001";
        final var expected = 27L;
        final var result = SeparateBlackAndWhiteBalls.minimumSteps(input);

        assertEquals(expected, result);
    }
}