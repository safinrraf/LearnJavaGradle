package com.learn.leetcode.daily.w2024.q202409;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/description/?envType=daily-question&envId=2024-09-15">Task</a>
 * <a href="https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/solutions/5788167/easiest-approach-fully-explained-must-watch/?envType=daily-question&envId=2024-09-15">Explanation</a>
 */
public final class FindTheLongestSubstringContainingVowelsInEvenCounts {
    private static final boolean[] IS_VOWEL = new boolean[]{true, false, false, false, true, false, false, false, true, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, false, false};
    private static final int[] XOR = new int[]{1, 0, 0, 0, 2, 0, 0, 0, 4, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0};

    public static int findTheLongestSubstring(String s) {
        final var n = s.length();
        //Map contains a mask (K) and an index (V)
        final var map = new HashMap<>(Map.of(0, -1));
        int mask = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            mask = switch (s.charAt(i)) {
                case 'a' -> mask ^ 1;
                case 'e' -> mask ^ (1 << 1);
                case 'i' -> mask ^ (1 << 2);
                case 'o' -> mask ^ (1 << 3);
                case 'u' -> mask ^ (1 << 4);
                default -> mask;
            };

            if (map.containsKey(mask)) {
                maxLength = Math.max(maxLength, i - map.get(mask));
            } else {
                map.put(mask, i);
            }
        }
        return maxLength;
    }

    public int findTheLongestSubstring_(String s) {
        final int[] earliest = new int[32];
        Arrays.fill(earliest, -2);
        earliest[0] = -1;
        final char[] cs = s.toCharArray();
        int key = 0;
        int longest = 0;
        for (int i = 0; i < cs.length; i++) {
            if (IS_VOWEL[cs[i] - 'a']) {
                key ^= XOR[cs[i] - 'a'];
            }
            if (earliest[key] == -2) {
                earliest[key] = i;
            }
            else {
                int len = i - earliest[key];
                if (len > longest) {
                    longest = len;
                }
            }
        }
        return longest;
    }
}
