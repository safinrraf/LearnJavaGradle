package com.learn.leetcode.daily.q202409;

/**
 * <a href="https://leetcode.com/problems/design-circular-deque/description/?envType=daily-question&envId=2024-09-28">Task</a>
 * <p>Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();</p>
 */
public final class MyCircularDeque {
    private static class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    private Node front;
    private Node rear;
    private int size;
    private final int capacity;

    public MyCircularDeque(int k) {
        capacity = k;
        size = 0;
        front = null;
        rear = null;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        final var newNode = new Node(value);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            newNode.next = front;
            newNode.prev = rear;
            front.prev = newNode;
            rear.next = newNode;
            front = newNode;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        final var newNode = new Node(value);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            newNode.next = front;
            newNode.prev = rear;
            rear.next = newNode;
            front.prev = newNode;
            rear = newNode;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            front.prev = rear;
            rear.next = front;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            rear = rear.prev;
            rear.next = front;
            front.prev = rear;
        }
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return front.value;
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return rear.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
