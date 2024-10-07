package com.learn.leetcode.daily.q202410;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/minimum-string-length-after-removing-substrings/description/?envType=daily-question&envId=2024-10-07">Task</a>
 * <a href="https://leetcode.com/problems/minimum-string-length-after-removing-substrings/solutions/5879675/easy-stack-solution-python-java-c-o-n-o-n/?envType=daily-question&envId=2024-10-07">Explanation</a>
 * <p>
 *     <li>Hint 1: Can we use brute force to solve the problem?
 *     <li>Hint 2: Repeatedly traverse the string to find and remove the substrings “AB” and “CD” until no more occurrences exist.
 * </p>
 * <p>
 * <b>Constraints</b>:
 * <li> {@code 1 <= s.length <= 100}
 * <li> s consists only of uppercase English letters.
 * </p>
 * <p>
 * <b>Example 1</b>:
 * <br>
 * Input: s = "ABFCACDB"
 * Output: 2
 * <br>Explanation: We can do the following operations:
 * <br>- Remove the substring "ABFCACDB", so s = "FCACDB".
 * <br>- Remove the substring "FCACDB", so s = "FCAB".
 * <br>- Remove the substring "FCAB", so s = "FC".
 * <br>So the resulting length of the string is 2.
 * <br>It can be shown that it is the minimum length that we can obtain.
 * <br>Example 2:
 * <br>
 * <br>Input: s = "ACBBD"
 * <br>Output: 5
 * <br>Explanation: We cannot do any operations on the string so the length remains the same.
 * </p>
 */
public final class MinimumStringLengthAfterRemovingSubstrings {
    private static final String AB = "AB";
    private static final String CD = "CD";
    private static final String EMPTY = "";

    /**
     * <b>Time complexity</b> O(N^2)<br>
     * <b>Space complexity</b> O(N)
     * @param s
     * @return
     */
    public static int minLength(String s) {
        var tmp_str = s.replace(AB, EMPTY);

        while (tmp_str.contains(AB) || tmp_str.contains(CD)) {
            tmp_str = tmp_str.replace(AB, EMPTY).replace(CD, EMPTY);
        }

        return tmp_str.length();
    }

    public int minLengthStack(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur_char = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(cur_char);
                continue;
            }

            if (cur_char == 'B' && stack.peek() == 'A') {
                stack.pop();
            }
            else if (cur_char == 'D' && stack.peek() == 'C') {
                stack.pop();
            }
            else {
                stack.push(cur_char);
            }
        }

        return stack.size();
    }
}
