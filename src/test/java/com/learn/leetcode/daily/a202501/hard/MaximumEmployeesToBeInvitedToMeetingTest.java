package com.learn.leetcode.daily.a202501.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumEmployeesToBeInvitedToMeetingTest {

    @Test
    void maximumInvitations1() {
        final int[] favorite = {2,2,1,2};
        final int expected = 3;
        final int answer = MaximumEmployeesToBeInvitedToMeeting.maximumInvitations(favorite);

        assertEquals(expected, answer);
    }

    @Test
    void maximumInvitations2() {
        final int[] favorite = {1,2,0};
        final int expected = 3;
        final int answer = MaximumEmployeesToBeInvitedToMeeting.maximumInvitations(favorite);

        assertEquals(expected, answer);
    }

    @Test
    void maximumInvitations3() {
        final int[] favorite = {3,0,1,4,1};
        final int expected = 4;
        final int answer = MaximumEmployeesToBeInvitedToMeeting.maximumInvitations(favorite);

        assertEquals(expected, answer);
    }
}