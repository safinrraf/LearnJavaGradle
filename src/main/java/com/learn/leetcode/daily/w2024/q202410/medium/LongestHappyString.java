package com.learn.leetcode.daily.w2024.q202410.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/longest-happy-string/description/?envType=daily-question&envId=2024-10-16">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code String, Greedy, Heap (Priority Queue)}
 * </ul>
 * <ul>Hints
 * <li> {@code Use a greedy approach.}
 * <li> {@code Use the letter with the maximum current limit that can be added without breaking the condition.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 ...}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 16.10.24 18:28
 */
public final class LongestHappyString {

    private record Element(Character ch, Integer count){};

    /**
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static String longestDiverseString(int a, int b, int c) {
        final PriorityQueue<Element> pq =
                new PriorityQueue<>(3, Comparator.comparingInt(Element::count).reversed());
        final var result = new StringBuilder();
        if(a > 0) {
            pq.offer(new Element('a', a));
        }
        if(b > 0) {
            pq.offer(new Element('b', b));
        }
        if(c > 0) {
            pq.offer(new Element('c', c));
        }

        while (!pq.isEmpty()) {
            final var element = pq.poll();

            // Check if last two characters are the same.
            if (result.length() >= 2
                    && result.charAt(result.length() - 1) == element.ch
                    && result.charAt(result.length() - 2) == element.ch) {

                if (pq.isEmpty()) {
                    break;  // No more valid characters.
                }

                // Pick the second character.
                final var second = pq.poll();
                var cnt = second.count;
                result.append(second.ch);
                cnt--;

                if (cnt > 0) {
                    pq.offer(new Element(second.ch, cnt));
                }
                pq.offer(element);
            } else {
                result.append(element.ch);
                var cnt = element.count;
                cnt--;

                if (cnt > 0) {
                    pq.offer(new Element(element.ch, cnt));
                }
            }
        }

        return result.toString();
    }
}
