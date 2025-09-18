package org.example.task2;

public class IntStack {
    private int[] data;
    private int top = -1;

    public IntStack() { this(16); }

    public IntStack(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity <= 0");
        data = new int[capacity];
    }

    public void push(int x) {
        if (top + 1 == data.length) grow();
        data[++top] = x;
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException("stack is empty");
        return data[top--];
    }

    public int peek() {
        return isEmpty() ? 0 : data[top];
    }

    public int size() { return top + 1; }
    public boolean isEmpty() { return top == -1; }
    public void clear() { top = -1; }

    private void grow() {
        int[] nd = new int[data.length * 2];
        System.arraycopy(data, 0, nd, 0, data.length);
        data = nd;
    }
}
