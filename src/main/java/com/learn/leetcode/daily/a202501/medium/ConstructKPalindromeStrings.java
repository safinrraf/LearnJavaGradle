package com.learn.leetcode.daily.a202501.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/construct-k-palindrome-strings/description/?envType=daily-question&envId=2025-01-11">Task</a>
 * <br><a href="https://leetcode.com/problems/construct-k-palindrome-strings/editorial/?envType=daily-question&envId=2025-01-11">Explanation</a>
 * <ul>Topics
 * <li> {@code Hash Table, String, Greedy, Counting}
 * </ul>
 * <ul>Hints
 * <li> {@code If the s.length < k we cannot construct k strings from s and answer is false.}
 * <li> {@code If the number of characters that have odd counts is > k then the minimum number of palindrome strings we can construct is > k and answer is false.}
 * <li> {@code Otherwise you can construct exactly k palindrome strings and answer is true (why ?).}
 * <li> {@code The answer why: The real challenge lies with odd-frequency characters. A palindrome can only have one odd-frequency character at its center; the rest must appear in even numbers. Therefore, the number of odd-frequency characters in the string determines how many palindromes we can form. Specifically, the minimum number of palindromes we can make is equal to the number of odd-frequency characters, because each odd-frequency character requires its own palindrome.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= s.length <= 10^5}
 * <li> {@code s consists of lowercase English letters.}
 * <li> {@code 1 <= k <= 10^5}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 11.01.25 19:13
 */
public final class ConstructKPalindromeStrings {

    /**
     * My solution
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param s a string.
     * @param k number of palindroms to build.
     * @return {@code true} if you can use all the characters in {@code s} to construct {@code k} palindrome strings or {@code false} otherwise.
     */
    public static boolean canConstruct(String s, int k) {
        //Hint #1
        if(s.length() < k) {
            return false;
        }

        int odd = 0;
        final Map<Character, Integer> map = new HashMap<>(s.length());

        //hint #2 & #3
        for(final var ch : s.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
        }

        for(final var item : map.entrySet()) {
            if ((item.getValue() & 1) != 0) {
                odd++;
            }
        }

        return odd <= k;
    }

    /**
     * Editorial.
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(1)}
     * </p>
     * @param s a string.
     * @param k number of palindroms to build.
     * @return {@code true} if you can use all the characters in {@code s} to construct {@code k} palindrome strings or {@code false} otherwise.
     */
    public static boolean canConstruct_Editorial(String s, int k) {
        // Handle edge cases
        if (s.length() < k) return false;
        if (s.length() == k) return true;

        // Initialize frequency array and oddCount
        int[] freq = new int[26];
        int oddCount = 0;

        // Increment the value of the index corresponding to the current character
        for (char chr : s.toCharArray()) {
            freq[chr - 'a']++;
        }

        // Count the number of characters that appear an odd number of times in s
        for (int count : freq) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }

        // Return if the number of odd frequencies is less than or equal to k
        return oddCount <= k;
    }

    /**
     * Editorial.
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(1)}
     * </p>
     * @param s a string.
     * @param k number of palindroms to build.
     * @return {@code true} if you can use all the characters in {@code s} to construct {@code k} palindrome strings or {@code false} otherwise.
     */
    public static boolean canConstruct_Editorial_bit_manipulation(String s, int k) {
        // Handle edge cases
        if (s.length() < k) return false;
        if (s.length() == k) return true;

        // Initialize oddCount as an integer bitmask
        int oddCount = 0;

        // Update the bitmask for each character in the string
        for (char chr : s.toCharArray()) {
            oddCount ^= 1 << (chr - 'a');
        }

        // Return if the number of odd frequencies is less than or equal to k
        return Integer.bitCount(oddCount) <= k;
    }
}
