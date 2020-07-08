package ru.job4.collection;

import java.util.Iterator;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        return linked.deleteLast();
    }

    public void push(T value) {
        linked.add(value);
    }

    public boolean isEmpty() {
        boolean res = true;
        if (linked.iterator().hasNext()) {
            res = false;
        }
        return res;
    }

    public Iterator<T> iterator() {
        return linked.iterator();
    }
}
