package com.learn.leetcode.daily.w2024.q202410.medium;

/**
 * <a href="https://leetcode.com/problems/separate-black-and-white-balls/description/?envType=daily-question&envId=2024-10-15">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Two Pointers, Greedy, String}
 * </ul>
 * <ul>Hints
 * <li>Every {@code 1} in the string {@code s} should be swapped with every {@code 0} on its right side.
 * <li>Iterate right to left and count the number of {@code 0} that have already occurred, whenever you iterate on {@code 1} add that counter to the answer.
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= n == s.length <= 105}
 * <li> {@code s[i] is either '0' or '1'.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 15.10.24 20:17
 */
public final class SeparateBlackAndWhiteBalls {
    /**
     * <p>Time complexity {@code O(N)}</p>
     * <p>Space complexity {@code O(1)}</p>
     * @param s input string
     * @return Return the minimum number of steps to group all the black balls to the right and all the white balls to the left.
     */
    public static long minimumSteps(String s) {
        long zero = 0L;
        long result = 0L;
        for(int i = s.length() - 1; i >= 0 ; i--) {
            if (s.charAt(i) == '0') {
                zero++;
            } else {
                result += zero;
            }
        }
        return result;
    }
}
