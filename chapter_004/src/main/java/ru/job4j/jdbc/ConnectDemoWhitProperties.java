package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectDemoWhitProperties {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        try (InputStream in = ConnectDemoWhitProperties.class.getClassLoader().getResourceAsStream("database.properties")) {
            Properties props = new Properties();
            props.load(in);
            Class.forName(props.getProperty("jdbc.driver"));
            String url = props.getProperty("jdbc.url");
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");
            Connection connection = DriverManager.getConnection(url, username, password);
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}

