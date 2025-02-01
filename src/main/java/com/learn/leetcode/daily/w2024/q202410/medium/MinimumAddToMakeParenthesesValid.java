package com.learn.leetcode.daily.w2024.q202410.medium;

/**
 * <a href="https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/?envType=daily-question&envId=2024-10-09">Task</a>
 * <br><a href="https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/solutions/5888626/easy-solution-no-stack-python-java-c-c-c-go-rust-o-n-o-1/?envType=daily-question&envId=2024-10-09">Explanation</a>
 * <li> Time Complexity {@code O(N)}
 * <li> Space Complexity {@code O(1)}
 * </p>
 * <br>@since 1.0.0
 * <br> 09.10.24 20:24
 * </p>
 */
public final class MinimumAddToMakeParenthesesValid {
    private static final char OB = '(';
    private static final char CB = ')';

    public static int minAddToMakeValid(String s) {
        int ob_count = 0;
        int cb_count = 0;

        for (final var c : s.toCharArray()) {
            if (c == OB) {
                ob_count++;
            } else if (c == CB && ob_count > 0) {
                ob_count--;
            } else {
                cb_count++;
            }
        }
        return ob_count + cb_count;
    }
}
