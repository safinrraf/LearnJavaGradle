package com.learn.leetcode.daily.x202412.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AddingSpacesToStringTest {

    @Test
    void addSpaces1() {
        final String s = "EnjoyYourCoffee";
        final int[] spaces = {5, 9};
        final String expected = "Enjoy Your Coffee";
        final String result = AddingSpacesToString.addSpaces(s, spaces);

        assertEquals(expected, result);
    }

    @Test
    void addSpaces2() {
        final String s = "LeetcodeHelpsMeLearn";
        final int[] spaces = {8,13,15};
        final String expected = "Leetcode Helps Me Learn";
        final String result = AddingSpacesToString.addSpaces(s, spaces);

        assertEquals(expected, result);
    }

    @Test
    void addSpaces3() {
        final String s = "icodeinpython";
        final int[] spaces = {1,5,7,9};
        final String expected = "i code in py thon";
        final String result = AddingSpacesToString.addSpaces(s, spaces);

        assertEquals(expected, result);
    }

    @Test
    void addSpaces4() {
        final String s = "spacing";
        final int[] spaces = {0,1,2,3,4,5,6};
        final String expected = " s p a c i n g";
        final String result = AddingSpacesToString.addSpaces(s, spaces);

        assertEquals(expected, result);
    }

    @Test
    void addSpaces5() {
        final String s = "q";
        final int[] spaces = {0};
        final String expected = " q";
        final String result = AddingSpacesToString.addSpaces(s, spaces);

        assertEquals(expected, result);
    }

    @Test
    void addSpaces6() {
        final String s = "ASDFGHJKLKJHGFD";
        final int[] spaces = {9,11};
        final String expected = "ASDFGHJKL KJ HGFD";
        final String result = AddingSpacesToString.addSpaces(s, spaces);

        assertEquals(expected, result);
    }
}