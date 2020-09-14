package se.lexicon.db;

import se.lexicon.exception.MYSQLConnectionException;
import se.lexicon.exception.OracleConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {

    private static String URL = "jdbc:oracle:thin:@localhost:1521/jdbc_lecture";
    private static String USERNAME = "oracle";
    private static String PASSWORD = "123456";

    public static Connection oracleGetConnection() throws OracleConnectionException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OracleConnectionException(e.getMessage());
        }
        return connection;
    }
}
