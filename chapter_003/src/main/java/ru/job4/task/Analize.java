package ru.job4.task;

import java.util.List;

class Analize {


    static Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        info.added = previous.size();
        info.deleted = previous.size() - current.size();
        info.changed = change(previous, current);
        return info;
    }

    private static int change(List<User> previous, List<User> current) {
        int ch = 0;
        for (User usercurrent : current) {
            int idcurrent = usercurrent.id;
            String namecurrent = usercurrent.name;
            for (User userprevious : previous) {
                int idprevious = userprevious.id;
                String nameprevious = userprevious.name;
                if (idcurrent == idprevious & !namecurrent.equals(nameprevious)) {
                    ch++;
                }
            }
        }
        return ch;
    }

    static class User {
        int id;
        String name;

        User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    static class Info {
        int added;
        int changed;
        int deleted;
    }
}
