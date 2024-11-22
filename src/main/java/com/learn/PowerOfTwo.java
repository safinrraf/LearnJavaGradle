package com.learn;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

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
 * <br> 22.11.24 09:01
 */
public class PowerOfTwo {
    private AtomicReference<BigInteger> current = new AtomicReference<>(null);

    public BigInteger next() {
        BigInteger recent, next;
        do {
            recent = current.get();
            next = (recent == null) ? BigInteger.valueOf(1) : recent.shiftLeft(1);
        } while (!current.compareAndSet(recent, next));
        return next;
    }
}
