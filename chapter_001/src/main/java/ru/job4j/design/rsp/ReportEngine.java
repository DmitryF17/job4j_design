package ru.job4j.design.rsp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;
import ru.job4j.design.rsp.MemStore;

public class ReportEngine {
    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary()).append(";");
        }
        return text.toString();
    }
    public String generateHR(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append(";")
                    .append(employer.getSalary()).append(";");
        }
        return text.toString();
    }

}
