package com.learn.leetcode.daily.u202411.medium;


/**
 * <a href="https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/description/?envType=daily-question&envId=2024-11-05">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code String}
 * </ul>
 * <ul>Hints
 * <li> {@code For any valid partition, since each part consists of an even number of the same characters, we can further partition each part into lengths of exactly 2.}
 * <li> {@code After noticing the first hint, we can decompose the whole string into disjoint blocks of size 2 and find the minimum number of changes required to make those blocks beautiful.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 2 <= s.length <= 10^5}
 * <li> {@code s has an even length.}
 * <li> {@code s[i] is either '0' or '1'.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 05.11.24 08:17
 */
public final class MinimumNumberOfChangesToMakeBinaryStringBeautiful {

    /**
     * <p>You are given a 0-indexed binary string s having an even length.</p>
     * @param s
     * @return the minimum number of changes required to make the string {@code s} beautiful.
     */
    public static int minChanges(String s) {
        var result = 0;
        for(int i = 1; i < s.length(); i += 2) {
            if(s.charAt(i) != s.charAt(i-1)) {
                result++;
            }
        }
        return result;
    }
}
