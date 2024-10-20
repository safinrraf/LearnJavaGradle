package com.learn.leetcode.daily.q202410.hard;

import java.util.ArrayList;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/parsing-a-boolean-expression/description/?envType=daily-question&envId=2024-10-20">Task</a>
 * <br><a href="https://leetcode.com/problems/parsing-a-boolean-expression/solutions/5939362/beats-100-00-stack-implementation-a-comprehensive-step-by-step-breakdown/?envType=daily-question&envId=2024-10-20">Explanation</a>
 * <ul>Topics
 * <li> {@code String, Stack, Recursion}
 * </ul>
 * <ul>Hints
 * <li> {@code Write a function "parse" which calls helper functions "parse_or", "parse_and", "parse_not".}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= expression.length <= 2 * 104}
 * <li> {@code expression[i] is one following characters: '(', ')', '&', '|', '!', 't', 'f', and ','.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 20.10.24 17:14
 */
public final class ParsingABooleanExpression {
    /**
     *
     * @param expression
     * @return A boolean expression is an expression that evaluates to either {@code true} or {@code false}.
     */
    public static boolean parseBoolExpr(String expression) {
        // Stack to hold characters and operators
        final Stack<Character> stk = new Stack<>();

        // Iterate over each character in the expression
        for (char c : expression.toCharArray()) {
            // Push valid characters (non ')' and non ',') to the stack
            if (c != ')' && c != ',') {
                stk.push(c);
            }
            else if (c == ')') {  // When ')' is encountered, evaluate subexpression
                // List to hold boolean values
                final ArrayList<Boolean> exp = new ArrayList<>();

                // Pop characters until '(' is found, collect 't' or 'f' values
                while (!stk.isEmpty() && stk.peek() != '(') {
                    final var t = stk.pop();
                    if (t == 't') {
                        exp.add(true);
                    }
                    else {
                        exp.add(false);
                    }
                }

                stk.pop();  // Pop the '(' from the stack

                if (!stk.isEmpty()) {
                    char t = stk.pop();  // Get the operator before '('
                    boolean v = exp.getFirst();  // Initialize result with the first value

                    // Perform the corresponding logical operation
                    switch (t) {
                        case '&' -> {
                            for (boolean b : exp) {
                                // AND operation
                                v &= b;
                            }
                        }
                        case '|' -> {
                            for (boolean b : exp) {
                                // OR operation
                                v |= b;
                            }
                        }
                        default ->   // NOT operation
                                v = !v;
                    }

                    // Push the result back to the stack as 't' or 'f'
                    if (v) {
                        stk.push('t');
                    }
                    else {
                        stk.push('f');
                    }
                }
            }
        }

        // Return the final result from the stack
        return stk.peek() == 't';
    }
}
