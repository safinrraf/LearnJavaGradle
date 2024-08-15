package com.learn.leetcode.easy.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/">Task</a>
 * */
@Slf4j
public final class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        final Set<Character> setRow = new HashSet<>(9);
        final Set<Character> setColumn = new HashSet<>(9);
        final Set<Character> setSquare = new HashSet<>(9);
        char squareNum, rowNum, columnNum, dot = '.';
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                rowNum = board[i][j];
                columnNum = board[j][i];
                squareNum = board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3];
                if(setRow.contains(rowNum)
                        || setColumn.contains(columnNum)
                        || setSquare.contains(squareNum)) {
                    return false;
                }
                if (rowNum != dot){
                    setRow.add(rowNum);
                }
                if (columnNum != dot){
                    setColumn.add(columnNum);
                }
                if (squareNum != dot){
                    setSquare.add(squareNum);
                }
            }
            setRow.clear();
            setColumn.clear();
            setSquare.clear();
        }
        return true;
    }

    public static boolean isValidSudoku_(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int squareNumMask = 511;
            int rowNumMask = 511;
            int columnNumMask = 511;
            for (int j = 0; j < 9; j++) {
                rowNumMask ^= (1 << board[i][j] - 1);
                columnNumMask ^= (1 << (board[j][i] - 1));
                squareNumMask ^= (1 << (board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3] - 1));
            }
            if (rowNumMask != 0 || squareNumMask != 0 || columnNumMask != 0)
                return false;
        }
        return true;
    }
}
