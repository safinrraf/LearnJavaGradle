package com.learn.leetcode.daily.w2024.q202409;

/**
 * <a href="https://leetcode.com/problems/find-missing-observations/description/?envType=daily-question&envId=2024-09-05">Task</a>
 */
public final class FindMissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalSum = mean * (n + m);
        int observedSum = 0;

        for (int roll : rolls) {
            observedSum += roll;
        }

        int missingSum = totalSum - observedSum;

        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];
        }

        int base = missingSum / n;
        int remainder = missingSum % n;

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = base + (i < remainder ? 1 : 0);
        }

        return result;
    }
}
