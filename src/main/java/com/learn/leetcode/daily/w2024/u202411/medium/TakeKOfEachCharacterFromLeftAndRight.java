package com.learn.leetcode.daily.w2024.u202411.medium;

/**
 * <a href="https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/description/?envType=daily-question&envId=2024-11-20">Task</a>
 * <br><a href="https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/solutions/6064203/easy-solution-beats-100-two-pointer-c-java-python-javascript/">Explanation</a>
 * <ul>Topics
 * <li> {@code Hash table, String, Sliding Window}
 * </ul>
 * <ul>Hints
 * <li> {@code Start by counting the frequency of each character and checking if it is possible.}
 * <li> {@code If you take x characters from the left side, what is the minimum number of characters you need to take from the right side? Find this for all values of x in the range 0 ≤ x ≤ s.length.}
 * <li> {@code Use a two-pointers approach to avoid computing the same information multiple times.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= s.length <= 10^5}
 * <li> {@code s consists of only the letters 'a', 'b', and 'c'.}
 * <li> {@code 0 <= k <= s.length}
 * </ul>
 * <br>@since 1.0.0
 * <br> 20.11.24 08:27
 */
public final class TakeKOfEachCharacterFromLeftAndRight {

    /**
     * {@code Time Complexity O(N)}
     * {@code Space Complexity O(1)}
     *
     * @param s a string s consisting of the characters 'a', 'b', and 'c'
     * @param k non-negative integer
     * @return the minimum number of minutes needed for you to take at least {@code k} of each character, or return {@code -1} if it is not possible to take {@code k} of each character.
     */
    public static int takeCharacters(String s, int k) {
        int result = s.length();
        int a_cnt = 0, a = 0;
        int b_cnt = 0, b = 0;
        int c_cnt = 0, c = 0;

        for (int i = 0; i < s.length(); i++) {
            final var chr = s.charAt(i);
            if(chr == 'a') {
                a_cnt++;
            } else if(chr == 'b') {
                b_cnt++;
            } else if (chr == 'c') {
                c_cnt++;
            }
        }

        if (a_cnt < k || b_cnt < k || c_cnt < k) {
            return -1;
        }

        var start = 0;
        var end = s.length();
        var left = 0;
        while(start < end) {
            final var chr = s.charAt(start);
            if(chr == 'a') {
                a++;
            } else if(chr == 'b') {
                b++;
            } else if (chr == 'c') {
                c++;
            }
            start++;

            // Shrink window if it exceeds the limits
            while (a > a_cnt - k || b > b_cnt - k || c > c_cnt - k) {
                if (s.charAt(left) == 'a') {
                    a--;
                }
                if (s.charAt(left) == 'b') {
                    b--;
                }
                if (s.charAt(left) == 'c') {
                    c--;
                }
                left++;
            }

            // Update the answer with the minimum number of characters to remove
            result = Math.min(result, s.length() - (start - left));
        }

        return result;
    }
}
