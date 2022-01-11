package org.softserveacademy.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {
    Connection getConnection() throws SQLException, IOException;
}
