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
            Class.forName(properties.getProperty("com.mysql.jdbc.Driver"));
            connection = DriverManager.getConnection(properties.getProperty("database.url"), properties.getProperty("database.user")
                    , properties.getProperty("database.pass"));
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
