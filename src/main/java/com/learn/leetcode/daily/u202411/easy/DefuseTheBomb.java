package com.learn.leetcode.daily.u202411.easy;

/**
 * <a href="https://leetcode.com/problems/defuse-the-bomb/description/?envType=daily-question&envId=2024-11-18">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Sliding Window}
 * </ul>
 * <ul>Hints
 * <li> {@code As the array is circular, use modulo to find the correct index.}
 * <li> {@code The constraints are low enough for a brute-force solution.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code n == code.length}
 * <li> {@code 1 <= n <= 100}
 * <li> {@code 1 <= code[i] <= 100}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 18.11.24 08:21
 */
public final class DefuseTheBomb {

    /**
     * {@code Time Complexity O(N)}
     * {@code Space Complexity O(N)}
     *
     * @param code input array.
     * @param k If k > 0, replace the i-th number with the sum of the next k numbers.
     *          If k < 0, replace the i-th number with the sum of the previous k numbers.
     *          If k == 0, replace the i-th number with 0.
     * @return the decrypted code to defuse the bomb!
     */
    public static int[] decrypt(int[] code, int k) {
        final var code_length = code.length;
        final int[] result = new int[code_length];
        var result_index = 0;

        if(k == 0) {
            return result;
        }

        for(int i = 0; i < code_length; i++) {
            var count = (k < 0) ? -k : k;
            if (k < 0) {
                var index = i - 1;
                while(count-- > 0) {
                    if (index < 0) {
                        index = code_length - 1;
                    }
                    result[result_index] += code[index];
                    index--;
                }
            } else {
                var index = i + 1;
                while(count-- > 0) {
                    if(index >= code_length) {
                        index = 0;
                    }
                    result[result_index] += code[index];
                    index++;
                }
            }
            result_index++;
        }

        return result;
    }
}
