package com.learn.leetcode.daily.x202412.medium;


/**
 * <a href="https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/description/?envType=daily-question&envId=2024-12-10">Task</a>
 * <br><a href="https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/solutions/6130737/simple-binary-search-100-beats/">Explanation</a>
 * <ul>Topics
 * <li> {@code Hash Table, String, Binary Search, Sliding Window, Counting}
 * </ul>
 * <ul>Hints
 * <li> {@code The constraints are small.}
 * <li> {@code Brute force checking all substrings.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 3 <= s.length <= 50}
 * <li> {@code s consists of only lowercase English letters.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 10.12.24 21:15
 */
public final class FindLongestSpecialSubstringThatOccursThrice1 {

    /**
     * <p>A string is called special if it is made up of only a single character. For example, the string {@code "abc"} is not special, whereas the strings {@code "ddd"}, {@code "zz"}, and {@code "f"} are special.</p>
     *
     * <p>
     * {@code Time Complexity O(...)}<br>
     * {@code Space Complexity O(...)}
     * </p>
     * @param s
     * @return the length of the longest special substring of {@code s} which occurs at least thrice, or {@code -1} if no special substring occurs at least thrice.
     */
    public static int maximumLength(String s) {
        final int n = s.length();
        int l = 1;
        int r = n;

        if (!helper(s, n, l)) {
            return -1;
        }

        //binary search
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (helper(s, n, mid)) l = mid;
            else r = mid;
        }

        return l;
    }

    private static boolean helper(String s, int n, int x) {
        final int[] cnt = new int[26];
        int p = 0;

        for (int i = 0; i < n; i++) {
            while (s.charAt(p) != s.charAt(i)) p++;
            if (i - p + 1 >= x) cnt[s.charAt(i) - 'a']++;
            if (cnt[s.charAt(i) - 'a'] > 2) return true;
        }

        return false;
    }
}
