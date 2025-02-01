package com.learn.leetcode.daily.w2024.q202409;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/lexicographical-numbers/description/?envType=daily-question&envId=2024-09-21">Task</a>
 * <br><a href="https://leetcode.com/problems/lexicographical-numbers/solutions/5813956/interviewers-expect-iterative-approach-lets-understand/?envType=daily-question&envId=2024-09-21">Explanation</a>
 */
public final class LexicographicalNumbers {
    public static List<Integer> lexicalOrder(int n) {
        final var numbers = IntStream
                .range(1, n + 1)
                .mapToObj(String::valueOf)
                .toList();

        // Sort the numbers lexicographically
        return numbers.stream()
                .sorted()
                .map(Integer::valueOf)
                .toList();
    }

    public List<Integer> lexicalOrder_(int n) {
        final List<Integer> al = new ArrayList<>();
        int curr = 1;
        for(int i=1; i<=n; i++)
        {
            al.add(curr);
            if(curr*10<=n) {
                curr = curr * 10;
            }
            else {
                while(curr%10==9 || curr>=n)
                {
                    curr = curr/10;
                }
                curr += 1;
            }
        }
        return al;
    }
}
