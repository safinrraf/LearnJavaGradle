package com.learn.leetcode.daily.a202501.medium;

/**
 * <a href="https://leetcode.com/problems/shifting-letters-ii/?envType=daily-question&envId=2025-01-05">Task</a>
 * <br><a href="https://leetcode.com/problems/shifting-letters-ii/solutions/6208398/shifting-letters-ii/?envType=daily-question&envId=2025-01-05">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, String, Prefix Sum}
 * </ul>
 * <ul>Hints
 * <li> {@code Instead of shifting every character in each shift, could you keep track of which characters are shifted and by how much across all shifts?}
 * <li> {@code Try marking the start and ends of each shift, then perform a prefix sum of the shifts.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= s.length, shifts.length <= 5 * 10^4}
 * <li> {@code shifts[i].length == 3}
 * <li> {@code 0 <= start-i <= end-i < s.length}
 * <li> {@code 0 <= direction-i <= 1}
 * <li> {@code s consists of lowercase English letters.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 05.01.25 19:39
 */
public final class ShiftingLetters2 {

    /**
     *
     * <p>
     * {@code Time Complexity O(N + M)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param s
     * @param shifts
     * @return the final string after all such shifts to {@code s} are applied.
     */
    public static String shiftingLetters(String s, int[][] shifts) {
        final int N = s.length();
        final int[] diffArray = new int[N]; // Initialize a difference array with all elements set to 0.

        // Process each shift operation
        for (int[] shift : shifts) {
            if (shift[2] == 1) { // If direction is forward (1)
                diffArray[shift[0]]++; // Increment at the start index
                if (shift[1] + 1 < N) {
                    diffArray[shift[1] + 1]--; // Decrement at the end+1 index
                }
            } else { // If direction is backward (0)
                diffArray[shift[0]]--; // Decrement at the start index
                if (shift[1] + 1 < N) {
                    diffArray[shift[1] + 1]++; // Increment at the end+1 index
                }
            }
        }

        final StringBuilder result = new StringBuilder();
        int numberOfShifts = 0;

        // Apply the shifts to the string
        for (int i = 0; i < N; i++) {
            numberOfShifts = (numberOfShifts + diffArray[i]) % 26; // Update cumulative shifts, keeping within the alphabet range
            if (numberOfShifts < 0) {
                numberOfShifts += 26; // Ensure non-negative shifts
            }

            // Calculate the new character by shifting `s[i]`
            final char shiftedChar = (char) ('a' + ((s.charAt(i) - 'a' + numberOfShifts) % 26));
            result.append(shiftedChar);
        }

        return result.toString();
    }
}
