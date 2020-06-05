package ru.job4j.searchfile;

import java.nio.file.Path;
import java.util.function.Predicate;

class ParameterSearch {
    private static final String MAX = "-m";
    private static final String NAME = "-f";
    private static final String REG = "-r";

    Predicate<Path> parameter(String searchlevel, String searchname) {
        Predicate<Path> res = null;
        switch (searchlevel) {
            case MAX:
                res = p -> p.toFile().getName().endsWith(searchname);
                break;
            case NAME:
                res = p -> p.toFile().toString().equals(searchname);
                break;
            case REG:
                res = p -> p.toFile().toString().matches(getPath(searchname));
            default:
        }
        return res;
    }

    private String getPath(String path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '*') {
                sb.append(".*");
            } else if (c == '.') {
                sb.append("\\.");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
