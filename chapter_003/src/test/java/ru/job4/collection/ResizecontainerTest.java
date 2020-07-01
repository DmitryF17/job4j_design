package ru.job4.collection;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ResizecontainerTest {

    private Resizecontainer<String> nodes = new Resizecontainer<>();

    @Before
    public void setUp() {
        nodes.add("1");
        nodes.add("2");
        nodes.add("3");
    }

    @Test
    public void addTest() {
        assertThat(nodes.get(0), is("1"));
        assertThat(nodes.get(1), is("2"));
        assertThat(nodes.get(2), is("3"));
    }

    @Test
    public void iteratorTest() {
        var it = nodes.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("1"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("2"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("3"));
        assertThat(it.hasNext(), is(false));
    }
}
