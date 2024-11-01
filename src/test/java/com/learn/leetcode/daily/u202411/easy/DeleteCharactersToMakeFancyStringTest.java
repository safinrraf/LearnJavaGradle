package com.learn.leetcode.daily.u202411.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteCharactersToMakeFancyStringTest {

    @Test
    void makeFancyString1() {
        var input = "leeetcode";
        var expected = "leetcode";
        var result = DeleteCharactersToMakeFancyString.makeFancyString(input);

        assertEquals(expected, result);
    }

    @Test
    void makeFancyString2() {
        var input = "aaabaaaa";
        var expected = "aabaa";
        var result = DeleteCharactersToMakeFancyString.makeFancyString(input);

        assertEquals(expected, result);
    }

    @Test
    void makeFancyString3() {
        var input = "aab";
        var expected = "aab";
        var result = DeleteCharactersToMakeFancyString.makeFancyString(input);

        assertEquals(expected, result);
    }

    @Test
    void makeFancyString4() {
        var input = "leeetcodeeeeeeeeeeeeeeeeeeeeeedddddddddddddddddddddd";
        var expected = "leetcodeedd";
        var result = DeleteCharactersToMakeFancyString.makeFancyString(input);

        assertEquals(expected, result);
    }

    @Test
    void makeFancyString5() {
        var input = "aaabaaaahgdkjzgfbdsjlhzvbldjfvhjjjjjjjjjjjjjjjjjjjjjjjjjgzzzzzzzzzzzzzzzzzzzzzzcbvhgvhgvkhgkvhgvk" +
                "hgvhgkvkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkvvvvvvvvvvvvvvvvvvvvvvvvvvvvgggggggggggggggggg" +
                "ffffffffffffffffffffffdddddddddddddddddddddddddddffffffffffffffffffffffffffffffff" +
                "gggggggggggggggggggggggggggccccccccccccccccccccccccfffffffffffffffffffff" +
                "dddddddddddddddfgjdhdhgfghfhjgfjhgfhgfhgggggggggggggggggggggggggggggggggggff" +
                "dddddddddddddxcccccccccccccccccccccxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" +
                "zzzzzzzzzzzzzzzzzzzzzzzzsssssssssssssssssssssssssswwwwwwwwwwwwwwwww" +
                "dfffdfdgfdgfdgfghfhgfhgfhghgfhgfhghgfhghfhgfhgfhgfgfhgfhgfhgfhghfhgfhgfhghfhgfjhjfhjgfjhgfjhgjfc" +
                "jgfcjgfxjgxdfdfxgcvvcxvcxvcxdxfdxfgdgfdcgfhgfhgvhg";
        var expected = "aabaahgdkjzgfbdsjlhzvbldjfvhjjgzzcbvhgvhgvkhgkvhgvkhgvhgkvkkvvggffddffggccffddfgjdhdhgfghfhj" +
                "gfjhgfhgfhggffddxccxxzzsswwdffdfdgfdgfdgfghfhgfhgfhghgfhgfhghgfhghfhgfhgfhgfgfhgfhgfhgfhghfhgfhgfhgh" +
                "fhgfjhjfhjgfjhgfjhgjfcjgfcjgfxjgxdfdfxgcvvcxvcxvcxdxfdxfgdgfdcgfhgfhgvhg";
        var result = DeleteCharactersToMakeFancyString.makeFancyString(input);

        assertEquals(expected, result);
    }

    @Test
    void makeFancyString6() {
        var input = "a";
        var expected = "a";
        var result = DeleteCharactersToMakeFancyString.makeFancyString(input);

        assertEquals(expected, result);
    }
}