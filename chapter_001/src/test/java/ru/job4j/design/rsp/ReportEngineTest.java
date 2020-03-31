package ru.job4j.design.rsp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHRGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        Employer worker1 = new Employer("Oleg", now, now, 150);
        Employer worker2 = new Employer("Vadim", now, now, 90);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        ReportEngine engine = new ReportEngine(store);
        for (Employer employer : store.findBy(em -> true)) {
            StringBuilder expect = new StringBuilder()
                    .append("Name; Salary;")
                    .append(employer.getName()).append(";")
                    .append(employer.getSalary()).append(";");
            assertEquals(engine.generateHR(em -> true), (expect.toString()));
        }
    }
}
