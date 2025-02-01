package com.learn.leetcode.daily.w2024.q202409;

/**
 * <a href="https://leetcode.com/problems/design-a-stack-with-increment-operation/?envType=daily-question&envId=2024-09-30">Task</a>
 * <p>Time Complexity
 * <br>O(1) ForPush
 * <br>O(1) ForPop
 * <br>O(K) ForIncrement</p>
 * <p>Space Complexity
 * <br>O(N)</p>
 */
public final class CustomStack {

    private final int[] arr;
    private int stackPos = -1;

    public CustomStack(int maxSize) {
        this.arr = new int[maxSize];
    }

    public void push(int x) {
        if(this.stackPos != this.arr.length - 1) {
            this.arr[++stackPos] = x;
        }
    }

    public int pop() {
        if (this.stackPos < 0) {
            return -1;
        }
        return this.arr[this.stackPos--];
    }

    public void increment(int k, int val) {
        final var stopPos = Math.min(k, this.arr.length);
        for (int i = 0; i < stopPos; i++) {
            this.arr[i] += val;
        }
    }

    public String toString() {
        final var strBuilder = new StringBuilder();
        strBuilder.append(" > The current State!\n");
        strBuilder.append(" > stackPos=").append(this.stackPos).append('\n');
        strBuilder.append(" > arr=").append('\n');
        for(final var item: this.arr) {
            strBuilder.append("  > ").append(item).append(" ");
        }
        return strBuilder.toString();
    }
}
