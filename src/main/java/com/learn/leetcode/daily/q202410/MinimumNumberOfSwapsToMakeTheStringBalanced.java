package com.learn.leetcode.daily.q202410;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/?envType=daily-question&envId=2024-10-08">Task</a>
 * <br><a href="https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/solutions/5884227/easy-optimized-solution-python-java-c-o-n-o-1/">Explanation</a>
 * <p>
 * <li>Hint 1: Iterate over the string and keep track of the number of opening and closing brackets on each step.
 * <li>Hint 2: If the number of closing brackets is ever larger, you need to make a swap.
 * <li>Hint 3: Swap it with the opening bracket closest to the end of s.
 * </p>
 * <p>
 * <li> Time Complexity {@code O(N)}
 * <li> Space Complexity {@code O(1)}
 * </p>
 * <p>
 * <br> @since 1.0.0
 * <br> 08.10.24 09:06
 * </p>
 */
public final class MinimumNumberOfSwapsToMakeTheStringBalanced {
    private static final char OB = '[';

    public static int minSwaps(String s) {
        var ob_count = 0;
        for (int i = 0; i < s.length(); i++) {
            final var c1 = s.charAt(i);

            if (c1 == OB) {
                ob_count++;
            } else if (ob_count > 0) {
                ob_count--;
            }
        }

        return (ob_count + 1) / 2;
    }
}
