package com.learn.leetcode.easy.strings;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/">Task</a>
 */
public final class FirstUniqueCharacterInString {
    public static int firstUniqChar(String s) {
        final HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            final char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public int firstUniqCharNotMy(String s) {
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(s.indexOf(c) == s.lastIndexOf(c)) {
                return i;
            }
        }

        return -1;
    }
}
