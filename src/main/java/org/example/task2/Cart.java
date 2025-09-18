package org.example.task2;

import java.util.Arrays;

public class Cart {
    private Item[] contents;
    private int size = 0;

    public Cart(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity <= 0");
        contents = new Item[capacity];
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == contents.length; }

    public void add(Item item) {
        if (isFull()) grow();
        contents[size++] = item;
    }

    public void removeById(long id) {
        if (isEmpty()) return;
        for (int i = 0; i < size; i++) {
            if (contents[i].getId() == id) {
                removeAtIndex(i);
                return;
            }
        }
    }

    private void removeAtIndex(int idx) {
        for (int i = idx; i < size - 1; i++) contents[i] = contents[i + 1];
        contents[--size] = null;
    }

    private void grow() { contents = Arrays.copyOf(contents, contents.length * 2); }

    public Item get(int i) {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException();
        return contents[i];
    }

    @Override
    public String toString() {
        return "Cart{contents=" + Arrays.toString(Arrays.copyOf(contents, size)) + "}\n";
    }
}

