package ru.job4j.io;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void loadTest() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.dialect"),
                is("org.hibernate.dialect.PostgreSQLDialect")
        );
    }
}