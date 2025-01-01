package com.learn.leetcode.daily.a202501.easy;

/**
 * <a href="https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/?envType=daily-question&envId=2025-01-01">Task</a>
 * <br><a href="https://leetcode.com/problems/maximum-score-after-splitting-a-string/solutions/4204192/maximum-score-after-splitting-a-string/">Explanation</a>
 * <ul>Topics
 * <li> {@code String, Prefix Sum}
 * </ul>
 * <ul>Hints
 * <li> {@code Precompute a prefix sum of ones ('1').}
 * <li> {@code Iterate from left to right counting the number of zeros ('0'), then use the precomputed prefix sum for counting ones ('1'). Update the answer.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 2 <= s.length <= 500}
 * <li> {@code The string s consists of characters '0' and '1' only.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 01.01.25 12:25
 */
public final class MaximumScoreAfterSplittingString {

    /**
     * My solution.
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param s
     * @return the maximum score after splitting the string into two <b>non-empty</b> substrings (i.e. <b>left</b> substring and <b>right</b> substring).
     */
    public static int maxScore(String s) {
        final int N = s.length();
        final int[] arr = new int[N];
        int tmp_sum = 0;
        int result = 0;

        //hint #1
        for(int i = N - 1; i >= 0; i--) {
            if(s.charAt(i) == '1') {
                arr[i] = ++tmp_sum;
            }
        }
        tmp_sum = 0;

        //hint #2
        for(int i = 0; i < N - 1; i++) {
            if(s.charAt(i) == '0') {
                tmp_sum++;
            }
            int tmp = tmp_sum;
            if(arr[i + 1] != 0) {
                tmp += arr[i + 1];
            }
            result = Math.max(result, tmp);
        }

        return result;
    }

    /**
     * Approach 3: One Pass
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(1)}
     * </p>
     * @param s
     * @return the maximum score after splitting the string into two <b>non-empty</b> substrings (i.e. <b>left</b> substring and <b>right</b> substring).
     */
    public int maxScore_one_pass(String s) {
        int ones = 0;
        int zeros = 0;
        int best = Integer.MIN_VALUE;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            } else {
                zeros++;
            }

            best = Math.max(best, zeros - ones);
        }

        if (s.charAt(s.length() - 1) == '1') {
            ones++;
        }

        return best + ones;
    }
}
