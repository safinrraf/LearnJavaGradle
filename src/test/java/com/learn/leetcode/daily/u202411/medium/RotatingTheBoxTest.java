package com.learn.leetcode.daily.u202411.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code ..., ..., ...}
 * </ul>
 * <ul>Hints
 * <li> {@code ...}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 ...}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 23.11.24 21:04
 */
class RotatingTheBoxTest {

    @Test
    void rotateTheBox1() {
        final char[][] box = {{'#','.','#'}};
        final char[][] expected = {
                {'.'},
                {'#'},
                {'#'}};
        final char[][] result = RotatingTheBox.rotateTheBox(box);

        RotatingTheBox.printBox(result);

        assertArrayEquals(expected, result);
    }

    @Test
    void rotateTheBox2() {
        final char[][] box = {  {'#','.','*','.'},
                                {'#','#','*','.'} };
        final char[][] expected = {
                {'#','.'},
                {'#','#'},
                {'*','*'},
                {'.','.'}};
        final char[][] result = RotatingTheBox.rotateTheBox(box);

        RotatingTheBox.printBox(result);

        assertArrayEquals(expected, result);
    }

    @Test
    void rotateTheBox3() {
        final char[][] box = {
                {'#','#','*','.','*','.'},
                {'#','#','#','*','.','.'},
                {'#','#','#','.','#','.'}
        };
        final char[][] expected = {
                {'.','#','#'},
                {'.','#','#'},
                {'#','#','*'},
                {'#','*','.'},
                {'#','.','*'},
                {'#','.','.'},
        };
        final char[][] result = RotatingTheBox.rotateTheBox(box);

        RotatingTheBox.printBox(result);

        assertArrayEquals(expected, result);
    }
}