package org.softserveacademy.util;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private final PropertyManager propertyManager = new PropertyManager();

    private Connection getConnection() throws IOException {
        Connection connection = null;
        try {
            Properties properties = propertyManager.getApplicationProperties();
            Class.forName(properties.getProperty("jdbc.driver"));
            connection = DriverManager.getConnection(properties.getProperty("jdbc.url"), properties.getProperty("jdbc.user"), properties.getProperty("jdbc.pass"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return connection;
    }

    public PreparedStatement getPreparedStatement(String sql) {
        try {
            return getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException | IOException t) {
            throw new IllegalArgumentException("");
        }
    }
}
