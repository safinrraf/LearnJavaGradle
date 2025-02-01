package com.learn.leetcode.daily.q202410;

import com.learn.leetcode.daily.w2024.q202410.medium.DividePlayersIntoTeamsOfEqualSkill;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DividePlayersIntoTeamsOfEqualSkillTest {

    @Test
    void dividePlayers1() {
        final var input = new int[]{3,2,5,1,3,4};
        final var expected = 22;
        final var result = DividePlayersIntoTeamsOfEqualSkill.dividePlayers(input);

        assertEquals(expected, result);
    }

    @Test
    void dividePlayers2() {
        final var input = new int[]{3,4};
        final var expected = 12;
        final var result = DividePlayersIntoTeamsOfEqualSkill.dividePlayers(input);

        assertEquals(expected, result);
    }

    @Test
    void dividePlayers3() {
        final var input = new int[]{1,1,2,3};
        final var expected = -1;
        final var result = DividePlayersIntoTeamsOfEqualSkill.dividePlayers(input);

        assertEquals(expected, result);
    }
}