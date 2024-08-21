package com.learn.leetcode.easy.strings;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/">Task</a>
 */
public final class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if(s.isBlank() || s.length()==1) {
            return true;
        }
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            var ch1 = Character.toLowerCase(s.charAt(begin));
            var ch2 = Character.toLowerCase(s.charAt(end));

            while(isNotAsciiAlphaNumericInLower(ch1)) {
                begin++;
                if(begin > end) {
                    return true;
                }
                ch1 = Character.toLowerCase(s.charAt(begin));
            }

            while(isNotAsciiAlphaNumericInLower(ch2)) {
                end--;
                if(end < begin) {
                    return true;
                }
                ch2 = Character.toLowerCase(s.charAt(end));
            }

            if(ch1 != ch2) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    public static boolean isNotAsciiAlphaNumericInLower(char ch) {
        return (ch < 'a' || ch > 'z') && (ch < '0' || ch > '9');
    }
}
