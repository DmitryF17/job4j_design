package ru.job4.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        var adding = findBy(parent);
        if (adding.isPresent()) {
            if (!findBy(child).isPresent()) {
                adding.get().children.add(new Node<>(child));
                return true;
            }
        }
        return false;
    }

    private Optional<Node<E>> findWithPredicate(Predicate<Node<E>> predicate) {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (predicate.test(el)) {
                return Optional.of(el);
            }
            data.addAll(el.children);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findWithPredicate(el -> el.value.equals(value));
    }

    boolean isBinary() {
        return findWithPredicate(el -> el.children.size() > 2).isEmpty();
    }
}
