package com.learn.leetcode.daily.q202410.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/permutation-in-string/description/?envType=daily-question&envId=2024-10-05">Task</a>
 * <a href="">Explanation</a>
 * <p>
 *     <li>Hint 1: Obviously, brute force will result in TLE. Think of something else.
 *     <li>Hint 2: How will you check whether one string is a permutation of another string?
 *     <ul>
 *         <li> Hm... by sorting them?...
 *     </ul>
 *     <li>Hint 3: One way is to sort the string and then compare. But, Is there a better way?
 *     <li>Hint 4: If one string is a permutation of another string then they must have one common metric. What is that?
 *     <ul>
 *         <li> Hm... s1 = "ab", s2 = "eidbaooo", it should be "true"... a Hash Table
 *     </ul>
 *     <li>Hint 5: Both strings must have same character frequencies, if one is permutation of another. Which data structure should be used to store frequencies?
 *     <li>Hint 6: What about hash table? An array of size 26?
 * </p>
 * <p>
 * <b>Constraints</b>:
 * <li> 1 <= s1.length, s2.length <= 104
 * <li> s1 and s2 consist of lowercase English letters.
 * </p>
 */
public final class PermutationInString {

    /**
     * <li>Time complexity = O(N+M)
     * <li>Space complexity = O(N+M)
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        //use HashMap as suggested to keep track of chars.
        final Map<Character, Integer> alphabetMap = new HashMap<>();
        final Map<Character, Integer> s2Map = new HashMap<>();

        for(int k = 0; k < s1.length(); k++) {
            alphabetMap.merge(s1.charAt(k), 1, Integer::sum);
        }

        for(int i = 0; i < s2.length(); i++) {
            if(alphabetMap.containsKey(s2.charAt(i))) {
                //new map to keep track of char frequencies
                s2Map.put(s2.charAt(i), 1);
                // two pointers:
                // nextInS1: this one to control the number of iterations
                // -1 because we already found one similar character
                var nextInS1 = s1.length() - 1;
                // this one to scan in S2
                var nextInS2 = i + 1;
                //sliding window
                while(nextInS1-- > 0 && nextInS2 < s2.length()) {
                    s2Map.merge(s2.charAt(nextInS2), 1, Integer::sum);
                    nextInS2++;
                }
                //now compare two maps
                if(alphabetMap.equals(s2Map)) {
                    return true;
                }
                s2Map.clear();
            }
        }
        return false;
    }

    public boolean checkInclusionHashMapOptimised(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        // Initialize the frequency map for s1
        for (char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        // Initialize the frequency map for the first window in s2
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            s2Map.put(c, s2Map.getOrDefault(c, 0) + 1);
        }

        // Check if the first window is a permutation
        if (s1Map.equals(s2Map)) return true;

        // Slide the window over s2
        for (int i = s1.length(); i < s2.length(); i++) {
            char newChar = s2.charAt(i);
            char oldChar = s2.charAt(i - s1.length());

            // Add the new character to the window
            s2Map.put(newChar, s2Map.getOrDefault(newChar, 0) + 1);

            // Remove the old character from the window
            if (s2Map.get(oldChar) == 1) {
                s2Map.remove(oldChar);
            } else {
                s2Map.put(oldChar, s2Map.get(oldChar) - 1);
            }

            // Check if the current window is a permutation
            if (s1Map.equals(s2Map)) return true;
        }

        return false;
    }

    /**
     * <li>Time complexity = O(n-m+1)
     * <li>Space complexity = O(26)
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusionFast(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if (m > n) return false;  // If s1 is longer than s2, no permutation is possible.

        // Frequency arrays for s1 and the current window in s2
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        // Count frequency array for s1
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        // Initialize the first window of size m in s2
        for (int i = 0; i < m; i++) {
            windowFreq[s2.charAt(i) - 'a']++;
        }

        // Slide the window over the string s2
        for (int i = 0; i <= n - m; i++) {
            // If frequencies match, we found a valid permutation
            if (Arrays.equals(s1Freq, windowFreq)) {
                return true;
            }

            // Slide the window to the right:
            if (i + m < n) {
                // Remove the first character of the current window
                windowFreq[s2.charAt(i) - 'a']--;
                // Add the next character to the window
                windowFreq[s2.charAt(i + m) - 'a']++;
            }
        }

        // Check the last window
        return Arrays.equals(s1Freq, windowFreq);
    }
}
