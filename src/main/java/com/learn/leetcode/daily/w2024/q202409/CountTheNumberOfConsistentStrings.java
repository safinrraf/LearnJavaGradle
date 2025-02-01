package com.learn.leetcode.daily.w2024.q202409;

/**
 * <a href="https://leetcode.com/problems/count-the-number-of-consistent-strings/description/?envType=daily-question&envId=2024-09-12">Task</a>
 */
public final class CountTheNumberOfConsistentStrings {
    public static int countConsistentStrings(String allowed, String[] words) {
        int result = 0;
        boolean onlyAllowed = true;
        for(var word: words) {
            for (int i = 0; i < word.length(); i++) {
                if (allowed.indexOf(word.charAt(i)) == -1) {
                    onlyAllowed = false;
                    break;
                }
            }
            if (onlyAllowed) {
                result++;
            }
            onlyAllowed = true;
        }
        return result;
    }
}
