package org.example;

import java.sql.SQLException;

public class App {

  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    UserDao userDao = new UserDao();

    User user = new User();
    user.setId("hsw0905");
    user.setName("harry");
    user.setPassword("1234abcd");

    userDao.add(user);
    System.out.println(user.getId() + " 등록 성공");

    User user2 = userDao.get(user.getId());
    System.out.println(user2.getName());
    System.out.println(user2.getPassword());

    System.out.println(user2.getId() + " 조회 성공");
  }
}
