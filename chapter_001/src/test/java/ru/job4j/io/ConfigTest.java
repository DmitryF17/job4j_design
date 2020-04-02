package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void loadTest() {
        Config config = new Config("./data/app.properties");
        config.load("hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect");
        assertThat(
                config.value("hibernate.dialect"),
                is("org.hibernate.dialect.PostgreSQLDialect")
        );
    }
}