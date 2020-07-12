package ru.job4.collection;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    private User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (children != user.children) return false;
        if (!Objects.equals(name, user.name)) return false;
        return Objects.equals(birthday, user.birthday);
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
