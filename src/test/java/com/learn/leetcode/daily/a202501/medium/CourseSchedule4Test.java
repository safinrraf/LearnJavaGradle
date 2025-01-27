package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseSchedule4Test {

    @Test
    void checkIfPrerequisite1() {
        final int numCourses = 2;
        final int[][] prerequisites = {{1, 0}};
        final int[][] queries = {{0, 1}, {1, 0}};
        final List<Boolean> expected = List.of(false,true);
        final List<Boolean> answer = CourseSchedule4.checkIfPrerequisite(numCourses, prerequisites, queries);

        assertEquals(expected, answer);
    }

    @Test
    void checkIfPrerequisite2() {
        final int numCourses = 2;
        final int[][] prerequisites = {};
        final int[][] queries = {{1, 0}, {0, 1}};
        final List<Boolean> expected = List.of(false,false);
        final List<Boolean> answer = CourseSchedule4.checkIfPrerequisite(numCourses, prerequisites, queries);

        assertEquals(expected, answer);
    }

    @Test
    void checkIfPrerequisite3() {
        final int numCourses = 3;
        final int[][] prerequisites = {{1, 2}, {1, 0}, {2, 0}};
        final int[][] queries = {{1, 0}, {1, 2}};
        final List<Boolean> expected = List.of(true,true);
        final List<Boolean> answer = CourseSchedule4.checkIfPrerequisite(numCourses, prerequisites, queries);

        assertEquals(expected, answer);
    }
}