package com.learn.leetcode.daily.q202409;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomStackTest {

    private static final CustomStack CUSTOM_STACK = new CustomStack(3);

    @Test
    void push() {
        CUSTOM_STACK.push(1);
        System.out.println(CUSTOM_STACK);
        CUSTOM_STACK.push(2);
        System.out.println(CUSTOM_STACK);
        assertEquals(2, CUSTOM_STACK.pop());
        System.out.println(CUSTOM_STACK);
        CUSTOM_STACK.push(2);
        System.out.println(CUSTOM_STACK);
        CUSTOM_STACK.push(3);
        System.out.println(CUSTOM_STACK);
        CUSTOM_STACK.increment(5, 100);
        System.out.println(CUSTOM_STACK);
        CUSTOM_STACK.increment(2, 100);
        System.out.println(CUSTOM_STACK);
        assertEquals(103, CUSTOM_STACK.pop());
        assertEquals(202, CUSTOM_STACK.pop());
        assertEquals(201, CUSTOM_STACK.pop());
        assertEquals(-1, CUSTOM_STACK.pop());
    }

    @Test
    void pop() {
    }

    @Test
    void increment() {
    }
}