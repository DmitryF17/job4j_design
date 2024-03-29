package ru.job4j.rsp;

import java.util.function.Predicate;

public class ReportAccountant implements Report {
    private static double dollarToRouble = 75.5;
    private Store store;

    public ReportAccountant(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() / dollarToRouble + " dollars").append(";");
        }
        return text.toString();
    }
}
