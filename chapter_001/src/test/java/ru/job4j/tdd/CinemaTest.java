package ru.job4j.tdd;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

public class CinemaTest {
    @Ignore
    @Test
    public void buy() {
        Account account = new AccountCinema();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = new Cinema3D().buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }
    @Ignore
    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }
    @Ignore
    @Test
    public void add() {
        Cinema cinema = new Cinema3D();
        Session3D session = new Session3D();
        cinema.add(new Session3D());
        assertThat(session, is(Arrays.asList(new Session3D())));
    }
    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenExceptionRow() {
        Account account = new AccountCinema();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = new Cinema3D().buy(account, 0, 1, date);
    }
    @Ignore
    @Test(expected = NoSuchElementException.class)
    public void findNotSession() {
        Cinema cinema = new Cinema3D();
        List<Session> sessions = cinema.find(session -> true);
    }
}


