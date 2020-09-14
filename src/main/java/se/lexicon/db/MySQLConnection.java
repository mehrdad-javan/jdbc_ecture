package se.lexicon.db;

import se.lexicon.exception.MYSQLConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static String URL = "jdbc:mysql://localhost:3306/jdbc_lecture?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Europe/Berlin";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";

    public static Connection mysqlGetConnection() throws MYSQLConnectionException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MYSQLConnectionException(e.getMessage());
        }
        return connection;
    }
}
