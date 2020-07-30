package ru.job4.task;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnalizeTest {
    @Test
    public void test() {
        Analize.User user1 = new Analize.User(1, "first");
        Analize.User user2 = new Analize.User(2, "second");
        Analize.User user3 = new Analize.User(3, "third");
        List<Analize.User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        List<Analize.User> listchange = new ArrayList<>(list);
        listchange.remove(user1);
        listchange.set(listchange.indexOf(user2), new Analize.User(2, "fourth"));
        Analize.Info rsl = Analize.diff(list, listchange);
        assertThat(rsl.added, is(3));
        assertThat(rsl.deleted, is(1));
        assertThat(rsl.changed, is(1));
    }
}
