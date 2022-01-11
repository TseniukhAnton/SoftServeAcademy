package org.softserveacademy.connection;

import org.softserveacademy.util.PropertyManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static ch.qos.logback.core.CoreConstants.MAX_POOL_SIZE;

public class BasicConnectionPool implements ConnectionPool {
    private static BasicConnectionPool basicConnectionPool;
    private static final PropertyManager propertyManager = new PropertyManager();

    private static List<Connection> connectionPool;
    private static List<Connection> usedConnections = new ArrayList<>();
    private static int INITIAL_POOL_SIZE = 10;
    private static int MAX_TIMEOUT = 5000;

    public BasicConnectionPool() {
    }

    public static BasicConnectionPool create() throws SQLException, IOException {
        if (basicConnectionPool == null) {
            basicConnectionPool = new BasicConnectionPool();
        }
        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            pool.add(createConnection());
        }
        return new BasicConnectionPool();
    }

    public static Connection createConnection() throws IOException {
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

    @Override
    public Connection getConnection() throws SQLException, IOException {
        if (connectionPool.isEmpty()) {
            if (usedConnections.size() < MAX_POOL_SIZE) {
                connectionPool.add(createConnection());
            } else {
                throw new RuntimeException(
                        "Maximum pool size reached, no available connections!");
            }
        }
        Connection connection = connectionPool
                .remove(connectionPool.size() - 1);
        if (!connection.isValid(MAX_TIMEOUT)) {
            connection = createConnection();
        }
        usedConnections.add(connection);
        return connection;
    }
}
