package com.learn.leetcode.easy.strings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/">Task</a>
 */
public final class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        final var result = new StringBuilder();
        final var sample = strs[0];

        for(int i = 0; i < sample.length(); i++) {
            final var ch = sample.charAt(i);

            for(int j = 1; j < strs.length; j++) {
                if(strs[j].charAt(i) != ch){
                    return result.toString();
                }
            }
            result.append(ch);
        }
        return result.toString();
    }
}
