package com.learn.leetcode.daily.w2024.u202411.easy;

/**
 * <a href="https://leetcode.com/problems/circular-sentence/description/?envType=daily-question&envId=2024-11-02">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code String}
 * </ul>
 * <ul>Hints
 * <li> {@code Check the character before the empty space and the character after the empty space.}
 * <li> {@code Check the first character and the last character of the sentence.}
 * <li> {@code Uppercase and lowercase English letters are considered different.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= sentence.length <= 500}
 * <li> {@code sentence consist of only lowercase and uppercase English letters and spaces.}
 * <li> {@code The words in sentence are separated by a single space.}
 * <li> {@code There are no leading or trailing spaces.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 02.11.24 18:39
 */
public final class CircularSentence {

    /**
     * {@code Time Complexity O(N)}
     * {@code Space Complexity O(1)}
     * @param sentence
     * @return Given a string sentence, return true if it is circular.
     */
    public static boolean isCircularSentence(String sentence) {
        //Hint #2
        if(sentence.charAt(0) != sentence.charAt(sentence.length()-1)) {
            return false;
        }

        //Hint 1
        //Iterating starting from the 3rd position:
        //Checking if the char before the space is equal to the char after the space.
        for(int i = 2; i < sentence.length(); i++) {
            if(sentence.charAt(i - 1) == ' ') {
                if(sentence.charAt(i - 2) != sentence.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isCircularSentenceEvenFaster(String s) {
        if (s.charAt(0) != s.charAt(s.length() - 1))
            return false;

        int k = s.indexOf(" ");
        if (k == -1)
            return true;

        while (k != -1) {
            if (s.charAt(k - 1) != s.charAt(k + 1)) {
                return false;
            }

            k = s.indexOf(" ", k+1);
        }
        return true;
    }
}
