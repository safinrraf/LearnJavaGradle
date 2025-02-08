package com.learn.leetcode.daily.b202502.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DesignNumberContainerSystemTest {

    @Test
    void test1() {
        final String[] input = {"NumberContainers", "find", "change", "change", "change", "change", "find", "change", "find"};
        final int[][] params = {{}, {10}, {2, 10}, {1, 10}, {3, 10}, {5, 10}, {10}, {1, 20}, {10}};
        final int result1 = -1;
        final int result2 = 1;
        final int result3 = 2;
        int answer;

        DesignNumberContainerSystem obj = new DesignNumberContainerSystem();

        for(int i = 1; i < input.length; i++) {
            switch (i) {
                case 1:
                    answer = obj.find(params[i][0]);
                    assertEquals(result1, answer, "find for 10 should be -1");
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                    obj.change(params[i][0], params[i][1]);
                    break;
                case 6:
                    answer = obj.find(params[i][0]);
                    assertEquals(result2, answer, "find for 10 should be 1");
                    break;
                case 8:
                    answer = obj.find(params[i][0]);
                    assertEquals(result3, answer, "find for 10 should be 2");
                    break;
            }
        }
    }

    @Test
    void test2() {
        final String[] input = {"NumberContainers","change","find","change","find","find","find"};
        final int[][] params = {{}, {1, 10}, {10}, {1, 20}, {10}, {20}, {30}};
        final int result1 = -1;
        final int result2 = 1;
        final int result3 = 2;
        int answer;

        DesignNumberContainerSystem obj = new DesignNumberContainerSystem();

        //change
        obj.change(1, 10);
        //find
        final int answer1 = obj.find(10);
        assertEquals(1, answer1, "1 for 10");

        //change
        obj.change(1, 20);
        //find
        final int answer2 = obj.find(10);
        assertEquals(-1, answer2, "-1 for 10");
    }
}