package com.learn.leetcode.daily.w2024.q202410.medium;

import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/sentence-similarity-iii/description/?envType=daily-question&envId=2024-10-06">Task</a>
 * <p>
 *     <li>Hint 1: One way to look at it is to find one sentence as a concatenation of a prefix and suffix from the other sentence.
 *     <ul>
 *         <li> Hm...
 *     </ul>
 *     <li>Hint 2: Get the longest common prefix between them and the longest common suffix.
 *     <ul>
 *         <li> Hm...
 *     </ul>
 * </p>
 * <p>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= sentence1.length, sentence2.length <= 100}
 * <li> sentence1 and sentence2 consist of lowercase and uppercase English letters and spaces.
 * <li> The words in sentence1 and sentence2 are separated by a single space.
 * <li> <b>My additional constraints</b>:
 * <ul>
 * <li> S1 and S2 must have either: the longest common prefix (LCP), or the longest common prefix (LCP) and the longest common suffix (LCS)
 * </ul>
 * </ul>
 * </p>
 * <p>
 * <ul><b>Intuition</b>:
 * <li> I will get two sentences - that means that I need to insert in the middle of one of them.
 * <ul>
 *     <li> ... at the end: "Eating right now", sentence2 = "Eating", here should be {@code true}
 * </ul>
 * <li> First step would be to get the longest common prefix (LCP) and the longest common suffix (LCS), as suggested in the Hint #2
 * <li> The words in sentence1 and sentence2 are separated by a single space.
 * </ul>
 * <ul><b>My questions</b>:
 * <li> Yet it is not clear (for now) how to "insert"? - But do I really need to?
 * </ul>
 * </p>
 * <p>
 *     <ul><b>Approach</b>:
 *     <li> # 1: using split - get arrays, because I need to find LCP and LCS by words not by chars
 *     <ul>
 *         <li> {@code s1 = "Frog cool" and s2 = "Frogs are cool"} are not similar, , since although there is a sentence "s are" inserted into s1, it is not separated from "Frog" by a space.
 *     </ul>
 *     <li> # 2: using two pointer - one for S1, and another for S2 - get the LCP and the LCS
 *     <ul>
 *         <li> How to store these LCP and CSP ??? - as an {@code int}
 *     </ul>
 *     </ul>
 * </p>
 */
public final class SentenceSimilarity3 {
    /**
     * Time complexity =
     * @param sentence1
     * @param sentence2
     * @return
     */
    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        // if they are already equal - then true
        if(sentence1.equals(sentence2)) {
            return true;
        }

        final var s1_array = sentence1.split(" ");
        final var s2_array = sentence2.split(" ");

        // To find LCP/LCS need the min length and the max length between the two
        var min_arr_length = 0;
        var max_arr_length = 0;

        if(s1_array.length > s2_array.length) {
            min_arr_length = s2_array.length;
            max_arr_length = s1_array.length;
        } else {
            min_arr_length = s1_array.length;
            max_arr_length = s2_array.length;
        }

        //the length of the Longest Common Prefix (LCP)
        //important note: LCP and LCS should be continuous
        var lcp = 0;
        //the length of the Longest Common Suffix (LCS).
        // LCS could be 0
        var lcs = 0;

        //LCP
        if (Objects.equals(s1_array[0], s2_array[0])) {
            lcp++;
            for (int i = 1; i < min_arr_length; i++) {
                //comparing from the beginning of the arrays
                if(Objects.equals(s1_array[i], s2_array[i])) {
                    lcp++;
                } else {
                    break;
                }
            }
        }

        //LCS
        if(Objects.equals(s1_array[s1_array.length - 1], s2_array[s2_array.length - 1])) {
            lcs++;
            for (int i = 1; i < min_arr_length; i++) {
                //to prevent double counting
                if(lcp + lcs >= min_arr_length) {
                    break;
                }
                //comparing from the end of the arrays
                if (Objects.equals(s1_array[s1_array.length - 1 - i], s2_array[s2_array.length - 1 - i])) {
                    lcs++;
                } else {
                    break;
                }
            }
        }

        if(min_arr_length == 1 && (lcp == 1 || lcs == 1)) {
            return true;
        } else {
            return (max_arr_length - lcp - lcs) + min_arr_length == max_arr_length;
        }
    }
}
