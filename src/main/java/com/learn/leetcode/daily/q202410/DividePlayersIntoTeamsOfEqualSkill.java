package com.learn.leetcode.daily.q202410;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/description/?envType=daily-question&envId=2024-10-04">Task</a>
 * <a href="">Explanation</a>
 * <p>Time complexity = O(NLogN) </p>
 * <p>Space complexity = O(1) </p>
 */
public final class DividePlayersIntoTeamsOfEqualSkill {
    public static long dividePlayers(int[] skill) {
        if (skill.length == 2) {
            return (long) skill[0] * skill[1];
        }
        Arrays.sort(skill);

        final var skillsSum = (long) skill[0] + skill[skill.length - 1];
        int start = 1;
        int end = skill.length - 2;
        long result = (long) skill[0] * skill[skill.length - 1];
        while (start < end) {
            if(skillsSum != (long) skill[start] + skill[end]) {
                return -1;
            }
            result += (long) skill[start] * skill[end];
            start++;
            end--;
        }

        return result;
    }
}
