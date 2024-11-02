package com.learn.leetcode.daily.u202411.easy;

/**
 * <a href="https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/?envType=daily-question&envId=2024-11-01">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code String}
 * </ul>
 * <ul>Hints
 * <li> {@code What's the optimal way to delete characters if three or more consecutive characters are equal?}
 * <li> {@code If three or more consecutive characters are equal, keep two of them and delete the rest.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= s.length <= 10^5}
 * <li> {@code s consists only of lowercase English letters.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 01.11.24 17:31
 */
public final class DeleteCharactersToMakeFancyString {

    /**
     * <p>A fancy string is a string where no three consecutive characters are equal.</p>
     * Given a string {@code s}, delete the minimum possible number of characters from s to make it fancy.
     * {@code Time Complexity O(N)}
     * {@code Space Complexity O(1)}
     *
     * @param s input string.
     * @return Return the final string after the deletion. It can be shown that the answer will always be unique.
     */
    public static String makeFancyString(String s) {
        if(s.length() < 3) {
            return s;
        }

        final var result = new StringBuilder();
        var count = 1;
        var chr = s.charAt(0);
        result.append(chr);
        for(int i = 1; i < s.length(); i++) {
            final var tmp_chr = s.charAt(i);
            if(chr == tmp_chr) {
                count++;
            } else {
                count = 1;
            }

            if(count < 3) {
                result.append(tmp_chr);
            }
            chr = tmp_chr;
        }
        return result.toString();
    }
}
