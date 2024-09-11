package com.learn.leetcode.daily.q202408;

import java.util.regex.Pattern;

/**
 * <a href="https://leetcode.com/problems/fraction-addition-and-subtraction/description/?envType=daily-question&envId=2024-08-23">Task</a>
 */
public final class FractionAdditionAndSubtraction {
    public String fractionAdditionNotMy(String expression) {
        int numerator = 0, denominator = 1;

        final var pattern = Pattern.compile("([+-]?\\d+)/(\\d+)");
        final var matcher = pattern.matcher(expression);

        while (matcher.find()) {
            int num = Integer.parseInt(matcher.group(1));
            int den = Integer.parseInt(matcher.group(2));

            numerator = numerator * den + num * denominator;
            denominator *= den;

            final var gcdVal = gcd(Math.abs(numerator), denominator);
            numerator /= gcdVal;
            denominator /= gcdVal;
        }

        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
