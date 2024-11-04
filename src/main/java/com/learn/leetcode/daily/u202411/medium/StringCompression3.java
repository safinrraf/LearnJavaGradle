package com.learn.leetcode.daily.u202411.medium;

/**
 * <a href="https://leetcode.com/problems/string-compression-iii/?envType=daily-question&envId=2024-11-04">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code String}
 * </ul>
 * <ul>Hints
 * <li> {@code Each time, just cut the same character in prefix up to at max 9 times. It’s always better to cut a bigger prefix.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= word.length <= 2 * 105}
 * <li> {@code word consists only of lowercase English letters.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 04.11.24 08:29
 */
public final class StringCompression3 {

    /**
     *
     * @param word
     * @return a compressed string.
     */
    public static String compressedString(String word) {
        final var result = new StringBuilder();
        var count = 1;
        var chr = word.charAt(0);

        for(int i = 1; i < word.length(); i++) {
            final var tmp_chr = word.charAt(i);
            if(chr == tmp_chr) {
                count++;
            } else {
                if(count > 0) {
                    result.append(count).append(chr);
                }
                count = 1;
            }

            if(count == 9) {
                result.append(count).append(chr);
                count = 0;
            }
            chr = tmp_chr;
        }
        if(count > 0) {
            result.append(count).append(chr);
        }

        return result.toString();
    }
}
