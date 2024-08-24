package com.learn.leetcode.easy.strings;

/**
 * <a href="https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/885/">Task</a>
 */
public final class ImplementStrStr {
    public static int strStrWithIndexOf(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.isEmpty()) {
            return -1;
        }

        final var first = needle.charAt(0);
        final var max = (haystack.length() - needle.length());

        for (int i = 0; i <= max; i++) {
            if (haystack.charAt(i) != first) {
                while (++i <= max && haystack.charAt(i) != first);
            }

            if (i <= max) {
                int j = i + 1;
                int end = j + needle.length() - 1;
                for (int k = 1; j < end && haystack.charAt(j) == needle.charAt(k); j++, k++);
                if (j == end) {
                    // Found whole string.
                    return i;
                }
            }
        }

        return -1;
    }
}
