package com.learn.classic;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

/**
 * <a href="">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code ..., ..., ...}
 * </ul>
 * <ul>Hints
 * <li> {@code ...}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 ...}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 20.10.24 21:36
 */
public final class FibonacciMemoisation {
    private static final Map<Long, Long> memo =
            new HashMap<>(Map.of(0L, 0L, 1L, 1L));

    public static Long fibonacci(long n) {
        if(!memo.containsKey(n)) {
            //Memoisationschritt
            memo.put(n, fibonacci(n - 1) + fibonacci(n - 2));
        }
        return memo.get(n);
    }

    /**
     * @param n
     * @return
     */
    public static Long fibonacciStream(long n) {
        final long[] last = {0L};
        final long[] next = {1L};

        final var longStream = LongStream.generate(() -> {
            var oldLast = last[0];
            last[0] = next[0];
            next[0] = oldLast + next[0];
            return oldLast;
        });

        return longStream.limit(n + 1).max().getAsLong();
    }
}
