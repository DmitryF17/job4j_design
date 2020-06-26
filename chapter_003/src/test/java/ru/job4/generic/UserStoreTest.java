package ru.job4.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserStoreTest {

    private Store<User> mem = new UserStore<>();

    @Before
    public void createMemList() {
        mem.add(new User("1"));
        mem.add(new User("3"));
        mem.add(new User("5"));
    }

    @Test
    public void addTest() {
        assertThat(mem.findById("1").getId(), is("1"));
        assertThat(mem.findById("3").getId(), is("3"));
        assertThat(mem.findById("5").getId(), is("5"));
    }

    @Test
    public void replaceTest() {
        assertThat(mem.replace("1", new User("2")), is(true));
        assertThat(mem.findById("2").getId(), is("2"));
    }

    @Test
    public void replaceNoIdTest() {
        assertThat(mem.replace("4", new User("2")), is(false));
    }

    @Test(expected = NullPointerException.class)
    public void deleteTest() {
       assertThat(mem.delete("1"), is(true));
       mem.findById("1").getId();
    }

    @Test
    public void deleteNoIdTest() {
        assertThat(mem.delete("4"), is(false));
    }

    @Test
    public  void findByIdTest() {
        assertThat(mem.findById("1").getId(), is("1"));
    }

    @Test(expected = NullPointerException.class)
    public  void findByNoIdTest() {
        mem.findById("4").getId();
    }
}
