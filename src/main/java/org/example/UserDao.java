package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

  public void add(User user) throws ClassNotFoundException, SQLException {
    Connection conn = getConnection();

    PreparedStatement ps = conn.prepareStatement(
        "insert into users(id, name, password) values(?,?,?)");

    ps.setString(1, user.getId());
    ps.setString(2, user.getName());
    ps.setString(3, user.getPassword());

    ps.executeUpdate();

    ps.close();
    conn.close();
  }

  private static Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");

    return DriverManager.getConnection(
        "jdbc:mysql://localhost/toby-spring", "root", "1234"
    );
  }

  public User get(String id) throws ClassNotFoundException, SQLException {
    Connection conn = getConnection();

    PreparedStatement ps = conn.prepareStatement(
        "select * from users where id = ?");

    ps.setString(1, id);

    ResultSet rs = ps.executeQuery();
    rs.next();

    User user = new User();

    user.setId(rs.getString("id"));
    user.setName(rs.getString("name"));
    user.setPassword(rs.getString("password"));

    rs.close();
    ps.close();
    conn.close();

    return user;
  }
}
