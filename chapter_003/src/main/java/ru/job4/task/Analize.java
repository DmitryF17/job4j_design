package ru.job4.task;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Analize {

    static Info diff(List<User> previous, List<User> current) {
        int changedelement = 0;
        int deletedelement = 0;
        Map<Integer, User> mapForCountChange = previous.stream().collect(Collectors.toMap(User::getId, user -> user));
        for (User currentuser : current) {
            int currentuserkey = currentuser.id;
            if (!mapForCountChange.containsKey(currentuserkey)) {
                deletedelement++;
            }
            if (mapForCountChange.containsKey(currentuserkey) & currentuser.equals(mapForCountChange.get(currentuserkey))) {
                changedelement++;
            }
        }
        Info info = new Info();
        info.changed = changedelement;
        info.added = current.size() + deletedelement - previous.size();
        info.deleted = deletedelement;
        return info;
    }

    static class User {
        int id;
        String name;

        User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        int getId() {
            return id;
        }
    }

    static class Info {
        int added;
        int changed;
        int deleted;
    }
}


