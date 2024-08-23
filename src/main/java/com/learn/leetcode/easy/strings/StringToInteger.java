package com.learn.leetcode.easy.strings;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/884/">Task</a>
 */
public final class StringToInteger {
    public static int myAtoi(String s) {
        long resultLong = 0;
        int resultInt ;
        int numCount = 0;
        boolean negative = false;

        for(int i = 0; i < s.length(); i++) {
            final var ch = s.charAt(i);

            if (ch == ' ' && numCount == 0) {
                continue;
            }

            //if the input string begins with non-Arithmetic char.
            if(isNotNumericIn(ch)) {
                break;
            }

            if(ch == '+' && numCount == 0) {
                numCount++;
                continue;
            }

            if(ch == '-' && numCount == 0) {
                negative = true;
                numCount++;
                continue;
            }

            if (isNotNumericInStrict(ch) && numCount!=0) {
                break;
            }

            if ((resultLong * 10 + (ch - '0')) > (long) Integer.MAX_VALUE) {
                resultLong = Integer.MAX_VALUE ;
                break;
            } else if ((resultLong * 10 - (ch - '0')) < (long) Integer.MIN_VALUE) {
                resultLong = Integer.MIN_VALUE ;
                break;
            }else {
                if (!negative) {
                    resultLong = resultLong * 10 + (ch - '0');
                } else {
                    resultLong = resultLong * 10 - (ch - '0');
                }
                numCount++;
            }
        }

        resultInt = (int) resultLong;

        return resultInt;
    }

    public static boolean isNotNumericIn(char ch) {
        return (ch < '0' || ch > '9') && ch != '-' && ch != '+' && ch != ' ';
    }

    public static boolean isNotNumericInStrict(char ch) {
        return (ch < '0' || ch > '9');
    }
}
