package com.learn.leetcode.daily.q202409;

import java.util.Map;
import java.util.TreeMap;


/**
 * <a href="https://leetcode.com/problems/my-calendar-i/description/?envType=daily-question&envId=2024-09-26">Task</a>
 * <a href="">Explanation</a>
 */
public final class MyCalendar {
    private final TreeMap<Integer, Integer> calendar = new TreeMap<>();

    public MyCalendar() {
        calendar.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public boolean book(int start, int end) {
        final Map.Entry<Integer, Integer> pair = calendar.higherEntry(start);
        boolean res = end <= pair.getValue();
        if (res)
            calendar.put(end, start);
        return res;
    }
}
