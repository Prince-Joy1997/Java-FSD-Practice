package org.example.DAO;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root";
    private  static final String PASSWORD = "root";

    private DBConnection() {}

    public static Connection getConnection() throws SQLException{

        DriverManager.registerDriver(new Driver());

        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
