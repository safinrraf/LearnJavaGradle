package com.learn.leetcode.daily.x202412.medium;

/**
 * <a href="https://leetcode.com/problems/adding-spaces-to-a-string/?envType=daily-question&envId=2024-12-03">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Two Pointers, String, Simulation}
 * </ul>
 * <ul>Hints
 * <li> {@code Create a new string, initially empty, as the modified string. Iterate through the original string and append each character of the original string to the new string. However, each time you reach a character that requires a space before it, append a space before appending the character.}
 * <li> {@code Since the array of indices for the space locations is sorted, use a pointer to keep track of the next index to place a space. Only increment the pointer once a space has been appended.}
 * <li> {@code Ensure that your append operation can be done in O(1).}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= s.length <= 3 * 10^5}
 * <li> {@code s consists only of lowercase and uppercase English letters.}
 * <li> {@code 1 <= spaces.length <= 3 * 10^5}
 * <li> {@code 0 <= spaces[i] <= s.length - 1}
 * <li> {@code All the values of spaces are strictly increasing.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 03.12.24 08:22
 */
public final class AddingSpacesToString {

    /**
     * {@code Time Complexity O(N)}
     * {@code Space Complexity O(N)}
     *
     * @param s
     * @param spaces
     * @return the modified string after the spaces have been added.
     */
    public static String addSpaces(String s, int[] spaces) {
        final StringBuilder result = new StringBuilder();
        int prev_start = 0;

        for(int i = 0; i < spaces.length; i++) {
            if(spaces[i] == 0) {
                result.append(" ");
            } else {
                result.append(s, prev_start, spaces[i]).append(" ");
                prev_start = spaces[i];
            }
        }
        result.append(s.substring(prev_start));
        return result.toString();
    }
}
