package com.learn.leetcode.daily.w2024.q202409;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/different-ways-to-add-parentheses/?envType=daily-question&envId=2024-09-19">Task</a>
 * <br><a href="https://leetcode.com/problems/different-ways-to-add-parentheses/solutions/5806448/beats-90-beginner-friendly-python3-java-c-c-rust-go-js/">Explanation</a>
 */
public final class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String expression) {
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            final var oper = expression.charAt(i);
            if (oper == '+' || oper == '-' || oper == '*') {
                final var s1 = diffWaysToCompute(expression.substring(0, i));
                final var s2 = diffWaysToCompute(expression.substring(i + 1));
                for (final int a : s1) {
                    for (final int b : s2) {
                        switch (oper) {
                            case '+' -> res.add(a + b);
                            case '-' -> res.add(a - b);
                            case '*' -> res.add(a * b);
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }
        return res;
    }
}
