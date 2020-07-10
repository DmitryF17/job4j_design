package ru.job4.collection;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] arge) {
        User first = new User("first", 1, new GregorianCalendar(2000, Calendar.JUNE, 23));
        User second = new User("first", 1, new GregorianCalendar(2000, Calendar.JUNE, 23));
        Map<User, Object> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map);
    }
}
