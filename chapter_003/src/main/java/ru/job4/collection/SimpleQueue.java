package ru.job4.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    int size = 0;


    public T poll() {
            for (int i = size; i > 0; i--) {
                out.push(in.pop());
            }
            T rsl = out.pop();
            size--;
            for (int i = size; i > 0; i--) {
                in.push(out.pop());
            }
            return rsl;
        }

    public void push(T value) {
        in.push(value);
        size++;
    }
}
