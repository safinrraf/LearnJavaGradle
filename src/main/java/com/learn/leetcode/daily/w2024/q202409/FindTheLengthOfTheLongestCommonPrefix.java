package com.learn.leetcode.daily.w2024.q202409;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/description/?envType=daily-question&envId=2024-09-24">Task</a>
 * <br><a href="https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/solutions/5826011/how-to-use-prefix-concept-here-map-trie-approaches-chalo-smjhe/">Explanation</a>
 */
public final class FindTheLengthOfTheLongestCommonPrefix {

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        final HashMap<Integer, Integer> prefix = new HashMap<>();

        // Store all prefixes of the first array
        for (int val : arr1) {
            int num = val;
            while (num > 0) {
                prefix.put(num, prefix.getOrDefault(num, 0) + 1);
                num /= 10;
            }
        }

        // Variable to track the maximum length
        int mx = Integer.MIN_VALUE;

        // Instead of creating another map, check the prefix at the moment
        for (int val : arr2) {
            int num = val;
            // Count the number of digits in num
            int len = (int) Math.log10(num) + 1;

            // Generate all prefixes again
            while (num > 0) {
                // If prefix found, break
                if (prefix.containsKey(num)) {
                    break;
                }
                num /= 10;
                // Decrease digit count as we decrease prefix
                len--;
            }

            mx = Math.max(mx, len);
        }

        return mx;
    }

}
