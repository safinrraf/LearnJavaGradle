package com.learn.leetcode.daily.b202502.easy;


/**
 * <a href="https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description/?envType=daily-question&envId=2025-02-05">Task</a>
 * <br><a href="https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/editorial/">Explanation</a>
 * <ul>Topics
 * <li> {@code Hash Table, String, Counting}
 * </ul>
 * <ul>Hints
 * <li> {@code The answer is false if the number of nonequal positions in the strings is not equal to 0 or 2.}
 * <li> {@code Check that these positions have the same set of characters.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= s1.length, s2.length <= 100}
 * <li> {@code s1.length == s2.length}
 * <li> {@code s1 and s2 consist of only lowercase English letters.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 05.02.25 08:29
 */
public final class CheckIfOneStringSwapCanMakeStringsEqual {

    /**
     *
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(N + M)}
     * </p>
     * @param s1
     * @param s2
     * @return {@code true} if it is possible to make both strings equal by performing <b>at most one string swap</b> on <b>exactly one</b> of the strings. Otherwise, return {@code false}.
     */
    public static boolean areAlmostEqual(String s1, String s2) {
        final char[] charArray1 = s1.toCharArray();
        final char[] charArray2 = s2.toCharArray();
        int diff_cnt = 0;
        char tmp1 = '0';
        char tmp2 = '0';
        for (int i = 0; i < charArray1.length; i++) {
            if(charArray1[i] != charArray2[i]) {
                diff_cnt++;
                if(diff_cnt == 1) {
                    tmp1 = charArray1[i];
                    tmp2 = charArray2[i];
                } else {
                    if(tmp1 != charArray2[i] || tmp2 != charArray1[i]) {
                        return false;
                    }
                }
            }
            if(diff_cnt > 2) {
                return false;
            }
        }

        return diff_cnt == 0 || diff_cnt == 2;
    }

    /**
     * Approach 2: Only Check Differences.
     * <p>
     * {@code Time Complexity O(...)}<br>
     * {@code Space Complexity O(...)}
     * </p>
     * @param s1
     * @param s2
     * @return {@code true} if it is possible to make both strings equal by performing <b>at most one string swap</b> on <b>exactly one</b> of the strings. Otherwise, return {@code false}.
     */
    public boolean areAlmostEqual_not_mine(String s1, String s2) {
        int firstIndexDiff = 0;
        int secondIndexDiff = 0;
        int numDiffs = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                numDiffs++;
                // numDiffs is more than 2, one string swap will not make two strings equal
                if (numDiffs > 2) return false;
                else if (numDiffs == 1) {
                    // store the index of first difference
                    firstIndexDiff = i;
                } else {
                    // store the index of second difference
                    secondIndexDiff = i;
                }
            }
        }
        // check if swap is possible
        return (
                s1.charAt(firstIndexDiff) == s2.charAt(secondIndexDiff) &&
                        s1.charAt(secondIndexDiff) == s2.charAt(firstIndexDiff)
        );
    }
}
