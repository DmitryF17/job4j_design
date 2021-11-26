package ru.job4j.rsp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportHR implements Report {
    private Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        employees.sort(new SortReversSalary());
        StringBuilder text = new StringBuilder();
        for (Employee employee : employees) {
            text.append("Name; Salary;");
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return text.toString();
    }

    private static class SortReversSalary implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Double.compare(o2.getSalary(), o1.getSalary());
        }
    }
}