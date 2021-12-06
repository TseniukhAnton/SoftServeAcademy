package org.softserveacademy.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static final String dbPropertiesFile = ".\\src\\main\\resources\\application.properties";
    private static final Properties properties = new Properties();

    private static Connection getConnection() throws IOException {
        Connection connection = null;
        try {
            FileReader reader = new FileReader(dbPropertiesFile);
            properties.load(reader);
            Class.forName(properties.getProperty("jdbc.driver"));
            connection = DriverManager.getConnection(properties.getProperty("jdbc.url"), properties.getProperty("jdbc.user"), properties.getProperty("jdbc.pass"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return connection;
    }

    public static PreparedStatement getPreparedStatement(String sql) {
        try {
            return getConnection().prepareStatement(sql);
        } catch (SQLException | IOException t) {
            throw new IllegalArgumentException("");
        }
    }
}
