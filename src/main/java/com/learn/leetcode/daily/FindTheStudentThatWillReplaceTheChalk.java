package com.learn.leetcode.daily;

/**
 * <a href="https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/description/?envType=daily-question&envId=2024-09-02">Task</a>
 */
public final class FindTheStudentThatWillReplaceTheChalk {
    public int chalkReplacer(int[] chalk, int initialChalkPieces) {
        long totalChalkNeeded = 0;
        for (int studentChalkUse : chalk) {
            totalChalkNeeded += studentChalkUse;
        }

        int remainingChalk = (int)(initialChalkPieces % totalChalkNeeded);

        for (int studentIndex = 0; studentIndex < chalk.length; studentIndex++) {
            if (remainingChalk < chalk[studentIndex]) {
                return studentIndex;
            }
            remainingChalk -= chalk[studentIndex];
        }

        return 0;
    }
}
