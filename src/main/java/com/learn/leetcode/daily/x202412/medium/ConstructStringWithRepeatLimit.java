package com.learn.leetcode.daily.x202412.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/construct-string-with-repeat-limit/description/?envType=daily-question&envId=2024-12-17">Task</a>
 * <br><a href="https://leetcode.com/problems/construct-string-with-repeat-limit/solutions/6141078/construct-string-with-repeat-limit/">Explanation</a>
 * <ul>Topics
 * <li> {@code Hash Table, String, Greedy, Heap (Priority Queue), Counting}
 * </ul>
 * <ul>Hints
 * <li> {@code ...}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= repeatLimit <= s.length <= 10^5}
 * <li> {@code s consists of lowercase English letters.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 17.12.24 08:21
 */
public final class ConstructStringWithRepeatLimit {

    /**
     * Approach 1: Greedy Character Frequency Distribution
     * <p>
     * {@code Time Complexity O(N * K)}<br>
     * {@code Space Complexity O(K), where K is 26 characters at most.}
     * </p>
     * @param s
     * @param repeatLimit
     * @return the lexicographically largest {@code repeatLimitedString} possible.
     */
    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        int currentCharIndex = 25; // Start from the largest character
        while (currentCharIndex >= 0) {
            if (freq[currentCharIndex] == 0) {
                currentCharIndex--;
                continue;
            }

            int use = Math.min(freq[currentCharIndex], repeatLimit);
            for (int k = 0; k < use; k++) {
                result.append((char) ('a' + currentCharIndex));
            }
            freq[currentCharIndex] -= use;

            if (freq[currentCharIndex] > 0) { // Need to add a smaller character
                int smallerCharIndex = currentCharIndex - 1;
                while (smallerCharIndex >= 0 && freq[smallerCharIndex] == 0) {
                    smallerCharIndex--;
                }
                if (smallerCharIndex < 0) {
                    break;
                }
                result.append((char) ('a' + smallerCharIndex));
                freq[smallerCharIndex]--;
            }
        }

        return result.toString();
    }

    /**
     * Approach 2: Heap-Optimized Greedy Character Frequency Distribution
     * <p>
     * {@code Time Complexity O(N * LogK)}<br>
     * {@code Space Complexity O(K), where K is 26 characters at most.}
     * </p>
     * @param s
     * @param repeatLimit
     * @return the lexicographically largest {@code repeatLimitedString} possible.
     */
    public static String repeatLimitedString2(String s, int repeatLimit) {
        final Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        final PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) ->
                Character.compare(b, a)
        );

        for (char ch : freq.keySet()) {
            maxHeap.offer(ch);
        }

        final StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            final char ch = maxHeap.poll();
            final int count = freq.get(ch);

            int use = Math.min(count, repeatLimit);
            for (int i = 0; i < use; i++) {
                result.append(ch);
            }

            freq.put(ch, count - use);

            if (freq.get(ch) > 0 && !maxHeap.isEmpty()) {
                final char nextCh = maxHeap.poll();
                result.append(nextCh);
                freq.put(nextCh, freq.get(nextCh) - 1);
                if (freq.get(nextCh) > 0) {
                    maxHeap.offer(nextCh);
                }
                maxHeap.offer(ch);
            }
        }

        return result.toString();
    }
}




