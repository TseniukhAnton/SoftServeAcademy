package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static final Properties properties = new Properties();
    private static Connection connection;

    private static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(properties.getProperty("database.driver"));
            con = DriverManager.getConnection(properties.getProperty(""), properties.getProperty(""), properties.getProperty(""));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return con;
    }

    public static PreparedStatement getPreparedStatement(String sql) {
        try {
            return getConnection().prepareStatement(sql);
        } catch (SQLException t) {
            throw new IllegalArgumentException("");
        }
    }
}
