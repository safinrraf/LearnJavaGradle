package com.learn.leetcode.easy.strings.ReverseString;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/">Task</a>
 */
public final class ReverseString {
    public static void reverseString(char[] s) {
        char temp;
        for(int i = 0; i < s.length / 2; i++) {
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}
