package in.stackroute.ust.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DbConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "password";

    private DbConnection() {}

    // Method to open a connection to the MySql database

    /*
     * First thing in a JDBC application is to establish a connection
     * with the database. 
     * This is done by loading the Driver class and then registering it.
     * 
     * Driver is represented by java.sql.Driver interface.
     * Connection is represented by java.sql.Connection interface.
     * These classes are present in java.sql package.
     * They throw java.sql.SQLException.
     * @throws SQLException
     * @return Connection
     */

    public static Connection getConnection() throws SQLException {
        // Loading the driver for mysql
        // Option 1: Using Class.forName()
        // This approach will @throws ClassNotFoundException as well if
        // the driver class is not found.
        // Class.forName("com.mysql.cj.jdbc.Driver");

        // Option 2: Using DriverManager.registerDriver()
        DriverManager.registerDriver(new Driver());

        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }

}
