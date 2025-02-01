package com.learn.leetcode.daily.w2024.q202409;

/**
 * <a href="https://leetcode.com/problems/shortest-palindrome/description/?envType=daily-question&envId=2024-09-20">Task</a>
 * <br><a href="https://leetcode.com/problems/shortest-palindrome/solutions/5810352/beats-100-beginner-friendly-python3-java-c-c-ruby-go-javascript/?envType=daily-question&envId=2024-09-20">Explanation</a>
 */
public final class ShortestPalindrome {
    public static String shortestPalindrome(String s) {
        int count = kmp(new StringBuilder(s).reverse().toString(), s);
        return new StringBuilder(s.substring(count)).reverse().toString() + s;
    }

    private static int kmp(String txt, String patt) {
        String newString = patt + '#' + txt;
        int[] pi = new int[newString.length()];
        int i = 1, k = 0;
        while (i < newString.length()) {
            if (newString.charAt(i) == newString.charAt(k)) {
                k++;
                pi[i] = k;
                i++;
            } else {
                if (k > 0) {
                    k = pi[k - 1];
                } else {
                    pi[i] = 0;
                    i++;
                }
            }
        }
        return pi[newString.length() - 1];
    }
}
