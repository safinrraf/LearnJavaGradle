package com.learn.leetcode.daily.w2024.q202410.medium;

/**
 * <a href="https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/description/?envType=daily-question&envId=2024-10-01">Task</a>
 * <a href="https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/solutions/5854122/100-beats-easy-to-understand-step-by-step-explaination-beginner-friendly/?envType=daily-question&envId=2024-10-01">Explanation</a>
 */
public final class CheckIfArrayPairsAreDivisibleByK {
    public static boolean canArrange(int[] arr, int k) {
        final var freq = new int[k];

        for (int j : arr) {
            //Hint 1: Keep an array of the frequencies of ((x % k) + k) % k for each x in arr.
            final var reminder = ((j % k) + k) % k;
            freq[reminder]++;
        }

        if (freq[0] % 2 != 0) {
            return false;
        }

        //Hint 2: for each i in [0, k - 1] we need to check if freq[i] == freq[k - i]
        for(int i = 1;i <= k / 2;i++) {
            if(freq[i] != freq[k - i]) {
                return false;
            }
        }

        return true;
    }
}
