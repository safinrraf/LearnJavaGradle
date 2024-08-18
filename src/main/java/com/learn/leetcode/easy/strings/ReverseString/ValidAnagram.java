package com.learn.leetcode.easy.strings.ReverseString;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/">Task</a>
 */
public final class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        final var intArr1 = s.codePoints().toArray();
        final var intArr2 = t.codePoints().toArray();

        Arrays.sort(intArr1);
        Arrays.sort(intArr2);

        return Arrays.equals(intArr1, intArr2);
    }
}
