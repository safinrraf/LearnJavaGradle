package com.learn.leetcode.daily.w2024.q202409;

import java.util.TreeMap;

/**
 * <a href="https://leetcode.com/problems/my-calendar-ii/description/?envType=daily-question&envId=2024-09-27">Task</a>
 * <br><a href="https://leetcode.com/problems/my-calendar-ii/solutions/5838424/full-sweep-line-concept-dry-run-illustration-brute-submission-faster/?envType=daily-question&envId=2024-09-27">Explanation</a>
 * <p>Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 * </p>
 */
public final class MyCalendarTwo {
    private final TreeMap<Integer, Integer> events;

    public MyCalendarTwo() {
        events = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // Increment start by +1 (start of booking)
        events.put(start, events.getOrDefault(start, 0) + 1);
        // Decrement end by -1 (end of booking)
        events.put(end, events.getOrDefault(end, 0) - 1);

        int activeBookings = 0;

        // Sweep through the events in chronological order
        for (int count : events.values()) {
            activeBookings += count;

            // If we have 3 or more overlapping bookings, it's a triple booking
            if (activeBookings >= 3) {
                // Revert the changes, as the booking is not valid
                events.put(start, events.get(start) - 1);
                events.put(end, events.get(end) + 1);

                // Remove from map if count reaches zero
                if (events.get(start) == 0) {
                    events.remove(start);
                }
                if (events.get(end) == 0) {
                    events.remove(end);
                }

                return false; // Booking failed
            }

            if (events.higherKey(start) != null && events.higherKey(start) > end) {
                break; // No need to check further
            }
        }

        // Booking is successful if no triple booking is found
        return true;
    }
}
