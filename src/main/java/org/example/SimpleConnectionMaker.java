package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {
  public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");

    return DriverManager.getConnection(
        "jdbc:mysql://localhost/toby-spring", "root", "1234"
    );
  }
}
