package io.bsy.circularbuffer;

import java.lang.reflect.Array;

public class CircularFifoBuffer<T> {

    private T[] items;
    private int current;
    private int maxIndex;
    private int occupied;

    public CircularFifoBuffer(Class<T> clazz, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity should be greater than zero");
        }
        maxIndex = capacity - 1;
        current = 0;
        occupied = 0;
        items = (T[]) Array.newInstance(clazz, capacity);
    }

    public T peek() {
        if (occupied == 0) {
            return null;
        }
        if (occupied == items.length) {
            return items[current];
        }
        var tailIndex = current - occupied;
        if (tailIndex < 0) {
            tailIndex = items.length + tailIndex;
        }
        return items[tailIndex];
    }

    public void push(T item) {
        items[current] = item;
        if (current == maxIndex) {
            current = 0;
        } else {
            current += 1;
        }
        if (occupied < items.length) {
            occupied += 1;
        }
    }

    public T pop() {
        if (occupied == 0) {
            return null;
        }
        if (occupied == items.length) {
            occupied -= 1;
            return items[current];
        }
        var tailIndex = current - occupied;
        if (tailIndex < 0) {
            tailIndex = items.length + tailIndex;
        }
        occupied -= 1;
        return items[tailIndex];
    }
}
