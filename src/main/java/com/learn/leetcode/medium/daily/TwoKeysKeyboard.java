package com.learn.leetcode.medium.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/2-keys-keyboard/description/?envType=daily-question&envId=2024-08-19">Task</a>
 */
public final class TwoKeysKeyboard {
    public static int minSteps(int n) {
        return findPrimeFactors(n).stream().reduce(0, Integer::sum);
    }

    public int minStepsNotMy(int n) {
        if (n == 1) return 0;

        int steps = 0;
        int factor = 2;

        while (n > 1) {
            while (n % factor == 0) {
                steps += factor;
                n /= factor;
            }
            factor++;
        }

        return steps;
    }

    public static List<Integer> findPrimeFactors(int num) {
        final List<Integer> factors = new ArrayList<>();

        // Check for number of 2s that divide num
        while (num % 2 == 0) {
            factors.add(2);
            num /= 2;
        }

        // num must be odd at this point, so we can skip even numbers
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            // While i divides num, add i and divide num
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }

        // This condition is to check if num is a prime number greater than 2
        if (num > 2) {
            factors.add(num);
        }

        return factors;
    }
}
