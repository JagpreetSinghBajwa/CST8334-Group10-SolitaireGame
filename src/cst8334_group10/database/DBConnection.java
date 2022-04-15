package cst8334_group10.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root1234";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/solitaire?useSSL=false";


    public static Connection getConnection () {
        try {
            return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }
}
