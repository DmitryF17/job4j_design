package ru.job4j.rsp;

import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter);
}
