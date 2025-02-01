package com.learn.leetcode.daily.q202409;

import com.learn.leetcode.daily.w2024.q202409.MyCalendarTwo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCalendarTwoTest {

    private static final MyCalendarTwo OBJ = new MyCalendarTwo();

    @Test
    void book() {
        final var bookings = new int[][]{{},{10,20},{50,60},{10,40},{5,15},{5,10},{25,55}};
        final var result = new Boolean[bookings.length];
        final var expected = new Boolean[]{null, true, true, true, false, true, true};
        int count = 0;

        for(final var book: bookings) {
            if(book.length == 0) {
                result[count++] = null;
            } else {
                result[count++] = OBJ.book(book[0], book[1]);
            }
        }

        assertArrayEquals(expected, result);
    }
}