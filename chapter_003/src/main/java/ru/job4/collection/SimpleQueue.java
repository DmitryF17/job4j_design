package ru.job4.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
private int size = 0;

    public T poll() {
       while (size != 0) {
           out.push(in.pop());
           size--;
       }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        size++;
    }
}
