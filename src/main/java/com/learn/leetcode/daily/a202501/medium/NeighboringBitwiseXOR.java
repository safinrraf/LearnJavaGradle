package com.learn.leetcode.daily.a202501.medium;

/**
 * <a href="https://leetcode.com/problems/neighboring-bitwise-xor/description/?envType=daily-question&envId=2025-01-17">Task</a>
 * <br><a href="https://leetcode.com/problems/neighboring-bitwise-xor/editorial/?envType=daily-question&envId=2025-01-17">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Bit Manipulation}
 * </ul>
 * <ul>Hints
 * <li> {@code Understand that from the original element, we are using each element twice to construct the derived array}
 * <li> {@code The xor-sum of the derived array should be 0 since there is always a duplicate occurrence of each element.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code n == derived.length}
 * <li> {@code 1 <= n <= 10^5}
 * <li> {@code The values in derived are either 0's or 1's}
 * </ul>
 * <br>@since 1.0.0
 * <br> 17.01.25 08:50
 */
public final class NeighboringBitwiseXOR {

    /**
     * Approach 1: Simulation
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param derived
     * @return <b>true</b> if such an array exists or <b>false</b> otherwise.
     */
    public static boolean doesValidArrayExist1(int[] derived) {
        // Create an original array initialized with 0.
        int[] original = new int[derived.length + 1];
        original[0] = 0;
        for (int i = 0; i < derived.length; i++) {
            original[i + 1] = derived[i] ^ original[i];
        }
        // Store the validation results in checkForZero and checkForOne respectively.
        boolean checkForZero = (original[0] == original[original.length - 1]);

        original[0] = 1;
        for (int i = 0; i < derived.length; i++) {
            original[i + 1] = derived[i] ^ original[i];
        }
        boolean checkForOne = (original[0] == original[original.length - 1]);

        return checkForZero || checkForOne;
    }

    /**
     * Approach 2: Cumulative XOR.
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(1)}
     * </p>
     * @param derived
     * @return <b>true</b> if such an array exists or <b>false</b> otherwise.
     */
    public static boolean doesValidArrayExist(int[] derived) {
        int XOR = 0;
        for (int element : derived) {
            XOR = XOR ^ element;
        }
        return XOR == 0;
    }

    /**
     * Approach 3: Sum Parity
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(1)}
     * </p>
     * @param derived
     * @return <b>true</b> if such an array exists or <b>false</b> otherwise.
     */
    public static boolean doesValidArrayExist3(int[] derived) {
        int sum = 0;
        for (int num : derived) {
            sum += num;
        }
        return sum % 2 == 0;
    }
}
