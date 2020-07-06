package ru.job4.collection;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ForwardLinkedReversTest {

    @Test
    public void whenAddThenIter() {
        ForwardLinkedRevers<Integer> linked = new ForwardLinkedRevers<>();
        linked.add(1);
        linked.add(2);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenAddAndRevertThenIter() {
        ForwardLinkedRevers<Integer> linked = new ForwardLinkedRevers<>();
        linked.add(1);
        linked.add(2);
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }
}
