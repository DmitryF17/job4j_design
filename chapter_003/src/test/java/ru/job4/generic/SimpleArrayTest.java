package ru.job4.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {

    private SimpleArray<Integer> simple;

    @Before
    public void setUp() {
        simple = new SimpleArray<>(5);
        simple.add(1);
        simple.add(2);
        simple.add(3);
        simple.add(4);
        simple.add(5);
    }

    @Test
    public void addGetTest() {
        assertThat(simple.get(0), is(1));
    }

    @Test
    public void setTest() {
        simple.set(2, 7);
        assertThat(simple.get(2), is(7));
    }

    @Test
    public void removeTest() {
        simple.remove(2);
        assertThat(simple.get(2), is(4));
        assertThat(simple.get(3), is(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void indexOutOfBoundSet() {
        simple.set(7, 9);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void indexOutOfBoundRemove() {
        simple.remove(9);
    }

    @Test
    public void iteratorTest() {
        assertThat(simple.iterator().hasNext(), is(true));
        assertThat(simple.iterator().hasNext(), is(true));
        assertThat(simple.iterator().next(), is(1));
        assertThat(simple.iterator().next(), is(2));
        assertThat(simple.iterator().next(), is(3));
        assertThat(simple.iterator().next(), is(4));
        assertThat(simple.iterator().next(), is(5));
        assertThat(simple.iterator().hasNext(), is(false));
    }
}
