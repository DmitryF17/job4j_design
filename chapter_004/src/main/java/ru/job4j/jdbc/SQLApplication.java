package ru.job4j.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class SQLApplication {
    private static final Logger LOG = LoggerFactory.getLogger(SQLApplication.class);

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/products";
        String username = "postgres";
        String password = "password";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement("SELECT * FROM product where product.id in (?, ?)");
            st.setInt(1, 1);
            st.setInt(2, 2);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(String.format("%s %s", rs.getString("name"), rs.getDate("expired_date")));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
    }
}
