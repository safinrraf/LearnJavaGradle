package com.learn.leetcode.daily.w2024.x202412.medium;

/**
 * <a href="https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/description/?envType=daily-question&envId=2024-12-04">Task</a>
 * <br><a href="https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/solutions/6110638/100-beats-short-simple/">Explanation</a>
 * <ul>Topics
 * <li> {@code Two Pointers, String}
 * </ul>
 * <ul>Hints
 * <li> {@code Consider the indices we will increment separately.}
 * <li> {@code We can maintain two pointers: pointer i for str1 and pointer j for str2, while ensuring they remain within the bounds of the strings.}
 * <li> {@code If both str1[i] and str2[j] match, or if incrementing str1[i] matches str2[j], we increase both pointers; otherwise, we increment only pointer i.}
 * <li> {@code It is possible to make str2 a subsequence of str1 if j is at the end of str2, after we can no longer find a match.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= str1.length <= 10^5}
 * <li> {@code 1 <= str2.length <= 10^5}
 * <li> {@code str1 and str2 consist of only lowercase English letters.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 04.12.24 08:17
 */
public final class MakeStringSubsequenceUsingCyclicIncrements {

    /**
     * {@code Time Complexity O(N)}
     * {@code Space Complexity O(1)}
     *
     * @param str1
     * @param str2
     * @return {@code true} if it is possible to make {@code str2} a subsequence of {@code str1} by performing the operation at most once, and {@code false} otherwise.
     */
    public static boolean canMakeSubsequence(String str1, String str2) {
        final int srcLen = str1.length();
        final int tgtLen = str2.length();
        int srcIdx = 0;
        int tgtIdx = 0;

        while (srcIdx < srcLen && tgtIdx < tgtLen) {
            final char srcChar = str1.charAt(srcIdx);
            final char tgtChar = str2.charAt(tgtIdx);

            if (srcChar == tgtChar ||
                    (srcChar == 'z' && tgtChar == 'a') ||
                    (srcChar + 1 == tgtChar)) {
                srcIdx++;
                tgtIdx++;
            } else {
                srcIdx++;
            }
        }
        return tgtIdx == tgtLen;
    }

    public boolean canMakeSubsequence1(String source, String target) {
        int targetIdx = 0, targetLen = target.length();

        for (char currChar : source.toCharArray()) {
            if (targetIdx < targetLen && (target.charAt(targetIdx) - currChar + 26) % 26 <= 1) {
                targetIdx++;
            }
        }
        return targetIdx == targetLen;
    }
}
